package com.sample.jni;

/**
 * Created by Jam on 16-10-18
 * Description:
 */
public class Test {
    static{
        System.loadLibrary("jni-test");
    }
    public static native void hello();
}
