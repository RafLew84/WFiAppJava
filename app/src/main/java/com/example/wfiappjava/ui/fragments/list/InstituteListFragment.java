package com.example.wfiappjava.ui.fragments.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wfiappjava.R;
import com.example.wfiappjava.data.DataProvider;
import com.example.wfiappjava.data.Institute;
import com.example.wfiappjava.databinding.FragmentInstituteListBinding;

import java.util.Collections;


public class InstituteListFragment extends Fragment {

    private FragmentInstituteListBinding binding;

    private int gridColumnCount = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gridColumnCount = requireActivity().getResources().getInteger(R.integer.grid_column_count);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInstituteListBinding.inflate(inflater);

        setupRecyclerView();
        setupItemTouchHelper(getDragDirs(), getSwipeDirs());

        return binding.getRoot();
    }

    private void setupRecyclerView() {
        binding.recyclerView.setAdapter(new InstituteAdapter(this::navigateToDetailFragment));
        binding.recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), gridColumnCount));
    }

    private int getSwipeDirs() {
        if(gridColumnCount >1)
            return 0;
        else
            return ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
    }

    private int getDragDirs() {
        return ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.UP | ItemTouchHelper.DOWN;
    }

    private void setupItemTouchHelper(int dragDirs, int swipeDirs) {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                dragDirs, swipeDirs) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                Collections.swap(DataProvider.institutes, from, to);
                if (recyclerView.getAdapter() != null)
                    recyclerView.getAdapter().notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                DataProvider.institutes.remove(viewHolder.getAdapterPosition());
                if (binding.recyclerView.getAdapter() != null)
                    binding.recyclerView.getAdapter().notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(binding.recyclerView);
    }

    private void navigateToDetailFragment(Institute institute) {
        NavDirections action = InstituteListFragmentDirections.actionInstituteListFragmentToInstituteDetailFragment(institute);
        NavHostFragment.findNavController(this).navigate(action);
    }
}