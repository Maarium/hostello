package com.example.hostello;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;

public class PhoneNumber extends AppCompatActivity {

    private ImageButton back;
    private EditText phoneInput;
    private TextView termsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Edge-to-edge layout
        EdgeToEdge.enable(this);

        // Set layout
        setContentView(R.layout.activity_phone_number);

        // Apply padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        initializeViews();

        // Setup click listeners
        setupClickListeners();

        // Setup back press handler
        setupBackPressHandler();

        // Setup clickable terms link
        setupTermsLink();
    }

    private void initializeViews() {
        back = findViewById(R.id.back);
        phoneInput = findViewById(R.id.phone_input);
        termsText = findViewById(R.id.phone_continue_agree);
    }

    private void setupClickListeners() {
        // Back button closes activity
        back.setOnClickListener(v -> finish());

        // You can also add a listener to Continue button here if needed
        findViewById(R.id.continue_button).setOnClickListener(v -> {
            // Example: move to next activity after phone input validation
            String phone = phoneInput.getText().toString().trim();
            if (!phone.isEmpty()) {
                // Proceed to next activity
                // startActivity(new Intent(this, NextActivity.class));
            }
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

    private void setupTermsLink() {
        String text = "By clicking Continue button you are agreeing to our terms of use";
        SpannableString ss = new SpannableString(text);

        int start = text.indexOf("terms of use");
        int end = start + "terms of use".length();

        ss.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Open TermsActivity
                startActivity(new Intent(PhoneNumber.this, intro.class));
            }
        }, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        termsText.setText(ss);
        termsText.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
