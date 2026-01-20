package com.example.hostello;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OtpActivity extends AppCompatActivity {

    private static final String TAG = "OtpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp);

        // ===== Edge-to-Edge padding (only once) =====
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupBackButton();
        setupConfirmButton();
        setupBackPressHandler();
    }

    private void setupBackButton() {
        ImageButton backButton = findViewById(R.id.back);
        if (backButton != null) {
            backButton.setOnClickListener(v -> finish());
        } else {
            Log.e(TAG, "Back button not found");
        }
    }

    private void setupConfirmButton() {
        // If it's a CardView (like your phone_to_otp_btn)
        CardView confirmButton = findViewById(R.id.member_confirm);

        if (confirmButton != null) {
            confirmButton.setOnClickListener(v -> {
                // Navigate to TermsOfUse activity
                Intent intent = new Intent(OtpActivity.this, TermsOfUse.class);
                startActivity(intent);
            });
        } else {
            Log.e(TAG, "Confirm button not found");
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
}