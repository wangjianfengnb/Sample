package com.sample.dagger.component;

import com.sample.dagger.DaggerActivity;
import com.sample.dagger.NextActivity;
import com.sample.dagger.bean.Model;
import com.sample.dagger.module.ModelModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jam on 16-8-9
 * Description:
 */
@Singleton
@Component(modules = ModelModule.class)
public interface ModelComponent {
    Model getModel();

    void inject(DaggerActivity activity);

    void inject(NextActivity nextActivity);
}
