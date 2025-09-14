public class ProfileViewModel extends AndroidViewModel {
    private FarmRepository farmRepository;
    // Assuming userId is fetched after login and stored, e.g., in SharedPreferences
    private int userId = 1; // Placeholder for the current user's ID

    public ProfileViewModel(Application application) {
        super(application);
        farmRepository = new FarmRepository(application);
    }

    public LiveData<Integer> getFarmCount() { return farmRepository.getFarmCount(userId); }
    public LiveData<Double> getTotalIncome() { return farmRepository.getTotalIncome(userId); }
    public LiveData<Double> getTotalExpenses() { return farmRepository.getTotalExpenses(userId); }
}
