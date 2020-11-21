package com.example.zujinhao.test.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zujinhao on 2018/1/23.
 */

public class RecordButton extends View {

    private Paint bgPaint;
    private Paint circlePaint;

    private int progress;

    private Point center;

    private int width;

    private int borderWidth;
    private int padding;

    private boolean isPressing;

    private ValueAnimator valueAnimator;

    public RecordButton(Context context) {
        this(context,null);
    }

    public RecordButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        progress = 0;
        padding = 25;
        isPressing = false;

        valueAnimator = ValueAnimator.ofInt(0,100);
        valueAnimator.setDuration(10 * 1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int progress = (int) animation.getAnimatedValue();
                setProgress(progress);
            }
        });
        initPaint();
    }

    private void initPaint() {
        bgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bgPaint.setColor(Color.RED);

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(Color.YELLOW);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        center = new Point(w / 2,h / 2);
        width = w;
        borderWidth = width / 14;

        circlePaint.setStrokeWidth(borderWidth);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBg(canvas);
        drawCircle(canvas);
    }

    private void drawBg(Canvas canvas) {
        canvas.drawCircle(center.x,center.y,width / 2 - borderWidth,bgPaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawCircle(Canvas canvas) {
        RectF rectF = new RectF(padding,padding,width - padding,width - padding);
        float angle = progress * 360 / 100;
        canvas.drawArc(rectF,-90,angle,false,circlePaint);

    }

    public void setProgress(@IntRange(from = 0,to = 100) int progress){
        this.progress = progress;
        invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isPressing = true;
                onPress();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_OUTSIDE:
                isPressing = false;
                onUp();
                break;
        }
        return true;
    }

    void onPress(){
        valueAnimator.start();
    }

    void onUp(){
        valueAnimator.cancel();
        setProgress(0);
    }
}


