package com.sample.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sample.R;

/**
 * Created by Jam on 16-8-18
 * Description:
 */
public class CustomViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        SelectorView sv = (SelectorView) findViewById(R.id.cv_circle);
    }
}
