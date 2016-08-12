package com.sample.dagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sample.R;
import com.sample.dagger.bean.Model;
import com.sample.dagger.component.DaggerModelComponent;
import com.sample.dagger.module.ModelModule;

import javax.inject.Inject;


/**
 * Created by Jam on 16-7-12
 * Description:
 */
public class DaggerActivity extends AppCompatActivity {

    private static final String TAG = "DaggerActivity";
    TextView text;
//
//    @Inject
//    DaggerPresenter presenter;

//    @Inject
//    OkHttpClient client;
//
//    @Inject
//    Retrofit retrofit;

    @Inject
    Model model1;

    @Inject
    Model model2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        text = (TextView) findViewById(R.id.text);
        text.setText("下一页");
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaggerActivity.this, NextActivity.class));
            }
        });
        inject();
//        presenter.showUserName();
//        Log.i(TAG, "client = " + (client == null ? "null" : client));
//        Log.i(TAG, "retrofit = " + (retrofit == null ? "null" : retrofit));
        Log.i(TAG, "model1 = " + (model1 == null ? "null" : model1));
        Log.i(TAG, "model2 = " + (model2 == null ? "null" : model2));
    }

    private void inject() {
//        AppComponent appComponent = ((MyApplication) getApplication()).getAppComponent();
//        DaggerActivityComponent.builder()
//                .appComponent(appComponent)
//                .activityModule(new ActivityModule(this))
//                .build().inject(this);
        DaggerModelComponent.builder()
                .modelModule(new ModelModule())
                .build()
                .inject(this);
    }

    public void showUserName(String name) {
        text.setText(name);
    }
}
