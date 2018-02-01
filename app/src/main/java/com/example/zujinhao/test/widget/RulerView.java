package com.example.zujinhao.test.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.zujinhao.test.other.UIToast;
import com.example.zujinhao.test.utils.ScreenSizeUtils;

/**
 * Created by zujinhao on 2017/10/16.
 */

public class RulerView extends View {
    private int sSpan = 50;//几像素代表一个单位
    private int sScreenWidth = 0;
    private int sViewHeight = 0;
    private int sScaleColor = Color.parseColor("#B7B7B7");
    private int sTextColor = Color.BLACK;
    private int sCenterLineColor = Color.GREEN;

    private int mCurrentStart;//当前开始大小
    private Paint mScalePaint;//画笔
    private Paint mTextPaint;
    private Paint mCenterLinePaint;

    private PointF lastPoint;
    private float dragedLength;




    public RulerView(Context context) {
        this(context,null);
    }

    public RulerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        initConfig();
    }


    private void initConfig() {
        sScreenWidth = ScreenSizeUtils.getInstance(getContext()).getScreenWidth();

        mCurrentStart = 0;

        mScalePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mScalePaint.setColor(sScaleColor);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(sTextColor);
        mTextPaint.setTextSize(50);

        mCenterLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCenterLinePaint.setColor(sCenterLineColor);



    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        sViewHeight = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawCenterLine(canvas);
        for (int i = 0;i < sScreenWidth / sSpan; i++){
            drawScale(i,canvas);
            drawText(i,canvas);
        }

    }



    private void drawCenterLine(Canvas canvas) {
        Rect rect = new Rect(sScreenWidth / 2 - 5,0,sScreenWidth / 2 + 5,140);
        canvas.drawRect(rect,mCenterLinePaint);
    }

    private void drawText(int position,Canvas canvas) {
        int distance = position * sSpan;
        int scaleValue = position + mCurrentStart;
        if (scaleValue % 5 == 0){
            canvas.drawText(scaleValue+"",position == 0 ? distance :distance - 12,180,mTextPaint);
        }
    }

    /**
     * 画刻度
     */
    private void drawScale(int position,Canvas canvas) {
        int distance = position * sSpan;
        int scaleValue = position + mCurrentStart;

        Rect rect;
        if (scaleValue % 5 == 0){
            rect = new Rect(position == 0?distance : distance-3,0,distance + 3,120);
        }else {
            rect = new Rect(distance-2,0,distance + 2,80);
        }
        canvas.drawRect(rect,mScalePaint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastPoint = new PointF(event.getX(),getY());
                break;
            case MotionEvent.ACTION_MOVE:
                dragedLength = event.getX() - lastPoint.x;
                lastPoint.y = event.getX();
                if (Math.abs(dragedLength) > 25){
                    left((int) -dragedLength / 150);
                    dragedLength = 0f;
                }
                break;
            case MotionEvent.ACTION_UP:
                lastPoint = null;
                dragedLength = 0;
                break;
        }
        return true;

    }

    public void left(int dis){
        if (mCurrentStart + dis < 0){
            return ;
        }
        mCurrentStart += dis;

        invalidate();
    }
}
