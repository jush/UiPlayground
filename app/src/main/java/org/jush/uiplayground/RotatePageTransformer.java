package org.jush.uiplayground;

import android.support.v4.view.ViewPager;
import android.view.View;

public class RotatePageTransformer implements ViewPager.PageTransformer {

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        view.setPivotX(pageWidth / 2);
        view.setPivotY(pageHeight);

        if (position <= -1) { // [-Infinity,-1]
            // This page is way off-screen to the left.
            view.setAlpha(0);
        } else if (position < 1) { // (-1,1)
            view.setTranslationX((-position) * pageWidth); //shift the view over
            view.setRotation(60 * position);

            // Fade the page relative to its position.
            view.setAlpha(1 - Math.abs(position));
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}