package com.example.android.europeanchampionship2016quiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.question1_choice1)
    RadioButton question1Choice1;
    @BindView(R.id.question1_choice2)
    RadioButton question1Choice2;
    @BindView(R.id.question1_choice3)
    RadioButton question1Choice3;
    @BindView(R.id.question3_choice1)
    CheckBox question3Choice1;
    @BindView(R.id.question3_choice2)
    CheckBox question3Choice2;
    @BindView(R.id.question3_choice3)
    CheckBox question3Choice3;
    @BindView(R.id.question3_choice4)
    CheckBox question3Choice4;
    @BindView(R.id.question4_choice1)
    RadioButton question4Choice1;
    @BindView(R.id.question4_choice2)
    RadioButton question4Choice2;
    @BindView(R.id.question5_choice1)
    RadioButton question5Choice1;
    @BindView(R.id.question5_choice2)
    RadioButton question5Choice2;
    @BindView(R.id.question5_choice3)
    RadioButton question5Choice3;
    @BindView(R.id.question6_choice1)
    RadioButton question6Choice1;
    @BindView(R.id.question6_choice2)
    RadioButton question6Choice2;
    @BindView(R.id.question6_choice3)
    RadioButton question6Choice3;
    @BindView(R.id.question8_choice1)
    CheckBox question8Choice1;
    @BindView(R.id.question8_choice2)
    CheckBox question8Choice2;
    @BindView(R.id.question8_choice3)
    CheckBox question8Choice3;
    @BindView(R.id.question8_choice4)
    CheckBox question8Choice4;
    @BindView(R.id.answer_question2)
    EditText answerQuestion2;
    @BindView(R.id.answer_question7)
    EditText answerQuestion7;
    @BindView(R.id.submit)
    Button submit;

    int answer1_score;
    int answer2_score;
    int answer3_score;
    int answer4_score;
    int answer5_score;
    int answer6_score;
    int answer7_score;
    int answer8_score;
    int final_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //Bind activity for binding the views.
        ButterKnife.bind(this);
    }

    //Question 1.
    @OnClick({R.id.question1_choice1, R.id.question1_choice2, R.id.question1_choice3})
    public void questionOne() {
        boolean answer1 = question1Choice2.isChecked();
        if (answer1) {
            answer1_score = answer1_score + 1;
        } else {
            answer1_score = 0;
        }
    }

    //Question 2.
    @OnTextChanged(R.id.answer_question2)
    public void questionTwo() {
        String answer2 = answerQuestion2.getText().toString();
        if (answer2.equals("Eder") || answer2.equals("eder") || answer2.equals("Ederzito António Macedo Lopes") || answer2.equals("Ederzito Antonio Macedo Lopes")) {
            answer2_score = answer2_score + 1;
        } else {
            answer2_score = 0;
        }
    }

    //Question 3.
    @OnCheckedChanged({R.id.question3_choice1, R.id.question3_choice2, R.id.question3_choice3, R.id.question3_choice4})
    public void questionThree() {
        if (question3Choice1.isChecked() && !question3Choice2.isChecked() && question3Choice3.isChecked() && !question3Choice4.isChecked()) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }
    }

    //Question 4.
    @OnClick({R.id.question4_choice1, R.id.question4_choice2})
    public void questionFour() {
        boolean answer4 = question4Choice1.isChecked();
        if (answer4) {
            answer4_score = answer4_score + 1;
        } else {
            answer4_score = 0;
        }
    }

    //Question 5.
    @OnClick({R.id.question5_choice1, R.id.question5_choice2, R.id.question5_choice3})
    public void questionFive() {
        boolean answer5 = question5Choice2.isChecked();
        if (answer5) {
            answer5_score = answer5_score + 1;
        } else {
            answer5_score = 0;
        }
    }

    //Question 6.
    @OnClick({R.id.question6_choice1, R.id.question6_choice2, R.id.question6_choice3})
    public void questionSix() {
        boolean answer6 = question6Choice3.isChecked();
        if (answer6) {
            answer6_score = answer6_score + 1;
        } else {
            answer6_score = 0;
        }
    }

    //Question 7.
    @OnTextChanged(R.id.answer_question7)
    public void questionSeven() {
        String answer7 = answerQuestion7.getText().toString();
        if (answer7.equals("England") || answer7.equals("england")) {
            answer7_score = answer7_score + 1;
        } else {
            answer7_score = 0;
        }
    }

    // Question 8.
    @OnCheckedChanged({R.id.question8_choice1, R.id.question8_choice2, R.id.question8_choice3, R.id.question8_choice4})
    public void questionEight() {
        if (question8Choice1.isChecked() && !question8Choice2.isChecked() && !question8Choice3.isChecked() && question8Choice4.isChecked()) {
            answer8_score = answer8_score + 1;
        } else {
            answer8_score = 0;
        }
    }

    //Final score.
    @OnClick(R.id.submit)
    public void checkResult() {
        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score + answer6_score + answer7_score + answer8_score;
        if (final_score < 8) {
            Toast.makeText(getApplicationContext(), "Try again. You scored " + String.valueOf(final_score) + " out of 8",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Perfect! You scored 8 out of 8",
                    Toast.LENGTH_LONG).show();
        }
    }
}