public class FarmDetailsViewModel extends AndroidViewModel {
    private FarmRepository repository;
    private LiveData<List<Transaction>> transactions;

    public FarmDetailsViewModel(Application application, int farmId) {
        super(application);
        repository = new FarmRepository(application);
        transactions = repository.getTransactionsForFarm(farmId);
    }

    public LiveData<List<Transaction>> getTransactions() {
        return transactions;
    }

    // ViewModelFactory to pass farmId to ViewModel
    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        private final Application application;
        private final int farmId;

        public Factory(Application application, int farmId) {
            this.application = application;
            this.farmId = farmId;
        }

        @NonNull @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new FarmDetailsViewModel(application, farmId);
        }
    }
}
