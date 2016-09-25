package com.example.vitalle;

import android.content.Context;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Random;


public class FindingGamePanel extends GamePanel {
    private MainThread thread;

    private ArrayList<FindingHazardousItem> HazardousItems = new ArrayList<FindingHazardousItem>();
    private Point touchPoint;

    public FindingGamePanel(Context context){
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(),this);

        Sprite testSprite = new Sprite(R.drawable.icon_test, context, 1, 6, scaleX, scaleY);
        Sprite testSprite2 = new Sprite(R.drawable.icon_test, context, 1, 6, scaleX, scaleY);
        Sprite testSprite3 = new Sprite(R.drawable.icon_test, context, 1, 6, scaleX, scaleY);
        Sprite testSprite4 = new Sprite(R.drawable.icon_test, context, 1, 6, scaleX, scaleY);

        touchPoint = new Point(0,0);
        Random r = new Random();
        int randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(100, 100, 300, 300, randomId,testSprite));
        randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(800,1200,300,300,randomId,testSprite2));
        randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(100,1200,300,300,randomId,testSprite3));
        randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(800, 100, 300, 300, randomId, testSprite4));

        setFocusable(true);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event){
        //when the user presses down on the surface
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchPoint.set((int) event.getX(), (int) event.getY());
                for(FindingHazardousItem hazardousItem:HazardousItems){
                    hazardousItem.isTouched(touchPoint);
                }
        }
        return super.onTouchEvent(event);
    }

    public void update(){
        super.update();
        for(FindingHazardousItem hazardousItem:HazardousItems){
            hazardousItem.update();
            if (hazardousItem.getWasTouched()){
                HazardousItems.remove(hazardousItem);
            }
        }
        if(HazardousItems.isEmpty()){
            Intent goToTamagochi = new Intent(parentContext,TamagochiGamePanel.class);
            parentContext.startActivity(goToTamagochi);
        }
        //update the coordinates of the item
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        for(FindingHazardousItem hazardousItem:HazardousItems) {
            hazardousItem.draw(canvas);
        }
    }

}
