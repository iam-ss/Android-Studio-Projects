package com.example.android.outingtime;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CouplesFragment extends Fragment {


    public CouplesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view,container,false);
        final ArrayList<Information> couples = new ArrayList<>();

        couples.add(new Information("Garden of Five Senses","Near Saket Metro Station, Mehrauli-Badarpur Road, Said Ul Ajaib, New Delhi, Delhi 110030","9AM–6PM","Saket Metro Station ",R.drawable.garden,R.raw.dlfsaket,2));
        couples.add(new Information("Parthsarathy Rocks, JNU","New Mehrauli Road, Munirka, New Delhi, Delhi 110067","Visit  Anytime","Hauz Khas Metro Station",R.drawable.parth,R.raw.dlfsaket,2));
        couples.add(new Information("The Fort: Hauz Khas Village ","Hauz Khas Entrance\n Hauz Khas\n Delhi, \n Pincode: 110029 ","5:00AM-8:00PM","Hauz Khas Metro Sttion",R.drawable.fort,R.raw.dlfsaket,2));
        couples.add(new Information("Paranthewali Gali","1984-1985, Gali Paranthe Wali, Chandni Chowk, New Delhi"," 9 AM to 11 PM","Chandni Chowk Metro Station",R.drawable.parantha,R.raw.dlfsaket,2));
        couples.add(new Information("Ice Lounge","1st Floor, MGF -Metropolitan Mall, Saket, New Delhi","12:00PM-12:30AM ","Saket Metro Station",R.drawable.ice,R.raw.dlfsaket,2));
        couples.add(new Information("Ridge Road","Ridge Road, Central Ridge Reserve Forest, Delhi","Anytime","Vishwavidyalaya",R.drawable.ridge,R.raw.dlfsaket,2));
        couples.add(new Information("Mehrauli Archaeological Park","Opposite Qutub Minar Metro Station, Anuvrat Marg, Mehrauli, New Delhi, Delhi 110030","10AM–6:30PM","Qutub Minar Metro Station",R.drawable.archaelogical,R.raw.dlfsaket,2));

        InformationAdapter ia = new InformationAdapter(getActivity(),couples);
        ListView lv = (ListView) rootView.findViewById(R.id.list_view);
        lv.setAdapter(ia);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("Info",couples.get(position));
                intent.putExtras(b);
                intent.setClass(view.getContext(),DetailedInfo.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

}