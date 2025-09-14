// Inside onCreateView
int farmId = FarmDetailsFragmentArgs.fromBundle(getArguments()).getFarmId();
FarmDetailsViewModel.Factory factory = new FarmDetailsViewModel.Factory(requireActivity().getApplication(), farmId);
viewModel = new ViewModelProvider(this, factory).get(FarmDetailsViewModel.class);

viewModel.getTransactions().observe(getViewLifecycleOwner(), transactions -> {
    // Update adapter and recalculate summary card
    // ...
});

binding.fabAddTransaction.setOnClickListener(v -> {
    // Navigate to AddTransactionFragment, passing the farmId
    NavDirections action = FarmDetailsFragmentDirections.actionFarmDetailsFragmentToAddTransactionFragment(farmId);
    NavHostFragment.findNavController(this).navigate(action);
});
