package com.example.vitalle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

/**
 * Created by samsung on 9/24/2016.
 */
public class Sprite {
    private int iCurrentSprite;
    private int iNumberOfSprites;
    private int iFrameLength;
    private int iFrameWidth;
    private int iFrameHeight;
    private ImageView imTarget;
    public int iViewId;
    private Bitmap bSource;
    private Bitmap bFrame;
    private Context parentContext;

    public Sprite(ImageView target, Context thisContext, int resourceId) {
        parentContext = thisContext;
        imTarget = target;
        bSource = BitmapFactory.decodeResource(parentContext.getResources(), resourceId);

        iCurrentSprite = 0;
        iNumberOfSprites = 6;

        iFrameWidth = bSource.getWidth()/iNumberOfSprites;
        iFrameHeight = bSource.getHeight();
        bFrame = Bitmap.createBitmap(iFrameWidth, iFrameHeight, Bitmap.Config.RGB_565);
        //cTarget = new Canvas(bSource);
    }

    void update(){
        iCurrentSprite++;
        if (iCurrentSprite >= iNumberOfSprites)
            iCurrentSprite = 0;
        bFrame = Bitmap.createBitmap(bSource,iCurrentSprite*iFrameWidth,0,iFrameWidth,iFrameHeight);
    }

    void draw(){
        imTarget.setImageDrawable(new BitmapDrawable(parentContext.getResources(), bFrame));
    }

}
