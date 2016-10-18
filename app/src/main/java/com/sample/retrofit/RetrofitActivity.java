package com.sample.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sample.R;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Jam on 16-8-12
 * Description:
 */
public class RetrofitActivity extends Activity {

    private static final String TAG = "RetrofitActivity";
    TextView text;
    Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit);
        text = (TextView) findViewById(R.id.text);
//        Observable<ArrayList<Benefit>> fromNetwrok = Api.getDefault()
//                .rxBenefits(10,1)
//                .compose(RxHelper.<ArrayList<Benefit>>handleResult());
//        RxRetrofitCache.load(this,"cacheKey",10 * 60 * 60,fromNetwrok,false)
//                .subscribe(new RxSubscribe<ArrayList<Benefit>>(this,"正在下载福利") {
//                    @Override
//                    protected void _onNext(ArrayList<Benefit> benefits) {
//                        Log.i(TAG,benefits.toString());
//                        text.setText("获得的结果为：" + benefits.toString());
//                    }
//
//                    @Override
//                    protected void _onError(String message) {
//                        Toast.makeText(RetrofitActivity.this,message,Toast.LENGTH_LONG).show();
//                    }
//                });
        Log.i(TAG, "android main thread id = " + Thread.currentThread().getId());
        subscription = Observable.just("1")
                .subscribeOn(Schedulers.io())
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        for (int i = 0; i < 100; i++) {
                            Log.i(TAG, "map i = " + i + ",currentThread = " + Thread.currentThread().getId());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        return s;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i(TAG, "onNext");
                    }
                });


    }

    public void stop(View v) {
        subscription.unsubscribe();

    }
}
