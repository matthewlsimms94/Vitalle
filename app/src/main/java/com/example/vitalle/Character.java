package com.example.vitalle;

import android.graphics.Canvas;

/**
 * Created by samsung on 9/24/2016.
 */
public class Character extends GameObject {

    static public int iFood, iHealth, iFun;
    static final public int iMax = 100;
    static int lowFood;

    Character(int x, int y, int height, int width, Sprite sprite) {
        super(x, y, height, width, sprite);
        iFood = iMax;
        iHealth = iMax;
        iFun = iMax;
    }

    @Override
    public void onTouch() {

    }


    public void update() {
        iFood--;
        iHealth--;
        iFun--;
    }

    public static void addFood()
    {
        iFood = iMax;
    }

    public static void addHealth()
    {
        iHealth = iMax;
    }

}
