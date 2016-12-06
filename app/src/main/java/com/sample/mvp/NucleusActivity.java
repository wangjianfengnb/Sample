package com.sample.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jam on 2016/12/6.
 */

public class NucleusActivity<P extends Presenter> extends AppCompatActivity implements ViewWithPresenter<P> {

    private PresenterDelegate<P> presenterDelegate =
            new PresenterDelegate<>(ReflectionPresenterFactory.<P>fromViewClass(getClass()));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterDelegate.onCreate(this);
    }

    @Override
    public PresenterFactory<P> getPresenterFactory() {
        return presenterDelegate.getPresenterFactory();
    }

    @Override
    public void setPresenterFactory(PresenterFactory<P> factory) {
        presenterDelegate.setPresenterFactory(factory);
    }

    @Override
    public P getPresenter() {
        return presenterDelegate.getPresenter();
    }
}
