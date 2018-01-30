package com.example.zujinhao.test.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.zujinhao.test.R;

/**
 * Created by zujinhao on 2018/1/12.
 */

public class BitmapGenerator {
    Paint mPaint ;
    Context mContext;
    Bitmap mContentBitmap;
    int mWidth;
    int mHeight;

    RectF avatarPos;


    public void init(Context context){
        mContext = context;
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(100);
    }

    public Bitmap generate(){
        mContentBitmap = BitmapFactory.decodeResource(mContext.getResources(),R.drawable.pic).copy(Bitmap.Config.ARGB_8888, true);
        mWidth = mContentBitmap.getWidth();
        mHeight = mContentBitmap.getHeight();

        Canvas canvas = new Canvas(mContentBitmap);
        Bitmap avatar = BitmapFactory.decodeResource(mContext.getResources(),R.drawable.avatar);
        avatarPos = new RectF(mWidth / 2 - 100,550f,mWidth / 2 + 100,550 + 200);

        canvas.drawBitmap(avatar,null,avatarPos,mPaint);
        canvas.drawText("我的复活码",mWidth / 2,750 + 100,mPaint);
        return mContentBitmap;
    }
}
