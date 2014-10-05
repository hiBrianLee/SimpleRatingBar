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

class MockAttributes extends SimpleRatingBarAttributes {

    private boolean mockSize;
    private boolean mockHideRatingNumber;
    private boolean mockMaxRating;
    private boolean mockTextColor;
    private boolean mockFilledIconColor;
    private boolean mockUnfilledIconColor;
    private boolean mockFilledIcon;
    private boolean mockUnfilledIcon;

    private float size;
    private boolean hideRatingNumber;
    private int maxRating;
    private int textColor;
    private int filledIconColor;
    private int unfilledIconColor;
    private String filledIcon;
    private String unfilledIcon;

    MockAttributes(Context context) {
        super(context, null);
    }

    @Override
    float getSize() {
        if (mockSize) {
            return size;
        } else {
            return super.getSize();
        }
    }

    @Override
    boolean getHideRatingNumber() {
        if (mockHideRatingNumber) {
            return hideRatingNumber;
        } else {
            return super.getHideRatingNumber();
        }
    }

    @Override
    int getMaxRating() {
        if (mockMaxRating) {
            return maxRating;
        } else {
            return super.getMaxRating();
        }
    }

    @Override
    int getTextColor() {
        if (mockTextColor) {
            return textColor;
        } else {
            return super.getTextColor();
        }
    }

    @Override
    int getFilledIconColor() {
        if (mockFilledIconColor) {
            return filledIconColor;
        } else {
            return super.getFilledIconColor();
        }
    }

    @Override
    int getUnfilledIconColor() {
        if (mockUnfilledIconColor) {
            return unfilledIconColor;
        } else {
            return super.getUnfilledIconColor();
        }
    }

    @Override
    String getFilledIcon() {
        if (mockFilledIcon) {
            return filledIcon;
        } else {
            return super.getFilledIcon();
        }
    }

    @Override
    String getUnfilledIcon() {
        if (mockUnfilledIcon) {
            return unfilledIcon;
        } else {
            return super.getUnfilledIcon();
        }
    }

    void setSize(float size) {
        mockSize = true;
        this.size = size;
    }

    void setHideRatingNumber(boolean hideRatingNumber) {
        mockHideRatingNumber = true;
        this.hideRatingNumber = hideRatingNumber;
    }

    void setMaxRating(int maxRating) {
        mockMaxRating = true;
        this.maxRating = maxRating;
    }

    void setTextColor(int textColor) {
        mockTextColor = true;
        this.textColor = textColor;
    }

    void setFilledIconColor(int filledIconColor) {
        mockFilledIconColor = true;
        this.filledIconColor = filledIconColor;
    }

    void setUnfilledIconColor(int unfilledIconColor) {
        mockUnfilledIconColor = true;
        this.unfilledIconColor = unfilledIconColor;
    }

    void setFilledIcon(String filledIcon) {
        mockFilledIcon = true;
        this.filledIcon = filledIcon;
    }

    void setUnfilledIcon(String unfilledIcon) {
        mockUnfilledIcon = true;
        this.unfilledIcon = unfilledIcon;
    }
}
