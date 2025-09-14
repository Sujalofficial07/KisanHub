@Dao
public interface TransactionDao {
    @Insert
    void insert(Transaction transaction);

    @Query("SELECT * FROM transactions WHERE farmId = :farmId ORDER BY date DESC")
    LiveData<List<Transaction>> getTransactionsForFarm(int farmId);
}
