package com.sample.dagger.module;

import com.sample.dagger.DaggerActivity;
import com.sample.dagger.DaggerPresenter;
import com.sample.dagger.bean.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jam on 16-7-13
 * Description:
 */
@Module
public class ActivityModule {
    private DaggerActivity activity;

    public ActivityModule(DaggerActivity activity) {
        this.activity = activity;
    }

    @Provides
    public DaggerActivity provideActivity() {
        return activity;
    }

    @Provides
    public DaggerPresenter provideDaggerPresenter(DaggerActivity activity, User user) {
        return new DaggerPresenter(activity, user);
    }
}
