package com.example.lsy_work;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class frirndFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<String> data;
    //private List<Map<String,Object>> item;
    private Context context;
    private myadapter myadapter;
    private ImageView iamgeview;
    private SwipeRefreshLayout mswipRefreshLayout;
    private TextView mTextView;
    public frirndFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_friend, container, false);
        context = this.getActivity();
        recyclerView =view.findViewById(R.id.recyclerview);
        data = new ArrayList<>();
        mswipRefreshLayout=view.findViewById(R.id.refresh_layout);
        mTextView=view.findViewById(R.id.pulldownrefresh);

        String[] name={"甄嬛","年世兰","宜修"};
        String[] address={"永寿宫","翊坤宫","景仁宫"};
        String[] number={"111111","222222","333333"};
        int[] jpg={R.drawable.p5,R.drawable.phua,R.drawable.phuang};

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        for(int i=0;i<name.length;i++){
            Map<String,Object> listitem=new HashMap<String,Object>();
            listitem.put("图片",jpg[i]);
            listitem.put("姓名",name[i]);
            listitem.put("地址",address[i]);
            listitem.put("联系方式",number[i]);
            list.add(listitem);
        }

        myadapter = new myadapter(list,context);
        GridLayoutManager layoutManager=new GridLayoutManager(context,1);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myadapter);
        mswipRefreshLayout.setEnabled(true);
        mswipRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTextView.setText("正在刷新");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mTextView.setText("刷新成功");
                        mswipRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });

        return view;
    }

    }

