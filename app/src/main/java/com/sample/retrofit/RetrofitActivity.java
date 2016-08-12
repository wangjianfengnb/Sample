package com.sample.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.sample.R;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by Jam on 16-8-12
 * Description:
 */
public class RetrofitActivity extends Activity {

    private static final String TAG = "RetrofitActivity";
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit);
        text = (TextView) findViewById(R.id.text);
        Observable<ArrayList<Benefit>> fromNetwrok = Api.getDefault()
                .rxBenefits(10,1)
                .compose(RxHelper.<ArrayList<Benefit>>handleResult());
        RxRetrofitCache.load(this,"cacheKey",10 * 60 * 60,fromNetwrok,false)
                .subscribe(new RxSubscribe<ArrayList<Benefit>>(this,"正在下载福利") {
                    @Override
                    protected void _onNext(ArrayList<Benefit> benefits) {
                        Log.i(TAG,benefits.toString());
                        text.setText("获得的结果为：" + benefits.toString());
                    }

                    @Override
                    protected void _onError(String message) {
                        Toast.makeText(RetrofitActivity.this,message,Toast.LENGTH_LONG).show();
                    }
                });
        
        
    }
}
