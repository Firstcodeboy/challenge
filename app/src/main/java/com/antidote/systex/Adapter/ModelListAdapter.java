package com.antidote.systex.Adapter;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.antidote.systex.Model.Model;
import com.antidote.systex.R;
import com.antidote.systex.RecycleViewOnClick.RecycleViewInterface;
import com.squareup.picasso.Picasso;

public class ModelListAdapter extends RecyclerView.Adapter<ModelListAdapter.MyViewHolder> {

    private final RecycleViewInterface recycleViewInterface;

    Context context;
    Model model;

    public ModelListAdapter(Context context, Model model, RecycleViewInterface recycleViewInterface) {
        this.context = context;
        this.model = model;
        this.recycleViewInterface = recycleViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycleview, viewGroup, false);
        return new MyViewHolder(view, recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imgView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.slide));
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.slide));
        Picasso.get().load(model.getDataList().get(position).getDefaultUrl()).into(holder.imgView);
        holder.txtTitle.setText(model.getDataList().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return model.getDataList().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgView;
        TextView txtTitle;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            cardView = itemView.findViewById(R.id.cardviewDisplay);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posotion = getAdapterPosition();
                    recycleViewInterface.OnClick(posotion);
                }
            });
        }
    }
}
