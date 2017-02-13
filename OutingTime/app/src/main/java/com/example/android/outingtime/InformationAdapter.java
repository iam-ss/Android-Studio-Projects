package com.example.android.outingtime;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by singham on 1/2/17.
 */

public class InformationAdapter extends ArrayAdapter {


    public InformationAdapter(Activity context, ArrayList<Information> info){
        super(context,0,info);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView =  convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false);
        }

        Information info = (Information) getItem(position);
        ImageView iv = (ImageView) listItemView.findViewById(R.id.item_image);
        iv.setImageResource(info.mImageResourceId);

        TextView tv = (TextView) listItemView.findViewById(R.id.image_text);
        tv.setText(info.mName);
        return listItemView;
    }
}
