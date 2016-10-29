package com.example.fulviocosco.sunshine.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by fulviocosco on 25/10/2016.
 */

public class MyUser implements Parcelable{

    private String userName;
    private String password;

    MyUser(String u, String p){
        userName = u;
        password = p;
    }

    private MyUser(Parcel p){
        userName = p.readString();
        password = p.readString();
    }

    // Getters
    String getUserName(){ return userName; }
    String getPassword(){ return password; }

    // Setters
    void setUserName(String u){ userName = u; }
    void setPassword(String p){ password = p; }


    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(password);
    }

    public static final Parcelable.Creator<MyUser> CREATOR = new Parcelable.Creator<MyUser>() {

        @Override
        public MyUser createFromParcel(Parcel source) {
            return new MyUser(source);
        }

        @Override
        public MyUser[] newArray(int size) {
            return new MyUser[0];
        }
    };

}
