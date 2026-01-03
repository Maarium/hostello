package com.example.hostello;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class buy_or_sell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_or_sell);

        Button ownerButton = findViewById(R.id.owner_button);
        Button memberButton = findViewById(R.id.member_button);

        setupButtonEffect(ownerButton);
        setupButtonEffect(memberButton);

        ownerButton.setOnClickListener(v -> {
            // Add navigation to owner screen here
        });

        memberButton.setOnClickListener(v -> {
            // Add navigation to member screen here
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setupButtonEffect(final Button button) {
        button.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    button.setBackgroundColor(Color.parseColor("#0D47A1"));
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    button.setBackgroundColor(Color.parseColor("#1565C0"));
                    break;
            }
            return false;
        });
    }
}