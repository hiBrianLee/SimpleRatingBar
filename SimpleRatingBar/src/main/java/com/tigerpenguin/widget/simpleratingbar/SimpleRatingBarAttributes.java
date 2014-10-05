/*
 * Copyright (C) 2014 Brian Lee
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tigerpenguin.widget.simpleratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

class SimpleRatingBarAttributes {

    private float size;
    private boolean hideRatingNumber;
    private int maxRating;
    private int textColor;
    private int filledIconColor;
    private int unfilledIconColor;
    private String filledIcon;
    private String unfilledIcon;

    SimpleRatingBarAttributes(Context context, AttributeSet attrs) {
        final int defaultFilledColor = context.getResources().getColor(SimpleRatingBar.DEFAULT_FILLED_COLOR_ID);
        final int defaultUnfilledColor = context.getResources().getColor(SimpleRatingBar.DEFAULT_UNFILLED_COLOR_ID);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SimpleRatingBar, 0, 0);
        try {
            size = typedArray.getDimensionPixelSize(R.styleable.SimpleRatingBar_SRB_size, 0);
            hideRatingNumber = typedArray.getBoolean(R.styleable.SimpleRatingBar_SRB_hideRatingNumber, false);
            maxRating = typedArray.getInt(R.styleable.SimpleRatingBar_SRB_maxRating, SimpleRatingBar.DEFAULT_MAX_RATING);
            filledIcon = typedArray.getString(R.styleable.SimpleRatingBar_SRB_filledIcon);
            unfilledIcon = typedArray.getString(R.styleable.SimpleRatingBar_SRB_unfilledIcon);
            textColor = typedArray.getColor(R.styleable.SimpleRatingBar_SRB_textColor, defaultFilledColor);
            filledIconColor = typedArray.getColor(R.styleable.SimpleRatingBar_SRB_filledIconColor, defaultFilledColor);
            unfilledIconColor = typedArray.getColor(R.styleable.SimpleRatingBar_SRB_unfilledIconColor,
                    defaultUnfilledColor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            typedArray.recycle();
        }
    }

    float getSize() {
        return size;
    }

    boolean getHideRatingNumber() {
        return hideRatingNumber;
    }

    int getMaxRating() {
        return maxRating;
    }

    int getTextColor() {
        return textColor;
    }

    int getFilledIconColor() {
        return filledIconColor;
    }

    int getUnfilledIconColor() {
        return unfilledIconColor;
    }

    String getFilledIcon() {
        return filledIcon;
    }

    String getUnfilledIcon() {
        return unfilledIcon;
    }
}
