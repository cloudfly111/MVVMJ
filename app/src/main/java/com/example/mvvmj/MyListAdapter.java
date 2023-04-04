package com.example.mvvmj;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmj.databinding.ItemImageBinding;

public class MyListAdapter extends ListAdapter<Image,MyListAdapter.ImageViewHolder> {

    private ItemImageBinding binding;

    protected MyListAdapter(@NonNull DiffUtil.ItemCallback<Image> diffCallback) {
        super(diffCallback);
    }
    class DifferCallBack extends DiffUtil.ItemCallback<Image>{

        @Override
        public boolean areItemsTheSame(@NonNull Image oldItem, @NonNull Image newItem) {
            return oldItem.imageName == newItem.imageName;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Image oldItem, @NonNull Image newItem) {
            return oldItem == newItem;
        }
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemImageBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ImageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Image currentItem = getItem(position);
//        holder
    }

    protected class ImageViewHolder extends RecyclerView.ViewHolder{

        public ImageViewHolder(@NonNull ItemImageBinding itemView) {
            super(itemView.getRoot());
        }

    }
}
