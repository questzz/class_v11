package com.example.myrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.myrecyclerview.R;
import com.example.myrecyclerview.models.Food;

import java.util.ArrayList;

// 어대터 만들때
// 1. 상속 RecyclerView.Adapter<> <---
// 2. 뷰 홀더를 만들기
public  class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder> {

    ArrayList<Food> list;
    Context context;

    public FoodListAdapter(ArrayList<Food> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.thumbnailImageView
        Food food = list.get(position);
        holder.titleTextView.setText(food.getTitle());
        holder.subTitleTextView.setText(food.getSubTitle());
        holder.detailTextView.setText(food.getDetail());

        Glide.with(context)
                .load(food.getThumbnail())
                .centerCrop()
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.thumbnailImageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // 내부 클래스
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnailImageView;
        TextView titleTextView;
        TextView subTitleTextView;
        TextView detailTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnailImageView = itemView.findViewById(R.id.thumbnailImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subTitleTextView = itemView.findViewById(R.id.subTitleTextView);
            detailTextView = itemView.findViewById(R.id.detailTextView);
        }
    }
}
