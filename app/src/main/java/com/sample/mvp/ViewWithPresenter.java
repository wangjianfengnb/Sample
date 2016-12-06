package com.sample.mvp;

/**
 * Created by Jam on 2016/12/6.
 */

public interface ViewWithPresenter<P extends Presenter> {

    PresenterFactory<P> getPresenterFactory();

    void setPresenterFactory(PresenterFactory<P> factory);

    P getPresenter();

}
