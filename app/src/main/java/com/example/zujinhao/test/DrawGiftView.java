package com.example.zujinhao.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by zujinhao on 2017/8/21.
 */

public class DrawGiftView  extends View{

    private ArrayList<Point> pointArrayList;
    Bitmap bitmap;
    Paint paint;
    Point lastPoint;
    private static final int SPAN = 100;
    public DrawGiftView(Context context) {
        this(context,null);
    }

    public DrawGiftView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        pointArrayList = new ArrayList<Point>();
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.emoji);
        paint = new Paint();
        lastPoint = null;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE){
            if (lastPoint == null ){
                lastPoint = new Point((int) event.getX(),(int) event.getY());
                pointArrayList.add(lastPoint);
                invalidate();
                return true;
            }
            if (Math.abs(lastPoint.x - event.getX()) > SPAN || Math.abs(lastPoint.y - event.getY()) > SPAN){
                lastPoint = new Point((int) event.getX(),(int) event.getY());
                pointArrayList.add(lastPoint);
                invalidate();
            }
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Point p : pointArrayList){
            canvas.drawBitmap(bitmap,p.x,p.y,paint);
        }
    }

    public void clear(){
        pointArrayList.clear();
        invalidate();
    }
}
