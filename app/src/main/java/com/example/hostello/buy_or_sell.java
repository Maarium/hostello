package com.example.hostello;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class buy_or_sell extends AppCompatActivity {

    private CardView ownerButton;
    private CardView memberButton;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy_or_sell);

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
        ownerButton = findViewById(R.id.owner_button);
        memberButton = findViewById(R.id.member_button);
    }

    private void setupClickListeners() {
        backButton.setOnClickListener(v -> finish());

        ownerButton.setOnClickListener(v -> {
            Intent intent = new Intent(buy_or_sell.this, OwnerActivity.class);
            startActivity(intent);
        });

        memberButton.setOnClickListener(v -> {
            Intent intent = new Intent(buy_or_sell.this, PhoneNumber.class);
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