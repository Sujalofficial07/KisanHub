package com.kisanhub.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.kisanhub.database.dao.FarmDao;
import com.kisanhub.database.dao.TransactionDao;
import com.kisanhub.database.dao.UserDao;
import com.kisanhub.database.entity.Farm;
import com.kisanhub.database.entity.Transaction;
import com.kisanhub.database.entity.User;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Farm.class, Transaction.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract FarmDao farmDao();
    public abstract TransactionDao transactionDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "kisanhub_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
