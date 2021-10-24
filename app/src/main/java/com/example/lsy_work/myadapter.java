package com.example.lsy_work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class myadapter extends RecyclerView.Adapter<myadapter.MyViewholder> {

    private View itemView;
    private List<Map<String,Object>> data;
    private Context context;
    public myadapter myadapter;
    Intent intent;

    public myadapter(List<Map<String, Object>> data, Context context){
        this.context=context;
        this.data=data;
    }
    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        itemView= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        MyViewholder myViewholder=new MyViewholder(itemView);
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView1.setText(data.get(position).get("姓名").toString());
        holder.textView2.setText(data.get(position).get("地址").toString());
        holder.textView3.setText(data.get(position).get("联系方式").toString());
        holder.imageView.setImageResource(Integer.parseInt(data.get(position).get("图片").toString()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= holder.getAdapterPosition();
                switch(position){
                    case 0:
                        Intent intent=new Intent();
                        intent.setClass(context,news1.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent();
                        intent1.setClass(context,news2.class);
                        context.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent();
                        intent2.setClass(context,news3.class);
                        context.startActivity(intent2);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder{
        TextView textView1,textView2,textView3;
        ImageView imageView;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);
            imageView=itemView.findViewById(R.id.imageView5);
        }
    }
}
