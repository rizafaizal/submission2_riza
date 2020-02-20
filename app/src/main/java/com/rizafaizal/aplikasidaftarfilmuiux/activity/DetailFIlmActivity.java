package com.rizafaizal.aplikasidaftarfilmuiux.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rizafaizal.aplikasidaftarfilmuiux.R;
import com.rizafaizal.aplikasidaftarfilmuiux.recyclerview.Model.Films;

public class DetailFIlmActivity extends AppCompatActivity {
    ImageView imgFilm;
    TextView txtJudulFilm, txtGenreFilm, txtScoreFilm, txtDescFilm;

    public static final String EXTRA_FILMS= "extra_films";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        imgFilm = findViewById(R.id.img_photo_detail);
        txtJudulFilm = findViewById(R.id.txt_judul_detail);
        txtGenreFilm = findViewById(R.id.txt_genre_detail);
        txtScoreFilm = findViewById(R.id.txt_score_detail);
        txtDescFilm = findViewById(R.id.txt_desc_detail);

        Films films = getIntent().getParcelableExtra(EXTRA_FILMS);
        txtJudulFilm.setText(films.getJudul());
        txtGenreFilm.setText(films.getGenre());
        txtScoreFilm.setText(films.getScore());
        txtDescFilm.setText(films.getDesc());
        Glide.with(this)
                .load(films.getPhoto())
                .apply(new RequestOptions().override(950, 900))
                .into(imgFilm);

        //Nama Bar
        ActionBar ab = getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.bar_detail_film));
        ab.setSubtitle(films.getJudul());

    }
}
