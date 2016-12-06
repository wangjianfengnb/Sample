package com.sample.mvp;

import android.support.annotation.Nullable;

/**
 * Created by Jam on 2016/12/6.
 */

public class PresenterDelegate<P extends Presenter> {
    private PresenterFactory<P> presenterFactory;
    private P presenter;

    public PresenterDelegate(@Nullable PresenterFactory<P> presenterFactory) {
        this.presenterFactory = presenterFactory;
    }

    @Nullable
    public PresenterFactory<P> getPresenterFactory() {
        return presenterFactory;
    }

    public void setPresenterFactory(@Nullable PresenterFactory<P> presenterFactory) {
        this.presenterFactory = presenterFactory;
    }

    public P getPresenter() {
        if (presenterFactory != null) {
            if (presenter == null) {
                presenter = presenterFactory.createPresenter();
            }
        }
        return presenter;
    }

    public void onCreate(Object view){
        getPresenter();
        if(presenter != null){
            presenter.setView(view);
        }
    }
}
