package com.example.wfiappjava.ui.fragments.detail;

import static android.os.Build.VERSION.SDK_INT;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.wfiappjava.data.Institute;
import com.example.wfiappjava.databinding.FragmentInstituteDetailBinding;
import com.example.wfiappjava.util.StopDeprecationWarningUtil;

public class InstituteDetailFragment extends Fragment {

    private FragmentInstituteDetailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInstituteDetailBinding.inflate(inflater);

        setupUi(getCurrentInstitute());

        return binding.getRoot();
    }


    private Institute getCurrentInstitute() {
        if (SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (getArguments() != null)
                return getArguments().getParcelable("institute", Institute.class);
            else return null;
        } else
            return StopDeprecationWarningUtil.parcelable(getArguments(), "institute", Institute.class);
    }

    private void setupUi(Institute currentInstitute) {
        Glide.with(this)
                .load(currentInstitute.getImageResource())
                .into(binding.instituteImageDetail);

        binding.titleDetail.setText(currentInstitute.getTitle());
        binding.universityTitleDetail.setText(currentInstitute.getInfo());
    }
}