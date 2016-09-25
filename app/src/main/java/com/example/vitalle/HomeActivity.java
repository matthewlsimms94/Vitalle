package com.example.vitalle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewStub;
import android.view.Window;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GamePanel(this));

        //setContentView(R.layout.activity_main);
        //ViewStub viewStub = (ViewStub) findViewById(R.id.homeGameView);
        //viewStub//
    }
}
