package com.example.testapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Labtest extends AppCompatActivity {
    private String[] labTestNames = {
            "Complete Blood Count (CBC)",
            "Basic Metabolic Panel (BMP)",
            "Lipid Panel",
            "Thyroid Stimulating Hormone (TSH)",
            "Urinalysis (UA)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_labtest);
        ListView listView = findViewById(R.id.labListView);

        // Create an ArrayAdapter to populate the ListView with doctor names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, labTestNames);

        // Set the ArrayAdapter to the ListView
        listView.setAdapter(adapter);
    }
}