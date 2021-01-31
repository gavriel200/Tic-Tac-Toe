package com.MechOwl.tic_tac_toe.game;

import android.widget.TextView;

import com.MechOwl.tic_tac_toe.R;

public class MainGame {
    private SquareSymbol[] squares;
    private final TextView text;
    private SquareSymbol turn;

    public SquareSymbol[] getSquares() {
        return squares;
    }

    public SquareSymbol getTurn() {
        return turn;
    }

    public MainGame(TextView text) {
        turn = SquareSymbol.X;
        this.text = text;
        text.setText(R.string.xTurn);
        this.squares = new SquareSymbol[]{
                SquareSymbol.NONE,
                SquareSymbol.NONE,
                SquareSymbol.NONE,
                SquareSymbol.NONE,
                SquareSymbol.NONE,
                SquareSymbol.NONE,
                SquareSymbol.NONE,
                SquareSymbol.NONE,
                SquareSymbol.NONE
        };
    }

    public void SquareClick(int square) {
        squares[square] = turn;
    }

    public void NextTurn() {
        if (turn == SquareSymbol.X) {
            turn = SquareSymbol.O;
            text.setText(R.string.oTurn);
        } else {
            turn = SquareSymbol.X;
            text.setText(R.string.xTurn);
        }
    }

    public void Restart() {
        turn = SquareSymbol.X;
        text.setText(R.string.xTurn);
        for (int i=0; i<9; i++) {
            squares[i] = SquareSymbol.NONE;
        }
    }

    public int CheckWin() {
        for (int i=0; i<8; i = i + 3) {
            if (squares[i] == squares[i+1] && squares[i] == squares[i+2]
                    && squares[i] != SquareSymbol.NONE){
                if (i == 0) {
                    return 13;
                } else if(i == 3) {
                    return 46;
                } else {
                    return 79;
                }
            }
        }
        for (int i=0; i<3; i++) {
            if (squares[i] == squares[i+3] && squares[i] == squares[i+6]
                    && squares[i] != SquareSymbol.NONE){
                if (i == 0) {
                    return 17;
                } else if (i == 1) {
                    return 28;
                } else {
                    return 39;
                }
            }
        }
        if (squares[0] == squares[4] && squares[0] == squares[8]
                && squares[0] != SquareSymbol.NONE){
            return 19;
        }
        if (squares[2] == squares[4] && squares[4] == squares[6]
                && squares[2] != SquareSymbol.NONE){
            return 37;
        }
        return 0;
    }

    public boolean CheckNoWin() {
        for (SquareSymbol s : squares) {
            if (s == SquareSymbol.NONE){
                return false;
            }
        }
        text.setText(R.string.noWon);
        return true;
    }

    public void Win() {
        if (turn == SquareSymbol.X) {
            text.setText(R.string.xWon);
        } else {
            text.setText(R.string.oWon);
        }
    }
}