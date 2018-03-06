
package com.iwave.gsonimagerecyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImReleaseDate {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("attributes")
    @Expose
    private Attributes________ attributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes________ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes________ attributes) {
        this.attributes = attributes;
    }

}
