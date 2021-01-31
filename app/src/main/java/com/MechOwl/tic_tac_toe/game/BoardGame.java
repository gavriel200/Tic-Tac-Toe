package com.MechOwl.tic_tac_toe.game;

import android.widget.Button;

public class BoardGame {
    private Button[] buttons;

    public BoardGame(Button[] buttons) {
        this.buttons = buttons;
    }

    public void reset() {
        for (Button b : buttons) {
            b.setText(null);
            b.setClickable(true);
        }
    }

    public void EndGame() {
        for (Button b : buttons) {
            b.setClickable(false);
        }
    }
}