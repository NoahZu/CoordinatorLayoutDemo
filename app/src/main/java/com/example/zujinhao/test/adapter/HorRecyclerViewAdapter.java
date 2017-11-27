package com.example.zujinhao.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zujinhao.test.R;

/**
 * Created by zujinhao on 2017/8/24.
 */

public class HorRecyclerViewAdapter extends RecyclerView.Adapter<HorRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    public HorRecyclerViewAdapter(Context context){
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_holder,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.countText.setText(""+(position+1));
    }

    @Override
    public int getItemCount() {
        return 70;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView countText;
        public MyViewHolder(View itemView) {
            super(itemView);
            countText = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }

}
