package com.example.bfusa.quickmark.fragments;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.bfusa.quickmark.R;
import com.example.bfusa.quickmark.StudentsActivity;

/**
 * Created by bfusa on 26-Oct-17.
 */

public class MainButtons {

    public static Activity activity;

    public static boolean BACK_FLAG;

    public static QuizzesButtons quizzesButtonsClass;

    public Button quizzesButton;
    public Button studentsButton;
    public Button classesButton;

    public MainButtons(Activity _activity, boolean _BACK_FLAG, QuizzesButtons _quizzesButtonsClass){

        this.activity = _activity;
        this.BACK_FLAG = _BACK_FLAG;
        this.quizzesButtonsClass = _quizzesButtonsClass;

        //main part
        assert quizzesButton != null;
        quizzesButton = this.activity.findViewById(R.id.quizzesButton);
        quizzesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click start intent for selecting quiz type or add another quizz
                BACK_FLAG = true;
                quizzesButton.setVisibility(View.GONE);
                studentsButton.setVisibility(View.GONE);
                classesButton.setVisibility(View.GONE);

                quizzesButtonsClass.twentyButton.setVisibility(View.VISIBLE);
                quizzesButtonsClass.fiftyButton.setVisibility(View.VISIBLE);
                quizzesButtonsClass.hundredButton.setVisibility(View.VISIBLE);
            }
        });

        assert studentsButton != null;
        studentsButton = this.activity.findViewById(R.id.studentsButton);
        studentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainButtons.activity.getApplicationContext(), StudentsActivity.class);
                MainButtons.activity.startActivity(intent);

            }
        });

        assert classesButton != null;
        classesButton = this.activity.findViewById(R.id.classesButton);
        classesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click start intent for selecting quiz type or add another quizz
                BACK_FLAG = true;
                quizzesButton.setVisibility(View.GONE);
                studentsButton.setVisibility(View.GONE);
                classesButton.setVisibility(View.GONE);

                quizzesButtonsClass.twentyButton.setVisibility(View.GONE);
                quizzesButtonsClass.fiftyButton.setVisibility(View.GONE);
                quizzesButtonsClass.hundredButton.setVisibility(View.GONE);
            }
        });

        //end of main part

        //make main part buttons visible at app open (they are gone by default)
        quizzesButton.setVisibility(View.VISIBLE);
        studentsButton.setVisibility(View.VISIBLE);
        classesButton.setVisibility(View.VISIBLE);
    }

}
