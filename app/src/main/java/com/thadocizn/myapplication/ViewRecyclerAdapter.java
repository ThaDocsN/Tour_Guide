package com.thadocizn.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewRecyclerAdapter extends RecyclerView.Adapter<ViewRecyclerAdapter.MyViewHolder> {
    private ArrayList<Place> placeList;

    public ViewRecyclerAdapter(ArrayList<Place> placeList) {
       this.placeList = placeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_info, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Place currentPlace = placeList.get(position);

        // Check if an image is provided for this word or not
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            holder.imageView.setImageResource(currentPlace.getImageResourceId());
            // Make sure the view is visible
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            holder.imageView.setVisibility(View.GONE);
        }

    holder.name.setText(currentPlace.getAttraction());
    holder.date.setText(currentPlace.getAttractionAddress());
    holder.city.setText(currentPlace.getAttractionCity());

    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView date;
        TextView city;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.address);
            city = itemView.findViewById(R.id.city);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
