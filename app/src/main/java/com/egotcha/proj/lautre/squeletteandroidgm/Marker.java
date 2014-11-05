package com.egotcha.proj.lautre.squeletteandroidgm;


import android.os.Parcel;
import android.os.Parcelable;

public class Marker implements Parcelable{
    public static final Parcelable.Creator<Marker> CREATOR=new Parcelable.Creator<Marker>(){


        @Override
        public Marker createFromParcel(Parcel parcel) {
            return new Marker(parcel);
        }

        @Override
        public Marker[] newArray(int i) {
            return new Marker[i];
        }

    };

    public Marker(Parcel source){
        id=source.readInt();
        titre= source.readString();
        lat= source.readDouble();
        lng= source.readDouble();
    }

    private int id;
    private String titre;
    private double lat;
    private double lng;

    public Marker(){

    }

    public Marker (String titre, int lat, int lng) {
        super();
        this.titre = titre;
        this.lat = lat;
        this.lng = lng;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getTitre() { return titre;}
    public void setTitre(String titre) {this.titre = titre;}

    public double getLat() {return lat;}
    public void setLat(double lat) {this.lat = lat;}

    public double getLng() {return lng;}
    public void setLng(double lng) {this.lng = lng; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titre);
        parcel.writeDouble(lat);
        parcel.writeDouble(lng);
        parcel.writeInt(id);

    }
}
