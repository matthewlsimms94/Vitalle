package com.example.vitalle;

import android.graphics.Canvas;

/**
 * Created by Note05 on 24/09/2016.
 */
public abstract class GameObject {

    int x,y,height,width;
    //Rectangle thajhsjkejhesrejkesrea;
    public GameObject()
    {
        //NOTHING
    }

    public void isTouched()
    {
        //check for touch blah blah
        //if true
        onTouch();
    }
    public abstract void onTouch();
    public abstract void draw(Canvas canvas);
    public abstract void update();
}
