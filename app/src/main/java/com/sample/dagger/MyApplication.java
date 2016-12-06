package com.sample.dagger;

import android.app.Application;

import com.sample.dagger.component.AppComponent;
import com.sample.dagger.component.DaggerAppComponent;
import com.sample.dagger.module.ApiModule;

/**
 * Created by Jam on 16-7-12
 * Description:
 */
public class MyApplication extends Application {


    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
