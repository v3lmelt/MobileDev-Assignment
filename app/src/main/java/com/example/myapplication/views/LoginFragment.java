package com.example.myapplication.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentLoginBinding;
import com.example.myapplication.utilities.ViewFragment;
import com.example.myapplication.viewmodels.LoginViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends ViewFragment<LoginViewModel, FragmentLoginBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }
}