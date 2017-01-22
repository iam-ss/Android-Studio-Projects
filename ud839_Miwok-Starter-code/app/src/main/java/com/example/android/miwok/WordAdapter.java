package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by singham on 17/1/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorId;
    private int mAudioResourceId;


    public WordAdapter(Activity context, ArrayList<Word> words,int colorId) {
        super(context, 0, words);
        this.mColorId=colorId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;


        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word word = getItem(position);
        TextView miwokNumberView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokNumberView.setText(word.getMiwok_Number());

        TextView defaultNumberView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultNumberView.setText(word.getDefault_Number());

        LinearLayout ll = (LinearLayout) listItemView.findViewById(R.id.list_item);
        ll.setBackgroundColor(ContextCompat.getColor(getContext(),mColorId));

        ImageView miwokImage = (ImageView) listItemView.findViewById(R.id.image);
        if (word.hasImage()) miwokImage.setImageResource(word.getResourceId());
        else miwokImage.setVisibility(View.GONE);


        return listItemView;
    }
}
