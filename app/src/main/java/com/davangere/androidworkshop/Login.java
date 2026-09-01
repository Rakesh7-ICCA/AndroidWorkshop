package com.davangere.androidworkshop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {


    SQLiteDatabase db;
    Button login;
    TextView tv;
    EditText name1,pass1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        login = findViewById(R.id.loginBtn);
        tv = findViewById(R.id.textView);
        name1 = findViewById(R.id.nameLog);
        pass1 = findViewById(R.id.passwordLog);

        db = openOrCreateDatabase("Userdb",MODE_PRIVATE,null);
        db.execSQL("Create table if not exists user(name TEXT, age TEXT, password TEXT)");

        login.setOnClickListener(v -> {
            authUser();
        });

    }

    protected void authUser(){

        db = openOrCreateDatabase("Userdb",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("SELECT * FROM user WHERE name = ? AND password = ?", new String[]{name1.getText().toString(), pass1.getText().toString()});
        if (c.getCount() > 0) {
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
        } else {
            tv.setText("");
            Toast.makeText(this, "User not exist", Toast.LENGTH_SHORT).show();
        }
    }

}