package com.example.zujinhao.test.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Scroller;

/**
 * Created by zujinhao on 2017/9/5.
 */

public class SwipeBackContainer extends FrameLayout {
    private Scroller mScroller;
    private float mLastX;
    private float mDownX;
    private float mCurrX;
    private int mRootWidth;
    private boolean isRightSlide;


    public SwipeBackContainer(Context context) {
        this(context,null);
    }

    public SwipeBackContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
        isRightSlide = true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mRootWidth = r - l;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = ev.getRawX();
                mLastX = mDownX;
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                mCurrX = event.getRawX();
                int scrolledX = (int) (mCurrX - mLastX);
                if (getScrollX() <= 0 && getScrollX() > -mRootWidth && scrolledX > 0){//右滑
                    scrollToFix(scrolledX,0);
                    isRightSlide = true;
                }else if (getScrollX() < 0 && getScrollX() >= -mRootWidth){//左滑
                    int span = scrolledX + mRootWidth;
                    System.out.println("span:"+span);
                    scrollToFix(span,0);
                    isRightSlide = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (isRightSlide ? getScrollXFix() > mRootWidth / 4 : getScrollXFix() > mRootWidth * 3 /4){//向右向左过了的距离分别判断
                    mScroller.startScroll(getScrollX(),0, - (mRootWidth - getScrollXFix()),0);
                }else{
                    mScroller.startScroll(getScrollX(),0, getScrollXFix(),0);
                }
                invalidate();
                break;
        }
        return true;
    }

    /**
     * 将滑动方向修正为与坐标相同，正向右，复向左
     * @param x
     * @param y
     */
    public void scrollToFix(int x, int y){
        scrollTo(-x,-y);
    }
    public int getScrollXFix() {
        return -getScrollX();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }
}
