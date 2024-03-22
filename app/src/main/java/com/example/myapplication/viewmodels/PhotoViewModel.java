package com.example.myapplication.viewmodels;

import com.example.myapplication.utilities.ObservableViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PhotoViewModel extends ObservableViewModel {
    @Inject
    public PhotoViewModel(){

    }

}
