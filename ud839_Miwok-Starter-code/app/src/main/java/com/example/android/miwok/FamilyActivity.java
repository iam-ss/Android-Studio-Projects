package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> family = new ArrayList<>();
        family.add(new Word("père", "father", R.drawable.family_father, R.raw.family_father));
        family.add(new Word("mère", "mother", R.drawable.family_mother, R.raw.family_mother));
        family.add(new Word("fils", "son", R.drawable.family_son, R.raw.family_son));
        family.add(new Word("fille", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        family.add(new Word("grand frère", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        family.add(new Word("frère cadet", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        family.add(new Word("grande sœur", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        family.add(new Word("sœur cadette", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        family.add(new Word("grand-mère", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        family.add(new Word("grand-père", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(this,family,R.color.category_family);
        ListView lv = (ListView) findViewById(R.id.word_list);
        lv.setAdapter(wordAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MediaPlayer mp = MediaPlayer.create(FamilyActivity.this, family.get(i).getAudioResourceId());
                mp.start();
            }
        });
    }
}
