// Inside onCreateView and after setting up view model...

binding.buttonSaveTransaction.setOnClickListener(v -> {
    // 1. Get all values from the form fields
    // 2. Perform validation
    // 3. Create a new Transaction object
    Transaction newTransaction = new Transaction();
    newTransaction.farmId = farmId; // Retrieved from navigation arguments
    newTransaction.amount = Double.parseDouble(binding.editTextAmount.getText().toString());
    // ... set other fields
    
    // 4. Save using the ViewModel
    viewModel.insert(newTransaction);
    
    // 5. Show confirmation and navigate back
    Snackbar.make(v, "Transaction saved", Snackbar.LENGTH_SHORT).show();
    NavHostFragment.findNavController(this).popBackStack();
});
