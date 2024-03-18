package com.example.myapplication.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapters.NewsRecycleViewAdapter;
import com.example.myapplication.databinding.FragmentNewsBinding;
import com.example.myapplication.utilities.ViewFragment;
import com.example.myapplication.viewmodels.NewsViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsFragment extends ViewFragment<NewsViewModel, FragmentNewsBinding> {

    public NewsFragment() {
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        assert view != null;
        RecyclerView recyclerView = (RecyclerView)(view.findViewById(R.id.newsRecyclerView));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new NewsRecycleViewAdapter());
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }
}