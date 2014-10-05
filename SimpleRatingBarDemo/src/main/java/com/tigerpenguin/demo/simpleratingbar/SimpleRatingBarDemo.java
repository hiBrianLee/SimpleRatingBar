package com.tigerpenguin.demo.simpleratingbar;

import android.app.Activity;
import android.os.Bundle;
import com.tigerpenguin.widget.simpleratingbar.SimpleRatingBar;


public class SimpleRatingBarDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_rating_bar_demo);

        setupRatingBars("defaultBar", 5);
        setupRatingBars("heartBar", 3);
        setupRatingBars("circleBar", 5);
        setupRatingBars("dollarBar", 4);
        setupRatingBars("musicBar", 3);
    }

    private void setupRatingBars(String prefix, int maxRating) {
        String packageName = getPackageName();
        for (int i = 0; i <= maxRating; i++) {
            int ratingBarId = getResources().getIdentifier(prefix + i, "id", packageName);
            SimpleRatingBar simpleRatingBar = (SimpleRatingBar) findViewById(ratingBarId);
            simpleRatingBar.setRating(i);
        }
    }
}
