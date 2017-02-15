package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by singham on 14/2/17.
 */

public class CategoryAdapter extends ArrayAdapter {

    Context mContext;

    public CategoryAdapter(Context context, ArrayList<Earthquake> earthquake_info) {
        super(context, 0, earthquake_info);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(convertView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false
            );
        }

        Earthquake info =(Earthquake) getItem(position);
        TextView tv= (TextView) listItemView.findViewById(R.id.magView);
        tv.setText(String.valueOf(info.getmMag()));

        tv = (TextView) listItemView.findViewById(R.id.cityView);
        tv.setText(info.getmCity());

        tv = (TextView) listItemView.findViewById(R.id.dateView);
        tv.setText(String.valueOf(info.getmDate()));

        return listItemView;
    }
}
