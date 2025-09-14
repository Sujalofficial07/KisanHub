package com.kisanhub.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.kisanhub.db.entity.Farm;

import java.util.List;

@Dao
public interface FarmDao {
    @Insert
    long insert(Farm farm);

    @Update
    void update(Farm farm);

    @Delete
    void delete(Farm farm);

    @Query("SELECT * FROM farms WHERE userId = :userId")
    LiveData<List<Farm>> getFarmsForUser(long userId);
}
