package com.example.myapplication.views;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentFeedbackBinding;
import com.example.myapplication.utilities.ViewFragment;
import com.example.myapplication.viewmodels.FeedbackViewModel;

public class FeedbackFragment extends ViewFragment<FeedbackViewModel, FragmentFeedbackBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_feedback;
    }
}