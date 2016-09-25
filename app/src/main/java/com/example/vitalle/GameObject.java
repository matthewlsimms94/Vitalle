package com.example.vitalle;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Note05 on 24/09/2016.
 */
public abstract class GameObject {

    int x, y, iHeight, iWidth;
    Rect rectangle;
    Sprite sprite;

    public GameObject(int x, int y, int height, int width, Sprite sprite) {
        rectangle = new Rect(x - width / 2, y - height / 2, x + width / 2, y + height / 2);
        this.x = x;
        this.y = y;
        this.iHeight = width;
        this.iWidth = height;
        this.sprite = sprite;
    }

    public void isTouched(Point touchPoint) {
        if ((touchPoint.x >= x - iWidth / 2 && touchPoint.x <= x + iWidth / 2) && (touchPoint.y >= y - iHeight / 2 && touchPoint.y <= y + iHeight / 2)) {
            onTouch();
        }
    }

    public abstract void onTouch();

    public void draw(Canvas canvas)
    {
        sprite.draw(canvas);
    }

    public abstract void update();
}
