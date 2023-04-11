package com.example.wfiappjava.ui.fragments.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wfiappjava.data.DataProvider;
import com.example.wfiappjava.data.Institute;
import com.example.wfiappjava.databinding.RecyclerviewItemBinding;

public class InstituteAdapter extends RecyclerView.Adapter<InstituteViewHolder> {

    private final OnItemClickListener onItemClickListener;

    public InstituteAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public InstituteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstituteViewHolder(RecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ), parent.getContext(), position -> onItemClickListener.onItemClick(DataProvider.institutes.get(position)));
    }

    @Override
    public void onBindViewHolder(@NonNull InstituteViewHolder holder, int position) {
        Institute currentInstitute = DataProvider.institutes.get(position);
        holder.bind(currentInstitute);
    }

    @Override
    public int getItemCount() {
        return DataProvider.institutes.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Institute institute);
    }
}
