package com.example.hostello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class intro extends AppCompatActivity {

    private CardView getStartedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // Initialize button
        getStartedButton = findViewById(R.id.get_started_button);

        // Set click listener
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to main activity or next screen
                Intent intent = new Intent(intro.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}