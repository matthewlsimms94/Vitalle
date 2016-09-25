package com.example.vitalle;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Display;
import android.view.WindowManager;



public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    public MainThread thread;

    int testX = 0, testXmod = 1;
    private Sprite testSprite;
    private Point itemPoint;
    //private Button buttonFood;
    private Point touchPoint;

    private Sprite background;
    private Character mainChar;

    private float scaleX,scaleY;
    private float screenX,screenY;
    private final float canvasX = 1080, canvasY = 1920;

    public GamePanel(Context context){
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(),this);

        //Get the screen dimensions for scaling
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenX = size.x;
        screenY = size.y;
        //Get the scale
        scaleX = screenX/canvasX;
        scaleY = screenY/canvasY;

        //item = new Items(new Rect(100,100,200,200));
        itemPoint = new Point(150,150);
        //buttonFood = new Button(150,150,100,100,1); //x, y, height, width
        touchPoint = new Point(0,0);

        background = new Sprite(R.drawable.home_bkg,context,1,1,scaleX,scaleY);



        setFocusable(true);

        Reminder.scheduleNotification(Reminder.getNotification("HELP!","I'm having an attack and I'm going to die and it's all your fault!",context),10,context);

        testSprite = new Sprite(R.drawable.test_sheet,context,6,6,scaleX,scaleY);
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
                //buttonFood.isTouched(touchPoint);
        }
        return super.onTouchEvent(event);
    }

    public void update(){
        background.update(0,0);
        testX += testXmod;
        if (testX < 0 || testX > 200)
            testXmod = -testXmod;
        testSprite.update(testX,50);
        //update the coordinates of the item
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        background.draw(canvas);
        testSprite.draw(canvas);
        //buttonFood.draw(canvas);
    }

}
