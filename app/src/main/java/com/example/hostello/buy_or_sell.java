package com.example.hostello;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class buy_or_sell extends AppCompatActivity {

    private Button ownerButton;
    private Button memberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_or_sell);

        // Initialize buttons using the correct IDs from XML
        ownerButton = findViewById(R.id.owner_button);
        memberButton = findViewById(R.id.member_button);

        // Set up hover/press effects for owner button
        setupButtonEffect(ownerButton);

        // Set up hover/press effects for member button
        setupButtonEffect(memberButton);

        // Set click listeners
        ownerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to owner screen
                // Intent intent = new Intent(BuyOrSellActivity.this, OwnerActivity.class);
                // startActivity(intent);
            }
        });

        memberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to member screen
                // Intent intent = new Intent(BuyOrSellActivity.this, MemberActivity.class);
                // startActivity(intent);
            }
        });
    }

    private void setupButtonEffect(final Button button) {
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Darker blue when pressed
                        button.setBackgroundColor(Color.parseColor("#0D47A1"));
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Original blue when released
                        button.setBackgroundColor(Color.parseColor("#1565C0"));
                        break;
                }
                return false; // Return false to allow click events to fire
            }
        });
    }
}