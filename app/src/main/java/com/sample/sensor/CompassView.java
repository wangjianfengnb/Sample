package com.sample.sensor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

import com.sample.R;

/**
 * Created by Jam on 16-9-23
 * Description:
 */
public class CompassView extends View implements Runnable{
    private Paint _mPaint = new Paint();
    private String _message = "正北 0°";
    private float _decDegree = 0;
    private Bitmap _compass;
    private Bitmap _arrow;

    public CompassView(Context context) {
        super(context);

        // 载入图片
        _compass = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        _arrow = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

        // 开启线程否则无法更新画面
        new Thread(this).start();
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);

        _mPaint.setColor(Color.WHITE);
        _mPaint.setTextSize(30);
        _mPaint.setFlags(Paint.FAKE_BOLD_TEXT_FLAG);

        canvas.drawText(_message, 75, 50, _mPaint);

        // 实现图像旋转
        Matrix mat = new Matrix();

        mat.reset();
        mat.setTranslate(15, 100);
        mat.preRotate(-_decDegree, 145, 145);

        // 绘制图像
        canvas.drawBitmap(_compass, mat, _mPaint);
        canvas.drawBitmap(_arrow, 152, 73, null);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            postInvalidate();
        }

    }

    // 更新指南针角度
    public void setDegree(float degree) {
        // 设置灵敏度
        if (Math.abs(_decDegree - degree) >= 2) {
            _decDegree = degree;

            int range = 22;

            String degreeStr = String.valueOf(_decDegree);

            // 指向正北
            if (_decDegree > 360 - range && _decDegree < 360 + range) {
                _message = "正北 " + degreeStr + "°";
            }

            // 指向正东
            if (_decDegree > 90 - range && _decDegree < 90 + range) {
                _message = "正东 " + degreeStr + "°";
            }

            // 指向正南
            if (_decDegree > 180 - range && _decDegree < 180 + range) {
                _message = "正南 " + degreeStr + "°";
            }

            // 指向正西
            if (_decDegree > 270 - range && _decDegree < 270 + range) {
                _message = "正西 " + degreeStr + "°";
            }

            // 指向东北
            if (_decDegree > 45 - range && _decDegree < 45 + range) {
                _message = "东北 " + degreeStr + "°";
            }

            // 指向东南
            if (_decDegree > 135 - range && _decDegree < 135 + range) {
                _message = "东南 " + degreeStr + "°";
            }

            // 指向西南
            if (_decDegree > 225 - range && _decDegree < 225 + range) {
                _message = "西南 " + degreeStr + "°";
            }

            // 指向西北
            if (_decDegree > 315 - range && _decDegree < 315 + range) {
                _message = "西北 " + degreeStr + "°";
            }
        }

    }

    // 更新指示信息
    public void setMessage(String message) {
        _message = message;

    }
}
