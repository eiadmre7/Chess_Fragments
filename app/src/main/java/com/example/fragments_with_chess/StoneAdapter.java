package com.example.fragments_with_chess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoneAdapter extends RecyclerView.Adapter<StoneAdapter.ViewHolder> {
    private ArrayList<Stone> stones;
    private ItemSelected activity;

    public interface ItemSelected{
        void onItemSelected(int index);
    }

    public StoneAdapter(Context context,ArrayList<Stone> list) {
        this.stones = list;
        this.activity = (ItemSelected) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tvname);
            imageView=itemView.findViewById(R.id.imageview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemSelected(stones.indexOf(v.getTag()));
                }
            });
        }
    }
    @NonNull
    @Override
    public StoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoneAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(stones.get(position));
        holder.textView.setText(stones.get(position).getName());
        holder.imageView.setImageResource(stones.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return stones.size();
    }
}
