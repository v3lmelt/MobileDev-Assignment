package com.example.myapplication.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityRegisterBinding;
import com.example.myapplication.utilities.ViewActivity;
import com.example.myapplication.viewmodels.RegisterViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RegisterActivity extends ViewActivity<RegisterViewModel, ActivityRegisterBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected int getWindowFeatureId() {
        return Window.FEATURE_NO_TITLE;
    }
}
