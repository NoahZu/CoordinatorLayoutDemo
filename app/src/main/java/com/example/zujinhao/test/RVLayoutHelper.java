package com.example.zujinhao.test;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zujinhao on 2018/3/23.
 * 管理Recycler的布局
 */

public class RVLayoutHelper {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private int mCurrentPosition;
    private OnPageChangeListener mOnPageChangeListener;



    public void attachToRecyclerView(@NonNull RecyclerView recyclerView){
        mRecyclerView = recyclerView;
        mCurrentPosition = 0;
        mLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE){//不动了
                    int po = mLayoutManager.findFirstVisibleItemPosition();
                    if (po != mCurrentPosition && mOnPageChangeListener != null){
                        mOnPageChangeListener.onPageChanged(mCurrentPosition,po);
                        mCurrentPosition = po;
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        if (mOnPageChangeListener != null){
            mOnPageChangeListener.onPageChanged(-1,mCurrentPosition);
        }
    }


    public View getCurrentView(){
        return mLayoutManager.findViewByPosition(mCurrentPosition);
    }


    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener){
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public interface OnPageChangeListener{
        void onPageChanged(int oldPosition,int position);
    }
}
