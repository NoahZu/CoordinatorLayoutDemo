package com.example.zujinhao.test.xhs;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.customview.widget.ViewDragHelper;

import java.util.HashMap;
import java.util.Map;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by zujinhao on 2017/11/27.
 * 放在他下边的view都能被拖动
 */

public class XhsTextContainerLayout extends FrameLayout {
    private ViewDragHelper mViewDragHelper;
    private Map<View, Rect> paramsMap = new HashMap<>();
    private OnClickListener commonClickListener;
    private Function1<XhsTextView, Unit> commonOnDeleteFunc;
    private XhsTextView currentXhsTextView = null;

    public XhsTextContainerLayout(Context context) {
        this(context,null);
    }

    public XhsTextContainerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mViewDragHelper = ViewDragHelper.create(this,1f,new ViewDragCallback());
        commonClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                onTextClick((XhsTextView)v);
            }
        };
        commonOnDeleteFunc = new Function1<XhsTextView, Unit>() {
            @Override
            public Unit invoke(XhsTextView xhsTextView) {
                onDelete(xhsTextView);
                return null;
            }
        };
    }

    private void onTextClick(XhsTextView xhsTextView) {
        if (xhsTextView.getStatus() == XhsTextStatus.NORMAL){
            xhsTextView.active();
            if (currentXhsTextView != null) currentXhsTextView.normal();
            currentXhsTextView = xhsTextView;
            return;
        }
        //todo edit?
    }

    private void onDelete(XhsTextView xhsTextView) {
        removeView(xhsTextView);
        paramsMap.remove(xhsTextView);
    }

    class ViewDragCallback extends ViewDragHelper.Callback{

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            onTextClick((XhsTextView)child);
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

        @Override
        public void onViewReleased(View child, float xvel, float yvel) {
            super.onViewReleased(child, xvel, yvel);
            paramsMap.put(child,new Rect(child.getLeft(),child.getTop(),child.getRight(),child.getBottom()));
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

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                Rect params = paramsMap.get(child);
                if (params != null) {
                    child.layout(params.left, params.top, params.right, params.bottom);
                } else {
                    child.layout(0, 0, child.getMeasuredWidth(), child.getMeasuredHeight());
                }
            }
        }
    }

    public void addXhsText(Context context,String content){
        XhsTextView textView = new XhsTextView(context);
//        textView.setOnClickListener(commonClickListener);
        textView.setOnDeleteFunc(commonOnDeleteFunc);
        textView.setTextContent(content);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        addView(textView,layoutParams);
        onTextClick(textView);
        currentXhsTextView = textView;
    }
}
