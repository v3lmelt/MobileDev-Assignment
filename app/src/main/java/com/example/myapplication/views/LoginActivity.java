package com.example.myapplication.views;

import android.os.Bundle;
import android.view.Window;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityLoginBinding;
import com.example.myapplication.utilities.ViewActivity;
import com.example.myapplication.viewmodels.LoginViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends ViewActivity<LoginViewModel, ActivityLoginBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getWindowFeatureId() {
        return Window.FEATURE_NO_TITLE;
    }
}
