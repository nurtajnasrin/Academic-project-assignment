package com.example.testapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class doctor extends AppCompatActivity {

    private String[] doctorNames = {
            "Dr. Smith", "Dr. Johnson", "Dr. Williams", "Dr. Brown", "Dr. Davis",
            "Dr. Miller", "Dr. Wilson", "Dr. Moore", "Dr. Taylor", "Dr. Anderson",
            "Dr. Thomas", "Dr. Jackson", "Dr. White", "Dr. Harris", "Dr. Martin",
            "Dr. Thompson", "Dr. Garcia", "Dr. Martinez", "Dr. Robinson", "Dr. Clark",
            "Dr. Rodriguez", "Dr. Lewis", "Dr. Lee", "Dr. Walker", "Dr. Hall",
            "Dr. Allen", "Dr. Young", "Dr. Hernandez", "Dr. King", "Dr. Wright"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor);

        ListView listView = findViewById(R.id.doctorList);

        // Convert array to ArrayList for flexibility (optional step)
        ArrayList<String> doctorList = new ArrayList<>(Arrays.asList(doctorNames));

        // Create and set the custom adapter
        DoctorAdapter adapter = new DoctorAdapter(this, doctorList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
