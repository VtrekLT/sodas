package com.example.bakis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private Context context;

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    ArrayList<Model> list;
    MyAdapter adapter;
    String searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //recyclerview

        recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true); // nebuvo sito pas antra

        //set layout as LinearLayout

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Model>();

        //send Query to FirebaseDatabase
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Data"); // jei neveikia galima be child i reference rasyt patha .child("Data")

        //search data
        //private void firebaseSearch(String searchText){
          //  Query firebaseSearchQuery = reference.orderByChild("title").startAt(searchText).endAt(searchText+"\uf8ff");
            //FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
        //}

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    Model m = dataSnapshot1.getValue(Model.class);
                    list.add(m);
                }
                adapter = new MyAdapter(ListActivity.this, list);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ListActivity.this, "Kažkas blogai",Toast.LENGTH_SHORT).show();
            }
        });
        //recyclerView.setAdapter(adapter);
    }


}
