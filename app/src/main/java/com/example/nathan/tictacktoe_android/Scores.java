package com.example.nathan.tictacktoe_android;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void getScores() {
        int xWins = 0;
        int oWins = 0;

        SharedPreferences scores = getSharedPreferences(winnerActivity.SCORES, MODE_PRIVATE);
        int scoreX = scores.getInt(winnerActivity.WINNER_X_SCORE, 0);
        int scoreO = scores.getInt(winnerActivity.WINNER_X_SCORE, 0);

        TextView scoreXLbl = (TextView) findViewById(R.id.xWinCntLbl);
        scoreXLbl.setText(scoreX);
        TextView scoreOLbl = (TextView) findViewById(R.id.oWinCntLbl);
        scoreOLbl.setText(scoreO);

    }

}
