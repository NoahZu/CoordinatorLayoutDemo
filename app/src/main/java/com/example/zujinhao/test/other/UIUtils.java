package com.example.zujinhao.test.other;

import android.content.Context;

public class UIUtils {
    public UIUtils() {
    }

    public static int dip2px(Context context, float dipValue) {
        float var2 = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * var2 + 0.5F);
    }

    public static int px2dip(Context context, float pxValue) {
        float var2 = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / var2 + 0.5F);
    }
}