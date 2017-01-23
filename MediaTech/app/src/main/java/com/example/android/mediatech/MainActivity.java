package com.example.android.mediatech;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = (Button) findViewById(R.id.play_btn);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.color_gray);
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "I'm done!!", Toast.LENGTH_SHORT).show();
                        releaseMediaPlayer();
                    }
                });
            }
        });

        Button pause = (Button) findViewById(R.id.pause_btn);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer.isPlaying())
                    mMediaPlayer.pause();
            }
        });

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
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

    public void decrease_volume(View view) {
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        float volume_level = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        if (volume_level <= 0.0) return;
        float newVolume = Math.max(0.0f, volume_level - 0.05f * maxVolume);

        am.setStreamVolume(AudioManager.STREAM_MUSIC, (int) Math.floor(newVolume), 0);
    }

    public void increase_volume(View view) {
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        float volume_level = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        if (volume_level >= maxVolume) return;
        float newVolume = Math.min(maxVolume, volume_level + 0.05f * maxVolume);

        am.setStreamVolume(AudioManager.STREAM_MUSIC, (int) Math.ceil(newVolume), AudioManager.FLAG_SHOW_UI);

    }


}
