package com.example.myapplication.utilities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProvider;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class ViewActivity<TViewModel extends ObservableViewModel, TViewDataBinding extends ViewDataBinding> extends AppCompatActivity {
    protected TViewModel viewModel;
    protected TViewDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindowFeatureId());
        setContentView(getLayoutId());
        BindViewModel();
    }

    protected void BindViewModel() {
        viewModel = new ViewModelProvider(this).get(getViewModelClass());
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setVariable(BR.viewModel, viewModel);
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

    protected abstract int getWindowFeatureId();
}
