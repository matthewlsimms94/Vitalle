package com.example.vitalle;

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
    /*
    1. Give Medicine
    2. Give Food
    3. Go to minigames
     */


    public Button(int x, int y, int height, int width, int buttonId, Context panelContext, Sprite sprite){
        super(x,y,height,width,sprite);
        this.buttonId = buttonId;
        this.panelContext = panelContext;
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
                // give medicine
                break;
            case 2:
                // give food
                break;
            case 3:
                Intent goToTamagochi = new Intent(panelContext,TamagochiGamePanel.class);
                panelContext.startActivity(goToTamagochi);
                //go to game menu
                break;
        }
    }





}
