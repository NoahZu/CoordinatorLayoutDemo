package com.example.zujinhao.test.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

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
