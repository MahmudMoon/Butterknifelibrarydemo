package com.example.moon.butterknifelibrarydemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Custom_Adapter extends RecyclerView.Adapter<Custom_Adapter.MyViewHolder>  {
    ArrayList<String> arrayList;
    Context context;
    private static final String TAG = "Custom_Adapter";
    
    public Custom_Adapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        Log.i(TAG, "Custom_Adapter: constructor");
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, viewGroup,false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(arrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.name)
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.name);
            Log.i(TAG, "MyViewHolder: ");
            ButterKnife.bind(this,itemView);

        }
    }
}
