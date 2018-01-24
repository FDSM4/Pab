package com.example.itachi.com.pab;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ITACHI on 21-01-2018.
 */
public class ListViewAdaptor extends RecyclerView.Adapter <ListViewAdaptor.MyViewHolder>{
    private LayoutInflater inflater;

    /////GET THE DATA INTO AN ARRAYLIST//////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ArrayList<Data> info;




    public ListViewAdaptor(Context context, ArrayList<Data> info){
        inflater = LayoutInflater.from(context);
        this.info = info;
       // Log.v("test",info.get(2).getName());

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;



    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //holder.text.setText("ITACHI");

        holder.text.setText(info.get(position).getId());
        holder.text2.setText(info.get(position).getName());
        holder.img.setImageResource(R.drawable.itachi);

    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView text,text2;
        ImageView img;
        private final Context context;

        public MyViewHolder(View itemView)   {
            super(itemView);
            context = itemView.getContext();
            CardView card = (CardView) itemView.findViewById(R.id.card);
            text = (TextView) itemView.findViewById(R.id.itemtext1);
            text2 = (TextView) itemView.findViewById(R.id.itemtext2);
            img = (ImageView) itemView.findViewById(R.id.itemimage);
            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           Intent intent = new Intent( context,ItemDiscription.class);
           context.startActivity(intent);
        }
    }
}
