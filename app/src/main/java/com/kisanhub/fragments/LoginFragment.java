public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding; // Using ViewBinding
    private AuthViewModel authViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        binding.buttonLogin.setOnClickListener(v -> {
            String username = binding.textFieldUsername.getEditText().getText().toString().trim();
            String password = binding.textFieldPassword.getEditText().getText().toString().trim();
            authViewModel.login(username, password);
        });

        binding.textViewSignupPrompt.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_signupFragment);
        });

        authViewModel.getAuthenticatedUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                // Navigate to the main app (e.g., Profile Page)
                NavHostFragment.findNavController(this).navigate(R.id.action_global_profileFragment);
            }
        });

        authViewModel.getErrorMessage().observe(getViewLifecycleOwner(), error -> {
            // Show a Snackbar or set an error on a text field
            Snackbar.make(binding.getRoot(), error, Snackbar.LENGTH_SHORT).show();
        });

        return binding.getRoot();
    }
}
