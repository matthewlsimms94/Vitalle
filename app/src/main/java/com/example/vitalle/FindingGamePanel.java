package com.example.vitalle;

import android.content.Context;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Random;


public class FindingGamePanel extends GamePanel {
    private MainThread thread;

    private Sprite background2;
    private Sprite sofa;
    private Sprite table;
    private ArrayList<FindingHazardousItem> HazardousItems = new ArrayList<FindingHazardousItem>();
    private Point touchPoint;

    public FindingGamePanel(Context context){
        super(context);

        getHolder().addCallback(this);


        thread = new MainThread(getHolder(),this);

        //background2 = new Sprite(R.drawable.home_bkg, context, 1, 6, scaleX, scaleY);
        Sprite sofa1 = new Sprite(R.drawable.game_sofa, context, 1, 6, scaleX, scaleY);
        Sprite flowers = new Sprite(R.drawable.game_flowers, context, 1, 6, scaleX, scaleY);
        Sprite rug = new Sprite(R.drawable.game_rug, context, 1, 6, scaleX, scaleY);
        sofa = new Sprite(R.drawable.game_sofa_1, context, 1, 6, scaleX, scaleY);
        //table = new Sprite(R.drawable.game_side_table, context, 1, 6, scaleX, scaleY);



        touchPoint = new Point(0,0);
        Random r = new Random();
        int randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(800, 2000, 600, 1400, randomId,sofa1, scaleX, scaleY));
        randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(300,1500,300,700,randomId,flowers, scaleX, scaleY));
        randomId = r.nextInt(4);
        HazardousItems.add(new FindingHazardousItem(500,2700,600,1400,randomId,rug, scaleX, scaleY));



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
        //background2.update(0, 0);
        sofa.update(800, 2000);
        //table.update(900, 2500);
        for(FindingHazardousItem hazardousItem:HazardousItems){
            hazardousItem.update();
            if (hazardousItem.getWasTouched()){
                HazardousItems.remove(hazardousItem);

            }
        }
        //Log.v("oi",HazardousItems.size()+"");

        if(HazardousItems.isEmpty()){
            Intent goToTamagochi = new Intent(parentContext,HomeActivity.class);
            parentContext.startActivity(goToTamagochi);
        }
        //update the coordinates of the item
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        //background2.draw(canvas);
        sofa.draw(canvas);
        //table.draw(canvas);
        for(FindingHazardousItem hazardousItem:HazardousItems) {
            hazardousItem.draw(canvas);
        }
    }

}
