package com.example.zujinhao.test.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by zujinhao on 2017/11/27.
 * 放在他下边的view都能被拖动
 */

public class DragViewContainerLayout extends LinearLayout {
    private ViewDragHelper mViewDragHelper;

    public DragViewContainerLayout(Context context) {
        this(context,null);
    }

    public DragViewContainerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mViewDragHelper = ViewDragHelper.create(this,1f,new ViewDragCallback());
    }



    class ViewDragCallback extends ViewDragHelper.Callback{

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }


        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            if (left<getPaddingLeft()){
                return getPaddingLeft();
            }

            if (left> getWidth()-child.getMeasuredWidth()){
                return getWidth()-child.getMeasuredWidth();
            }
            return left;
        }


        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            if (top <getPaddingTop()){
                return  getPaddingTop();
            }

            if (top > getHeight()-child.getMeasuredHeight()){
                return getHeight()-child.getMeasuredHeight();
            }

            return  top;
        }

        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);

        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return 1;
        }

        @Override
        public int getViewVerticalDragRange(View child) {
            return 1;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mViewDragHelper.cancel();
                break;
        }
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }
}
