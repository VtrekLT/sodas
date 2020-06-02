package com.example.bakis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import static java.lang.System.load;

public class Plot extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    String ids = "";
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot);
        //fireStore = FirebaseFirestore.getInstance();
        //fAuth = FirebaseAuth.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for(int i=1;i<=120;i++) {
            final ImageView square = (ImageView)findViewById(getResources().getIdentifier("square_" + i,"id", this.getPackageName()));
            square.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ids = v.getResources().getResourceEntryName(v.getId());
                    showPopup(v);
                }
            });
        }
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();

    }

    private void showPopup (View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        ImageView square = ((ImageView)findViewById(getResources().getIdentifier(ids,"id", this.getPackageName())));
        switch(item.getItemId()) {

            case R.id.fence1:
                square.setImageResource(R.mipmap.fenceh);
                Toast.makeText(this, "Tvora pastatyta horizontaliai", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.fence2:
                square.setImageResource(R.mipmap.fencev);
                Toast.makeText(this, "Tvora pastatyta vertikaliai", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.texture1:
                square.setImageResource(R.mipmap.soil);
                Toast.makeText(this, "Žemės pagrindas nustatytas šiam blokui", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.texture2:
                square.setImageResource(R.mipmap.stone);
                Toast.makeText(this, "Akmeninis pagrindas nustatytas šiam blokui", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.texture3:
                square.setImageResource(R.mipmap.wood);
                Toast.makeText(this, "Medinių lentų pagrindas nustatytas šiam blokui", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.grass1:
                square.setImageResource(R.mipmap.grass1);
                Toast.makeText(this, "Žolė pasodinta", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.grass2:
                square.setImageResource(R.mipmap.grass2);
                Toast.makeText(this, "Pasodinta apaugusi žolė", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.crop1:
                square.setImageResource(R.mipmap.broccoli);
                Toast.makeText(this, "Brokolis pasodintas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.crop2:
                square.setImageResource(R.mipmap.brussel);
                Toast.makeText(this, "Briuselio kopūstas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.crop3:
                square.setImageResource(R.mipmap.cabbage);
                Toast.makeText(this, "Kopūstas pasodintas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.crop4:
                square.setImageResource(R.mipmap.cauliflower);
                Toast.makeText(this, "Žiedinis kopūstas pasodintas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.flower1:
                square.setImageResource(R.mipmap.chamomile);
                Toast.makeText(this, "Ramunė pasodinta", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.flower2:
                square.setImageResource(R.mipmap.marigold);
                Toast.makeText(this, "Medetka pasodinta", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.flower3:
                square.setImageResource(R.mipmap.nasturtium);
                Toast.makeText(this, "Nasturtė pasodinta", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.flower4:
                square.setImageResource(R.mipmap.sunflower);
                Toast.makeText(this, "Saulėgrąža pasodinta", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.berrie1:
                square.setImageResource(R.mipmap.blueberry);
                Toast.makeText(this, "Mėlynės pasodintos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.berrie2:
                square.setImageResource(R.mipmap.raspberries);
                Toast.makeText(this, "Avietės pasodintos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.berrie3:
                square.setImageResource(R.mipmap.strawberries);
                Toast.makeText(this, "Braškės pasodintos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.green1:
                square.setImageResource(R.mipmap.lettuce);
                Toast.makeText(this, "Salotos pasodintos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.green2:
                square.setImageResource(R.mipmap.spinach);
                Toast.makeText(this, "Špinatai pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.herb1:
                square.setImageResource(R.mipmap.mint);
                Toast.makeText(this, "Mėta pasodinta", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.herb2:
                square.setImageResource(R.mipmap.basil);
                Toast.makeText(this, "Bazilikas pasodintas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.herb3:
                square.setImageResource(R.mipmap.dill);
                Toast.makeText(this, "Krapai pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.legume1:
                square.setImageResource(R.mipmap.beans);
                Toast.makeText(this, "Pupelės pasodintos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.legume2:
                square.setImageResource(R.mipmap.peas);
                Toast.makeText(this, "Žirniai pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.vegetable1:
                square.setImageResource(R.mipmap.paprika);
                Toast.makeText(this, "Paprika pasodinta", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.vegetable2:
                square.setImageResource(R.mipmap.tomato);
                Toast.makeText(this, "Pomidorai pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.vegetable3:
                square.setImageResource(R.mipmap.tomatocherry);
                Toast.makeText(this, "Pomidorai(cherry) pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.vegetable4:
                square.setImageResource(R.mipmap.tomatosliv);
                Toast.makeText(this, "Pomidorai(slyviniai) pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.vegetable5:
                square.setImageResource(R.mipmap.eggplant);
                Toast.makeText(this, "Baklažanas pasodintas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.vegetable6:
                square.setImageResource(R.mipmap.hotpepper);
                Toast.makeText(this, "Aštrieji pipirai pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.root1:
                square.setImageResource(R.mipmap.radish);
                Toast.makeText(this, "Ridikai pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.root2:
                square.setImageResource(R.mipmap.carrot);
                Toast.makeText(this, "Morkos pasodintos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.root3:
                square.setImageResource(R.mipmap.garlic);
                Toast.makeText(this, "Česnakai pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.root4:
                square.setImageResource(R.mipmap.onion);
                Toast.makeText(this, "Svogūnai pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.root5:
                square.setImageResource(R.mipmap.potato);
                Toast.makeText(this, "Bulvės pasodintos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.root6:
                square.setImageResource(R.mipmap.beets);
                Toast.makeText(this, "Burokai pasodinti", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;



        }
    }

}
