package com.example.nbkrist_events;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView register;
    private EditText username,password;
    private Button loginButton;

    private SQLiteDatabase db;
    private Cursor cursor;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SQLiteOpenHelper openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        register = findViewById(R.id.register);
        username = findViewById(R.id.username);
        password= findViewById(R.id.password);
        loginButton = findViewById(R.id.login);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString().trim();
                String pswd = password.getText().toString().trim();
                if (uname.isEmpty() || pswd.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter your Email and Password to login", Toast.LENGTH_SHORT).show();
                } else {
                    cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_ao + " WHERE " + DatabaseHelper.COL_2 + "=? AND " + DatabaseHelper.COL_3 + "=?", new String[]{uname, pswd});

                    if(cursor.getCount()==0){
                        Toast.makeText(LoginActivity.this,"no entries exist",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    while(cursor.moveToNext()){
                        String name=cursor.getString(1);


                        Toast.makeText(LoginActivity.this,"login sucess",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, home.class));

                    }

                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }
        });



    }



}