package com.example.sahyadri_events;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminRegistrationsAdapter extends RecyclerView.Adapter<AdminRegistrationsAdapter.MyViewHolder>{
    int i=1;
    private Context context;
    private Activity activity;
    private ArrayList name,mail, usn,branch,sem;

    AdminRegistrationsAdapter(Activity activity, Context context, ArrayList name, ArrayList mail, ArrayList usn, ArrayList sem, ArrayList branch){
        this.activity = activity;
        this.context =context;
        this.name = name;
        this.usn = usn;
        this.mail = mail;
        this.sem = sem;
        this.branch = branch;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_admin_registeration_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminRegistrationsAdapter.MyViewHolder holder, int position) {
        holder.name_text.setText(String.valueOf(name.get(position)));
        holder.mail_txt.setText(String.valueOf(mail.get(position)));
        holder.usn_txt.setText(String.valueOf(usn.get(position)));
        holder.sem_txt.setText(String.valueOf(sem.get(position)));
        holder.branch_txt.setText(String.valueOf(branch.get(position)));
    }


    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView branch_txt, name_text, mail_txt,usn_txt,sem_txt;


        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_text = itemView.findViewById(R.id.txt_name);
            mail_txt = itemView.findViewById(R.id.txt_mail);
            usn_txt = itemView.findViewById(R.id.txt_usn);
            sem_txt=itemView.findViewById(R.id.txt_sem);
            branch_txt=itemView.findViewById(R.id.txt_branch);
        }
    }
}
