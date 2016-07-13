package com.sample.dagger.component;

import com.sample.dagger.bean.User;
import com.sample.dagger.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Jam on 16-7-12
 * Description:
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {

    OkHttpClient getClient();

    Retrofit getRetrofit();

    User getUser();


}
