package com.example.android.outingtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class collegeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        final ArrayList<Information> couples = new ArrayList<>();

        couples.add(new Information("Sri Ram College of Commerce","Maurice Nagar, Near University Of Delhi, New Delhi, Delhi 110007","8:30AM-1:30PM","Vishwavidyalaya Metro Station",R.drawable.srcc,R.raw.dlfsaket,4));
        couples.add(new Information("Hindu College","University of Delhi, University Enclave, Delhi, 110007","Visit  Anytime"," Vishwavidyalaya Metro Station ",R.drawable.hindu,R.raw.dlfsaket,4));
        couples.add(new Information("Lady Sri Ram College for Women","Lala Lajpat Rai Rd, Amar Colony, Lajpat Nagar 4, New Delhi, Delhi 110024 ","Visit  Anytime","Moolchand Metro Station",R.drawable.lsr,R.raw.dlfsaket,4));
        couples.add(new Information("Amity University","Sector-125, Noida, Uttar Pradesh 201313"," 9 AM to 11 PM","Botanical Garden Metro Station",R.drawable.amity,R.raw.dlfsaket,4));
        couples.add(new Information("National Institute of Fashion Technology","Nift Campus, Main Road, Hauz Khas, New Delhi, Delhi 110016","12:00PM-12:30AM ","Hauz Khas Metro Station",R.drawable.nift,R.raw.dlfsaket,4));
        couples.add(new Information("IIT-DELHI","Hauz Khas, New Delhi, Delhi 110016","Visit Anytime","Hauz Khas Metro Station",R.drawable.iit,R.raw.dlfsaket,4));
        couples.add(new Information("Kirori Mal","University of Delhi, North Campus, Delhi, 110007","8:30AM-1:30PM","Vishwavidyalaya Metro Station",R.drawable.kirorimalcollege,R.raw.dlfsaket,4));

        InformationAdapter ia = new InformationAdapter(collegeActivity.this,couples);
        ListView lv = (ListView) findViewById(R.id.list_view);
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
    }
}
