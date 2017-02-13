package com.example.android.outingtime;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by singham on 1/2/17.
 */

public class Information implements Parcelable {
    String mName;
    String mAddress;
    String mTimings;
    String mMetro;
    int mColorId; // 1=mall, 2=couple 3=restaurants 4=colleges
    int mAudioId;
    int mImageResourceId;
     Information(String name,String add,String timings,String metro, int image_id,int audio_id,int parent){
        mName = name;
        mAddress = add;
        mTimings = timings;
        mMetro = metro;
        mImageResourceId = image_id;
        mAudioId = audio_id;
        mColorId = parent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mAddress);
        dest.writeString(mTimings);
        dest.writeString(mMetro);
        dest.writeInt(mImageResourceId);
        dest.writeInt(mAudioId);
        dest.writeInt(mColorId);
    }
    public static final Parcelable.Creator<Information> CREATOR
            = new Parcelable.Creator<Information>() {
        public Information createFromParcel(Parcel in) {
            return new Information(in);
        }

        public Information[] newArray(int size) {
            return new Information[size];
        }
    };

    private Information(Parcel in) {
        mName = in.readString();
        mAddress = in.readString();
        mTimings = in.readString();
        mMetro = in.readString();
        mImageResourceId = in.readInt();
        mAudioId = in.readInt();
        mColorId = in.readInt();
    }

}
