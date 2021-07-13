package com.example.sahyadri_events;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandingPageAdapter extends RecyclerView.Adapter<LandingPageAdapter.MyViewHolder>{
    int i=1;
    private Context context;
    private Activity activity;
    private ArrayList event_name,id, event_id_recycler,event_description,admin_id;

    LandingPageAdapter(Activity activity, Context context,ArrayList id, ArrayList event_name,ArrayList event_id_recycler,ArrayList event_description,ArrayList admin_id){
        this.activity = activity;
        this.context = context;
        this.event_name = event_name;
        this.id = id;
        this.event_id_recycler = event_id_recycler;
        this.event_description = event_description;
        this.admin_id = admin_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_landing_row, parent, false);
        return new MyViewHolder(view);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final LandingPageAdapter.MyViewHolder holder, int position) {

        holder.event_name_text.setText(String.valueOf(event_name.get(position)));
        holder.event_id_txt.setText(String.valueOf(event_id_recycler.get(position)));
        holder.event_desc_txt.setText(String.valueOf(event_description.get(position)));
        holder.admin_id_txt.setText(String.valueOf(admin_id.get(position)));
    }


    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_txt, event_name_text, event_id_txt,event_desc_txt,admin_id_txt;


        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            event_name_text = itemView.findViewById(R.id.book_title_txt);
            event_id_txt = itemView.findViewById(R.id.book_author_txt);
            event_desc_txt = itemView.findViewById(R.id.txt_desc);
            admin_id_txt=itemView.findViewById(R.id.txt_admin);

        }

    }
}
