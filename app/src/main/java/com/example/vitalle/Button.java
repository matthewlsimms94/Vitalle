package com.example.vitalle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.ContextMenu;

/**
 * Created by Note05 on 25/09/2016.
 */
public class Button extends GameObject {


    private int buttonId;
    private Context panelContext;
    private MainThread thread;
    /*
    1. Give Medicine
    2. Give Food
    3. Go to minigames
     */


    public Button(int x, int y, int height, int width, int buttonId, Context panelContext, Sprite sprite, float xScale, float yScale, MainThread thread){
        super(x,y,height,width,sprite,xScale,yScale);
        this.buttonId = buttonId;
        this.panelContext = panelContext;
        this.thread = thread;
    }

    @Override
    public void draw(Canvas canvas){
       super.draw(canvas);
    }

    @Override
    public void update(){
        super.update();
    }

    @Override
    public void onTouch(){
        switch(buttonId){
            case 1:
                Character.addHealth();
                break;
            case 2:
                Character.addFood();
                break;
            case 3:
                Intent goToFinding = new Intent(panelContext,FindingActivity.class);
                thread.setRunning(false);

                thread.canvas = thread.surfaceHolder.lockCanvas();
                thread.surfaceHolder.unlockCanvasAndPost(thread.canvas);
                thread.interrupt();
                panelContext.startActivity(goToFinding);
                ((Activity)panelContext).finish();
                //go to game menu
                break;
        }
    }





}
