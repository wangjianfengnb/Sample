package com.sample.retrofit;

import java.io.Serializable;

/**
 * Created by Jam on 16-8-12
 * Description:
 */
public class BaseModel<T> implements Serializable{
    public String error;
    public String msg;
    public T results;


    public boolean success(){
        return error.equals("false");
    }
}
