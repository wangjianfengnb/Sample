package com.sample.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.sample.R;
import com.sample.dagger.component.AppComponent;
import com.sample.dagger.component.DaggerActivityComponent;
import com.sample.dagger.module.ActivityModule;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


/**
 * Created by Jam on 16-7-12
 * Description:
 */
public class DaggerActivity extends AppCompatActivity {

    private static final String TAG = "DaggerActivity";
    TextView text;

    @Inject
    DaggerPresenter presenter;

    @Inject
    OkHttpClient client;

    @Inject
    Retrofit retrofit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        text = (TextView) findViewById(R.id.text);
        inject();
        presenter.showUserName();
        Log.i(TAG, "client = " + (client == null ? "null" : client));
        Log.i(TAG, "retrofit = " + (retrofit == null ? "null" : retrofit));
    }

    private void inject() {
        AppComponent appComponent = ((MyApplication) getApplication()).getAppComponent();
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(this))
                .build().inject(this);
    }

    public void showUserName(String name) {
        text.setText(name);
    }
}
