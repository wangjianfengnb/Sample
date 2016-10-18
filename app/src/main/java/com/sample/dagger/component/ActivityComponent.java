package com.sample.dagger.component;

import com.sample.dagger.module.ActivityModule;

import dagger.Component;

/**
 * Created by Jam on 16-7-13
 * Description:
 */
@ActivityScope
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface ActivityComponent {
    //void inject(DaggerActivity daggerActivity);
}
