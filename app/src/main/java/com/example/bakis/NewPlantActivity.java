package com.example.bakis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewPlantActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plant);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_plant_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_plant:
                savePlant();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void savePlant() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int persquare = numberPickerPriority.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this,"Prašau įveskite pavadinimą ir aprašymą", Toast.LENGTH_SHORT).show();
                    return;
        }
        CollectionReference plantsRef = FirebaseFirestore.getInstance()
                .collection("Notebook");
        plantsRef.add(new Plant(title, description, persquare));
        Toast.makeText(this, "Užrašas sukurtas", Toast.LENGTH_SHORT).show();
        finish();
    }
}
