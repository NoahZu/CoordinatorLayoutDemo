package com.example.zujinhao.test.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.RVLayoutHelper;
import com.example.zujinhao.test.bean.VideoBean;
import com.example.zujinhao.test.widget.PlayerView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zujinhao on 2018/3/23.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoViewHolder> {
    private List<VideoBean> mData;
    private Context mContext;



    public VideoListAdapter(Context context){
        mContext = context;
        mData = new ArrayList<VideoBean>();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_video_list,parent,false));
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.setData(mData.get(position));
        holder.play(mData.get(position));
    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private SimpleDraweeView author;
        private PlayerView playerView;

        VideoViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            author = itemView.findViewById(R.id.iv_avater);
            playerView = itemView.findViewById(R.id.player_view);
        }

        public void setData(VideoBean data){
            title.setText(data.getVideoTitle());
            author.setImageURI(data.getAuthor());
            playerView.setCover(data.getVideoCover());
        }

        public void play(VideoBean videoBean){
            playerView.startPlay(videoBean);
        }
    }

    public void add(VideoBean bean){
        mData.add(bean);
    }


    public VideoBean getData(int position){
        if (mData == null || mData.size() == 0){
            return null;
        }
        return mData.get(position);
    }

}
