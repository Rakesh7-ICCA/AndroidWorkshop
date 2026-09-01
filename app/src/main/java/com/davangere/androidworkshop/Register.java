package com.davangere.androidworkshop;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {


    EditText name , age , password;
    Button registerBtn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.regiName);
        age = findViewById(R.id.regiAge);
        password = findViewById(R.id.regiPass);

        registerBtn = findViewById(R.id.registerBtn);
        db = openOrCreateDatabase("Userdb",MODE_PRIVATE,null);
        db.execSQL("Create table if not exists user(name TEXT, age TEXT, password TEXT)");

        registerBtn.setOnClickListener(v -> {
            try {
                db.execSQL("INSERT INTO user VALUES(?,?,?)", new String[]{name.getText().toString(), age.getText().toString(),password.getText().toString()});
                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        }
}