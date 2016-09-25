package com.example.vitalle;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Note05 on 24/09/2016.
 */
public abstract class GameObject {

    int x, y, iHeight, iWidth;
    float scaleX, scaleY;
    Rect rectangle;
    Sprite sprite;

    public GameObject(int x, int y, int height, int width, Sprite sprite, float xScale, float yScale) {
        rectangle = new Rect(x, y, x + width , y + height);
        this.x = x;
        this.y = y;
        this.iWidth = width;
        this.iHeight = height;
        this.scaleX = xScale;
        this.scaleY = yScale;
        this.sprite = sprite;
    }

    public void isTouched(Point touchPoint) {
        Point scaledTouchPoint = new Point();
        scaledTouchPoint.x = (int)(touchPoint.x/scaleX);
        scaledTouchPoint.y = (int)(touchPoint.y/scaleY);
        if ((scaledTouchPoint.x >= x && scaledTouchPoint.x <= x + iWidth) && (scaledTouchPoint.y >= y && scaledTouchPoint.y <= y + iHeight)) {
            onTouch();
        }
    }

    public abstract void onTouch();

    public void draw(Canvas canvas) {
        sprite.draw(canvas);
    }

    public void update()
    {
        sprite.update(x,y);
    }
}
