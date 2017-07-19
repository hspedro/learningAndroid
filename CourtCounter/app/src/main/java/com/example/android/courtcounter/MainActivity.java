package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int scoreTeamA = 0, scoreTeamB = 0;
    int foulTeamA = 0, foulTeamB = 0;
    int yellowTeamA = 0, yellowTeamB = 0;
    int redTeamA = 0, redTeamB = 0;
    int posTeamA = 50, posTeamB = 50;

    /**
     * Add 1 goal to the scoreA and displays
     */
    public void addGoalForTeamA(View view){
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Add 1 foul to the teamA and displays
     */
    public void addFoulForTeamA(View view){
        foulTeamA += 1;
        displayFoulTeamA(foulTeamA);
    }

    /**
     * Add 1 yellow to the teamA and displays
     */
    public void addYellowForTeamA(View view){
        yellowTeamA += 1;
        displayYellowTeamA(yellowTeamA);
    }

    /**
     * Add 1 red to the teamA and displays
     */
    public void addRedForTeamA(View view){
        redTeamA += 1;
        displayRedTeamA(redTeamA);
    }

    /**
     * Displays the score for team A
     */
    private void displayForTeamA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the foul for team A
     */
    private void displayFoulTeamA(int foul){
        TextView foulView = (TextView) findViewById(R.id.Afouls);
        foulView.setText(String.valueOf(foul));
    }

    /**
     * Displays the yelllows for team A
     */
    private void displayYellowTeamA(int y){
        TextView yView = (TextView) findViewById(R.id.Ayellows);
        yView.setText(String.valueOf(y));
    }

    /**
     * Displays the reds for team A
     */
    private void displayRedTeamA(int r){
        TextView rView = (TextView) findViewById(R.id.Areds);
        rView.setText(String.valueOf(r));
    }

    /**
     * Add 1 goal to the scoreB and displays
     */
    public void addGoalForTeamB(View view){
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Add 1 foul to the teamB and displays
     */
    public void addFoulForTeamB(View view){
        foulTeamB += 1;
        displayFoulTeamB(foulTeamB);
    }

    /**
     * Add 1 yellow to the teamB and displays
     */
    public void addYellowForTeamB(View view){
        yellowTeamB += 1;
        displayYellowTeamB(yellowTeamB);
    }

    /**
     * Add 1 red to the teamB and displays
     */
    public void addRedForTeamB(View view){
        redTeamB += 1;
        displayRedTeamB(redTeamB);
    }

    /**
     * Displays the score for team B
     */
    private void displayForTeamB(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the foul for team B
     */
    private void displayFoulTeamB(int foul){
        TextView foulView = (TextView) findViewById(R.id.Bfouls);
        foulView.setText(String.valueOf(foul));
    }

    /**
     * Displays the yelllows for team B
     */
    private void displayYellowTeamB(int y){
        TextView yView = (TextView) findViewById(R.id.Byellows);
        yView.setText(String.valueOf(y));
    }

    /**
     * Displays the reds for team B
     */
    private void displayRedTeamB(int r){
        TextView rView = (TextView) findViewById(R.id.Breds);
        rView.setText(String.valueOf(r));
    }

    /**
     * Reset both scores
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulTeamA = 0;
        foulTeamB = 0;
        yellowTeamA = 0;
        yellowTeamB = 0;
        redTeamA = 0;
        redTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulTeamA(foulTeamA);
        displayFoulTeamB(foulTeamB);
        displayYellowTeamA(yellowTeamA);
        displayYellowTeamB(yellowTeamB);
        displayRedTeamA(redTeamA);
        displayRedTeamB(redTeamB);
    }

}
