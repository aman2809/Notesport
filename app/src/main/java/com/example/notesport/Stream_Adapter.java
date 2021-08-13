package com.example.notesport;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Stream_Adapter extends FirebaseRecyclerAdapter<StreamDataModel,Stream_Adapter.StreamViewHolder>
{
    public Stream_Adapter(@NonNull FirebaseRecyclerOptions<StreamDataModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Stream_Adapter.StreamViewHolder holder, int position, @NonNull StreamDataModel model)
    {
        holder.t1.setText(model.getStream_Name());
        holder.t2.setText(model.getStream_Description());
        Glide.with(holder.image.getContext()).load(model.getStream_Icon()).into(holder.image);

        holder.image.setOnClickListener(v -> {
            Intent intent = new Intent(holder.image.getContext(),Stream_Main_Activity.class);
            intent.putExtra("Stream_Name",model.getStream_Name());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            holder.image.getContext().startActivity(intent);
        });
    }
    @NonNull
    @Override
    public StreamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stream_card_design,parent,false);
        return new StreamViewHolder(view);
    }
    class StreamViewHolder extends RecyclerView.ViewHolder
    {
        ImageView  image;
        TextView t1,t2;
        public StreamViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
        }
    }
}
