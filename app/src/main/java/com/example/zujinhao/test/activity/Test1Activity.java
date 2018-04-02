package com.example.zujinhao.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.adapter.BottomItemAdapter;
import com.example.zujinhao.test.adapter.ItemTouchHelperAdapter;
import com.example.zujinhao.test.adapter.MyTouchHelper;
import com.example.zujinhao.test.adapter.Test1Adapter;

public class Test1Activity extends BaseActivity {
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private Test1Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("这是标题");
        recyclerView = (RecyclerView) findViewById(R.id.rvToDoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter = new Test1Adapter(Test1Activity.this));


        ItemTouchHelper touchHelper = new ItemTouchHelper(new MyTouchHelper(adapter));
        touchHelper.attachToRecyclerView(recyclerView);


    }






}
