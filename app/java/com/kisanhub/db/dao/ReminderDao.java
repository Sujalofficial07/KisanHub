package com.kisanhub.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kisanhub.db.entity.Reminder;

import java.util.List;

@Dao
public interface ReminderDao {
    @Insert
    long insert(Reminder r);

    @Update
    void update(Reminder r);

    @Query("SELECT * FROM reminders WHERE farmId = :farmId ORDER BY dueDate")
    LiveData<List<Reminder>> forFarm(long farmId);
}
