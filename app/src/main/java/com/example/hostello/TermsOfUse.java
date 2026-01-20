package com.example.hostello;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TermsOfUse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_terms_of_use);

        ImageButton backButton = findViewById(R.id.back);
        Button termsBackButton = findViewById(R.id.terms_back_btn);
        Button agreeButton = findViewById(R.id.term_agree_btn);

        backButton.setOnClickListener(v -> goToHome());
        termsBackButton.setOnClickListener(v -> goToHome());

        // ✅ AGREE BUTTON NAVIGATION
        agreeButton.setOnClickListener(v -> goToHome());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void goToHome() {
        Intent intent = new Intent(TermsOfUse.this, MainHomeActivity.class);
        startActivity(intent);
        finish();
    }
}
