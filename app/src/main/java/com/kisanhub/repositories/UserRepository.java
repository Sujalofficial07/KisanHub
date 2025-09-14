package com.kisanhub.repositories;

import android.app.Application;
import com.kisanhub.database.AppDatabase;
import com.kisanhub.database.dao.UserDao;
import com.kisanhub.database.entity.User;
import java.util.function.Consumer;

public class UserRepository {
    private final UserDao userDao;

    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();
    }

    public void signup(User user, Consumer<Boolean> callback) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            if (userDao.getUser(user.username) == null) {
                userDao.insert(user);
                callback.accept(true); // Success
            } else {
                callback.accept(false); // User already exists
            }
        });
    }

    public void login(String username, String password, Consumer<User> callback) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            User user = userDao.login(username, password);
            callback.accept(user); // Returns user object on success, null on failure
        });
    }
}
