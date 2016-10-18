package com.sample.aidl;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Jam on 16-10-18
 * Description:
 */
public class AIDLActivity extends AppCompatActivity {
    IBookManager manger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onn","onCreate");
        bindService(new Intent(this, AIDLService.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                try {
                    manger = IBookManager.Stub.asInterface(service);
                    manger.addBook(new Book("book11111"));
                    manger.getList();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                manger = null;
            }
        }, BIND_AUTO_CREATE);
    }
}
