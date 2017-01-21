package com.example.android.mediatech;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = (Button) findViewById(R.id.play_btn);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer == null)
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.backstreet);
                mediaPlayer.start();
            }
        });

        Button pause = (Button) findViewById(R.id.pause_btn);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                    mediaPlayer.pause();
            }
        });
    }

    public void decrease_volume(View view){
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        float volume_level= am.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        if(volume_level <= 0.0) return ;
        float newVolume  = Math.max(0.0f, volume_level - 0.05f*maxVolume);

        am.setStreamVolume(AudioManager.STREAM_MUSIC,(int)Math.floor(newVolume),AudioManager.FLAG_SHOW_UI);
    }

    public void increase_volume(View view){
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        float volume_level= am.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        if(volume_level >= maxVolume) return ;
        float newVolume  = Math.min(maxVolume,volume_level + 0.05f*maxVolume);

        am.setStreamVolume(AudioManager.STREAM_MUSIC,(int)Math.ceil(newVolume),AudioManager.FLAG_SHOW_UI);

    }
}
