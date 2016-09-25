package com.example.vitalle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
    }
    public void OpenAdventureGame(View view){
        Intent intent = new Intent(this, AdventureGameActivity.class);
        startActivity(intent);
    }

    public void OpenFindingGame(View view) {
        Intent intent = new Intent(this, FindingGameActivity.class);
        startActivity(intent);
    }
}
