package com.example.bakis;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitle, mDetail;
    private ImageView mImage;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mTitle = (TextView) itemView.findViewById(R.id.rTitle);
        mDetail = (TextView) itemView.findViewById(R.id.rDescription);
        mImage = (ImageView) itemView.findViewById(R.id.rImageView);

    }


    }

