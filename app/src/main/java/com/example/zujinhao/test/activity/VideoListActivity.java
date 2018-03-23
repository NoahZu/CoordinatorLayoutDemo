package com.example.zujinhao.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.RVLayoutHelper;
import com.example.zujinhao.test.adapter.VideoListAdapter;


public class VideoListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private VideoListAdapter mAdapter;

    private RVLayoutHelper mRVLayoutHelper;
    private PagerSnapHelper mPagerSnapHelper;

    private VideoView viewView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);


        mAdapter = new VideoListAdapter(this);
        for (int i = 0;i < 20 ;i++){
            mAdapter.add("aaaa");
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);




        mPagerSnapHelper = new PagerSnapHelper();
        mRVLayoutHelper = new RVLayoutHelper();

        mRVLayoutHelper.setOnPageChangeListener(new RVLayoutHelper.OnPageChangeListener() {
            @Override
            public void onPageChanged(int oldPosition, int position) {
                System.out.println("===position:oldPosition:"+oldPosition+",newPosition:"+position);
            }
        });

        mPagerSnapHelper.attachToRecyclerView(mRecyclerView);
        mRVLayoutHelper.attachToRecyclerView(mRecyclerView);



    }
}
