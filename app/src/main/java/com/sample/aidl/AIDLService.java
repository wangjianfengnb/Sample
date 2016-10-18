package com.sample.aidl;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jam on 16-10-18
 * Description:
 */
public class AIDLService extends android.app.Service {
    private static final String TAG = "AIDLService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new BookManager();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"AIDLService onCreate");
    }

    class BookManager extends IBookManager.Stub {
        List<Book> books = new ArrayList<>();

        @Override
        public void addBook(Book book) throws RemoteException {
            Log.i(TAG, "addBook :" + book.name);
            books.add(book);
        }

        @Override
        public List<Book> getList() throws RemoteException {
            Log.i(TAG, "getList()");
            return books;
        }
    }
}
