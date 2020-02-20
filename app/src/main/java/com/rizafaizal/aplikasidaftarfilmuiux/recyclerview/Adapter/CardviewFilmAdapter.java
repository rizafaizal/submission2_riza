package com.rizafaizal.aplikasidaftarfilmuiux.recyclerview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rizafaizal.aplikasidaftarfilmuiux.R;
import com.rizafaizal.aplikasidaftarfilmuiux.recyclerview.Model.Films;

import java.util.ArrayList;

public class CardviewFilmAdapter extends RecyclerView.Adapter<CardviewFilmAdapter.CardviewViewHolder> {
    private ArrayList<Films> listFilms;

    public CardviewFilmAdapter(ArrayList<Films> listFilms) {
        this.listFilms = listFilms;
    }

    //::::::OnItemClick
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public CardviewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_film, viewGroup, false);
        return new CardviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardviewViewHolder holder, int position) {
        Films films = listFilms.get(position);

        Glide.with(holder.itemView.getContext())
                .load(films.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.txtJudul.setText(films.getJudul());
        holder.txtGenre.setText(films.getGenre());
        holder.txtScore.setText(films.getScore());
        holder.txtDesc.setText(films.getDesc());

        //Event onClick
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

    public class CardviewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView txtJudul, txtGenre, txtScore, txtDesc;

        public CardviewViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_photo);
            txtJudul = itemView.findViewById(R.id.txt_judul);
            txtGenre = itemView.findViewById(R.id.txt_genre);
            txtScore = itemView.findViewById(R.id.txt_score);
            txtDesc = itemView.findViewById(R.id.txt_desc);
        }
    }

    //Interface OnItemClick
    public interface OnItemClickCallback {
        void onItemClicked(Films data);
    }
}
