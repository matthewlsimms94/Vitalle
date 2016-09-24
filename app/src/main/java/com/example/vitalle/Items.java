package com.example.vitalle;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Note05 on 24/09/2016.
 */
public class Items extends GameObject {

    //instance variables
    private Rect rectangle;

    //constructor
    public Items (x,y,height,width){
        this.rectangle = rectangle;
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
    //coordinates of item
    public void update(Point point){
        //ltrb
        rectangle.get(/*position*/);
         }
}
