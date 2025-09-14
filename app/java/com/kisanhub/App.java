package com.kisanhub;

import android.app.Application;

import androidx.room.Room;

import com.kisanhub.db.AppDatabase;

public class App extends Application {
    private static App instance;
    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "kisanhub-db")
                .fallbackToDestructiveMigration()
                .build();
    }

    public static App getInstance() { return instance; }
    public static AppDatabase getDatabase(){ return database; }
}
