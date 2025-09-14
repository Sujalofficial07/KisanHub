public class UserRepository {
    private UserDao userDao;

    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();
    }

    // Using an ExecutorService for background operations
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
