public class FarmsListViewModel extends AndroidViewModel {
    private FarmRepository farmRepository;
    private LiveData<List<Farm>> allFarms;
    // Assume userId is available
    private int userId = 1;

    public FarmsListViewModel(Application application) {
        super(application);
        farmRepository = new FarmRepository(application);
        allFarms = farmRepository.getFarms(userId);
    }

    public LiveData<List<Farm>> getAllFarms() { return allFarms; }
    public void insert(Farm farm) { farmRepository.insertFarm(farm); }
    public void update(Farm farm) { farmRepository.updateFarm(farm); }
    public void delete(Farm farm) { farmRepository.deleteFarm(farm); }
}
