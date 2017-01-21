package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("rouge","red",R.drawable.color_red));
        colors.add(new Word("vert","green",R.drawable.color_green));
        colors.add(new Word("marron","brown",R.drawable.color_brown));
        colors.add(new Word("gris","gray",R.drawable.color_gray));
        colors.add(new Word("noir","black",R.drawable.color_black));
        colors.add(new Word("blanc","white",R.drawable.color_white));
        colors.add(new Word("Jaune poussiéreux","dusty yellow",R.drawable.color_dusty_yellow));
        colors.add(new Word("Moutarde jaune","mustard yellow",R.drawable.color_mustard_yellow));


        WordAdapter wordAdapter = new WordAdapter(this,colors,R.color.category_colors);
        ListView lv = (ListView) findViewById(R.id.word_list);
        lv.setAdapter(wordAdapter);
    }
}
