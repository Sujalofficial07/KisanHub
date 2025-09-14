package com.kisanhub.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.snackbar.Snackbar;
import com.kisanhub.R;
import com.kisanhub.databinding.FragmentSignupBinding;
import com.kisanhub.viewmodels.AuthViewModel;

public class SignupFragment extends Fragment {
    private FragmentSignupBinding binding;
    private AuthViewModel authViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        // Observer for successful authentication
        authViewModel.getAuthenticatedUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                // After signup, navigate to the main part of the app and clear the back stack
                NavHostFragment.findNavController(this).navigate(R.id.action_global_profileFragment);
            }
        });

        // Observer for error messages
        authViewModel.getErrorMessage().observe(getViewLifecycleOwner(), error -> {
            if (error != null && !error.isEmpty()) {
                Snackbar.make(binding.getRoot(), error, Snackbar.LENGTH_SHORT).show();
            }
        });

        // Handle the signup button click
        binding.buttonSignup.setOnClickListener(v -> {
            String username = binding.textFieldUsernameSignup.getEditText().getText().toString().trim();
            String password = binding.textFieldPasswordSignup.getEditText().getText().toString().trim();
            authViewModel.signup(username, password);
        });

        // Handle the prompt to go to the login screen
        binding.textViewLoginPrompt.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_signupFragment_to_loginFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Prevent memory leaks
    }
}
