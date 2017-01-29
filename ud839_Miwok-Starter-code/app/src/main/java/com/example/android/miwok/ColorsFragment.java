package com.example.android.miwok;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.Context.AUDIO_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {


    private MediaPlayer mMediaPlayer = null;
    private AudioManager am = null;
    public AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (i == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            } else if (i == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
        }
    };
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("rouge", "red", R.drawable.color_red, R.raw.color_red));
        colors.add(new Word("vert", "green", R.drawable.color_green, R.raw.color_green));
        colors.add(new Word("marron", "brown", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new Word("gris", "gray", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new Word("noir", "black", R.drawable.color_black, R.raw.color_black));
        colors.add(new Word("blanc", "white", R.drawable.color_white, R.raw.color_white));
        colors.add(new Word("Jaune poussiéreux", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new Word("Moutarde jaune", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));


        WordAdapter wordAdapter = new WordAdapter(getActivity(), colors, R.color.category_colors);
        ListView lv = (ListView) rootview.findViewById(R.id.word_list);
        lv.setAdapter(wordAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                am = (AudioManager) getActivity().getSystemService(AUDIO_SERVICE);
                int audioFocusResponse = am.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (audioFocusResponse == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), colors.get(i).getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        });
        return rootview;
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            am.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
