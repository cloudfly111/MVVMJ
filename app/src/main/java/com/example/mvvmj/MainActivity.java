package com.example.mvvmj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;

import com.example.mvvmj.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity" ;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        how to use view-binding in activity
//        https://developer.android.com/topic/libraries/view-binding#activities
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SelectImageDialog dialog = new SelectImageDialog(MainActivity.this);
        String[] imageArray = getResources().getStringArray(R.array.image);
        dialog.setArray(imageArray);
        dialog.show();


    }





}