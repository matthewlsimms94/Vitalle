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

        Sprite testSprite = new Sprite(R.drawable.test_sheet, context, 6, 6, scaleX, scaleY);

        touchPoint = new Point(0,0);
        Random r = new Random();
        int randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(100, 100, 200, 200, randomId,testSprite));
        randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(400,400,200,200,randomId,testSprite));
        randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(100,400,200,200,randomId,testSprite));
        randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(400,100,200,200,randomId,testSprite));

        setFocusable(true);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event){
        //when the user presses down on the surface
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchPoint.set((int) event.getX(), (int) event.getY());
                HazardousItems.get(0).isTouched(touchPoint);
                HazardousItems.get(1).isTouched(touchPoint);
                HazardousItems.get(2).isTouched(touchPoint);
                HazardousItems.get(3).isTouched(touchPoint);
        }
        return super.onTouchEvent(event);
    }

    public void update(){
        for(FindingHazardousItem hazardousItem:HazardousItems){
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
    }

}
