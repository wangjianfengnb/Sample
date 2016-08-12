package com.sample.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sample.dagger.bean.Model;
import com.sample.dagger.component.DaggerModelComponent;
import com.sample.dagger.module.ModelModule;

import javax.inject.Inject;

/**
 * Created by Jam on 16-8-9
 * Description:
 */
public class NextActivity extends AppCompatActivity{


    private static final String TAG = "NextActivity";
    @Inject
    Model model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerModelComponent.builder().modelModule(new ModelModule())
                .build()
                .inject(this);
        Log.i(TAG, "model = " + (model == null ? "null" : model));
    }



}
