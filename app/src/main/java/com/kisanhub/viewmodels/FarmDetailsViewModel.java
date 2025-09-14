package com.kisanhub.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.kisanhub.database.entity.Transaction;
import com.kisanhub.repositories.FarmRepository;
import java.util.List;

// THIS IS THE CORRECT CLASS FOR THIS FILE
public class FarmDetailsViewModel extends AndroidViewModel {
    private final FarmRepository repository;
    private final LiveData<List<Transaction>> transactions;

    public FarmDetailsViewModel(@NonNull Application application, int farmId) {
        super(application);
        repository = new FarmRepository(application);
        transactions = repository.getTransactionsForFarm(farmId);
    }

    public LiveData<List<Transaction>> getTransactions() {
        return transactions;
    }

    public static class Factory implements ViewModelProvider.Factory {
        private final Application application;
        private final int farmId;

        public Factory(@NonNull Application application, int farmId) {
            this.application = application;
            this.farmId = farmId;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass.isAssignableFrom(FarmDetailsViewModel.class)) {
                return (T) new FarmDetailsViewModel(application, farmId);
            }
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
