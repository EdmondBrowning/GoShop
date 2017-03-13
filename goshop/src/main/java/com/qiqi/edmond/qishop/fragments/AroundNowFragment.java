package com.qiqi.edmond.qishop.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.AroundNowAdapter;
import com.qiqi.edmond.qishop.interfaces.mvp.views.AroundNowViewInterface;
import com.qiqi.edmond.qishop.presenters.AroundNowPresenter;
import com.qiqi.edmond.qishop.utils.AroundNowInfo;
import com.qiqi.edmond.qishop.utils.AroundNowData;

import java.util.List;

/**
 * Created by edmond on 17-1-25.
 */

public class AroundNowFragment extends Fragment implements AroundNowViewInterface,AroundNowAdapter.OnItemClickListener{

    private View view;
    private RecyclerView recyclerView;
    private View footer;
    private SwipeRefreshLayout swipeRefreshLayout;

    private AroundNowData data = new AroundNowData();

    private AroundNowAdapter adapter;

    private AroundNowPresenter presenter;

    private Activity activity;

    private LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_around_now,container,false);
        activity = getActivity();

        presenter = new AroundNowPresenter(this);

        footer = LayoutInflater.from(activity).inflate(R.layout.footer,null);

        adapter = new AroundNowAdapter(activity,data.getAroundNowInfos(),footer);
        adapter.setOnItemClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastItemPosition= ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                if(lastItemPosition==data.getAroundNowInfos().size()){
                    presenter.loadMoring();
                }
            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refreshing();
            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE);

        presenter.initing();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        presenter = null;
    }

    @Override
    public void initing() {

    }

    @Override
    public void inited(AroundNowData result) {
        data.getAroundNowInfos().clear();
        data.getAroundNowInfos().addAll(result.getAroundNowInfos());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initError() {
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshing() {

    }

    @Override
    public void refreshed(AroundNowData result) {
        swipeRefreshLayout.setRefreshing(false);
        data.getAroundNowInfos().clear();
        data.getAroundNowInfos().addAll(result.getAroundNowInfos());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void refreshError() {
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadMoring() {

    }

    @Override
    public void loadMored(List<AroundNowInfo> result) {
        Log.d("","lo");
        data.getAroundNowInfos().addAll(result);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadMoreError() {
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClick(View v, int position) {

    }

    @Override
    public void logoClick(View v, int position) {

    }

    @Override
    public void watchingClick(View v, int position) {

    }

    @Override
    public void commentClick(View v, int position) {

    }

    @Override
    public void thumbClick(View v, int position) {

    }

    @Override
    public void collectionClick(View v, int position) {

    }

    @Override
    public void careClick(View v, int position) {

    }
}
