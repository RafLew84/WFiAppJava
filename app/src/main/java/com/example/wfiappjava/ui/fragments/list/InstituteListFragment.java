package com.example.wfiappjava.ui.fragments.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.wfiappjava.data.Institute;
import com.example.wfiappjava.databinding.FragmentInstituteListBinding;


public class InstituteListFragment extends Fragment {

    private FragmentInstituteListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInstituteListBinding.inflate(inflater);

        binding.recyclerView.setAdapter(new InstituteAdapter(this::navigateToDetailFragment));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return binding.getRoot();
    }

    private void navigateToDetailFragment(Institute institute) {
        NavDirections action = InstituteListFragmentDirections.actionInstituteListFragmentToInstituteDetailFragment(institute);
        NavHostFragment.findNavController(this).navigate(action);
    }
}