package com.example.zujinhao.test.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zujinhao.test.other.AppbarLayoutForbidOpenBehavior;
import com.example.zujinhao.test.R;

public class Test2Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private WebView webView;
    private AppBarLayout appBarLayout;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    private TextView titleText;
    private ImageView imageView;

    private AppbarLayoutForbidOpenBehavior appbarLayoutForbidOpenBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        webView = (WebView) findViewById(R.id.wv_introduce);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        titleText = (TextView) findViewById(R.id.tv_title);
        imageView = (ImageView) findViewById(R.id.iv_background);

        webView.loadUrl("http://noahzu.github.io/");
        appbarLayoutForbidOpenBehavior = new AppbarLayoutForbidOpenBehavior();


        setSupportActionBar(toolbar);
        mCollapsingToolbarLayout.setTitle("关于");

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    titleText.setVisibility(View.GONE);
                    toolbar.setTitle("");
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    titleText.setVisibility(View.VISIBLE);
                }
            }
        });


        appBarLayout.post(new Runnable() {
            @Override
            public void run() {
                CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
                params.setBehavior(appbarLayoutForbidOpenBehavior);
                appbarLayoutForbidOpenBehavior.setCanOpen(true);
                appBarLayout.setExpanded(true,false);
            }
        });

    }







}