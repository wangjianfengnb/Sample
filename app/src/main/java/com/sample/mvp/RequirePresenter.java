package com.sample.mvp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Jam on 2016/12/6.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequirePresenter {
    Class<? extends Presenter> value();
}
