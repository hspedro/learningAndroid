package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitQuestions(View view) {

        int scoreQ1, scoreQ2, scoreQ3, scoreQ4, scoreQ5;

        // Check if all questions were answered
        try {
            scoreQ1 = checkQ1();
            scoreQ2 = checkQ2();
            scoreQ3 = checkQ3();
            scoreQ4 = checkQ4();
            scoreQ5 = checkQ5();

            // If any score value is -1 then some question was left without answer
            if ((scoreQ1 < 0) || (scoreQ2 < 0) || (scoreQ3 < 0) || (scoreQ4 < 0) || (scoreQ5 < 0)) {
                // Display toast so that user check answers again
                Toast.makeText(this, "Oops! Seems like you forgot a question", Toast.LENGTH_SHORT).show();
            } else {
                //Compute totalScore
                int totalScore = scoreQ1 + scoreQ2 + scoreQ3 + scoreQ4 + scoreQ5;
                Toast.makeText(this, "Congratulations! Your score is: " + totalScore,
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.d("DEBUG:", "Exception caught checking if questions were answered");
        }
    }

    /**
     * This function checks if Q1 was answered and computes the score
     *
     * @return -1 if not answered, 20 if correct and 0 if incorrect
     */
    private int checkQ1() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.alternatives1);
        RadioButton answer = (RadioButton) findViewById(R.id.alt13);

        int choice = rg.getCheckedRadioButtonId();

        // Check if no button was selected in the RadioGroup
        if(choice == -1) {
            return -1;
        } else {
            // If selected button was 3rd, correct answer
            if(choice == answer.getId()) {
                return 20;
            // If not, wrong answer
            } else {
                return 0;
            }
        }
    }

    /**
     * This function checks if Q2 was answered and computes the score
     *
     * @return -1 if not answered, 20 if correct and 0 if incorrect
     */
    private int checkQ2() {
        CheckBox a1 = (CheckBox) findViewById(R.id.alt21);
        CheckBox a2 = (CheckBox) findViewById(R.id.alt22);
        CheckBox a3 = (CheckBox) findViewById(R.id.alt23);
        CheckBox a4 = (CheckBox) findViewById(R.id.alt24);
        CheckBox a5 = (CheckBox) findViewById(R.id.alt25);

        if(!a1.isChecked() && !a2.isChecked() && !a3.isChecked() &&
                !a4.isChecked() && !a5.isChecked()) {
            // Nothing is checked
            return -1;
        } else {
            if(a1.isChecked() && a2.isChecked() && a5.isChecked()) {
                return 20;
            } else {
                return 0;
            }
        }
    }

    /**
     * This function checks if Q3 was answered and computes the score
     *
     * @return -1 if not answered, 20 if correct and 0 if incorrect
     */
    private int checkQ3() {
        EditText answer = (EditText) findViewById(R.id.alt31);

        if(answer.getText().toString().isEmpty()) {
            return -1;
        }

        if(answer.getText().toString().toLowerCase().equals("google")) {
            return 20;
        } else {
            return 0;
        }
    }

    /**
     * This function checks if Q4 was answered and computes the score
     *
     * @return -1 if not answered, 20 if correct and 0 if incorrect
     */
    private int checkQ4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.alternatives4);
        RadioButton answer = (RadioButton) findViewById(R.id.alt45);

        int choice = rg.getCheckedRadioButtonId();

        // Check if no button was selected in the RadioGroup
        if(choice == -1 ) {
            return -1;
        } else {
            // If selected button was 3rd, correct answer
            if(choice == answer.getId()) {
                return 20;
                // If not, wrong answer
            } else {
                return 0;
            }
        }
    }

    /**
     * This function checks if Q5 was answered and computes the score
     *
     * @return -1 if not answered, 20 if correct and 0 if incorrect
     */
    private int checkQ5() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.alternatives5);
        RadioButton answer = (RadioButton) findViewById(R.id.alt54);

        int choice = rg.getCheckedRadioButtonId();

        // Check if no button was selected in the RadioGroup
        if (choice == -1) {
            return -1;
        } else {
            if (choice == answer.getId()) {
                return 20;
            } else {
                return 0;
            }
        }
    }
}
