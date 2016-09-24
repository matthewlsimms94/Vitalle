package com.example.vitalle;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;

    private Sprite testSprite;
    private Items item;
    private Point itemPoint;

    public GamePanel(Context context){
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(),this);

        item = new Items(new Rect(100,100,200,200));
        itemPoint = new Point(150,150);

        setFocusable(true);

        testSprite = new Sprite(R.drawable.test_sheet,context,6,6);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        thread = new MainThread(getHolder(),this);

        thread.setRunning(true);
        thread.start();
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        while(true){
            try{
                thread.setRunning(false);
                thread.join();
            }catch(Exception e){e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);

        //when the user presses down on the surface]
        case MotionEvent.ACTION_DOWN;
            touchPoint.set((int)event.getX(), (int)event.getY());
            item.isTouched(touchPoint,itemPoint)
    }

    public void update(){
        testSprite.update();
        //update the coordinates of the item
        item.update(itemPoint);
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        testSprite.draw(canvas);
        item.draw(canvas);
    }

}
