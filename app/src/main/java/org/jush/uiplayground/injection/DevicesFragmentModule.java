package org.jush.uiplayground.injection;

import org.jush.uiplayground.presenters.DevicesPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class DevicesFragmentModule {
    @Provides
    DevicesPresenter devicesPresenter() {
        return new DevicesPresenter();
    }
}
