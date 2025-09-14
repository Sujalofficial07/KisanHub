@Dao
public interface TransactionDao {
    @Insert
    void insert(Transaction transaction);

    @Query("SELECT * FROM transactions WHERE farmId = :farmId ORDER BY date DESC")
    LiveData<List<Transaction>> getTransactionsForFarm(int farmId);
    
    @Query("SELECT SUM(amount) FROM transactions WHERE farmId IN (SELECT id FROM farms WHERE userId = :userId) AND type = 'income'")
    LiveData<Double> getTotalIncomeForUser(int userId);

    @Query("SELECT SUM(amount) FROM transactions WHERE farmId IN (SELECT id FROM farms WHERE userId = :userId) AND type = 'expense'")
    LiveData<Double> getTotalExpensesForUser(int userId);
    
    @Query("SELECT * FROM transactions WHERE farmId = :farmId")
    LiveData<List<Transaction>> getAllTransactionsForFarm(int farmId);
}
