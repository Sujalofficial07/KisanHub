public class FarmRepository {
    private FarmDao farmDao;
    private TransactionDao transactionDao;

    public FarmRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        farmDao = db.farmDao();
        transactionDao = db.transactionDao();
    }

    // For Profile Dashboard
    public LiveData<Integer> getFarmCount(int userId) { return farmDao.getFarmCountForUser(userId); }
    public LiveData<Double> getTotalIncome(int userId) { return transactionDao.getTotalIncomeForUser(userId); }
    public LiveData<Double> getTotalExpenses(int userId) { return transactionDao.getTotalExpensesForUser(userId); }

    // For Farms List
    public LiveData<List<Farm>> getFarms(int userId) { return farmDao.getAllFarmsForUser(userId); }
    
    // Get transactions for a specific farm to calculate profit/loss
    public LiveData<List<Transaction>> getTransactionsForFarm(int farmId) {
        return transactionDao.getAllTransactionsForFarm(farmId);
    }

    public void insertFarm(Farm farm) {
        AppDatabase.databaseWriteExecutor.execute(() -> farmDao.insert(farm));
    }
}
