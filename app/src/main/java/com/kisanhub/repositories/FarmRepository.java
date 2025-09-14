package com.kisanhub.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.kisanhub.database.AppDatabase;
import com.kisanhub.database.dao.FarmDao;
import com.kisanhub.database.dao.TransactionDao;
import com.kisanhub.database.entity.Farm;
import com.kisanhub.database.entity.Transaction;
import java.util.List;

public class FarmRepository {
    private FarmDao farmDao;
    private TransactionDao transactionDao;

    public FarmRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        farmDao = db.farmDao();
        transactionDao = db.transactionDao();
    }

    // Farm operations
    public void insertFarm(Farm farm) { AppDatabase.databaseWriteExecutor.execute(() -> farmDao.insert(farm)); }
    public void updateFarm(Farm farm) { AppDatabase.databaseWriteExecutor.execute(() -> farmDao.update(farm)); }
    public void deleteFarm(Farm farm) { AppDatabase.databaseWriteExecutor.execute(() -> farmDao.delete(farm)); }
    
    // Transaction operations
    public void insertTransaction(Transaction transaction) { AppDatabase.databaseWriteExecutor.execute(() -> transactionDao.insert(transaction)); }

    // LiveData getters
    public LiveData<Integer> getFarmCount(int userId) { return farmDao.getFarmCountForUser(userId); }
    public LiveData<Double> getTotalIncome(int userId) { return transactionDao.getTotalIncomeForUser(userId); }
    public LiveData<Double> getTotalExpenses(int userId) { return transactionDao.getTotalExpensesForUser(userId); }
    public LiveData<List<Farm>> getFarms(int userId) { return farmDao.getFarmsForUser(userId); }
    public LiveData<List<Transaction>> getTransactionsForFarm(int farmId) { return transactionDao.getTransactionsForFarm(farmId); }
}
