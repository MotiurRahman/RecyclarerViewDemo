package com.bd.recyclarerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static View.OnClickListener myOnclickListner;
    RecyclerView myrecyclerVeiw;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<PersonData> people;
    private static  RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myrecyclerVeiw = findViewById(R.id.myrecyclerVeiw);
        myrecyclerVeiw.setHasFixedSize(true);

        myOnclickListner = new MyonclickListner(this);

        layoutManager = new LinearLayoutManager(this);
        myrecyclerVeiw.setLayoutManager(layoutManager);
        myrecyclerVeiw.setItemAnimator(new DefaultItemAnimator());
        people = new ArrayList<PersonData>();

        for (int i = 0; i < MyData.nameArray.length; i++) {
            people.add(new PersonData(MyData.nameArray[i], MyData.emailArray[i], MyData.imageArray[i], MyData.id_[i]));
        }
        adapter = new MyAdapter(people,getApplicationContext());
        myrecyclerVeiw.setAdapter(adapter);
    }

    public class MyonclickListner implements View.OnClickListener {
        public final Context context;

        public MyonclickListner(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            int selectedItemPosition = myrecyclerVeiw.getChildAdapterPosition(view);
            RecyclerView.ViewHolder viewHolder = myrecyclerVeiw.findViewHolderForAdapterPosition(selectedItemPosition);
            TextView textViewName = (TextView)viewHolder.itemView.findViewById(R.id.textViewName);
            TextView textViewEmail = (TextView)viewHolder.itemView.findViewById(R.id.textViewEmail);
            ImageView img = (ImageView)viewHolder.itemView.findViewById(R.id.imageView);
            String selectName = (String) textViewName.getText();
            String selectEmail = (String) textViewEmail.getText();

            Toast.makeText(context, selectName, Toast.LENGTH_SHORT).show();
            Toast.makeText(context, selectEmail, Toast.LENGTH_SHORT).show();
        }
    }

}