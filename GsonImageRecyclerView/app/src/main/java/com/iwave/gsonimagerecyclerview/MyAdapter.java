package com.iwave.gsonimagerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.List;

/**
 * Created by user on 3/5/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Entry> mImages;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView ;
        private View mLayout;

        public ViewHolder(View v) {
            super(v);
            mLayout=v;
            mImageView=v.findViewById(R.id.ImageView);

        }
    }
    public MyAdapter(List<Entry> entries) {

        mImages=entries;

    }

    public MyAdapter(Context context) {

        this.mContext=context;

    }
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(
                                    parent.getContext());
        View v = inflater.inflate(R.layout.image_view, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        final Entry image = mImages.get(position);

        String ImageFromLink=image.getImImage().get(0).getLabel();

        Glide.with(holder.mImageView.getContext()).load(ImageFromLink).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {

        if (mImages!= null) {
            return mImages.size();
        } else {
            return 0;
        }
    }


}
