package com.example.android.outingtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        final ArrayList<Information> rests = new ArrayList<>();

        rests.add(new Information("Caraway The Grand","The Grand, Phase II, Nelson Mandela Road, Vasant Kunj, Pocket 4, Sector C, Vasant Kunj, Delhi NCR 110070","7PM–12AM","Delhi Aerocity Metro Station",R.drawable.carawaythegrand,R.raw.dlfsaket,3));
        rests.add(new Information("Gol Chakkar","Gol Chakkar, Bada Bazar Rd, Old Rajinder Nagar, Rajinder Nagar, New Delhi 110060","11AM–Midnight","Malviya Nagar Metro Station",R.drawable.golchakkar,R.raw.dlfsaket,3));
        rests.add(new Information("Indian Accent","The Manor Hotel, 77, Friends colony West, New Delhi, 110065","12–2:30PM \n 7–11:30PM","Rajiv Chowk",R.drawable.indian_accent,R.raw.dlfsaket,3));
        rests.add(new Information("On the WaterFront","The Lodhi Hotel, Lodhi Road, New Delhi, 110003","12:30 PM-3:50 PM \n 7 PM-11:30 PM","JLN Stadium Metro Station",R.drawable.onthewaterfront,R.raw.dlfsaket,3));
        rests.add(new Information("Lady Baga","P, 3/90, Baba Kharak Singh Marg, Block I, Connaught Place, New Delhi, Delhi 110001","12 Noon to 12:30 AM","Rajiv Chowk",R.drawable.ladybaga,R.raw.dlfsaket,3));

        InformationAdapter ia = new InformationAdapter(RestaurantActivity.this,rests);
        ListView lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(ia);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("Info",rests.get(position));
                intent.putExtras(b);
                intent.setClass(view.getContext(),DetailedInfo.class);
                startActivity(intent);
            }
        });

    }
}
