package com.example.testapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Medicine extends AppCompatActivity {

    private String[] medicineNames = {
            "Acetaminophen",
            "Ibuprofen",
            "Aspirin",
            "Lisinopril",
            "Levothyroxine",
            "Amlodipine",
            "Metformin",
            "Atorvastatin",
            "Simvastatin",
            "Metoprolol",
            "Omeprazole",
            "Losartan",
            "Albuterol",
            "Azithromycin",
            "Amoxicillin",
            "Prednisone",
            "Citalopram",
            "Escitalopram",
            "Sertraline",
            "Fluoxetine",
            "Hydrochlorothiazide",
            "Gabapentin",
            "Tramadol",
            "Warfarin",
            "Ranitidine",
            "Pantoprazole",
            "Doxycycline",
            "Clindamycin",
            "Cephalexin",
            "Amphetamine",
            "Diazepam",
            "Oxycodone",
            "Morphine",
            "Furosemide",
            "Metronidazole",
            "Bupropion",
            "Lorazepam",
            "Venlafaxine",
            "Trazodone",
            "Phenytoin"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  EdgeToEdge.enable(this);
        setContentView(R.layout.activity_medicine);

        ListView listView = findViewById(R.id.medicine);

        // Create an ArrayAdapter to populate the ListView with doctor names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, medicineNames);

        // Set the ArrayAdapter to the ListView
        listView.setAdapter(adapter);
    }
}