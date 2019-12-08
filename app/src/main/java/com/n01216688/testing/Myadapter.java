package com.n01216688.testing;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewholder> {

    private Context context;
    ArrayList<DataStructure_Restaurantinfo> restaurantdata;
    private onRecyclerListener onRecyclerListener;

    public Myadapter(Context c , ArrayList<DataStructure_Restaurantinfo> d, onRecyclerListener onRecyclerListener){
        this.context = c;
        this.restaurantdata = d;
        this.onRecyclerListener = onRecyclerListener;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        MyViewholder holder = new MyViewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.MyViewholder holder, int position) {
  //      Glide.with(holder.itemView).load(restaurantdata.get(position).get)

        holder.name.setText(restaurantdata.get(position).getName());
        holder.phone.setText(restaurantdata.get(position).getPhone());
        holder.address.setText(restaurantdata.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return (restaurantdata!=null) ? restaurantdata.size() : 0;
    }


    public class MyViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView phone;
        TextView address;
        public MyViewholder(View itemView){
            super(itemView);

            this.name =  itemView.findViewById(R.id.name);
            this.phone =  itemView.findViewById(R.id.phone);
            this.address = itemView.findViewById(R.id.address);
            itemView.setOnClickListener((this));

        }

        @Override
        public void onClick(View view) {

            onRecyclerListener.onRecyclerClick(getAdapterPosition());

        }
    }

    public interface onRecyclerListener{
        void onRecyclerClick(int position);
    }

}
