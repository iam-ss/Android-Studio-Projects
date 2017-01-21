/**
 * Created by singham on 17/1/17.
 */

package com.example.android.miwok;

public class Word {
    private static final int IMAGE_NOT_VISIBLE = -1;
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;
    private int mAudioClipId;

    public Word(String miwok_Number, String default_Number, int audioClipId) {
        this.mDefaultTranslation = default_Number;
        this.mMiwokTranslation = miwok_Number;
        this.mImageResourceId = IMAGE_NOT_VISIBLE;
        this.mAudioClipId = audioClipId;

    }

    public Word(String miwok_Number, String default_Number, int mImageResourceId, int audioClipId) {
        this.mDefaultTranslation = default_Number;
        this.mMiwokTranslation = miwok_Number;
        this.mImageResourceId = mImageResourceId;
        this.mAudioClipId = audioClipId;
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

    public int getAudioResourceId() {
        return mImageResourceId;
    }

}
