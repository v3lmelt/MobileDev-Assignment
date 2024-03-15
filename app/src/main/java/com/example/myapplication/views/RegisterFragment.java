package com.example.myapplication.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentRegisterBinding;
import com.example.myapplication.utilities.ViewFragment;
import com.example.myapplication.viewmodels.RegisterViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RegisterFragment extends ViewFragment<RegisterViewModel, FragmentRegisterBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }
}