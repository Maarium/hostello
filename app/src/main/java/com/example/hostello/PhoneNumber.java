package com.example.hostello;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PhoneNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        // ===== Back Button =====
        ImageButton backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // ===== Terms of Use =====
        TextView termsText = findViewById(R.id.phone_continue_agree);
        String fullText = "By Continue you are accepting our terms of use";
        SpannableString spannable = new SpannableString(fullText);

        int start = fullText.indexOf("terms of use");
        int end = start + "terms of use".length();

        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(PhoneNumber.this, TermsOfUse.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(Color.parseColor("#007AFF"));
                ds.setUnderlineText(false);
            }
        }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        termsText.setText(spannable);
        termsText.setMovementMethod(LinkMovementMethod.getInstance());

        // ===== Continue Button =====
        CardView continueButton = findViewById(R.id.member_continue_btn);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText phoneInput = findViewById(R.id.phone_input);
                String phoneNumber = phoneInput.getText().toString().trim();

                if (phoneNumber.isEmpty()) {
                    phoneInput.setError("Please enter your phone number");
                    return;
                }

                // Navigate to next activity
                Intent intent = new Intent(PhoneNumber.this, MemberVerificationCode.class);
                intent.putExtra("phone_number", phoneNumber); // optional
                startActivity(intent);
            }
        });
    }
}
