package com.example.zujinhao.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.adapter.HorRecyclerViewAdapter;

public class RecyclerViewSnapHelperTestActivity extends BaseActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_snap_helper_test);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1, LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new HorRecyclerViewAdapter(this));

        new PagerSnapHelper().attachToRecyclerView(recyclerView);
//        new LinearSnapHelper().attachToRecyclerView(recyclerView);
    }
}
