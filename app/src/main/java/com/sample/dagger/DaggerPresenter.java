package com.sample.dagger;

import com.sample.dagger.bean.User;

/**
 * Created by Jam on 16-7-13
 * Description:
 */
public class DaggerPresenter {
    DaggerActivity activity;
    User user;

    public DaggerPresenter(DaggerActivity activity, User user) {
        this.user = user;
        this.activity = activity;
    }

    public void showUserName() {
        activity.showUserName(user.name);
    }
}
