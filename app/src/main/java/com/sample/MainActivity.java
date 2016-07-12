package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sample.bezier.BezierActivity;
import com.sample.recycler.RecyclerActivity;

/**
 * Created by Jam on 16-7-12
 * Description:
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void recycler(View v) {
        startActivity(new Intent(this, RecyclerActivity.class));
    }

    public void bezier(View v) {
        startActivity(new Intent(this, BezierActivity   .class));
    }
}