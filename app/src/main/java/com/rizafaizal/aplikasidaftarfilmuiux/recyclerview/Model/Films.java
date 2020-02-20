package com.rizafaizal.aplikasidaftarfilmuiux.recyclerview.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Films implements Parcelable {


    private String judul;
    private String genre;
    private String score;
    private String desc;
    private String photo;
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.judul);
        parcel.writeString(this.genre);
        parcel.writeString(this.score);
        parcel.writeString(this.desc);
        parcel.writeString(this.photo);
    }

    public Films() {

    }

    protected Films(Parcel in) {
        this.judul = in.readString();
        this.genre = in.readString();
        this.score = in.readString();
        this.desc = in.readString();
        this.photo = in.readString();
    }

    public static final Creator<Films> CREATOR = new Creator<Films>() {
        @Override
        public Films createFromParcel(Parcel source) {
            return new Films(source);
        }

        @Override
        public Films[] newArray(int size) {
            return new Films[size];
        }
    };

}
