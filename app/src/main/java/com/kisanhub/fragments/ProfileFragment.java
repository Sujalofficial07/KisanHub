// Inside onCreateView of ProfileFragment
profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

profileViewModel.getFarmCount().observe(getViewLifecycleOwner(), count -> {
    binding.textViewTotalFarms.setText("Total Farms: " + count);
});

profileViewModel.getTotalIncome().observe(getViewLifecycleOwner(), income -> {
    // Handle null case
    double totalIncome = (income == null) ? 0 : income;
    binding.textViewTotalIncome.setText("Total Income: ₹" + totalIncome);
    updateNetProfit();
});

profileViewModel.getTotalExpenses().observe(getViewLifecycleOwner(), expenses -> {
    double totalExpenses = (expenses == null) ? 0 : expenses;
    binding.textViewTotalExpenses.setText("Total Expenses: ₹" + totalExpenses);
    updateNetProfit();
});

// Helper method to update Net Profit
private void updateNetProfit() {
    Double income = profileViewModel.getTotalIncome().getValue();
    Double expenses = profileViewModel.getTotalExpenses().getValue();
    double totalIncome = (income == null) ? 0 : income;
    double totalExpenses = (expenses == null) ? 0 : expenses;
    double netProfit = totalIncome - totalExpenses;

    if (netProfit >= 0) {
        binding.textViewNetProfit.setText("Net Profit: ₹" + netProfit);
        binding.textViewNetProfit.setTextColor(getResources().getColor(R.color.profit_green, null));
    } else {
        binding.textViewNetProfit.setText("Net Loss: ₹" + Math.abs(netProfit));
        binding.textViewNetProfit.setTextColor(getResources().getColor(R.color.loss_red, null));
    }
}
