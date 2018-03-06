package com.iwave.gsonimagerecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    //private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutManager mGridLayoutManager;
    private static OkHttpClient mClient = new OkHttpClient();
    public static List<Entry> entries = new ArrayList<>();
    public static List<ImImage> mEntryImages = new ArrayList<>();
    public static Entry entry;
    public static Data data;
    private static String mResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.MyRecyclerView);

        mRecyclerView.setHasFixedSize(true);

         mGridLayoutManager= new GridLayoutManager(this,2);

        mRecyclerView.setLayoutManager(mGridLayoutManager);


        getImages();

        mAdapter = new MyAdapter(entries);

        mRecyclerView.setAdapter(mAdapter);

    }

    public void getImages() {

        Request request = new Request.Builder().
                url("http://itunes.apple.com/us/rss/topalbums/limit=10/json")
                .build();

        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {

                mResponse = response.body().string();

                Gson gson = new Gson();

                data = gson.fromJson(mResponse, Data.class);

               // entry = gson.fromJson(mResponse, Entry.class);

                List<Entry> entry2 = data.getFeed().getEntry();

               // List<ImImage> imageEntry2 = entry.getImImage();

                for (Entry entry1 : entry2) {

                    entries.add(entry1);

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        mAdapter.notifyDataSetChanged();

                    }
                });


            }
        });

    }
}
