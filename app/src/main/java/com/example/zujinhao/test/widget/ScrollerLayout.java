package com.example.zujinhao.test.widget;

import android.content.Context;
import androidx.core.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by zujinhao on 2017/8/22.
 */

public class ScrollerLayout extends LinearLayout {
    private Scroller mScroller;

    public ScrollerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP){
            mScroller.startScroll(getScrollX(),0,50,0);
            invalidate();
        }
        return true;
    }

    @Override
    public void computeScroll() {
        Log.d("===TAG===","computeScroll");
        Log.d("===TAG===","computeScrollOffset():"+mScroller.computeScrollOffset()+",currX:"+mScroller.getCurrX()+",currY:"+mScroller.getCurrY());
    }
}
