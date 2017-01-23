package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("rouge", "red", R.drawable.color_red, R.raw.color_red));
        colors.add(new Word("vert", "green", R.drawable.color_green, R.raw.color_green));
        colors.add(new Word("marron", "brown", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new Word("gris", "gray", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new Word("noir", "black", R.drawable.color_black, R.raw.color_black));
        colors.add(new Word("blanc", "white", R.drawable.color_white, R.raw.color_white));
        colors.add(new Word("Jaune poussiéreux", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new Word("Moutarde jaune", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));


        WordAdapter wordAdapter = new WordAdapter(this,colors,R.color.category_colors);
        ListView lv = (ListView) findViewById(R.id.word_list);
        lv.setAdapter(wordAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.i("ColorsActivity", "Current Word :" + colors.get(i));
                releaseMediaPlayer(mp);
                mp = MediaPlayer.create(ColorsActivity.this, colors.get(i).getAudioResourceId());
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer(mp);
                    }
                });
            }
        });


    }

    private void releaseMediaPlayer(MediaPlayer mMediaPlayer) {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
