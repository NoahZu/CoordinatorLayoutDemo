package com.example.zujinhao.test.adapter;

import android.content.Context;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.RVLayoutHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zujinhao on 2018/3/23.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoViewHolder> {
    private List<String> mData;
    private Context mContext;



    public VideoListAdapter(Context context){
        mContext = context;
        mData = new ArrayList<String>();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_video_list,parent,false));
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{

        public VideoViewHolder(View itemView) {
            super(itemView);
        }

        public void set(){

        }
    }

    public void add(String bean){
        mData.add(bean);
    }

}
