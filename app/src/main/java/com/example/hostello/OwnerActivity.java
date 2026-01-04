package com.example.hostello;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OwnerActivity extends AppCompatActivity {

    private ImageButton backButton;
    private CardView getStartedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_owner);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();
        setupClickListeners();
        setupBackPressHandler();
    }

    private void initializeViews() {
        backButton = findViewById(R.id.back_button);
        getStartedButton = findViewById(R.id.get_started_button_owner);
    }

    private void setupClickListeners() {
        backButton.setOnClickListener(v -> finish());

        getStartedButton.setOnClickListener(v -> {
            Intent intent = new Intent(OwnerActivity.this, OwnerRegistrationActivity.class);
            startActivity(intent);
        });
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