package com.exsample.android.quiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Saving correct answers in variables for each question (except multiple answer coquestion 3 and 10)
    final String answerQuestion1 = "the wizard of oz";
    final int answerQuestion2 = R.id.q2_radioButton1;
    final String answerQuestion4 = "the godfather";
    final int answerQuestion5 = R.id.q5_radioButton2;
    final int answerQuestion6 = R.id.q6_radioButton3;
    final int answerQuestion7 = R.id.q7_radioButton2;
    final String answerQuestion8 = "the lord of the rings";
    final int answerQuestion9 = R.id.q9_radioButton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Check quiz answers. Display the given score and correct answer for the quiz
    public void checkQuiz(View v) {

        //Track the score for right answer
        int correct_answer = 0;

        //Save incorrect answers into list
        ArrayList<String> correctedAnswers = new ArrayList<>();

        /*
        Add one to correct_answer if the statement is true (ie. answer is correct),
        otherwise save the correct answer into string variable correctedAnswers
        */

        if (question1()) {
            correct_answer += 1;
        } else
            correctedAnswers.add("Question 1: The Wizard of Oz");

        if (question2()) {
            correct_answer += 1;
        } else
            correctedAnswers.add("Question 2: Back to the Future");

        if (question3()) {
            correct_answer += 1;
        } else
            correctedAnswers.add("Question 3: Forrest Gump, Tom Hanks");

        if (question4()) {
            correct_answer += 1;
        } else
            correctedAnswers.add("Question 4: The Godfather");

        if (question5()) {
            correct_answer += 1;
        } else
            correctedAnswers.add("Question 5: No");

        if (question6()) {
            correct_answer += 1;
        } else
            correctedAnswers.add("Question 6: Star Wars");

        if (question7()) {
            correct_answer += 1;
        } else
            correctedAnswers.add("Question 7: Scarface");

        if (question8()) {
            correct_answer += 1;
        } else
            correctedAnswers.add("Question 8: The Lord of the Rings");

        if (question9()) {
            correct_answer += 1;
        } else
            correctedAnswers.add("Question 9: Yes");

        if (question10()) {
            correct_answer += 1;
        } else
            correctedAnswers.add("Question 10: Terminator, Arnold Schwarzenegger");

        //Appends incorrect answer string to sequence and adding new line after each
        StringBuilder sb = new StringBuilder();
        for (String s : correctedAnswers) {
            sb.append(s);
            sb.append("\n");
        }

        CharSequence text;
        if (correct_answer == 10) {  //text message if all question are correct
            text = "You got 10/10 answers right. \n\nYou are a true movie lover!";
        } else    // another text message if there is at least one incorrect answers
            text = "You got " + correct_answer + "/10 answers right.\n\nThe corrected answer:\n" + sb.toString();

        //Display toast message depending on the number of correct answers
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /*
    Return true if the string is equal to string "the wizard of oz",
    otherwise return false, for question 1
    */
    private boolean question1() {
        EditText et = findViewById(R.id.q1_editText);

        return et.getText().toString().trim().equalsIgnoreCase(answerQuestion1);
    }

    // Return true if the first radioButton was clicked, otherwise return false, for question 2
    private boolean question2() {
        RadioGroup rg = findViewById(R.id.q2_radioGroup);

        return rg.getCheckedRadioButtonId() == answerQuestion2;
    }

    /*
    Return true if the first and second checkbox was clicked, otherwise return false,
    for question 3
    */
    private boolean question3() {
        CheckBox cb1 = findViewById(R.id.q3_checkBox1);
        CheckBox cb2 = findViewById(R.id.q3_checkBox2);
        CheckBox cb3 = findViewById(R.id.q3_checkBox3);
        CheckBox cb4 = findViewById(R.id.q3_checkBox4);

        return cb1.isChecked() && cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked();
    }

    /*
    Return true if the string is equal to string "the godfather",
    otherwise return false, for question 4
    */
    private boolean question4() {
        EditText et = findViewById(R.id.q4_editText);

        return et.getText().toString().trim().equalsIgnoreCase(answerQuestion4);
    }

    /*
    Return true if the second radioButton was clicked and false if the first
    radioButton was clicked, for question 5
    */
    private boolean question5() {
        RadioGroup rg = findViewById(R.id.q5_radioGroup);

        return rg.getCheckedRadioButtonId() == answerQuestion5;
    }

    // Return true if the third radioButton was clicked, otherwise return false, for question 6
    private boolean question6() {
        RadioGroup rg = findViewById(R.id.q6_radioGroup);

        return rg.getCheckedRadioButtonId() == answerQuestion6;
    }

    /*
    Return true if the second radioButton was clicked,
    otherwise return false, for question 7
    */
    private boolean question7() {
        RadioGroup rg = findViewById(R.id.q7_radioGroup);

        return rg.getCheckedRadioButtonId() == answerQuestion7;
    }

    /*
    Return true if the string is equal to string "the lord of the rings",
    otherwise return false, for question 8
    */
    private boolean question8() {
        EditText et = findViewById(R.id.q8_editText);

        return et.getText().toString().trim().equalsIgnoreCase(answerQuestion8);
    }

    /*
    Return true if the second radioButton was clicked  and false if the first
    radioButton was clicked, for question 9
    */
    private boolean question9() {
        RadioGroup rg = findViewById(R.id.q9_radioGroup);

        return rg.getCheckedRadioButtonId() == answerQuestion9;
    }

    /*
    Return true if the first and third checkbox was clicked, otherwise return false,
    for question 10
    */
    private boolean question10() {
        CheckBox cb1 = findViewById(R.id.q10_checkBox1);
        CheckBox cb2 = findViewById(R.id.q10_checkBox2);
        CheckBox cb3 = findViewById(R.id.q10_checkBox3);
        CheckBox cb4 = findViewById(R.id.q10_checkBox4);

        return cb1.isChecked() && !cb2.isChecked() && cb3.isChecked() && !cb4.isChecked();
    }

}
