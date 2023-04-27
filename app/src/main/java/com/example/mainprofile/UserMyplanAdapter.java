package com.example.mainprofile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserMyplanAdapter extends RecyclerView.Adapter<UserMyplanAdapter.ViewHolder> {

    ArrayList<UserMyplanClass> planList;
    Context context;

    public UserMyplanAdapter(ArrayList<UserMyplanClass> planList, Context context) {
        this.planList = planList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserMyplanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_plan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserMyplanAdapter.ViewHolder holder, int position) {

        UserMyplanClass model = planList.get(position);

        // Set the values of the views in the ViewHolder to the data from the Trip object
        holder.titleTextView.setText(model.getTripTitle());
        holder.dateTextView.setText(model.getTripFromDate() + " - " + model.getTripToDate());
        holder.descriptionTextView.setText(model.getTripDesc());
        // Set the image using an image loading library like Picasso or Glide
      ///  Picasso.get().load(model.getTripImageUrl()).into(holder.imageView);
        Glide.with(context)
                .load(model.getTripImageUrl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return planList.size();
    }

    public void searchDataList(ArrayList<UserMyplanClass> searchList){
        planList = searchList;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public TextView dateTextView;
        public TextView descriptionTextView;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.text_view_title);
            dateTextView = itemView.findViewById(R.id.text_view_date);
            descriptionTextView = itemView.findViewById(R.id.text_view_description);
            imageView = itemView.findViewById(R.id.image_view);

        }
    }
}
