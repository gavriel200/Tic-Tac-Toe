package com.MechOwl.tic_tac_toe.game;

import android.view.View;

public class Lines {
    private View[] views;

    public Lines(View[] views) {
        this.views = views;
    }

    public void reset() {
        for (View v : views) {
            v.setVisibility(View.INVISIBLE);
        }
    }
}
