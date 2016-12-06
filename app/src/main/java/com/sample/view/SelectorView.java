package com.sample.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.sample.R;

/**
 * Created by Jam on 16-8-18
 * Description:
 */
public class SelectorView extends View {
    private Context mContext;// 上下文环境引用
    private Paint mPaint;
    private Bitmap bitmap;  //位图
    private boolean isClick;    //标记是否被点击了

    public SelectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        initRes(context);
        //点击事件
        setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //判断是否点击
                if (isClick) {
                    mPaint.setColorFilter(null);
                    isClick = false;
                }else {
                    mPaint.setColorFilter(new LightingColorFilter(0x00000000, 0XFF00FF00));//这个地方设置的是LightingColorFilter()
                    isClick = true;
                }
                invalidate();
            }
        });
    }

    public SelectorView(Context context) {
        super(context);
    }

    private void initRes(Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.phone);//带点击改变的图片
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
    }

    private void initPaint(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }
}
