package com.davangere.androidworkshop;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button menu = findViewById(R.id.menubtn);
        Button emergenc = findViewById(R.id.emergency);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HelloActivity.class);
                startActivity(i);
            }
        });

        Context ctx = this;

        emergenc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1011);
                Intent in = new Intent(Intent.ACTION_CALL);
                in.setData(Uri.parse("tel:11100"));
                startActivity(in);
            }
        });


        ((Button)findViewById(R.id.frag)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent i = new Intent(ctx, FragActivity.class);
               startActivity(i);
            }
        });

        ((Button)findViewById(R.id.cam)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ctx, CameraActivity.class);
                startActivity(i);
            }
        });


        ((Button)findViewById(R.id.mapBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ctx, MapActivity.class);
                startActivity(i);
            }
        });

        ((Button)findViewById(R.id.notif)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ctx, NotificationActivity.class);
                startActivity(i);
            }
        });

    }
}