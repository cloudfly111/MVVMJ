package com.example.mvvmj;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.mvvmj.databinding.DialogSelectImageBinding;

/**
 * dialog for selecting image
 * **/

public class SelectImageDialog extends Dialog {
    private DialogSelectImageBinding binding = DialogSelectImageBinding.inflate(getLayoutInflater());
    private String[] array;
    private String TAG = "SelectImageDialog";

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
        setImage();
        setContentView(binding.getRoot());
    }

    public void setArray(String[] array){
        this.array = array;
    }

    private void setImage(){
        // get resource Id by the name of image, and set image resource to the background of imageView
        // then add imageView to linearlayout and display image on the dialog
        for (String imageName:
             array) {
            Log.i(TAG, "setImage: "+ imageName);
            ImageView image = new ImageView(getContext());
            image.setBackgroundResource(getContext().getResources().getIdentifier(imageName,"drawable", getContext().getPackageName()));
            binding.linearLayoutId.addView(image);
        }

    }


}
