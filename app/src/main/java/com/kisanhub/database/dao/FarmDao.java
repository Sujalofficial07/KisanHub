package com.kisanhub.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.kisanhub.database.entity.Transaction;
import java.util.List;

@Dao
public interface TransactionDao {
    @Insert
    void insert(Transaction transaction);

    @Query("SELECT * FROM transactions WHERE farmId = :farmId ORDER BY date DESC")
    LiveData<List<Transaction>> getTransactionsForFarm(int farmId);

    @Query("SELECT SUM(amount) FROM transactions WHERE farmId IN (SELECT id FROM farms WHERE userId = :userId) AND type = 'income'")
    LiveData<Double> getTotalIncomeForUser(int userId);

    // THIS IS THE CORRECTED LINE
    @Query("SELECT SUM(amount) FROM transactions WHERE farmId IN (SELECT id FROM farms WHERE userId = :userId) AND type = 'expense'")
    LiveData<Double> getTotalExpensesForUser(int userId);
}
