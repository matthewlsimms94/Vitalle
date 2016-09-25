package com.example.vitalle;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Note05 on 24/09/2016.
 */
public class FindingHazardousItem extends GameObject {

    //instance variables
    boolean wasTouched = false;

    //Constructor
    public FindingHazardousItem(int x, int y, int height, int width, Sprite sprite){
        super(x, y, height, width, sprite);
    }

    @Override
    public void draw(Canvas canvas){
        //draw item onto the canvas
        //if wasTouched = true do not drawn;
        /*paint paint = new paint
        canvas.drawRect(rectangle, paint);
        * */
    }

    @Override
    public void update(){
        if (wasTouched == true){
            //stop updating
        }
    }

    @Override
    public void onTouch(){
        wasTouched = true;
        //Disappear
    }

    public static void doAThing()
    {

    }
}
