package com.example.zujinhao.test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zujinhao on 2017/7/5.
 */

public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment {
    private RecyclerView recyclerView;
    private View rootView;
    private BottomItemAdapter adapter;
    private List<String> items;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("==TAG==","onCreateView");
        rootView = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);
        items = getArguments().getStringArrayList("item");
        findView();
        initView();
        return rootView;
    }

    private void findView() {
        recyclerView = rootView.findViewById(R.id.recyclerview);
    }

    public void setItemData(String... items) {
        ArrayList<String> itemList = new ArrayList<>(Arrays.asList(items));
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("item",itemList);
        setArguments(bundle);
    }

    private void initView() {
        RecyclerViewDivider.Builder builder =  new RecyclerViewDivider.Builder(getContext());
        builder.setColor(Color.parseColor("#44ff0000"));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(builder.build());
        adapter = new BottomItemAdapter(getContext(),items);
        recyclerView.setAdapter(adapter);
    }

}
