package com.innovations.beyondr.Model;

import android.graphics.drawable.Drawable;

public class MainNavModel {
    Drawable image_drawable;
    String item_name;

    public MainNavModel(Drawable image_drawable, String item_name) {
        this.image_drawable = image_drawable;
        this.item_name = item_name;
    }

    public Drawable getImage_drawable() {
        return image_drawable;
    }

    public String getItem_name() {
        return item_name;
    }
}
