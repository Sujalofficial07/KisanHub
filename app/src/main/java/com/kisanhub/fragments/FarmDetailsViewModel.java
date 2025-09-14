package com.kisanhub.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.kisanhub.databinding.FragmentFarmDetailsBinding;
import com.kisanhub.viewmodels.FarmDetailsViewModel;

public class FarmDetailsFragment extends Fragment {

    private FragmentFarmDetailsBinding binding;
    private FarmDetailsViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFarmDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // This is a simplified way to get arguments.
        // A real app might use Safe Args.
        int farmId = getArguments() != null ? getArguments().getInt("farmId", -1) : -1;
        if (farmId != -1) {
            FarmDetailsViewModel.Factory factory = new FarmDetailsViewModel.Factory(requireActivity().getApplication(), farmId);
            viewModel = new ViewModelProvider(this, factory).get(FarmDetailsViewModel.class);
            
            // Observe LiveData from the ViewModel here
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
