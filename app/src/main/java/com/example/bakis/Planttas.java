package com.example.bakis;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Planttas extends AppCompatActivity {
    TextView name, type, perSquare;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String plantId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_plants1);
        //name = findViewById(R.id.name);
        //perSquare = findViewById(R.id.perSquare);
        //type = findViewById(R.id.type);


        fStore = FirebaseFirestore.getInstance();


        DocumentReference documentReference = fStore.collection("plants").document(plantId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                name.setText(documentSnapshot.getString("name"));
                perSquare.setText(documentSnapshot.getString("perSquare"));
                type.setText(documentSnapshot.getString("type"));

            }
        });


    }
}
