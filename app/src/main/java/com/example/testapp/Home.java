package com.example.testapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.Signature;

public class Home extends AppCompatActivity {

TextView lab, doc,medicine,order,articales;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        lab=findViewById(R.id.lab_text);        lab=findViewById(R.id.lab_text);
        doc=findViewById(R.id.doctor_text);
        medicine=findViewById(R.id.medicine_text);
        order=findViewById(R.id.order_text);

        articales=findViewById(R.id.articals_text);

        lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this, Labtest.class);
                startActivity(intent);
                finish();
            }
        });
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this, doctor.class);
                startActivity(intent);
                finish();
            }
        });
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this, Medicine.class);
                startActivity(intent);
                finish();
            }
        });
        articales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this, health_articales.class);
                startActivity(intent);
                finish();
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this, order_details.class);
                startActivity(intent);
                finish();
            }
        });




    }
    }
