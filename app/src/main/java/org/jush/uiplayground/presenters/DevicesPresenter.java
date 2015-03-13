package org.jush.uiplayground.presenters;

import android.os.Handler;

import org.jush.uiplayground.R;
import org.jush.uiplayground.views.DevicesView;

public class DevicesPresenter extends ViewPresenter<DevicesView> {
    public void fetchAndAddDevices() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView() != null) {
                    getView().addDevice(R.string.app_name, android.R.drawable.sym_def_app_icon);
                }
            }
        }, 2000);

    }
}
