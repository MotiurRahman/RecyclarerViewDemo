package com.bd.recyclarerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static ArrayList<PersonData> peopleDataSet;
    private Context context;

    public MyAdapter(ArrayList<PersonData> people, Context context) {

        this.peopleDataSet = people;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        final MyViewHolder holder = new MyViewHolder(view);

        view.setOnClickListener(MainActivity.myOnclickListner);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        final PersonData peopleData = peopleDataSet.get(position);
        ImageView imageView = holder.imageView;
        TextView textViewName = holder.textViewName;
        TextView textViewEmail = holder.textViewEmail;

        imageView.setImageResource(peopleData.getImg());
        textViewName.setText(peopleData.getName());
        textViewEmail.setText(peopleData.getEmail());

//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(v.getContext(),Waz.class);
////                intent.putExtra("name",listItem.getHead());
////                v.getContext().startActivity(intent);
//
//                Toast.makeText(context, peopleData.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return peopleDataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewName;
        TextView textViewEmail;
        public LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewEmail = (TextView) itemView.findViewById(R.id.textViewEmail);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.card_View);

        }
    }
}
