package com.kisanhub;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This layout contains the NavHostFragment, so we just need to set it.
        setContentView(R.layout.activity_main);
    }
}
