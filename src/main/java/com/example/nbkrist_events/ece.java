package com.example.nbkrist_events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ece extends AppCompatActivity {

    private TextView headerTextView;
    private TextView bodyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_aids);

        headerTextView = findViewById(R.id.headerTextView);
        bodyTextView = findViewById(R.id.bodyTextView);

        // Update header text
        headerTextView.setText("AAVISHKAR");

        // Update body text
        bodyTextView.setText("A National level Technical symposium (AAVISHKAR - 2K23) organizing by IETE Student branch ECE\nFor registrations:https://www.nbkrist.co.in/ECEshowallevents.php" +
                "\n");
    }
}
