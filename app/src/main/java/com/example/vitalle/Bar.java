package com.example.vitalle;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by samsung on 9/25/2016.
 */
public class Bar extends GameObject {

    float mainScaleX, mainScaleY;
    int barId;
    Sprite barTop;
        /*
    1. Medicine
    2. Food
    3. Fun
     */

    public Bar(int x, int y, int height, int width, Sprite sprite, Sprite barTop, float xScale, float yScale, int id) {
        super(x, y, height, width, sprite, xScale, yScale);
        this.barTop = barTop;
        barId = id;
        mainScaleX = scaleX;
        mainScaleY = scaleY;
    }

    @Override
    public void update() {
        super.update();
        barTop.update(x+420,y+115);
        if (barId == 1)
            barTop.scaleSizeX = Character.fHealth/Character.fMax;
        if (barId == 2)
            barTop.scaleSizeX = Character.fFood/Character.fMax;
        if (barId == 3)
            barTop.scaleSizeX = Character.fFun/Character.fMax;
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        barTop.draw(canvas);
    }


    @Override
    public void onTouch()
    {

    }
}
