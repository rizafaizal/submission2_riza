package com.rizafaizal.aplikasidaftarfilmuiux.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rizafaizal.aplikasidaftarfilmuiux.R;
import com.rizafaizal.aplikasidaftarfilmuiux.activity.DetailFIlmActivity;
import com.rizafaizal.aplikasidaftarfilmuiux.recyclerview.Adapter.CardviewFilmAdapter;
import com.rizafaizal.aplikasidaftarfilmuiux.recyclerview.Model.Films;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    //ArrayList
    private RecyclerView rcFilms;
    private ArrayList<Films> list = new ArrayList<>();

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcFilms = view.findViewById(R.id.rc_films);
        rcFilms.setHasFixedSize(true);

        list.addAll(getListFilm());
        showRecyclerCardView();
    }

    public ArrayList<Films> getListFilm() {
        String[] dataJudul = getResources().getStringArray(R.array.data_judul_movies);
        String[] dataGenre = getResources().getStringArray(R.array.data_genre_movies);
        String[] dataScore = getResources().getStringArray(R.array.data_score_movies);
        String[] dataDesc = getResources().getStringArray(R.array.data_desc_movies);
        String[] dataPhoto = getResources().getStringArray(R.array.data_photo_movies);

        ArrayList<Films> listFilm = new ArrayList<>();
        for (int i = 0; i < dataJudul.length; i++) {
            Films films = new Films();
            films.setJudul(dataJudul[i]);
            films.setGenre(dataGenre[i]);
            films.setScore(dataScore[i]);
            films.setDesc(dataDesc[i]);
            films.setPhoto(dataPhoto[i]);

            listFilm.add(films);
        }
        return listFilm;
    }

    private void showRecyclerCardView() {
        rcFilms.setLayoutManager(new LinearLayoutManager(getContext()));
        CardviewFilmAdapter cardviewFilmAdapter = new CardviewFilmAdapter(list);
        rcFilms.setAdapter(cardviewFilmAdapter);

        //ItemClick
        cardviewFilmAdapter.setOnItemClickCallback(new CardviewFilmAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Films data) {
                showSelectedHero(data);
            }
        });
    }

    private void showSelectedHero(Films films) {
        Toast.makeText(getContext(), getResources().getString(R.string.kamu_pilih) + films.getJudul(), Toast.LENGTH_SHORT).show();

        Intent moveToDetail = new Intent(getContext(), DetailFIlmActivity.class);
        moveToDetail.putExtra(DetailFIlmActivity.EXTRA_FILMS, films);
        startActivity(moveToDetail);
    }
}
