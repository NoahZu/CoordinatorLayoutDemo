

    package com.example.zujinhao.test.other;

    import android.content.Context;
    import android.graphics.Color;
    import android.graphics.PixelFormat;
    import android.os.Build;
    import android.os.Handler;
    import android.view.Gravity;
    import android.view.WindowManager;
    import android.widget.TextView;
    import android.widget.Toast;

/**
 * @author LvMeng
 */
public class UIToast {

    private static long oldtime = 0;
    private static int id;

    private static Handler handler;


    public static void show(Context context, CharSequence text) {
        if (handler == null){
            handler = new Handler(context.getMainLooper());
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            return;
        }

        final TextView textView = new TextView(context);
        textView.setBackgroundResource(android.R.drawable.toast_frame); //设置成官方原生的 Toast 背景
        textView.setText(text);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(14);
        textView.setGravity(Gravity.CENTER);
        int padding = UIUtils.dip2px(context, 5);
        textView.setPadding(padding + padding, padding, padding + padding, padding);
        final WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE; //设置这个 window 不可点击，不会获取焦点，这样可以不干扰背后的 Activity 的交互。
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.format = PixelFormat.TRANSLUCENT; //这样可以保证 Window 的背景是透明的，不然背景可能是黑色或者白色。

        params.y = UIUtils.dip2px(context, 80);
        params.gravity = Gravity.BOTTOM;
        params.windowAnimations = android.R.style.Animation_Toast; //使用官方原生的 Toast 动画效果


        try {
            windowManager.addView(textView, params);
        } catch (Exception e) {
            e.printStackTrace();
        }


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    windowManager.removeView(textView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },3000);
    }

    public static void show(Context context, int resId) {
        show(context, context.getResources().getText(resId));
    }

    /**
     * 这是一个居中，算是个伪单 栗 吧～
     *
     * @param context
     * @param text
     * @param text
     * @param length
     */
//    public static void showCenterSingleton(Context context, CharSequence text, int length, int giftid) {
//        if (oldtime == 0) {
//            oldtime = System.currentTimeMillis();
//            id = giftid;
//        } else if (System.currentTimeMillis() - oldtime < 3000 && id == giftid) {
//            return;
//        } else {
//            oldtime = System.currentTimeMillis();
//            id = giftid;
//        }
//
//        final TextView textView = new TextView(context);
//        textView.setBackgroundResource(android.R.drawable.toast_frame); //设置成官方原生的 Toast 背景
//        textView.setText(text);
//        textView.setTextColor(Color.WHITE);
//        textView.setTextSize(14);
//        textView.setGravity(Gravity.CENTER);
//        int padding = UIUtils.dip2px(context, 5);
//        textView.setPadding(padding + padding, padding, padding + padding, padding);
//        final WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
//        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//        params.type = WindowManager.LayoutParams.TYPE_TOAST;
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE; //设置这个 window 不可点击，不会获取焦点，这样可以不干扰背后的 Activity 的交互。
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.format = PixelFormat.TRANSLUCENT; //这样可以保证 Window 的背景是透明的，不然背景可能是黑色或者白色。
//
//
//        params.gravity = Gravity.CENTER;
//        params.windowAnimations = android.R.style.Animation_Toast; //使用官方原生的 Toast 动画效果
//
//        try {
//            windowManager.addView(textView, params);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        Observable.timer(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
//
//            @Override
//            public void accept(Long aLong) throws Exception {
//                try {
//                    windowManager.removeView(textView);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    public static void show(Context context, final View view) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//            Toast toast = new Toast(context);
//            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//            toast.setDuration(Toast.LENGTH_SHORT);
//            toast.setView(view);
//            toast.show();
//            return;
//        }
//
//
//        final WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
//        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//        params.type = WindowManager.LayoutParams.TYPE_TOAST;
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE; //设置这个 window 不可点击，不会获取焦点，这样可以不干扰背后的 Activity 的交互。
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.format = PixelFormat.TRANSLUCENT; //这样可以保证 Window 的背景是透明的，不然背景可能是黑色或者白色。
//
//
//        params.gravity = Gravity.CENTER;
//        params.windowAnimations = android.R.style.Animation_Toast; //使用官方原生的 Toast 动画效果
//
//        try {
//            windowManager.addView(view, params);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Observable.timer(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
//
//            @Override
//            public void accept(Long aLong) throws Exception {
//
//                try {
//                    windowManager.removeView(view);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//    }
}

