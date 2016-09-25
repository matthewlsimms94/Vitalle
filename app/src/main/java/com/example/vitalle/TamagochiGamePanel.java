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
    private Button buttonFun;
    private Button buttonHealth;

    private Bar barFood;
    private Bar barHealth;
    private Bar barFun;

    private Point touchPoint;
    private Sprite background;
    private Character mainChar;

    public TamagochiGamePanel(Context context){
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(),this);

        testSprite = new Sprite(R.drawable.test_sheet,context,1,2, scaleX, scaleY);

        background = new Sprite(R.drawable.home_bkg,context,1,2,scaleX,scaleY);
        Sprite buttonFoodSprite = new Sprite(R.drawable.home_button_food,context,1,1,scaleX,scaleY);
        Sprite buttonFunSprite = new Sprite(R.drawable.home_button_game,context,1,1,scaleX,scaleY);
        Sprite buttonHealthSprite = new Sprite(R.drawable.home_button_health,context,1,1,scaleX,scaleY);

        Sprite mainFoodBarSprite = new Sprite(R.drawable.home_bar_food,context,1,2,scaleX,scaleY);
        Sprite topBarFoodSprite = new Sprite(R.drawable.home_bar_food_b, context,1,2,scaleX,scaleY);

        Sprite mainFunBarSprite = new Sprite(R.drawable.home_bar_fun,context,1,2,scaleX,scaleY);
        Sprite topBarFunSprite = new Sprite(R.drawable.home_bar_fun_b, context,1,2,scaleX,scaleY);

        Sprite mainHealthBarSprite = new Sprite(R.drawable.home_bar_health,context,1,2,scaleX,scaleY);
        Sprite topBarHealthSprite = new Sprite(R.drawable.home_bar_health_b, context,1,2,scaleX,scaleY);

        Sprite characterSprite = new Sprite(R.drawable.home_char1,context,1,1,scaleX,scaleY);

        buttonFood = new Button(25,2800,650,650,2, context,buttonFoodSprite, scaleX, scaleY,thread); //x, y, height, width
        buttonFun = new Button(775,2800,650,650,3, context,buttonFunSprite, scaleX, scaleY,thread); //x, y, height, width
        buttonHealth = new Button(1475,2800,650,650,1, context,buttonHealthSprite, scaleX, scaleY,thread); //x, y, height, width

        barFood = new Bar(25,100,100,100,mainFoodBarSprite,topBarFoodSprite,scaleX,scaleY,2);
        barFun = new Bar(25,450,100,100,mainFunBarSprite,topBarFunSprite,scaleX,scaleY,3);
        barHealth = new Bar(25,800,100,100,mainHealthBarSprite,topBarHealthSprite,scaleX,scaleY,1);

        mainChar = new Character(250,900,1080,1920,characterSprite,scaleX,scaleY);
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
                buttonHealth.isTouched(touchPoint);
                buttonFun.isTouched(touchPoint);
        }
        return super.onTouchEvent(event);
    }

    public void update(){
        super.update();
        //update the coordinates of the item
        background.update(0,0);
        mainChar.update();
        buttonFood.update();
        buttonFun.update();
        buttonHealth.update();
        barFood.update();
        barFun.update();
        barHealth.update();
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        background.draw(canvas);
        mainChar.draw(canvas);
        buttonFood.draw(canvas);
        buttonFun.draw(canvas);
        buttonHealth.draw(canvas);
        barFood.draw(canvas);
        barFun.draw(canvas);
        barHealth.draw(canvas);
    }

}
