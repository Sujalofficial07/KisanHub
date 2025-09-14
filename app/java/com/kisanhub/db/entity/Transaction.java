package com.kisanhub.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long farmId;
    public double amount;
    public String description;
    public String category; // Seeds, Labour, Fertilizer, Transport, Irrigation, Others, Income
    public String type; // income or expense
    public long date; // epoch millis

    public Transaction(long farmId, double amount, String description, String category, String type, long date) {
        this.farmId = farmId;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.type = type;
        this.date = date;
    }
}
