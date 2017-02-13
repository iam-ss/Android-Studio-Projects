[33mcommit 670495e4e205111b58a6c390fa51df7057d379db[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Feb 13 11:54:30 2017 +0530

    Outing Time Project - All activities completed.

[33mcommit 99d4becde6f02448a8a154b0359ee5cbba33ff77[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Feb 13 11:47:05 2017 +0530

    Outing Time Project - First commit

[33mcommit e3813bc2a83f80ced8a6536e5f52f5b7ea2e5438[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 30 16:38:34 2017 +0530

    Further visual polish.
    Use context to fetch tab titles .
    Remove hardcoded strings.

[33mcommit 46e1064d7f06660b95727175b563a8363fcc3463[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 30 04:58:49 2017 +0530

    Add tabs for fragments.
    Do Visual Polish of the tabs.

[33mcommit e04217c0b59a43f8d25378ddcad1c41474d9e28b[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 30 03:47:36 2017 +0530

    Modify MainActivity to contain a ViewPager that allows the users to swipe between the list of words.
    Create CategoryAdapter Class that extends from FragmentPageAdapter.Provide appropriate fragment for each page in the ViewPager.
    Delete unused files (namely all activities except the MainActivity ) and the activity_category file.

[33mcommit 447c261b83e425d5ed9a96eb362949aa7be5ef8f[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 30 03:26:04 2017 +0530

    Shift the Activity part to Fragment.java file for every activity and attached the associated activity_category.xml file to support the made fragment.
     No visual changes made.

[33mcommit 5d9eb4ae70ff234a4745c62600d3b783be5eae6a[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 30 03:08:11 2017 +0530

    Shift the NumbersActivity part to NumbersFragment.java file and attached the associated activity_category.xml file to support the made fragment.
     No visual changes made.

[33mcommit cb0277c6e59890d80f13c738c1b60cbd6a094ada[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 30 01:03:02 2017 +0530

    Update androidManifest.xml file . Add parent activity attribute in every activity tag to support the up botton within every activity.

[33mcommit 8ad7e3adf118a0f8b0730d5657bbc00524caf5c9[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Tue Jan 24 19:14:13 2017 +0530

    Remove  the attribute  "android:background="?android:attr/selectableItemBackground ""  and add a new attribute " android:drawSelectorOnTop="true" "" .(Works the same )

[33mcommit 130a2ce98d07cc4e1807377cba570149a15c2571[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Tue Jan 24 19:10:51 2017 +0530

    Add FrameLayout and used the attribute  "android:background="?android:attr/selectableItemBackground "" for bringing standard feedbacks to different views.

[33mcommit d752c80375aee10a53a03f0ef520a33b68b0bc68[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Tue Jan 24 19:09:09 2017 +0530

    Add requestAudioFocus() and onAudioFocusChangeListener() in all category files.

[33mcommit d4c767d477b667041d4bdedb3152467fb6545fa5[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Tue Jan 24 16:38:21 2017 +0530

    Remove UI Flag from volume up control

[33mcommit 23838d6d5f5767ab931e2643badbb07dbc0f6e9d[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Tue Jan 24 14:55:43 2017 +0530

    Use onStop() method to clean media player resources when user closes the app.

[33mcommit c83ad597ede177c9193363423c8f42396c5d216e[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 23 21:01:22 2017 +0530

    No Functional Changes.
    Code Clean Up.

[33mcommit e3634333619e34205a77737a769c312fca17997f[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 23 20:40:14 2017 +0530

    Add setOnCompletionListener callback() method in every activity (Except main() ) .
    Add releaseMediaPlayer() method in every activity .
    Call releaseMediaPlayer() method before creating a mediaPlayer object and after completing of the playback.

[33mcommit dca43feaa0177dd24add0eaa9986dff4d4b9f03c[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 23 20:23:04 2017 +0530

    add color_gray.mp3 file to raw folder of resourced directory .
    add setOnCompletionListener to register a callback() when the song is finished playing.
    add method releaseMediaPlayer() and call it before creating any MediaPlayer object and call it after the playback is finished.

[33mcommit 1de6f5da813c11723a1efa223f9d1617bd7c353c[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 23 18:52:09 2017 +0530

    Override the toString() method of Word Class and use Log to print the word object of the associated clicked item.

[33mcommit ab6e0ed7680005f1b90535304f97a9d0ebf33c6e[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Mon Jan 23 16:58:33 2017 +0530

    Testing Commit

[33mcommit 4a5e7caf4dfd15549e84c4ef78f758686ada1aa8[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Sun Jan 22 23:50:54 2017 +0530

    Add setOnItemClickListener in every activity so that whenever user touches any item of the list view , it plays the respective sound.
    #my_experiment

[33mcommit 7c6663e80cc11f1e7d942a112652826891dc5903[m
Author: singham <singhams.shubham571@gmail.com>
Date:   Sun Jan 22 03:57:49 2017 +0530

    Update the word to contain additional member int audioClipId .
    Update the two constructors to include the third parameter for initialising audioClipId.
    Update all the activities , except the main, to reflect the corresponding change in the word class.

[33mcommit 8a26cddaaa777fd9021141418848a183c3be2ceb[m
Author: Shubham Singh <singhams.shubham571@gmail.com>
Date:   Sun Jan 22 02:37:22 2017 +0530

    Readd project "Happy Birthday"

[33mcommit bfce1240e41deed093e1c792d9de15eb95dcfdeb[m
Author: Shubham Singh <singhams.shubham571@gmail.com>
Date:   Sun Jan 22 02:34:41 2017 +0530

    Delete  project "Happy Birthday."

[33mcommit 9970a9cbd37247ff081528738bb76d506c468f68[m
Author: Shubham Singh <singhams.shubham571@gmail.com>
Date:   Sun Jan 22 02:28:03 2017 +0530

    Add volume up and volume down buttons and add their respective functionality in their java files

[33mcommit a5ac0d339eaef7de3bf6dbf02c390310cd44f350[m
Author: Shubham Singh <singhams.shubham571@gmail.com>
Date:   Sun Jan 22 00:56:04 2017 +0530

    add backstree.mp3 song to check the capabilitits of MediaPlayer class.

[33mcommit d279136f39babb7d9b26aa815cba766b4bc8ce6e[m
Author: Shubham Singh <singhams.shubham571@gmail.com>
Date:   Sat Jan 21 23:44:35 2017 +0530

    First Commit
