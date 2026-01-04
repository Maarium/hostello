package com.example.hostello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button; // or import androidx.appcompat.widget.AppCompatButton if using that

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MemberVerificationCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_member_vcode);

        // ===== Edge-to-Edge padding =====
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ===== Back Button Functionality =====
        ImageButton backButton = findViewById(R.id.back);
        if (backButton != null) {
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed(); // Go back to previous screen
                }
            });
        }

        // ===== Confirm Button Navigation =====
        Button confirmButton = findViewById(R.id.member_confirm); // replace with actual button id
        if (confirmButton != null) {
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to TermsOfUse activity
                    Intent intent = new Intent(MemberVerificationCode.this, TermsOfUse.class);
                    startActivity(intent);
                }
            });
        }
    }
}
