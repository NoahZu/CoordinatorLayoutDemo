package com.example.zujinhao.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.RVLayoutHelper;
import com.example.zujinhao.test.adapter.VideoListAdapter;


public class VideoListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private VideoListAdapter mAdapter;

    private RVLayoutHelper mRVLayoutHelper;
    private PagerSnapHelper mPagerSnapHelper;

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


        mRVLayoutHelper.setOnPageChangeListener(new RVLayoutHelper.OnPageChangeListener() {
            @Override
            public void onPageChanged(int oldPosition, int position) {
                System.out.println("当前是页码："+position);
            }
        });

        mPagerSnapHelper = new PagerSnapHelper();
        mRVLayoutHelper = new RVLayoutHelper();

        mPagerSnapHelper.attachToRecyclerView(mRecyclerView);
        mRVLayoutHelper.attachToRecyclerView(mRecyclerView);

    }
}
