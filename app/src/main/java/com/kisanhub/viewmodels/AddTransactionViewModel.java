public class AddTransactionViewModel extends AndroidViewModel {
    private FarmRepository repository;
    public AddTransactionViewModel(Application application) {
        super(application);
        repository = new FarmRepository(application);
    }
    public void insert(Transaction transaction) {
        repository.insertTransaction(transaction); // Add this method to the repository
    }
}
