package com.example.bakis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;


public class PlantAdapter extends FirestoreRecyclerAdapter<Plant, PlantAdapter.PlantHolder> {
    private OnItemClickListener listener;


    public PlantAdapter(@NonNull FirestoreRecyclerOptions<Plant> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PlantHolder plantHolder, int i, @NonNull Plant plant) {
        plantHolder.textViewTitle.setText(plant.getName());
        plantHolder.textViewDescription.setText(plant.getType());
        plantHolder.textViewPersquare.setText(String.valueOf(plant.getPersquare()));

    }

    @NonNull
    @Override
    public PlantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item, parent, false);
        return new PlantHolder(v);
    }

    public void deleteItem (int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class PlantHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewPersquare;


        public PlantHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPersquare = itemView.findViewById(R.id.text_view_persquare);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(getSnapshots().getSnapshot(position),position);
                    }

                }
            });

        }
    }
    public interface OnItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;

    }
}
