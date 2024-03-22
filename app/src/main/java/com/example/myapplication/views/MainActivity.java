package com.example.myapplication.views;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView _bottomNavView;
    private FragmentManager _fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initComponent();
        initBottomNavView();
    }

    private void initComponent(){
        _bottomNavView = findViewById(R.id.bottom_navigation);
        _fragmentManager = getSupportFragmentManager();
    }
    private void initBottomNavView(){

        _bottomNavView.setOnItemSelectedListener(item -> {
            FragmentTransaction _transaction = _fragmentManager.beginTransaction();
            int id = item.getItemId();
            if(id == R.id.to_homepage_fragment){
                _transaction.replace(R.id.nav_host, new NewsFragment());
                _transaction.commit();
            }else if(id == R.id.to_news_fragment){
                _transaction.replace(R.id.nav_host, new NewsFragment());
                _transaction.commit();
            }else if(id == R.id.to_shoot_fragment){
                _transaction.replace(R.id.nav_host, new PhotoFragment());
                _transaction.commit();
            }
            return true;
        });
    }

}