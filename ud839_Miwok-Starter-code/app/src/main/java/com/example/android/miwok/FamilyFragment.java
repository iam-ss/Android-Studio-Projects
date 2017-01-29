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
public class FamilyFragment extends Fragment {

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

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> family = new ArrayList<>();
        family.add(new Word("père", "father", R.drawable.family_father, R.raw.family_father));
        family.add(new Word("mère", "mother", R.drawable.family_mother, R.raw.family_mother));
        family.add(new Word("fils", "son", R.drawable.family_son, R.raw.family_son));
        family.add(new Word("fille", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        family.add(new Word("grand frère", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        family.add(new Word("frère cadet", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        family.add(new Word("grande sœur", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        family.add(new Word("sœur cadette", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        family.add(new Word("grand-mère", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        family.add(new Word("grand-père", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), family, R.color.category_family);
        ListView lv = (ListView) rootview.findViewById(R.id.word_list);
        lv.setAdapter(wordAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                am = (AudioManager) getActivity().getSystemService(AUDIO_SERVICE);
                int audioFocusResponse = am.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (audioFocusResponse == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), family.get(i).getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        });
        return rootview;
    }

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
            am.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
