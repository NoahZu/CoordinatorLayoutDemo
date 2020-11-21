package com.example.zujinhao.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.activity.Test1Activity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchHelperAdapter{
    private Context mContext;
    private List<String> mData;


    public Test1Adapter(Context context){
        mContext = context;
        mData = new ArrayList<String>();
        for (int i = 0;i<20;i++){
            mData.add("======="+i);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BottomItemAdapter.MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView textView = holder.itemView.findViewById(R.id.tv_title);
        textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mData,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }
}
