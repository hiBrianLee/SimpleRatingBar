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

import android.test.AndroidTestCase;
import android.view.View;

import static com.tigerpenguin.widget.simpleratingbar.SimpleRatingBar.SimpleRatingBarTester;

public class SimpleRatingBarTest extends AndroidTestCase {

    private static final String STARS[] = { "", "★", "★★", "★★★", "★★★★", "★★★★★", "★★★★★★"};
    private static final String DOLLARS[] = { "", "$", "$$", "$$$", "$$$$", "$$$$$", "$$$$$$"};
    
    private SimpleRatingBar simpleRatingBar;
    private SimpleRatingBarTester simpleRatingBarTester;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        simpleRatingBar = new SimpleRatingBar(getContext());
        simpleRatingBarTester = new SimpleRatingBarTester(simpleRatingBar);
    }

    @Override
    protected void tearDown() throws Exception {
        simpleRatingBar = null;
        simpleRatingBarTester = null;
        super.tearDown();
    }

    public void testRatingTextInt() {
        for(int i = 0; i <= 5; i++) {
            simpleRatingBar.setRating(i);
            assertEquals(String.valueOf(i), simpleRatingBarTester.getRatingTextDisplayed().toString());
        }
    }

    public void testRatingTextInvalidInt() {
        simpleRatingBar.setRating(-1);
        assertEquals("-1", simpleRatingBarTester.getRatingTextDisplayed().toString());

        simpleRatingBar.setRating(6);
        assertEquals("6", simpleRatingBarTester.getRatingTextDisplayed().toString());
    }

    public void testRatingTextDouble() {
        for(double d = 0.0d; d <= 5.0d; d += 1.0d) {
            simpleRatingBar.setRating(d);
            assertEquals(String.valueOf(d), simpleRatingBarTester.getRatingTextDisplayed().toString());
        }
    }

    public void testRatingTextInvalidDouble() {
        simpleRatingBar.setRating(-1.0);
        assertEquals("-1.0", simpleRatingBarTester.getRatingTextDisplayed().toString());

        simpleRatingBar.setRating(6.0);
        assertEquals("6.0", simpleRatingBarTester.getRatingTextDisplayed().toString());
    }

    public void testIconInt() {
        simpleRatingBar.setRating(0);
        assertRatingIcons(STARS, 0, 5);

        simpleRatingBar.setRating(1);
        assertRatingIcons(STARS, 1, 4);

        simpleRatingBar.setRating(2);
        assertRatingIcons(STARS, 2, 3);

        simpleRatingBar.setRating(3);
        assertRatingIcons(STARS, 3, 2);

        simpleRatingBar.setRating(4);
        assertRatingIcons(STARS, 4, 1);

        simpleRatingBar.setRating(5);
        assertRatingIcons(STARS, 5, 0);
    }

    public void testIconInvalidInt() {
        simpleRatingBar.setRating(-1);
        assertRatingIcons(STARS, 0, 5);

        simpleRatingBar.setRating(6);
        assertRatingIcons(STARS, 5, 0);
    }

    public void testIconDouble() {
        simpleRatingBar.setRating(0.0);
        assertRatingIcons(STARS, 0, 5);
        simpleRatingBar.setRating(0.3);
        assertRatingIcons(STARS, 0, 5);

        simpleRatingBar.setRating(0.5);
        assertRatingIcons(STARS, 1, 4);
        simpleRatingBar.setRating(1.0);
        assertRatingIcons(STARS, 1, 4);
        simpleRatingBar.setRating(1.3);
        assertRatingIcons(STARS, 1, 4);

        simpleRatingBar.setRating(4.3);
        assertRatingIcons(STARS, 4, 1);
        simpleRatingBar.setRating(4.5);
        assertRatingIcons(STARS, 5, 0);
        simpleRatingBar.setRating(5.0);
        assertRatingIcons(STARS, 5, 0);
    }

    public void testIconInvalidDouble() {
        simpleRatingBar.setRating(-0.1);
        assertRatingIcons(STARS, 0, 5);

        simpleRatingBar.setRating(5.1);
        assertRatingIcons(STARS, 5, 0);
    }

    public void testSize() {
        float textSize = 20f;

        MockAttributes mockAttributes = new MockAttributes(getContext());
        mockAttributes.setSize(textSize);
        simpleRatingBarTester.readAttributes(mockAttributes);
        assertEquals(textSize, simpleRatingBarTester.getRatingNumberTextSize());
        assertEquals(textSize, simpleRatingBarTester.getFilledIconTextSize());
        assertEquals(textSize, simpleRatingBarTester.getUnfilledIconTextSize());

        textSize = 52f;
        mockAttributes.setSize(textSize);
        simpleRatingBarTester.readAttributes(mockAttributes);
        assertEquals(textSize, simpleRatingBarTester.getRatingNumberTextSize());
        assertEquals(textSize, simpleRatingBarTester.getFilledIconTextSize());
        assertEquals(textSize, simpleRatingBarTester.getUnfilledIconTextSize());
    }

    public void testHideRatingNumber() {
        assertEquals(View.VISIBLE, simpleRatingBarTester.getRatingNumberVisibility());

        MockAttributes mockAttributes = new MockAttributes(getContext());
        mockAttributes.setHideRatingNumber(true);

        simpleRatingBarTester.readAttributes(mockAttributes);
        assertEquals(View.GONE, simpleRatingBarTester.getRatingNumberVisibility());
    }
    
    public void testMaxRating() {
        simpleRatingBar.setRating(Integer.MAX_VALUE);
        assertRatingIcons(STARS, 5, 0);

        MockAttributes mockAttributes = new MockAttributes(getContext());
        mockAttributes.setMaxRating(3);
        simpleRatingBarTester.readAttributes(mockAttributes);
        simpleRatingBar.setRating(Integer.MAX_VALUE);
        assertRatingIcons(STARS, 3, 0);

        mockAttributes.setMaxRating(6);
        simpleRatingBarTester.readAttributes(mockAttributes);
        simpleRatingBar.setRating(Integer.MAX_VALUE);
        assertRatingIcons(STARS, 6, 0);
    }

    public void testRatingColor() {
        int defaultFilledIconColor = simpleRatingBarTester.getFilledIconColor();
        int defaultUnfilledIconColor = simpleRatingBarTester.getUnfilledIconColor();

        int newColor = 12345;
        MockAttributes mockAttributes = new MockAttributes(getContext());
        mockAttributes.setTextColor(newColor);
        simpleRatingBarTester.readAttributes(mockAttributes);
        assertEquals(newColor, simpleRatingBarTester.getRatingColor());
        assertEquals(defaultFilledIconColor, simpleRatingBarTester.getFilledIconColor());
        assertEquals(defaultUnfilledIconColor, simpleRatingBarTester.getUnfilledIconColor());
    }

    public void testFilledIconColor() {
        int defaultRatingColor = simpleRatingBarTester.getRatingColor();
        int defaultUnfilledIconColor = simpleRatingBarTester.getUnfilledIconColor();

        int newColor = 12345;
        MockAttributes mockAttributes = new MockAttributes(getContext());
        mockAttributes.setFilledIconColor(newColor);
        simpleRatingBarTester.readAttributes(mockAttributes);
        assertEquals(defaultRatingColor, simpleRatingBarTester.getRatingColor());
        assertEquals(newColor, simpleRatingBarTester.getFilledIconColor());
        assertEquals(defaultUnfilledIconColor, simpleRatingBarTester.getUnfilledIconColor());
    }

    public void testUnfilledIconColor() {
        int defaultRatingColor = simpleRatingBarTester.getRatingColor();
        int defaultFilledIconColor = simpleRatingBarTester.getFilledIconColor();

        int newColor = 12345;
        MockAttributes mockAttributes = new MockAttributes(getContext());
        mockAttributes.setUnfilledIconColor(newColor);
        simpleRatingBarTester.readAttributes(mockAttributes);
        assertEquals(defaultRatingColor, simpleRatingBarTester.getRatingColor());
        assertEquals(defaultFilledIconColor, simpleRatingBarTester.getFilledIconColor());
        assertEquals(newColor, simpleRatingBarTester.getUnfilledIconColor());
    }

    public void testFilledIcon() {
        MockAttributes mockAttributes = new MockAttributes(getContext());
        mockAttributes.setFilledIcon("$");
        simpleRatingBarTester.readAttributes(mockAttributes);

        simpleRatingBar.setRating(0);
        assertRatingIcons(DOLLARS, 0, 5);

        simpleRatingBar.setRating(3);
        assertRatingIcons(DOLLARS, 3, 2);

        simpleRatingBar.setRating(5);
        assertRatingIcons(DOLLARS, 5, 0);
    }

    public void testUnfilledIcon() {
        MockAttributes mockAttributes = new MockAttributes(getContext());
        mockAttributes.setUnfilledIcon("$");
        simpleRatingBarTester.readAttributes(mockAttributes);

        simpleRatingBar.setRating(0);
        assertEquals(STARS[0], simpleRatingBarTester.getFilledRatingDisplayed().toString());
        assertEquals(DOLLARS[5], simpleRatingBarTester.getUnfilledRatingDisplayed().toString());

        simpleRatingBar.setRating(3);
        assertEquals(STARS[3], simpleRatingBarTester.getFilledRatingDisplayed().toString());
        assertEquals(DOLLARS[2], simpleRatingBarTester.getUnfilledRatingDisplayed().toString());

        simpleRatingBar.setRating(5);
        assertEquals(STARS[5], simpleRatingBarTester.getFilledRatingDisplayed().toString());
        assertEquals(DOLLARS[0], simpleRatingBarTester.getUnfilledRatingDisplayed().toString());
    }

    private void assertRatingIcons(String[] icons, int expectedFilled, int expectedUnfilled) {
        assertEquals(icons[expectedFilled], simpleRatingBarTester.getFilledRatingDisplayed().toString());
        assertEquals(icons[expectedUnfilled], simpleRatingBarTester.getUnfilledRatingDisplayed().toString());
    }
}
