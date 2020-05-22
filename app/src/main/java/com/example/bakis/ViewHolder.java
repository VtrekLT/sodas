package com.example.bakis;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ViewHolder extends RecyclerView.ViewHolder {

    //View mView;
    public TextView mTitle, mDetail;
    public ImageView mImage;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mTitle = (TextView) itemView.findViewById(R.id.rTitle);
        mDetail = (TextView) itemView.findViewById(R.id.rDescription);
        mImage = (ImageView) itemView.findViewById(R.id.rImageView);


        //mView = itemView;

    }
    // see details to recycler view row
    //public void setDetails(Context context, String title, String description, String image) {
        //views

        //TextView mTitle = mView.findViewById(R.id.rTitle);
        //TextView mDetail = mView.findViewById(R.id.rDescription);
        //ImageView mImage = mView.findViewById(R.id.rImageView);
        //set data to views
        //mTitle.setText(title);
        //mDetail.setText(description);
        //Picasso.get().load(image).into(mImage);

    }
//}
