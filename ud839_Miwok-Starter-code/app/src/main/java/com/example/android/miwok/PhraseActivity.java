package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> phrases = new ArrayList<>();
        phrases.add(new Word("Où allez-vous?","Where are you going?"));
        phrases.add(new Word("Comment vous appelez-vous?","What is your name?"));
        phrases.add(new Word("Mon nom est...","My name is..."));
        phrases.add(new Word("Comment allez-vous?","How are you feeling?"));
        phrases.add(new Word("Je me sens bien.","I’m feeling good."));
        phrases.add(new Word("Viens-tu?","Are you coming? "));
        phrases.add(new Word("Oui j'arrive","Yes, I’m coming"));
        phrases.add(new Word("J'arrive.","I’m coming."));
        phrases.add(new Word("Allons-y.","Let’s go. "));
        phrases.add(new Word("Venez ici.","Come here. "));

        WordAdapter wordAdapter = new WordAdapter(this,phrases,R.color.category_phrases);
        ListView lv = (ListView) findViewById(R.id.word_list);
        lv.setAdapter(wordAdapter);
    }
}
