package net.paulacr.starwars.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Paula on 01/11/2015.
 */
public class PeopleModel implements Parcelable{

    private String name;
    private String homeworld;
    private String gender;
    private Integer icon;

    public PeopleModel(String name, String homeworld, String gender, Integer icon) {
        this.name = name;
        this.homeworld = homeworld;
        this.gender = gender;
        this.icon = icon;
    }

    protected PeopleModel(Parcel in) {
        name = in.readString();
        homeworld = in.readString();
        gender = in.readString();
    }

    public static final Creator<PeopleModel> CREATOR = new Creator<PeopleModel>() {
        @Override
        public PeopleModel createFromParcel(Parcel in) {
            return new PeopleModel(in);
        }

        @Override
        public PeopleModel[] newArray(int size) {
            return new PeopleModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeString(homeworld);
        parcel.writeString(gender);
    }
}
