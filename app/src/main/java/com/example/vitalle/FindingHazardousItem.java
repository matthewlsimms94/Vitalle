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
    public FindingHazardousItem(int x, int y, int height, int width,int itemId, Sprite sprite){
        super(x, y, height, width, sprite);
        this.itemId = itemId;

    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
    }

    @Override
    public void update(){
        super.update();
        if (wasTouched){
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
