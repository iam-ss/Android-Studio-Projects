package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("un","one",R.drawable.number_one));
        words.add(new Word("deux","two",R.drawable.number_two));
        words.add(new Word("Trois","three",R.drawable.number_three));
        words.add(new Word("quatre","four",R.drawable.number_four));
        words.add(new Word("cinq","five",R.drawable.number_five));
        words.add(new Word("six","six",R.drawable.number_six));
        words.add(new Word("Sept","seven",R.drawable.number_seven));
        words.add(new Word("huit","eight",R.drawable.number_eight));
        words.add(new Word("neuf","nine",R.drawable.number_nine));
        words.add(new Word("Dix","ten",R.drawable.number_ten));

        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_numbers);
        ListView lv = (ListView) findViewById(R.id.word_list);
        lv.setAdapter(wordAdapter);
    }
}
