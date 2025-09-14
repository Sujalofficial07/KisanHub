package com.kisanhub.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reminders")
public class Reminder {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long farmId;
    public String title;
    public long dueDate;
    public boolean isDone;

    public Reminder(long farmId, String title, long dueDate) {
        this.farmId = farmId;
        this.title = title;
        this.dueDate = dueDate;
        this.isDone = false;
    }
}
