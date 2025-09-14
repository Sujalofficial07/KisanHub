package com.kisanhub.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.kisanhub.database.entity.Transaction;
import com.kisanhub.repositories.FarmRepository;

public class AddTransactionViewModel extends AndroidViewModel {
    private final FarmRepository repository;

    public AddTransactionViewModel(@NonNull Application application) {
        super(application);
        repository = new FarmRepository(application);
    }

    public void insert(Transaction transaction) {
        repository.insertTransaction(transaction);
    }
}
