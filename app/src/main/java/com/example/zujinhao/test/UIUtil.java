package com.example.zujinhao.test;

import android.content.Context;

public final class UIUtil {
    public UIUtil() {
    }

    public static int dip2px(Context context, double dpValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * (double)density + 0.5D);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}