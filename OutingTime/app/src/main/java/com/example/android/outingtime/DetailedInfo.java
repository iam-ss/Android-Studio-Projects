package com.example.android.outingtime;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

//comment
public class DetailedInfo extends AppCompatActivity {

    private int mAudioId=-1;
    private AudioManager am=null;
    private MediaPlayer mp = null;
    private int par;

    public  AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener(){
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mp.pause();
                mp.seekTo(0);
            }else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mp.start();
            }
        }
    };

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // take care of this
        setContentView(R.layout.detailed_info);

        Bundle b = this.getIntent().getExtras();
        if(b!=null){
            Information info = b.getParcelable("Info");
            if(info==null)return;

            TextView tv = (TextView) findViewById(R.id.name);
            tv.setText(info.mName);

            tv = (TextView) findViewById(R.id.address);
            tv.setText(info.mAddress);

            tv= (TextView) findViewById(R.id.timings);
            tv.setText(info.mTimings);

            tv=(TextView) findViewById(R.id.metro);
            tv.setText(info.mMetro);

            ImageView iv = (ImageView) findViewById(R.id.main_image);
            iv.setImageResource(info.mImageResourceId);

            mAudioId = info.mAudioId;
            par = info.mColorId;

            RelativeLayout rv;
            LinearLayout ll;

            switch(par){
                case 2:
                    rv = (RelativeLayout) findViewById(R.id.mainTitle);
                    rv.setBackgroundColor(Color.parseColor("#ec407a"));

                    ll = (LinearLayout) findViewById(R.id.addressCardLinearLayout);
                    ll.setBackgroundColor(Color.parseColor("#e91e63"));

                    ll = (LinearLayout) findViewById(R.id.timingLayout);
                    ll.setBackgroundColor(Color.parseColor("#e91e63"));

                    tv = (TextView) findViewById(R.id.metroHeading);
                    tv.setTextColor(Color.parseColor("#c51162"));

                    tv =  (TextView)findViewById(R.id.metro);
                    tv.setTextColor(Color.parseColor("#c51162"));

                    tv= (TextView) findViewById(R.id.google_maps);
                    tv.setBackgroundColor(Color.parseColor("#c51162"));

                    break;

                case 1:
                    rv = (RelativeLayout) findViewById(R.id.mainTitle);
                    rv.setBackgroundColor(Color.parseColor("#673ab7"));

                    ll = (LinearLayout) findViewById(R.id.addressCardLinearLayout);
                    ll.setBackgroundColor(Color.parseColor("#7e57c2"));

                    ll = (LinearLayout) findViewById(R.id.timingLayout);
                    ll.setBackgroundColor(Color.parseColor("#7e57c2"));

                    tv = (TextView) findViewById(R.id.metroHeading);
                    tv.setTextColor(Color.parseColor("#5e35b1"));

                    tv =  (TextView)findViewById(R.id.metro);
                    tv.setTextColor(Color.parseColor("#9575cd"));

                    tv= (TextView) findViewById(R.id.google_maps);
                    tv.setBackgroundColor(Color.parseColor("#4527a0"));

                    break;

                case 3:
                    rv = (RelativeLayout) findViewById(R.id.mainTitle);
                    rv.setBackgroundColor(Color.parseColor("#388e3c"));

                    ll = (LinearLayout) findViewById(R.id.addressCardLinearLayout);
                    ll.setBackgroundColor(Color.parseColor("#558b2f"));

                    ll = (LinearLayout) findViewById(R.id.timingLayout);
                    ll.setBackgroundColor(Color.parseColor("#558b2f"));

                    tv = (TextView) findViewById(R.id.metroHeading);
                    tv.setTextColor(Color.parseColor("#33691e"));

                    tv =  (TextView)findViewById(R.id.metro);
                    tv.setTextColor(Color.parseColor("#689f38"));

                    tv= (TextView) findViewById(R.id.google_maps);
                    tv.setBackgroundColor(Color.parseColor("#2e7d32"));

                    break;

                case 4:
                    rv = (RelativeLayout) findViewById(R.id.mainTitle);
                    rv.setBackgroundColor(Color.parseColor("#7b1fa2"));

                    ll = (LinearLayout) findViewById(R.id.addressCardLinearLayout);
                    ll.setBackgroundColor(Color.parseColor("#9c27b0"));

                    ll = (LinearLayout) findViewById(R.id.timingLayout);
                    ll.setBackgroundColor(Color.parseColor("#9c27b0"));

                    tv = (TextView) findViewById(R.id.metroHeading);
                    tv.setTextColor(Color.parseColor("#7b1fa2"));

                    tv =  (TextView)findViewById(R.id.metro);
                    tv.setTextColor(Color.parseColor("#ab47bc"));

                    tv= (TextView) findViewById(R.id.google_maps);
                    tv.setBackgroundColor(Color.parseColor("#9c27b0"));
                    break;

            }
        }
    }


    public void clickMe(View v) {
        if(mAudioId == -1)return;
        releaseMediaPlayer();
        am = (AudioManager) getSystemService(AUDIO_SERVICE);
        int audioFocusResponse = am.requestAudioFocus(onAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if(audioFocusResponse == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
            mp = MediaPlayer.create(DetailedInfo.this,mAudioId);
            mp.start();
            mp.setOnCompletionListener(onCompletionListener);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

    public void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if(mp==null)return;
        mp.release();
        mp=null;
        am.abandonAudioFocus(onAudioFocusChangeListener);
    }


    public void open_maps(View view){
        TextView tv = (TextView) findViewById(R.id.address);
        TextView tv1 = (TextView) findViewById(R.id.name);
        Uri gmmIntentUri = Uri.parse("geo:0,0?q="+tv.getText()+" "+tv1.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

}
