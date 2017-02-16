package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by singham on 14/2/17.
 */

public class CategoryAdapter extends ArrayAdapter {

    Context mContext;

    public CategoryAdapter(Context context, ArrayList<Earthquake> earthquake_info) {
        super(context, 0, earthquake_info);
    }

    private int getMagnitudeColor(double mag){
        if(mag<2.0)return R.color.magnitude1;
        else if(mag<3.0)return R.color.magnitude2;
        else if(mag<4.0)return R.color.magnitude3;
        else if(mag<5.0)return R.color.magnitude4;
        else if(mag<6.0)return R.color.magnitude5;
        else if(mag<7.0)return R.color.magnitude6;
        else if(mag<8.0)return R.color.magnitude7;
        else if(mag<9.0)return R.color.magnitude8;
        else if(mag<10.0)return R.color.magnitude9;
        else return R.color.magnitude10plus;
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


        double mag = info.getmMag();
        DecimalFormat df = new DecimalFormat("0.0");
        tv.setText(df.format(mag));

        GradientDrawable magnitudeCircle = (GradientDrawable) tv.getBackground();
        int magnitudeColor = getMagnitudeColor(mag);
        magnitudeCircle.setColor(ContextCompat.getColor(getContext(),magnitudeColor));

        if(info.getmCity().contains("of")){
            String[] completeLocation = info.getmCity().split("(?<=of )");

            tv = (TextView) listItemView.findViewById(R.id.nearBy);
            tv.setText(completeLocation[0]);

            tv = (TextView) listItemView.findViewById(R.id.cityView);
            tv.setText(completeLocation[1]);
        }
        else{
            tv = (TextView) listItemView.findViewById(R.id.nearBy);
            tv.setText("Near The");

            tv = (TextView) listItemView.findViewById(R.id.cityView);
            tv.setText(info.getmCity());

        }


        String[] timeAndDate = String.valueOf(info.getmDate()).split("\n");

        tv = (TextView) listItemView.findViewById(R.id.dateView);
        tv.setText(timeAndDate[0]);

        tv = (TextView) listItemView.findViewById(R.id.time);
        tv.setText(timeAndDate[1]);

        return listItemView;
    }
}
