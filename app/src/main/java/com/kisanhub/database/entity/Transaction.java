package com.kisanhub.database.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions", foreignKeys = @ForeignKey(entity = Farm.class,
        parentColumns = "id",
        childColumns = "farmId",
        onDelete = ForeignKey.CASCADE))
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int farmId;
    public double amount;
    public String description;
    public String category;
    public String type; // "income" or "expense"
    public long date;   // Timestamp
}
