
package com.iwave.gsonimagerecyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("attributes")
    @Expose
    private Attributes_______ attributes;

    public Attributes_______ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes_______ attributes) {
        this.attributes = attributes;
    }

}
