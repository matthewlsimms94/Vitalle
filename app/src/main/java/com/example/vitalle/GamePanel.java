package com.example.vitalle;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Display;
import android.view.WindowManager;



public abstract class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    protected Context parentContext;

    protected float scaleX,scaleY;
    protected float screenX,screenY;
    protected final float canvasX = 1080, canvasY = 1920;

    public GamePanel(Context context){
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(),this);

        //Get the screen dimensions for scaling
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        display.getSize(size);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        float density = metrics.density;
        screenX = size.x;
        screenY = size.y;
        //Get the scale
        scaleX = (screenX/canvasX)/density;//screenX/canvasX;
        scaleY = (screenY/canvasY)/density;//screenY/canvasY;

        setFocusable(true);
        parentContext = context;
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
        return super.onTouchEvent(event);
    }

    public void update(){
        //update the coordinates of the item
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
    }

}
