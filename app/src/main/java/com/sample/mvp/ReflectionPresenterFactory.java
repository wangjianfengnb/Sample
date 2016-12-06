package com.sample.mvp;

import android.support.annotation.Nullable;

/**
 * Created by Jam on 2016/12/6.
 */

public class ReflectionPresenterFactory<P extends Presenter> implements PresenterFactory<P> {

    private Class<P> presenterClass;

    @Nullable
    public static <P extends Presenter> ReflectionPresenterFactory<P> fromViewClass(Class<?> viewClass) {
        RequirePresenter annotation = viewClass.getAnnotation(RequirePresenter.class);
        //noinspection unchecked
        Class<P> presenterClass = annotation == null ? null : (Class<P>)annotation.value();
        return presenterClass == null ? null : new ReflectionPresenterFactory<>(presenterClass);
    }

    public ReflectionPresenterFactory(Class<P> presenterClass) {
        this.presenterClass = presenterClass;
    }

    @Override
    public P createPresenter() {
        try {
            return presenterClass.newInstance();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}