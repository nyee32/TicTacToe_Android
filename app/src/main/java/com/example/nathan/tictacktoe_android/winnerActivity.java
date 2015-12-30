package com.example.nathan.tictacktoe_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class winnerActivity extends AppCompatActivity {
    public final static String WINNER_X_SCORE = "winnerX";
    public final static String WINNER_O_SCORE = "winnerO";
    public final static String SCORES = "scores";


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
        Intent in = getIntent();
        labelStr = in.getStringExtra(Game.WINNER_MSG);
        TextView winnerText = (TextView) findViewById(R.id.winnerMsg);

        int s = recoverScores();

        System.out.println("score = " + s);
        winnerText.setTextSize(30);
        winnerText.setText("Congratulations\nplayer " + labelStr + " won!");
    }

    public void restart(View view) {
        //TODO
        //some type of reset function here
//        Intent gb = getIntent();
//        GameBoard myGb = (GameBoard)gb.getSerializableExtra("gmBoard");
//        myGb.resetBoard();
        System.out.println("User pressed the restart button");
        finish();
    }

    private void updateScores () {
        SharedPreferences scores = getSharedPreferences(SCORES,MODE_PRIVATE);
        SharedPreferences.Editor editor = scores.edit();
        editor.putInt("winnerx", 1);
        editor.commit();

    }

    private int recoverScores() {
        SharedPreferences scores = getSharedPreferences("scores",MODE_PRIVATE);
        int score = scores.getInt("winnerx", -1);

        return score;
    }

    public void checkScores (View view) {
        Intent in = new Intent(this, Scores.class);
        startActivity(in);

    }

}
