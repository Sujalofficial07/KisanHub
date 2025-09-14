package com.kisanhub.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.kisanhub.database.entity.User;
import com.kisanhub.repositories.UserRepository;

public class AuthViewModel extends AndroidViewModel {
    private final UserRepository userRepository;
    private final MutableLiveData<User> authenticatedUser = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public AuthViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<User> getAuthenticatedUser() {
        return authenticatedUser;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void signup(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            errorMessage.setValue("Username and password cannot be empty");
            return;
        }
        User newUser = new User();
        newUser.username = username;
        newUser.password = password; // In a real app, HASH THE PASSWORD!

        userRepository.signup(newUser, success -> {
            if (success) {
                login(username, password); // Auto-login after signup
            } else {
                errorMessage.postValue("Username already exists.");
            }
        });
    }

    public void login(String username, String password) {
        userRepository.login(username, password, user -> {
            if (user != null) {
                authenticatedUser.postValue(user);
            } else {
                errorMessage.postValue("Invalid username or password.");
            }
        });
    }
}
