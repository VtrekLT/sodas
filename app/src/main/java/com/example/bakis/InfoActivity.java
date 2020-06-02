package com.example.bakis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);




        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent myIntent = new Intent(InfoActivity.this, SettingsActivity.class);
                InfoActivity.this.startActivity(myIntent);
                Toast.makeText(this, "Nustatymai atidaryti", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Intent myIntent2 = new Intent(InfoActivity.this, MainActivity.class);
                InfoActivity.this.startActivity(myIntent2);
                Toast.makeText(this, "Užrašinė atidaryta", Toast.LENGTH_SHORT).show();
                        break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch(item.getItemId()){
                        case R.id.nav_logout:
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(getApplicationContext(),Login.class));
                            finish();
                            break;
                        case R.id.nav_plants:
                            Intent myIntent2 = new Intent(InfoActivity.this, ListActivity.class);
                            InfoActivity.this.startActivity(myIntent2);
                            break;
                        case R.id.nav_plot:
                            Intent myIntent3 = new Intent(InfoActivity.this, Plot.class);
                            InfoActivity.this.startActivity(myIntent3);
                            break;
                    }

                    return true;
                }
            };

}
