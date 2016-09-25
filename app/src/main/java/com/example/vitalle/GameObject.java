package com.example.vitalle;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Note05 on 24/09/2016.
 */
public abstract class GameObject {

    int x,y,height,width;
    Rect rectangle;

    public GameObject(int x,int y,int height,int width){
        rectangle = new Rect(x-width/2,y-height/2,x+width/2,y+height/2);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void isTouched(Point touchPoint)
    {
        if ((touchPoint.x >= x-width/2 && touchPoint.x <= x+width/2) && (touchPoint.y >= y-height/2 && touchPoint.y <= y+height/2)){
            onTouch();
        }
    }
    public abstract void onTouch();
    public abstract void draw(Canvas canvas);
    public abstract void update();
}
