package com.example.vitalle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageView;
import android.graphics.Rect;

/**
 * Created by samsung on 9/24/2016.
 */
public class Sprite {
    private int iCurrentFrame;
    private int iNumberOfFrames;

    private int iFrameLength;
    private int iFrameCounter;

    private int iFrameWidth;
    private int iFrameHeight;

    private int x, y;
    private float scaleX,scaleY;

    private Bitmap bSource;
    private Bitmap bFrame;

    //private Context parentContext;

    public Sprite(int resourceId, Context parentContext, int numberOfFrames, int frameLength, float scaleX, float scaleY) {
        bSource = BitmapFactory.decodeResource(parentContext.getResources(), resourceId);

        iCurrentFrame = 0;
        iNumberOfFrames = numberOfFrames;
        iFrameLength = frameLength;
        iFrameCounter = 0;

        x = 50;
        y = 50;

        this.scaleX = scaleX;
        this.scaleY = scaleY;

        iFrameWidth = bSource.getWidth()/iNumberOfFrames;
        iFrameHeight = bSource.getHeight();
        bFrame = Bitmap.createBitmap(iFrameWidth, iFrameHeight, Bitmap.Config.RGB_565);
        //cTarget = new Canvas(bSource);
    }

    void update(int x, int y){
        this.x = x;
        this.y = y;
        iFrameCounter++;
        if (iFrameCounter >= iFrameLength)
        {
            iFrameCounter = 0;
            iCurrentFrame++;
            if (iCurrentFrame >= iNumberOfFrames)
                iCurrentFrame = 0;
            bFrame = Bitmap.createBitmap(bSource,iCurrentFrame*iFrameWidth,0,iFrameWidth,iFrameHeight);
        }
    }

    void draw(Canvas canvas){
        float xFloat = (float)x;
        float yFloat = (float)y;
        float widthFloat = (float)iFrameWidth;
        float heightFloat = (float)iFrameHeight;

        Log.e("TEMP","SIZES: "+scaleX + " " + scaleY);

        Rect src = new Rect(0,0,iFrameWidth-1, iFrameHeight-1);
        Rect dest = new Rect((int)(xFloat*scaleX),(int)(yFloat*scaleY),(int)((xFloat+widthFloat-1)*scaleX), (int)((yFloat+heightFloat-1)*scaleY));
        canvas.drawBitmap(bFrame, src, dest, null);
        //canvas.drawBitmap(bFrame,x,y,null);
        //imTarget.setImageDrawable(new BitmapDrawable(parentContext.getResources(), bFrame));
    }

}
