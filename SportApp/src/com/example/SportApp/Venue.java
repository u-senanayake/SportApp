package com.example.SportApp;

import android.graphics.Bitmap;

/**
 * Created by Udayanga Senanayake on 5/6/2015.
 */
public class Venue {
    public String description;
    public String title;
    public  String link;
    public String img;
    public Bitmap bitmap;

    public Venue(String t, String d,String l,String im,Bitmap bitmap ){
        this.title=t;
        this.description=d;
        this.link=l;
        this.img =im;
        this.bitmap=bitmap;
    }

    public Venue() {

    }
}
