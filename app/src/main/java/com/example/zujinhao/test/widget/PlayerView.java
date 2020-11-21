package com.example.zujinhao.test.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.bean.VideoBean;
import com.facebook.drawee.view.SimpleDraweeView;

public class PlayerView extends FrameLayout {
    private VideoView mVideoView;
    private SimpleDraweeView mCoverView;


    public PlayerView(@NonNull Context context) {
        this(context,null);
    }

    public PlayerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public PlayerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.player_view,this);

        mVideoView = findViewById(R.id.video_vide);
        mCoverView = findViewById(R.id.iv_cover);
    }

    public void startPlay(VideoBean videoBean){
        mCoverView.setVisibility(GONE);
        mVideoView.setVideoURI(Uri.parse(videoBean.getVideoUrl()));
        mVideoView.start();
    }

    public void stopPlay(VideoBean videoBean){
        mCoverView.setVisibility(VISIBLE);
        mVideoView.stopPlayback();
    }

    public void setCover(String cover){
        mCoverView.setVisibility(VISIBLE);
        mCoverView.setImageURI(cover);
    }
}
