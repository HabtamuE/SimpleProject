package com.beginner.userinformationmanagmentapp.RecyclerViewClasses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beginner.userinformationmanagmentapp.DetailActivity;
import com.beginner.userinformationmanagmentapp.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.DatabaseViewHolders> {
    private Context context;
    public AdapterClass(ArrayList<ModalClass> objModelClassArrayList, Context context) {
        this.objModelClassArrayList = objModelClassArrayList;
        this.context=context;

    }

    ArrayList<ModalClass>objModelClassArrayList;

    @NonNull
    @Override
    public DatabaseViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleRow= LayoutInflater.from(parent.getContext()).inflate(R.layout.sinle_row,parent,false);
        return  new DatabaseViewHolders(singleRow);

    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseViewHolders holder, int position) {
        ModalClass objModalClass=objModelClassArrayList.get(position);
        holder.id.setText(Integer.toString(objModalClass.getID()));
        holder.firstname.setText(objModalClass.getFirstname());
        holder.lastname.setText(objModalClass.getLastname());



    }

    @Override
    public int getItemCount() {
        return objModelClassArrayList.size();

    }

    public  class DatabaseViewHolders extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        TextView id,firstname,lastname;

        @Override
        public boolean onLongClick(View v) {
            return false;
        }

        public DatabaseViewHolders(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.idTv);
            firstname=itemView.findViewById(R.id.firstnameTv);
            lastname=itemView.findViewById(R.id.lastnameTv);




            itemView.setOnClickListener(this);
                  }

        @Override
        public void onClick(View v) {

            Intent intn=new Intent(context, DetailActivity.class);
            intn.putExtra("my app", (Serializable) objModelClassArrayList.get(getAdapterPosition()));
            intn.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intn);


        }
    }
}
