package com.kisanhub.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;

import com.kisanhub.db.entity.Transaction;

import java.util.List;

@Dao
public interface TransactionDao {
    @Insert
    long insert(Transaction t);

    @Delete
    void delete(Transaction t);

    @Query("SELECT * FROM transactions WHERE farmId = :farmId ORDER BY date DESC")
    LiveData<List<Transaction>> getForFarm(long farmId);

    @Query("SELECT SUM(CASE WHEN type='income' THEN amount ELSE -amount END) FROM transactions WHERE farmId = :farmId")
    LiveData<Double> getNetForFarm(long farmId);

    @Query("SELECT SUM(amount) FROM transactions WHERE farmId = :farmId AND type='income'")
    LiveData<Double> getIncomeForFarm(long farmId);

    @Query("SELECT SUM(amount) FROM transactions WHERE farmId = :farmId AND type='expense'")
    LiveData<Double> getExpenseForFarm(long farmId);

    @Query("SELECT * FROM transactions WHERE farmId = :farmId AND (description LIKE '%' || :q || '%' OR category LIKE '%' || :q || '%') ORDER BY date DESC")
    LiveData<List<Transaction>> search(long farmId, String q);
}
