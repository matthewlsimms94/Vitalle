package com.example.vitalle;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class TamagochiGamePanel extends GamePanel{
    private MainThread thread;


    private Sprite testSprite;
    private Point itemPoint;
    private Button buttonFood;
    private Point touchPoint;

    public TamagochiGamePanel(Context context){
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(),this);

        testSprite = new Sprite(R.drawable.test_sheet,context,1,2, scaleX, scaleY);

        buttonFood = new Button(5,5,100,100,1, context,testSprite); //x, y, height, width
        touchPoint = new Point(0,0);

        setFocusable(true);

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
        //when the user presses down on the surface
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchPoint.set((int) event.getX(), (int) event.getY());
                buttonFood.isTouched(touchPoint);
        }
        return super.onTouchEvent(event);
    }

    public void update(){
        super.update();
        //update the coordinates of the item
        buttonFood.update();
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        buttonFood.draw(canvas);
    }

}
