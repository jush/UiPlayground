package org.jush.uiplayground;

import android.app.Application;

import org.jush.uiplayground.injection.ApplicationComponent;
import org.jush.uiplayground.injection.ApplicationModule;
import org.jush.uiplayground.injection.DaggerApplicationComponent;

public class UiPlaygroundApplication extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        this.component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    ApplicationComponent getComponent() {
        return component;
    }
}
