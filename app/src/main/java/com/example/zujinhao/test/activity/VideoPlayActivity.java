package com.example.zujinhao.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.example.zujinhao.test.R;

public class VideoPlayActivity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        videoView = (VideoView) findViewById(R.id.vv);
        videoView.setVideoPath("http://os1oi9hmp.bkt.clouddn.com/howtouse.mp4");
        videoView.start();
    }
}
