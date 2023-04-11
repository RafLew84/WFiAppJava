package com.example.wfiappjava.ui.fragments.list;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wfiappjava.data.Institute;
import com.example.wfiappjava.databinding.RecyclerviewItemBinding;

public class InstituteViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerviewItemBinding binding;
    private final Context context;

    public InstituteViewHolder(RecyclerviewItemBinding binding, Context context, OnItemClickListener onItemClickListener) {
        super(binding.getRoot());
        this.binding = binding;
        this.context = context;
        binding.getRoot().setOnClickListener(v -> onItemClickListener.onItemClick(getAdapterPosition()));
    }

    public void bind(Institute institute) {
            binding.title.setText(institute.getTitle());
            binding.subTitle.setText(institute.getInfo());

            Glide.with(context).load(institute.getImageResource())
                    .into(binding.instituteImage);
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
