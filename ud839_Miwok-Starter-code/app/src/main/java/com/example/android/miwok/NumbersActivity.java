package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("un", "one", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("deux", "two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Trois", "three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("quatre", "four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("cinq", "five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Sept", "seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("huit", "eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("neuf", "nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Dix", "ten", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_numbers);
        ListView lv = (ListView) findViewById(R.id.word_list);
        lv.setAdapter(wordAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("NUmbersActivity", "Current Word :" + words.get(i));
                releaseMediaPlayer(mp);
                mp = MediaPlayer.create(NumbersActivity.this, words.get(i).getAudioResourceId());
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
