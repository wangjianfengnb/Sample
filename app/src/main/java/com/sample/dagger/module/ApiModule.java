package com.sample.dagger.module;

import android.app.Application;

import com.sample.dagger.bean.User;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Jam on 16-7-12
 * Description:
 */
@Module
public class ApiModule {
    public static final String END_POINT = "http://www.baidu.com";


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .build();
        return client;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(END_POINT)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    User provideUser(){
        return new User("name form ApiProvide");
    }

}
