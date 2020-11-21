package com.example.zujinhao.test.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.VideoView;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.RVLayoutHelper;
import com.example.zujinhao.test.adapter.VideoListAdapter;
import com.example.zujinhao.test.bean.VideoBean;
import com.example.zujinhao.test.widget.PlayerView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;


public class VideoListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private VideoListAdapter mAdapter;

    private RVLayoutHelper mRVLayoutHelper;
    private PagerSnapHelper mPagerSnapHelper;
    private LinearLayoutManager mLinearLayoutManager;

    private PlayerView mOldPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);


        mAdapter = new VideoListAdapter(this);
        mLinearLayoutManager = new LinearLayoutManager(this);
        for (int i = 0;i < 20 ;i++){
            mAdapter.add(new VideoBean(
                    "http://v9-dy.ixigua.com/77682a6cb92eafc82c8f1022b8d17449/5ad70e5c/video/m/22009ecfed7fea24cb5a8af8dea0f1563381154c04800003bdff8727ec0/",
                    "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1800044523,394840037&fm=27&gp=0.jpg",
                    "陈翔六点半",
                    "https://p3.pstatp.com/aweme/100x100/c150001e6de3d8e4e65.jpeg")
            );
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);




        mPagerSnapHelper = new PagerSnapHelper();
        mRVLayoutHelper = new RVLayoutHelper();

        mRVLayoutHelper.setOnPageChangeListener(new RVLayoutHelper.OnPageChangeListener() {
            @Override
            public void onPageChanged(int oldPosition, int position) {
                doStopPreVideo(oldPosition);
                doUpdateNexVideo(position);
            }
        });

        mPagerSnapHelper.attachToRecyclerView(mRecyclerView);
        mRVLayoutHelper.attachToRecyclerView(mRecyclerView);

    }

    private void doStopPreVideo(int oldPosition) {
        if (oldPosition < 0 || mOldPlayerView == null){
            return;
        }
        mOldPlayerView.stopPlay(mAdapter.getData(oldPosition));
    }

    private void doUpdateNexVideo(int position) {
        int firstCompleteVisPosition = mLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
        if (firstCompleteVisPosition < 0){
            return;
        }
        View contentView = mLinearLayoutManager.findViewByPosition(firstCompleteVisPosition < 0 ? 0 : firstCompleteVisPosition);
        PlayerView playerView = contentView.findViewById(R.id.player_view);
        playerView.startPlay(mAdapter.getData(position));
        mOldPlayerView = playerView;
    }
}
