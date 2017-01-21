/**
 * Created by singham on 17/1/17.
 */

package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private static final int IMAGE_NOT_VISIBLE = -1;
    private int mImageResourceId;

    public Word(String miwok_Number, String default_Number) {
        this.mDefaultTranslation = default_Number;
        this.mMiwokTranslation = miwok_Number;
        this.mImageResourceId = IMAGE_NOT_VISIBLE;
    }

    public Word(String miwok_Number, String default_Number, int mImageResourceId) {
        this.mDefaultTranslation = default_Number;
        this.mMiwokTranslation = miwok_Number;
        this.mImageResourceId = mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != IMAGE_NOT_VISIBLE;
    }

    public String getMiwok_Number() {
        return mMiwokTranslation;
    }

    public String getDefault_Number() {
        return mDefaultTranslation;
    }

    public int getResourceId() {
        return mImageResourceId;
    }

}
