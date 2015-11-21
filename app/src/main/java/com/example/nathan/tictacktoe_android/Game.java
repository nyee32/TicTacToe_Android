package com.example.nathan.tictacktoe_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Game extends AppCompatActivity {
    private playerTurn turn = playerTurn.turnO;
    private GameBoard gb = new GameBoard();
    private int count = 0;
    public final static String WINNER_MSG = "com.example.nathan.tictacktoe_android.winner_msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setText(View view) {
        Button piece = (Button) view;
        piece.setClickable(false);
        playerTurn winner;

        count++;
        if (turn == playerTurn.turnX) {
            piece.setText("X");
            turn = playerTurn.turnO;
            gb.addMark(piece.getId(), playerTurn.turnX);
        } else {
            piece.setText("O");
            turn = playerTurn.turnX;
            gb.addMark(piece.getId(), playerTurn.turnO);
        }

        if (gb.checkForWin() == playerTurn.turnO) {
            winnerScreen(playerTurn.turnO);
            System.out.println("Player O Wins!");
        } else if (gb.checkForWin() == playerTurn.turnX) {
            winnerScreen(playerTurn.turnX);
            System.out.println("Player X Wins!");
        }
        gb.printBoard();
    }

    public void restart(View view) {
        //TODO
        //some type of reset function here
        finish();
    }

    private void winnerScreen(playerTurn winner) {
        Intent in = new Intent(this, winnerActivity.class);
        String player = "";
        if (winner == playerTurn.turnO) {
            player = "O";
        } else {
            player = "X";
        }
        in.putExtra(WINNER_MSG, player);
        startActivity(in);
    }
}
