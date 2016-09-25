package com.example.vitalle;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Note05 on 24/09/2016.
 */
public class FindingHazardousItem extends GameObject {

    //instance variables
    private boolean wasTouched = false;
    private int itemId;

    //Constructor
    public FindingHazardousItem(int x, int y, int height, int width,int itemId){
        super(x, y, height, width);
        this.itemId = itemId;
    }

    @Override
    public void draw(Canvas canvas){
        //draw item onto the canvas
        //switch case itemId -> which item is going to be drawn
        //if wasTouched = true -> do not drawn;
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
        if (itemId < 4) {
            wasTouched = true;
        }
        //Disappear
    }

    public boolean getWasTouched(){
        return this.wasTouched;
    }

}
