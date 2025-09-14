public class AuthViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private MutableLiveData<User> authenticatedUser = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public AuthViewModel(Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<User> getAuthenticatedUser() {
        return authenticatedUser;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void signup(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            errorMessage.setValue("Username and password cannot be empty");
            return;
        }
        User newUser = new User();
        newUser.username = username;
        newUser.password = password; // Note: In a real app, hash the password!

        userRepository.signup(newUser, success -> {
            if (success) {
                // For simplicity, automatically log in after signup
                login(username, password);
            } else {
                errorMessage.postValue("Username already exists.");
            }
        });
    }

    public void login(String username, String password) {
        userRepository.login(username, password, user -> {
            if (user != null) {
                authenticatedUser.postValue(user);
            } else {
                errorMessage.postValue("Invalid username or password.");
            }
        });
    }
}
