package com.example.nbkrist_events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class eee extends AppCompatActivity {

    private TextView headerTextView;
    private TextView bodyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_aids);

        headerTextView = findViewById(R.id.headerTextView);
        bodyTextView = findViewById(R.id.bodyTextView);

        // Update header text
        headerTextView.setText("INSPIRON");

        // Update body text
        bodyTextView.setText("Inspiron is a national level technical symposium organized by the department of EEE. It is a great way to promote technical education and provides an opportunity for students to showcase their technical abilities, talents, skills, ideas and gain recognition for their work.\nFor registrations:https://www.nbkrist.co.in/eee-events.php" +
                "\n");
    }
}
