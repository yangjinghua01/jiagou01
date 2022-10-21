package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerView.ViewHolder holder;
    private List<String>car = new ArrayList<>();
    private CardView cardView;
    private TextView ttt;
    public Adapter2(List<String> car) {
        this.car = car;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyc2,parent,false);
        holder =new RecyclerView.ViewHolder(view) {
        };
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String  s = car.get(position);
        cardView = holder.itemView.findViewById(R.id.carview);
        ttt = holder.itemView.findViewById(R.id.ttt);
        ttt.setText(s);
    }

    @Override
    public int getItemCount() {
        return car.size();
    }
}
