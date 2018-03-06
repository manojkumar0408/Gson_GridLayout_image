
package com.iwave.gsonimagerecyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImContentType {

    @SerializedName("im:contentType")
    @Expose
    private ImContentType_ imContentType;
    @SerializedName("attributes")
    @Expose
    private Attributes___ attributes;

    public ImContentType_ getImContentType() {
        return imContentType;
    }

    public void setImContentType(ImContentType_ imContentType) {
        this.imContentType = imContentType;
    }

    public Attributes___ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes___ attributes) {
        this.attributes = attributes;
    }

}
