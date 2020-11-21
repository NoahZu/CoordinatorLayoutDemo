package com.example.zujinhao.test.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.zujinhao.test.widget.MyViewHolder;
import com.example.zujinhao.test.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Test4Activity extends BaseActivity {
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        collapsingToolbarLayout.setTitle("zheshi tool bar");
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.rvToDoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new MyViewHolder(LayoutInflater.from(Test4Activity.this).inflate(R.layout.item_rv,parent,false));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 20;
            }
        });
    }




}