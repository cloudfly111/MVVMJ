package com.example.mvvmj;

import java.util.Date;

public class Image extends Object {
    /**
     * the name of Image
     **/
    String imageName;
    /**
     * the resource id of Image
     **/
    String imageResource;
    /**
     * the date of Image
     **/
    Date imageDate;

    public void setImageDate(Date imageDate) {
        this.imageDate = imageDate;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }
}

