package com.kisanhub.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.kisanhub.repositories.FarmRepository;

public class ProfileViewModel extends AndroidViewModel {
    private final FarmRepository farmRepository;
    // Placeholder for the current user's ID after login
    private final int userId = 1;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        farmRepository = new FarmRepository(application);
    }

    public LiveData<Integer> getFarmCount() { return farmRepository.getFarmCount(userId); }
    public LiveData<Double> getTotalIncome() { return farmRepository.getTotalIncome(userId); }
    public LiveData<Double> getTotalExpenses() { return farmRepository.getTotalExpenses(userId); }
}
