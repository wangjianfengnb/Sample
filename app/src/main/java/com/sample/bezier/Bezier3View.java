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
public class Bezier3View extends View {
    private Point assistPoint1; //控制点
    private Point assistPoint2;
    private Paint mPaint; //画笔
    private Path mPath; //路径
    private Point startPoint; //起点
    private Point endPoint;  //终点

    public Bezier3View(Context context) {
        super(context);
        init();
    }

    public Bezier3View(Context contex, AttributeSet attr) {
        super(contex, attr);
        init();
    }


    /**
     * 150         startPoint(300,150)                                         endPoint(900,150)
     * <p/>
     * <p/>
     * <p/>
     * 450                   assistPoint1(500,450)   assistPoint2(700,450)
     */
    private void init() {
        mPaint = new Paint();
        mPath = new Path();
        startPoint = new Point(300, 150);
        endPoint = new Point(900, 150);
        assistPoint1 = new Point(500, 450);
        assistPoint2 = new Point(700, 450);
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
        mPath.cubicTo(assistPoint2.x, assistPoint2.y, assistPoint1.x, assistPoint1.y, endPoint.x, endPoint.y);
        //画path
        canvas.drawPath(mPath, mPaint);
        //画控制点
        canvas.drawPoint(assistPoint1.x, assistPoint1.y, mPaint);
        canvas.drawPoint(assistPoint2.x, assistPoint2.y, mPaint);

        //画线
        canvas.drawLine(startPoint.x, startPoint.y, assistPoint1.x, assistPoint1.y, mPaint);
        canvas.drawLine(endPoint.x, endPoint.y, assistPoint2.x, assistPoint2.y, mPaint);
        canvas.drawLine(assistPoint1.x, assistPoint1.y, assistPoint2.x, assistPoint2.y, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                assistPoint1.x = (int) event.getX();
                assistPoint1.y = (int) event.getY();
                invalidate();
                break;
        }
        return true;
    }
}