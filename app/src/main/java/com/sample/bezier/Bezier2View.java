package com.sample.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by Jam on 16-7-12
 * Description:
 */
public class Bezier2View extends View {
    private Point assistPoint; //控制点
    private Paint mPaint; //画笔
    private Path mPath; //路径
    private Point startPoint; //起点
    private Point endPoint;  //终点

    public Bezier2View(Context context) {
        super(context);
        init();
    }

    public Bezier2View(Context contex, AttributeSet attr) {
        super(contex, attr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPath = new Path();
        startPoint = new Point(300, 600);
        endPoint = new Point(900, 600);
        assistPoint = new Point(600, 900);
        // 抗锯齿
        mPaint.setAntiAlias(true);
        // 防抖动
        mPaint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED); //画笔颜色
        mPaint.setStrokeWidth(10); //画笔宽度
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.reset();
        //起点
        mPath.moveTo(startPoint.x, startPoint.y);
        //mPath
        mPath.quadTo(assistPoint.x, assistPoint.y, endPoint.x, endPoint.y);
        //画path
        canvas.drawPath(mPath, mPaint);
        //画控制点
        canvas.drawPoint(assistPoint.x, assistPoint.y, mPaint);

        //画线
        canvas.drawLine(startPoint.x, startPoint.y, assistPoint.x, assistPoint.y, mPaint);
        canvas.drawLine(endPoint.x, endPoint.y, assistPoint.x, assistPoint.y, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                assistPoint.x = (int) event.getX();
                assistPoint.y = (int) event.getY();
                invalidate();
                break;
        }
        return true;
    }
}