package org.jush.uiplayground.injection;

import android.app.Application;

import dagger.Component;

@Component(
        modules = ApplicationModule.class)
public interface ApplicationComponent {
    Application injectApplication(Application application);
}