package com.example.myapplication.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.models.LoginModel;
import com.example.myapplication.utilities.ObservableViewModel;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoginViewModel extends ObservableViewModel {
    private final LoginModel model = new LoginModel();

    @Inject
    public LoginViewModel() {
    }

    @Bindable
    public String getUserName() {
        return model.getUserName();
    }

    public void setUserName(String userName) {
        if (model.getUserName().equals(userName))
            return;

        this.model.setUserName(userName);
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassword() {
        return model.getPassword();
    }

    public void setPassword(String password) {
        if (model.getPassword().equals(password))
            return;

        this.model.setPassword(password);
        notifyPropertyChanged(BR.password);
    }

    public void onRegisterButtonClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment);
    }

    public void onLoginButtonClicked(View view) {
        Log.i("LoginViewModel", "LoginButtonClicked");
    }
}
