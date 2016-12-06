package com.sample.mvp;

/**
 * Created by Jam on 2016/12/6.
 */

public class Presenter<View> {
    View view;
    public View getView(){
        return view;
    }
    public void setView(View view){
        this.view = view;
    }
}
