package com.example.mvvmj;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.mvvmj.databinding.DialogSelectImageBinding;

/**
 * dialog for selecting image
 * **/

public class SelectImageDialog extends Dialog {
    private DialogSelectImageBinding binding = DialogSelectImageBinding.inflate(getLayoutInflater());

    public SelectImageDialog(@NonNull Context context) {
        super(context);
        // get the window of dialog
        Window window = getWindow();
        // set the background color under the dialog
        window.setDimAmount(0.3F);
        // set the width and height of dialog
        window.setLayout(500,300);
        // set the background color to transparent (the window of dialog)
        window.setBackgroundDrawableResource(R.color.transparent);
    }

    @Override
    public void show() {
        super.show();
        setContentView(binding.getRoot());
    }


}
