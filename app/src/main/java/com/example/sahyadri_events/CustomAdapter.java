package com.example.sahyadri_events;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    int i=1;
    private Context context;
    private Activity activity;
    private ArrayList event_name,id, event_id_recycler,event_link;

    CustomAdapter(Activity activity, Context context,ArrayList id, ArrayList event_name,ArrayList event_id_recycler,ArrayList event_link){
        this.activity = activity;
        this.context = context;
        this.event_name = event_name;
        this.id = id;
        this.event_link=event_link;
        this.event_id_recycler = event_id_recycler;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.event_name_text.setText(String.valueOf(event_name.get(position)));
        holder.event_id_txt.setText(String.valueOf(event_id_recycler.get(position)));
        holder.event_link_txt.setText(String.valueOf(event_link.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_txt, event_name_text, event_id_txt,event_link_txt;


        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_txt = itemView.findViewById(R.id.book_id_txt);
            event_name_text = itemView.findViewById(R.id.book_title_txt);
            event_id_txt = itemView.findViewById(R.id.book_author_txt);
            event_link_txt=itemView.findViewById(R.id.txt_meet_link);

        }

    }

}