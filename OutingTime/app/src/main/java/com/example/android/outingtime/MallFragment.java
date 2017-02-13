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
public class MallFragment extends Fragment {


    public MallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view,container,false);

        final ArrayList<Information> malls=new ArrayList<>();

        malls.add(new Information("Select CityWalk","A-3 District Centre,\n Saket, New Delhi, \n Delhi 110017","10:30AM – 11PM","Malviya Nagar Metro Station",R.drawable.select_citywalk,R.raw.select,1));
        malls.add(new Information("DLF Emporio","4, Nelson Mandela Road, \nVasant Kunj, New Delhi, \nDelhi 110070","11AM – 9PM","Chhatarpur Metro Station",R.drawable.dlfemporio,R.raw.dlfemporio,1));
        malls.add(new Information("DLF Promenade","3, Nelson Mandela Marg, \nVasant Kunj Malls, New Delhi, \nDelhi 110070","10AM – 9:30PM","Chhatarpur Metro Station",R.drawable.dlf_promenade_mall,R.raw.dlfpromenade,1));
        malls.add(new Information("Pacific Mall","Tagore Garden, Najafgarh Road,New Delhi,\nDelhi 110018","11AM – 9PM","Subhash Nagar Metro Station",R.drawable.pacific_mall,R.raw.pacificmall,1));
        malls.add(new Information("DLF Place Saket","A 4, District Center, \nPress Enclave Road, \nSaket, New Delhi, \nDelhi 110017","10AM – 11PM","Malviya Nagar Metro Station",R.drawable.dlfpace_saket,R.raw.dlfsaket,1));

        InformationAdapter inAdapter = new InformationAdapter(getActivity(),malls);
        ListView lv = (ListView) rootView.findViewById(R.id.list_view);
        lv.setAdapter(inAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("Info",malls.get(position));
                intent.putExtras(b);
                intent.setClass(view.getContext(),DetailedInfo.class);
                startActivity(intent);
            }
        });


        return rootView;
    }

}