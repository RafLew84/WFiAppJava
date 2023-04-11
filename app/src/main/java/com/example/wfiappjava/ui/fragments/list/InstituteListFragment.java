package com.example.wfiappjava.ui.fragments.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.wfiappjava.databinding.FragmentInstituteListBinding;


public class InstituteListFragment extends Fragment {

    private FragmentInstituteListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInstituteListBinding.inflate(inflater);
        return binding.getRoot();
    }
}