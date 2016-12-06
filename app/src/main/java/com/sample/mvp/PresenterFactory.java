package com.sample.mvp;

/**
 * Created by Jam on 2016/12/6.
 */
public interface PresenterFactory<P extends Presenter> {
    P createPresenter();
}
