// Inside onCreateView of FarmsListFragment
binding.fabAddFarm.setOnClickListener(v -> {
    showAddEditFarmDialog(null); // Pass null for adding a new farm
});

// Adapter needs to handle long-press
// In your FarmAdapter's onBindViewHolder:
holder.itemView.setOnLongClickListener(v -> {
    // Show context menu or dialog with Edit/Delete options
    PopupMenu popup = new PopupMenu(v.getContext(), v);
    popup.getMenuInflater().inflate(R.menu.farm_context_menu, popup.getMenu());
    popup.setOnMenuItemClickListener(item -> {
        if (item.getItemId() == R.id.action_edit_farm) {
            showAddEditFarmDialog(currentFarm);
            return true;
        } else if (item.getItemId() == R.id.action_delete_farm) {
            // Show confirmation dialog before deleting
            new MaterialAlertDialogBuilder(getContext())
                .setTitle("Delete Farm")
                .setMessage("Are you sure you want to delete " + currentFarm.name + "? This cannot be undone.")
                .setPositiveButton("Delete", (dialog, which) -> viewModel.delete(currentFarm))
                .setNegativeButton("Cancel", null)
                .show();
            return true;
        }
        return false;
    });
    popup.show();
    return true;
});

// Method to show the Add/Edit dialog
private void showAddEditFarmDialog(Farm farm) {
    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
    builder.setTitle(farm == null ? "Add New Farm" : "Edit Farm Name");

    // Set up the input
    final EditText input = new EditText(requireContext());
    input.setInputType(InputType.TYPE_CLASS_TEXT);
    if (farm != null) {
        input.setText(farm.name);
    }
    builder.setView(input);

    builder.setPositiveButton(farm == null ? "Add" : "Save", (dialog, which) -> {
        String farmName = input.getText().toString().trim();
        if (farm == null) { // Add new farm
            Farm newFarm = new Farm();
            newFarm.name = farmName;
            newFarm.userId = 1; // Set current user ID
            viewModel.insert(newFarm);
        } else { // Update existing farm
            farm.name = farmName;
            viewModel.update(farm);
        }
    });
    builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
    builder.show();
}
