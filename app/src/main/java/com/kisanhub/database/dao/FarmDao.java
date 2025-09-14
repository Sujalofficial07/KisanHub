package com.kisanhub.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.kisanhub.database.entity.Farm;
import java.util.List;

@Dao
public interface FarmDao {
    @Insert
    void insert(Farm farm);

    @Update
    void update(Farm farm);

    @Delete
    void delete(Farm farm);

    @Query("SELECT * FROM farms WHERE userId = :userId ORDER BY name ASC")
    LiveData<List<Farm>> getFarmsForUser(int userId);

    @Query("SELECT COUNT(*) FROM farms WHERE userId = :userId")
    LiveData<Integer> getFarmCountForUser(int userId);
}
