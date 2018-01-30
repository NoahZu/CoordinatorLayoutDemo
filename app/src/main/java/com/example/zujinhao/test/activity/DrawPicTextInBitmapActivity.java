package com.example.zujinhao.test.activity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.utils.BitmapGenerator;
import com.example.zujinhao.test.widget.ShareContentCardView;
import com.facebook.drawee.backends.pipeline.Fresco;

public class DrawPicTextInBitmapActivity extends BaseActivity {
    ImageView bitmapDisplayer;
    Handler mMainHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.activity_draw_pic_text_in_bitmap);
        mMainHandler = new Handler(getMainLooper());
        bitmapDisplayer = (ImageView) findViewById(R.id.bitmap_displayer);

        findViewById(R.id.generate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapGenerator bitmapGenerator = new BitmapGenerator();
                bitmapGenerator.init(DrawPicTextInBitmapActivity.this);
                Bitmap b = bitmapGenerator.generate();
                bitmapDisplayer.setImageBitmap(b);
            }
        });

        findViewById(R.id.generate_vew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ShareContentCardView shareContentCardView = new ShareContentCardView(DrawPicTextInBitmapActivity.this);
                shareContentCardView.setData();
                mMainHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        generateByView(shareContentCardView);
                    }
                },1000);
            }
        });

        findViewById(R.id.show_vew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DrawPicTextInBitmapActivity.this);
                builder.setView(new ShareContentCardView(DrawPicTextInBitmapActivity.this));
                builder.setNegativeButton("取消",null);
                builder.create().show();
            }
        });
    }

    private void generateByView(View view) {

        bitmapDisplayer.setImageBitmap(getViewBitmap(view));
    }


    //把布局变成Bitmap
    private Bitmap getViewBitmap(View addViewContent) {

        addViewContent.setDrawingCacheEnabled(true);

        addViewContent.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        addViewContent.layout(0, 0,
                addViewContent.getMeasuredWidth(),
                addViewContent.getMeasuredHeight());

        addViewContent.buildDrawingCache();
        Bitmap cacheBitmap = addViewContent.getDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);

        return bitmap;
    }
}
