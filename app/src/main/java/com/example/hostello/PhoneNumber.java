package com.example.hostello;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PhoneNumber extends AppCompatActivity {

    private static final String TAG = "PhoneNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phone_number);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Use CardView instead of Button
        CardView btnNext = findViewById(R.id.phone_to_otp_btn);

        if (btnNext != null) {
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToOtpActivity();
                }
            });
        } else {
            Log.e(TAG, "CardView phone_to_otp_btn not found in layout");
        }
    }

    private void navigateToOtpActivity() {
        Intent intent = new Intent(PhoneNumber.this, OtpActivity.class);

        // Optional: Pass data to OtpActivity
        // intent.putExtra("phone_number", phoneNumber);

        startActivity(intent);
    }
}