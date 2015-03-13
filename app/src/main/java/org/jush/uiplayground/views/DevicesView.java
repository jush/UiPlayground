package org.jush.uiplayground.views;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public interface DevicesView {
    void addDevice(@StringRes int nameId, @DrawableRes int iconId);
}
