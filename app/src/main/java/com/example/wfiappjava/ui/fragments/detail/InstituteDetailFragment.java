package com.example.wfiappjava.ui.fragments.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.wfiappjava.databinding.FragmentInstituteDetailBinding;

public class InstituteDetailFragment extends Fragment {

    private FragmentInstituteDetailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInstituteDetailBinding.inflate(inflater);
        return binding.getRoot();
    }
}