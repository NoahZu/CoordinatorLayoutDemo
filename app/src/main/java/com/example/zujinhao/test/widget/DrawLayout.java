package com.example.zujinhao.test.widget;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by zujinhao on 2017/8/30.
 */

public class DrawLayout extends FrameLayout {
    private int mWidth;
    private int mHeight;
    private Point prePoint;
    private int mMySlop = 20;

    public DrawLayout(@NonNull Context context) {
        this(context,null);
    }

    public DrawLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        onInit();
    }

    private void onInit() {
        prePoint = null;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mWidth = right - left;
        mHeight = top - bottom;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                prePoint = new Point((int)event.getX(),(int) event.getY());
                printPoint("down",prePoint);
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                Point currentPoint = new Point((int)event.getX(),(int) event.getY());
                printPoint("move",currentPoint);
                moveByFinger(currentPoint);
                break;
        }
        return true;
    }

    private void moveByFinger(Point point) {
        if (prePoint == null){
            return;
        }
        if (!filterPointBySlop(point)){
            return;
        }
        int xDiv = point.x - prePoint.x;
        int yDiv = point.y - prePoint.y;

        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        marginLayoutParams.leftMargin += xDiv;
        marginLayoutParams.topMargin += yDiv;
        prePoint = point;
        requestLayout();
    }

    private boolean filterPointBySlop(Point point){
        int xDiv = point.x - prePoint.x;
        int yDiv = point.y - prePoint.y;
        if (xDiv > mMySlop || yDiv > mMySlop){
            return true;
        }
        return false;
    }

    public void printPoint(String tag,Point point){
        System.out.println("==="+tag+",x:"+point.x+"y:"+point.y);
    }
}
