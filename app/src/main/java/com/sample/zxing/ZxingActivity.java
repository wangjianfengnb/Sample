package com.sample.zxing;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sample.R;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * Created by Jam on 16-8-9
 * Description:
 */
public class ZxingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);
        CaptureFragment captureFragment = new CaptureFragment();
      //  CodeUtils.setFragmentArgs(captureFragment);


        captureFragment.setAnalyzeCallback(analyzecallback);
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_content, captureFragment).commit();
    }
    CodeUtils.AnalyzeCallback analyzecallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Log.i("ZxingActivity",result);
        }

        @Override
        public void onAnalyzeFailed() {

        }
    };
}
