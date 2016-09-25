package com.example.vitalle;

import android.graphics.Canvas;

/**
 * Created by Note05 on 25/09/2016.
 */
public class Button extends GameObject {


    int buttonId;

    public Button(int x, int y, int height, int width, int buttonId){
        super(x,y,height,width);
        this.buttonId = buttonId;
    }

    @Override
    public void draw(Canvas canvas){
        //draw item onto the canvas
        /*paint paint = new paint
        canvas.drawRect(rectangle, paint);
        * */
    }

    @Override
    public void update(){

    }

    @Override
    public void onTouch(){
        switch(buttonId){
            case 1:
                FindingHazardousItem.doAThing();
        }
    }





}
