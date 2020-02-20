package com.rizafaizal.aplikasidaftarfilmuiux.recyclerview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rizafaizal.aplikasidaftarfilmuiux.R;
import com.rizafaizal.aplikasidaftarfilmuiux.recyclerview.Model.Films;

import java.util.ArrayList;

public class GridFilmAdapter extends RecyclerView.Adapter<GridFilmAdapter.GridViewHolder> {
    private ArrayList<Films> listFilms;

    public GridFilmAdapter(ArrayList<Films> listFilms) {
        this.listFilms = listFilms;
    }

    //::::::OnItemClick
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_films, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listFilms.get(position).getPhoto())
                .apply(new RequestOptions().override(450, 550))
                .into(holder.imgPhoto);
        //Item onClick
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listFilms.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFilms.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo_grid);
        }
    }

    //Interface OnItemClick
    public interface OnItemClickCallback {
        void onItemClicked(Films data);
    }
}
