package org.jush.uiplayground.injection;

import org.jush.uiplayground.DevicesFragment;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class, modules = DevicesFragmentModule.class)
public interface DevicesFragmentComponent {
    DevicesFragment inject(DevicesFragment devicesFragment);
}
