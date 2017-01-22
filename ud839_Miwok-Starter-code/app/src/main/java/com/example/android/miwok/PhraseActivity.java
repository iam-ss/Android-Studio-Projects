package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> phrases = new ArrayList<>();
        phrases.add(new Word("Où allez-vous?", "Where are you going?", R.raw.phrase_where_are_you_going));
        phrases.add(new Word("Comment vous appelez-vous?", "What is your name?", R.raw.phrase_what_is_your_name));
        phrases.add(new Word("Mon nom est...", "My name is...", R.raw.phrase_my_name_is));
        phrases.add(new Word("Comment allez-vous?", "How are you feeling?", R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("Je me sens bien.", "I’m feeling good.", R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Viens-tu?", "Are you coming? ", R.raw.phrase_are_you_coming));
        phrases.add(new Word("Oui j'arrive", "Yes, I’m coming", R.raw.phrase_yes_im_coming));
        phrases.add(new Word("J'arrive.", "I’m coming.", R.raw.phrase_im_coming));
        phrases.add(new Word("Allons-y.", "Let’s go. ", R.raw.phrase_lets_go));
        phrases.add(new Word("Venez ici.", "Come here. ", R.raw.phrase_come_here));

        WordAdapter wordAdapter = new WordAdapter(this,phrases,R.color.category_phrases);
        ListView lv = (ListView) findViewById(R.id.word_list);
        lv.setAdapter(wordAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MediaPlayer mp = MediaPlayer.create(PhraseActivity.this, phrases.get(i).getAudioResourceId());
                mp.start();
            }
        });
    }
}
