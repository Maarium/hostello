package com.example.hostello;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TermsOfUse extends AppCompatActivity {

    private static final String TAG = "TermsOfUse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_terms_of_use);

        // ===== Edge-to-Edge padding =====
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupViews();
        setupBackPressHandler();
    }

    private void setupViews() {
        // Initialize views
        ImageButton backButton = findViewById(R.id.back);
        Button termsBackButton = findViewById(R.id.terms_back_btn);
        Button agreeButton = findViewById(R.id.term_agree_btn);

        // Null checks with logging
        if (backButton != null) {
            backButton.setOnClickListener(v -> finish());
        } else {
            Log.e(TAG, "Back button not found");
        }

        if (termsBackButton != null) {
            termsBackButton.setOnClickListener(v -> finish());
        } else {
            Log.e(TAG, "Terms back button not found");
        }

        if (agreeButton != null) {
            agreeButton.setOnClickListener(v -> goToHome());
        } else {
            Log.e(TAG, "Agree button not found");
        }
    }

    private void setupBackPressHandler() {
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }

    private void goToHome() {
        try {
            Intent intent = new Intent(TermsOfUse.this, MainHomeActivity.class);
            // Clear the back stack so user can't go back to terms
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.e(TAG, "Error navigating to MainHomeActivity: " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(this, "Error: MainHomeActivity not found", Toast.LENGTH_LONG).show();

            // Alternative: Just finish this activity if MainHomeActivity doesn't exist
            finish();
        }
    }
}