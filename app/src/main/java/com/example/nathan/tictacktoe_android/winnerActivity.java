package com.example.nathan.tictacktoe_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class winnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWinner();
    }

    private void getWinner() {
        String labelStr;
        setContentView(R.layout.activity_winner);
        Intent in = getIntent();

        labelStr = in.getStringExtra(Game.WINNER_MSG);
        TextView winnerText = (TextView) findViewById(R.id.winnerMsg);

        winnerText.setTextSize(30);
        winnerText.setText("Congratulations\nplayer " + labelStr + " won!");
    }

}
