package com.sample.dagger.module;

import com.sample.dagger.bean.Model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jam on 16-8-9
 * Description:
 */
@Module
public class ModelModule {
    @Singleton
    @Provides
    public Model provideModel() {
        return new Model();
    }


}
