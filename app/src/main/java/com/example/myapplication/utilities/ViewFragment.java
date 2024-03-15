package com.example.myapplication.utilities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class ViewFragment<TViewModel extends ObservableViewModel, TViewDataBinding extends ViewDataBinding> extends Fragment {
    protected TViewModel viewModel;
    protected TViewDataBinding binding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(getViewModelClass());
        binding.setVariable(BR.viewModel, viewModel);
        return binding.getRoot();
    }

    @SuppressWarnings("unchecked")
    private Class<TViewModel> getViewModelClass() {
        Type type = getClass().getGenericSuperclass();
        if(!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("Type must be a parameterized type");
        }

        ParameterizedType parameterizedType = (ParameterizedType)type;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if(actualTypeArguments.length < 2) {
            throw new IllegalStateException("Number of type arguments must be 2");
        }

        return (Class<TViewModel>)actualTypeArguments[0];
    }

    protected abstract int getLayoutId();
}
