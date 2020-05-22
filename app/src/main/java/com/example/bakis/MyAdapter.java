package com.example.bakis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Model> models;
    public MyAdapter(Context c, ArrayList<Model> m) {
        context = c;
        models = m;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(models.get(position).getTitle());
        holder.description.setText(models.get(position).getDescription());
        Picasso.get().load(models.get(position).getImage()).into(holder.image);
            holder.btn.setVisibility(View.VISIBLE);
            holder.onClick(position);



    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, description;
        ImageView image;
        Button btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.rTitle);
            description = (TextView) itemView.findViewById(R.id.rDescription);
            image = (ImageView) itemView.findViewById(R.id.rImageView);
            btn = (Button) itemView.findViewById(R.id.checkDetails);

        }

        public void onClick(final int position){
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, position+ " paspaustas", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
