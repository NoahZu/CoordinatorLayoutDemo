package com.example.zujinhao.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zujinhao.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zujinhao on 2017/7/5.
 */

public class BottomItemAdapter extends RecyclerView.Adapter<BottomItemAdapter.MyViewHolder> {
    private Context context;
    private List<String> items = new ArrayList<String>();

    public BottomItemAdapter(Context context,List<String> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_bottom_menu,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
