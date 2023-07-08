package com.example.mvvmj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.NumberPicker;

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

        binding.buttonId.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                showDatePickerDialog(v);
                  showNumberPickerDialog(v,new String[]{"0", "1", "2", "3", "4", "5", "6"},6,0,2);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SelectImageDialog dialog = new SelectImageDialog(MainActivity.this);
        String[] imageArray = getResources().getStringArray(R.array.image);
        dialog.setArray(imageArray);
//        dialog.show();


    }

    //show date picker in spinner mode
    private void showDatePickerDialog(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"DatePickerFragment");
    }

    //show number picker
    //TODO: 研究如何顯示年月日日期
    private  void  showNumberPickerDialog(View v,String[] list,int maxIndex,int minIndex,int displayIndex){
        NumberPicker numPicker = new NumberPicker(v.getContext());
        numPicker.setValue(displayIndex);
        numPicker.setMinValue(minIndex);
        numPicker.setMaxValue(maxIndex);
        numPicker.setDisplayedValues(list);
        numPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d(TAG, "onValueChange: " + picker.getValue());
            }
        });

        Dialog dialog = new Dialog(
                v.getContext()
        );
        dialog.setContentView(numPicker);
        dialog.show();
    }

}