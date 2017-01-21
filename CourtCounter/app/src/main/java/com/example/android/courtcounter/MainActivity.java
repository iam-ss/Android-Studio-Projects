package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreA=0;
    private int scoreB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA();
        displayForTeamB();
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA() {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreA));
    }


    /**
     * Increments the score by 1 following free throw shoot
     */
    public void increment1forA(View view){
        scoreA++;
        displayForTeamA();
    }

    /**
     * Increments the score by 2
     */
    public void increment2forA(View view){
        scoreA+=2;
        displayForTeamA();
    }

    /**
     * Increments the score by 3
     */
    public void increment3forA(View view){
        scoreA+=3;
        displayForTeamA();
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB() {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreB));
    }

    /**
     * Increments the score by 1 following free throw shoot
     */
    public void increment1forB(View view){
        scoreB++;
        displayForTeamB();
    }

    /**
     * Increments the score by 2
     */
    public void increment2forB(View view){
        scoreB+=2;
        displayForTeamB();
    }

    /**
     * Increments the score by 3
     */
    public void increment3forB(View view){
        scoreB+=3;
        displayForTeamB();
    }

    /**
     * Resets the score of the teamA
     **/
    public void reset(View view){
        scoreA=0;
        scoreB=0;
        displayForTeamA();
        displayForTeamB();
    }
}
