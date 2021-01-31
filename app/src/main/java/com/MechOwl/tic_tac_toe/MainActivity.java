package com.MechOwl.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.MechOwl.tic_tac_toe.game.BoardGame;
import com.MechOwl.tic_tac_toe.game.Lines;
import com.MechOwl.tic_tac_toe.game.SquareSymbol;
import com.MechOwl.tic_tac_toe.game.MainGame;

public class MainActivity extends AppCompatActivity {
    BoardGame board;
    MainGame  game;
    Lines line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button[] buttons = new Button[]{
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9)
        };
        View[] views = new View[] {
                findViewById(R.id.line1to3),
                findViewById(R.id.line4to6),
                findViewById(R.id.line7to9),
                findViewById(R.id.line1to7),
                findViewById(R.id.line2to8),
                findViewById(R.id.line3to9),
                findViewById(R.id.line1to9),
                findViewById(R.id.line3to7),
        };
        line = new Lines(views);
        board = new BoardGame(buttons);
        game = new MainGame(findViewById(R.id.text1));
    }

    @SuppressLint("NonConstantResourceId")
    public void SquareClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                game.SquareClick(0);
                break;
            case R.id.button2:
                game.SquareClick(1);
                break;
            case R.id.button3:
                game.SquareClick(2);
                break;
            case R.id.button4:
                game.SquareClick(3);
                break;
            case R.id.button5:
                game.SquareClick(4);
                break;
            case R.id.button6:
                game.SquareClick(5);
                break;
            case R.id.button7:
                game.SquareClick(6);
                break;
            case R.id.button8:
                game.SquareClick(7);
                break;
            case R.id.button9:
                game.SquareClick(8);
                break;
        }
        v.setClickable(false);
        Button b = (Button) v;
        if (game.getTurn() == SquareSymbol.X) {
            b.setText(R.string.X);
        } else {
            b.setText(R.string.O);
        }
        int i = game.CheckWin();
        if (i != 0) {
            line(i);
            game.Win();
            board.EndGame();
        } else {
            if (game.CheckNoWin()) {
                board.EndGame();
            } else {
                game.NextTurn();
            }
        }
    }

    public void Restart(View v) {
        game.Restart();
        board.reset();
        line.reset();
    }

    public void line(int i) {
        switch (i) {
            case 13 :
                findViewById(R.id.line1to3).setVisibility(View.VISIBLE);
                break;
            case 46:
                findViewById(R.id.line4to6).setVisibility(View.VISIBLE);
                break;
            case 79:
                findViewById(R.id.line7to9).setVisibility(View.VISIBLE);
                break;
            case 17:
                findViewById(R.id.line1to7).setVisibility(View.VISIBLE);
                break;
            case 28:
                findViewById(R.id.line2to8).setVisibility(View.VISIBLE);
                break;
            case 39:
                findViewById(R.id.line3to9).setVisibility(View.VISIBLE);
                break;
            case 19:
                findViewById(R.id.line1to9).setVisibility(View.VISIBLE);
                break;
            case 37:
                findViewById(R.id.line3to7).setVisibility(View.VISIBLE);
                break;
        }
    }
}