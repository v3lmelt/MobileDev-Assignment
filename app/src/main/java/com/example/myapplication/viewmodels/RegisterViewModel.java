package com.example.myapplication.viewmodels;

import android.util.Log;
import android.view.View;

import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import com.example.myapplication.models.RegisterModel;
import com.example.myapplication.utilities.ObservableViewModel;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class RegisterViewModel extends ObservableViewModel {
    private final RegisterModel model = new RegisterModel();

    @Inject
    public RegisterViewModel() {
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

    @Bindable
    public String getRepeatedPassword() {
        return model.getRepeatedPassword();
    }

    public void setRepeatedPassword(String repeatedPassword) {
        if (model.getRepeatedPassword().equals(repeatedPassword))
            return;

        this.model.setRepeatedPassword(repeatedPassword);
        notifyPropertyChanged(BR.repeatedPassword);
    }

    public void onRegisterButtonClicked(View view) {
        Log.i("RegisterViewModel", "RegisterButtonClicked");
    }
}
