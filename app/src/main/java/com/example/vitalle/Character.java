package com.example.vitalle;

import android.graphics.Canvas;

/**
 * Created by samsung on 9/24/2016.
 */
public class Character extends GameObject {

    static public float fFood, fHealth, fFun;
    static final public float fMax = 100;
    static int lowFood;
    static final float highHealth = 80, healthHurt = 10;
    static long lastMed = -1;
    int iFrameCount = 0;

    Character(int x, int y, int height, int width, Sprite sprite,float xScale,float yScale) {
        super(x, y, height, width, sprite, xScale, yScale);
        fFood = fMax;
        fHealth = fMax;
        fFun = fMax;

    }

    @Override
    public void onTouch() {

    }


    public void update() {
        super.update();
        iFrameCount++;
        if (iFrameCount%7 == 0)
            fFood--;
        if (iFrameCount%30 == 0)
            fHealth--;
        if (iFrameCount%15 == 0)
            fFun--;
    }

    public static void addFood()
    {
        fFood = fMax;
    }

    public static void addHealth() {
        if (System.currentTimeMillis() > lastMed + 5000)
        {
            fHealth = fMax;
            lastMed = System.currentTimeMillis();
        }
        else
            fHealth -= healthHurt;

    }

}
