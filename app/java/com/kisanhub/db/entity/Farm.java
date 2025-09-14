package com.kisanhub.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "farms")
public class Farm {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long userId;
    public String name;

    public Farm(long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
