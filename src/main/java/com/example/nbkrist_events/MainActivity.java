package com.example.nbkrist_events;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button register,login;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private EditText regusername,regpassword;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper = new DatabaseHelper(this);

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        regusername = findViewById(R.id.username);
        regpassword = findViewById(R.id.password);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String username = regusername.getText().toString().trim();
                String password = regpassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                } else {
                    insertData(username,password);
                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();
            }
        });
    }
    public void insertData(String username,String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,username);
        contentValues.put(DatabaseHelper.COL_3,password);


        long id = db.insert(DatabaseHelper.TABLE_ao,null,contentValues);
    }
}
