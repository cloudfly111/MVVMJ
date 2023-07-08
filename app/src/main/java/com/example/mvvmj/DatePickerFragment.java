package com.example.mvvmj;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Locale;

/*
* date picker
* */
//TODO: 研究如何西元年轉民國
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private static final String TAG = "DatePickerFragment";

    //source: https://developer.android.com/develop/ui/views/components/pickers

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        ///set Date Data in date picker
        final Calendar calendar = Calendar.getInstance(Locale.TAIWAN);
        int year = calendar.get(Calendar.YEAR);
        int yearInTaiwanFormat = year -1911;
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog= new DatePickerDialog(requireContext(), R.style.CustomDatePickerDialogTheme,this,year,month,day ) ;

        return dialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        ///get the selected date
        Log.d(TAG, "onDateSet: "+String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(dayOfMonth));
    }
}
