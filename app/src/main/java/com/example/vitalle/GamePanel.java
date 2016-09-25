package com.example.vitalle;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;


    private Sprite testSprite;
    private Point itemPoint;
    private Button buttonFood;
    private Point touchPoint;

    public GamePanel(Context context){
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(),this);

        //item = new Items(new Rect(100,100,200,200));
        itemPoint = new Point(150,150);
        buttonFood = new Button(150,150,100,100,1); //x, y, height, width
        touchPoint = new Point(0,0);

        setFocusable(true);

        Reminder.scheduleNotification(Reminder.getNotification("HELP!","I'm having an attack and I'm going to die and it's all your fault!",context),10,context);

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
        //when the user presses down on the surface
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchPoint.set((int) event.getX(), (int) event.getY());
                buttonFood.isTouched(touchPoint);
        }
        return super.onTouchEvent(event);
    }

    public void update(){
        testSprite.update();
        //update the coordinates of the item
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        testSprite.draw(canvas);
        buttonFood.draw(canvas);
    }

}
