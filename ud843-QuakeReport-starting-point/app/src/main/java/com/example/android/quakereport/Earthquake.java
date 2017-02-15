package com.example.android.quakereport;

/**
 * Created by singham on 14/2/17.
 */

public class Earthquake {
    private double mMag;
    private String mCity;
    private String mDate;

    public Earthquake(double mag, String city, String date){
        mMag = mag;
        mCity = city;
        mDate = date;
    }

    public double getmMag(){
        return mMag;
    }

    public String getmCity(){
        return  mCity;
    }

    public String getmDate(){
        return mDate;
    }


}
