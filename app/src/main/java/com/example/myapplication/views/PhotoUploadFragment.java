package com.example.myapplication.views;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPhotoBinding;
import com.example.myapplication.databinding.FragmentUploadPhotoBinding;
import com.example.myapplication.utilities.ViewFragment;
import com.example.myapplication.viewmodels.PhotoViewModel;

public class PhotoUploadFragment extends ViewFragment<PhotoViewModel, FragmentUploadPhotoBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_upload_photo;
    }
}