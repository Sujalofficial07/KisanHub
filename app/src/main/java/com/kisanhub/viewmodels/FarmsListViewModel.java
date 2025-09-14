package com.kisanhub.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.kisanhub.database.entity.Farm;
import com.kisanhub.repositories.FarmRepository;
import java.util.List;

public class FarmsListViewModel extends AndroidViewModel {
    private final FarmRepository farmRepository;
    private final LiveData<List<Farm>> allFarms;
    private final int userId = 1; // Placeholder user ID

    public FarmsListViewModel(@NonNull Application application) {
        super(application);
        farmRepository = new FarmRepository(application);
        allFarms = farmRepository.getFarms(userId);
    }

    public LiveData<List<Farm>> getAllFarms() { return allFarms; }
    public void insert(Farm farm) { farmRepository.insertFarm(farm); }
    public void update(Farm farm) { farmRepository.updateFarm(farm); }
    public void delete(Farm farm) { farmRepository.deleteFarm(farm); }
}
