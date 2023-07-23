package com.example.nbkrist_events;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity implements View.OnClickListener {

    private ImageButton[][] imageButtons = new ImageButton[4][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find image buttons by their IDs
        imageButtons[0][0] = findViewById(R.id.button1);
        imageButtons[0][1] = findViewById(R.id.button2);
        imageButtons[1][0] = findViewById(R.id.button3);
        imageButtons[1][1] = findViewById(R.id.button4);
        imageButtons[2][0] = findViewById(R.id.button5);
        imageButtons[2][1] = findViewById(R.id.button6);
        imageButtons[3][0] = findViewById(R.id.button7);
        imageButtons[3][1] = findViewById(R.id.button8);


        // Set click listener for each button
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                imageButtons[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View view) {
        // Handle button click events
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                if (view == imageButtons[0][0]) {
                    startActivity(new Intent(home.this, it_aids.class));

                    return;
                }
                    if (view == imageButtons[1][0]) {
                        startActivity(new Intent(home.this, it_aids.class));
                        return;

                    }
                if (view == imageButtons[0][1]) {
                    startActivity(new Intent(home.this, cse.class));
                    return;
                }
                if (view == imageButtons[1][1]) {
                    startActivity(new Intent(home.this, ece.class));
                    return;
                }
                if (view == imageButtons[2][0]) {
                    startActivity(new Intent(home.this, eee.class));
                    return;
                }
                if (view == imageButtons[2][1]) {
                    startActivity(new Intent(home.this, mech.class));
                    return;
                }
                if (view == imageButtons[3][0]) {
                    startActivity(new Intent(home.this, civil.class));
                    return;
                }

            }
        }

    }
}

