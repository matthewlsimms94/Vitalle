package com.example.vitalle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;

public class HomeActivity extends Activity {

    GamePanel mainPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//Needs to check if running soon
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mainPanel =  new GamePanel(this);
        setContentView(mainPanel);

        //setContentView(R.layout.activity_main);
        //ViewStub viewStub = (ViewStub) findViewById(R.id.homeGameView);
        //viewStub//
    }
/*
    @Override
    public void onResume()
    {
        super.onResume();
        mainPanel =  new GamePanel(this);
        setContentView(mainPanel);
    }

/*
    @Override
    public void onPause(){
        super.onPause();
        mainPanel.thread.setRunning(false);
        mainPanel.setVisibility(View.GONE);
        finish();
    }

    @Override
    public void onStop(){
        super.onStop();
        mainPanel.thread.setRunning(false);
        mainPanel.setVisibility(View.GONE);
        finish();
    }*/
}
