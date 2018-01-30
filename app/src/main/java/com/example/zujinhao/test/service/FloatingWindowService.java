package com.example.zujinhao.test.service;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;

public class FloatingWindowService extends Service {
	
	public static final String OPERATION = "operation";
	public static final int OPERATION_SHOW = 100;
	public static final int OPERATION_HIDE = 101;
	
	private static final int HANDLE_CHECK_ACTIVITY = 200;
	
	private boolean isAdded = false;
	private static WindowManager wm;
	private static WindowManager.LayoutParams params;
	private Button btn_floatView;
	
	private List<String> homeList;
	private ActivityManager mActivityManager;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		homeList = getHomes();
		createFloatView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		int operation = intent.getIntExtra(OPERATION, OPERATION_SHOW);
		switch(operation) {
			case OPERATION_SHOW:
				mHandler.removeMessages(HANDLE_CHECK_ACTIVITY);
				mHandler.sendEmptyMessage(HANDLE_CHECK_ACTIVITY);
				break;
			case OPERATION_HIDE:
				mHandler.removeMessages(HANDLE_CHECK_ACTIVITY);
				break;
		}
		return super.onStartCommand(intent, flags, startId);
	}

	
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what) {
			case HANDLE_CHECK_ACTIVITY:
				if(isHome()) {
					if(!isAdded) {
						wm.addView(btn_floatView, params);
						isAdded = true;
					}
				} else {
					if(isAdded) {
						wm.removeView(btn_floatView);
						isAdded = false;
					}
				}
				mHandler.sendEmptyMessageDelayed(HANDLE_CHECK_ACTIVITY, 1000);
				break;
			}
		}
	};
	
	/**
	 */
	private void createFloatView() {
		btn_floatView = new Button(getApplicationContext());
        btn_floatView.setText("我是悬浮窗");
        
        wm = (WindowManager) getApplicationContext()
        	.getSystemService(Context.WINDOW_SERVICE);
        params = new WindowManager.LayoutParams();
        

        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;

        params.format = PixelFormat.RGBA_8888;
        

        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                              | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;

        btn_floatView.setOnTouchListener(new OnTouchListener() {
        	int lastX, lastY;
        	int paramX, paramY;
        	
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					lastX = (int) event.getRawX();
					lastY = (int) event.getRawY();
					paramX = params.x;
					paramY = params.y;
					break;
				case MotionEvent.ACTION_MOVE:
					int dx = (int) event.getRawX() - lastX;
					int dy = (int) event.getRawY() - lastY;
					params.x = paramX + dx;
					params.y = paramY + dy;
			        wm.updateViewLayout(btn_floatView, params);
					break;
				}
				return true;
			}
		});
        
        wm.addView(btn_floatView, params);
        isAdded = true;
	}
	
	/**
	 */
	private List<String> getHomes() {
		List<String> names = new ArrayList<String>();  
	    PackageManager packageManager = this.getPackageManager();  

	    Intent intent = new Intent(Intent.ACTION_MAIN);  
	    intent.addCategory(Intent.CATEGORY_HOME);  
	    List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(intent,  
	            PackageManager.MATCH_DEFAULT_ONLY);  
	    for(ResolveInfo ri : resolveInfo) {  
	        names.add(ri.activityInfo.packageName);  
	    }
	    return names;  
	}
	
	/**
	 */  
	public boolean isHome(){  
		if(mActivityManager == null) {
			mActivityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);  
		}
	    List<RunningTaskInfo> rti = mActivityManager.getRunningTasks(1);  
	    return homeList.contains(rti.get(0).topActivity.getPackageName());  
	}

}
