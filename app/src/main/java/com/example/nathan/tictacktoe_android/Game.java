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
import android.widget.TextView;

import java.util.ArrayList;

public class Game extends AppCompatActivity {
    private playerTurn turn = playerTurn.turnO;
    private GameBoard gb = new GameBoard();
    private int count = 0;
    private ArrayList<Button> setPiece = new ArrayList<Button>();
    public final static String WINNER_MSG = "com.example.nathan.tictacktoe_android.winner_msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        System.out.println("start Activity");
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
        boolean ifWin = false;

        setPiece.add(piece);

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
            ifWin = true;
        } else if (gb.checkForWin() == playerTurn.turnX) {
            winnerScreen(playerTurn.turnX);
            System.out.println("Player X Wins!");
            ifWin = true;
        }
        gb.printBoard();
        System.out.println("count = " + count);
        if (count == 9 && !ifWin) {
            ((TextView)findViewById(R.id.catTxt)).setText("TIE GAME");
            ((Button)findViewById(R.id.catRst)).setVisibility(View.VISIBLE);
            System.out.println("Cats Game");
        }
    }

    public void catRst(View View) {
        clearBoard();
        ((TextView)findViewById(R.id.catTxt)).setText("");
        ((Button)findViewById(R.id.catRst)).setVisibility(View.INVISIBLE);
    }

    public void clearBoard() {
        // Method that clears the board
        System.out.println("Clearing beard");
        gb.resetBoard();
        count = 0;
        for (Button btn : setPiece) {
            btn.setText("");
            btn.setClickable(true);
        }

    }

    @Override
    public void onRestart() {
        super.onRestart();
        System.out.println("Restarting Game");
        clearBoard();
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
        in.putExtra("gmBoard", gb);
        startActivity(in);
    }
}
