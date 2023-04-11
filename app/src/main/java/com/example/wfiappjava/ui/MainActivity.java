package com.example.wfiappjava.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.wfiappjava.data.DataProvider;
import com.example.wfiappjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (DataProvider.institutes.isEmpty())
            DataProvider.getInstituteData(this);
    }
}