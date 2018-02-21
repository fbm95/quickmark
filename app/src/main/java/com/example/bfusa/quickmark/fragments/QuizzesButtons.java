package com.example.bfusa.quickmark.fragments;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bfusa.quickmark.R;

/**
 * Created by bfusa on 26-Oct-17.
 */

public class QuizzesButtons {

    public static Activity activity;

    public static boolean BACK_FLAG;

    public Button twentyButton;
    public Button fiftyButton;
    public Button hundredButton;

    public QuizzesButtons(Activity _activity, boolean _BACK_FLAG) {

        this.activity = _activity;
        this.BACK_FLAG = _BACK_FLAG;

        //quizzes part
        assert twentyButton!= null;
        twentyButton = this.activity.findViewById(R.id.twentyButton);
        twentyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click start intent for selecting quiz type or add another quizz
                Toast.makeText(QuizzesButtons.activity.getApplicationContext(), "Will invoke scanner for 20 questions", Toast.LENGTH_SHORT).show();

            }
        });

        assert fiftyButton!= null;
        fiftyButton = this.activity.findViewById(R.id.fiftyButton);
        fiftyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click start intent for selecting quiz type or add another quizz
                Toast.makeText(QuizzesButtons.activity.getApplicationContext(), "Will invoke scanner for 50 questions", Toast.LENGTH_SHORT).show();
            }
        });

        assert hundredButton!= null;
        hundredButton = this.activity.findViewById(R.id.hundredButton);
        hundredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click start intent for selecting quiz type or add another quizz
                Toast.makeText(QuizzesButtons.activity.getApplicationContext(), "Will invoke scanner for 100 questions", Toast.LENGTH_SHORT).show();
            }
        });
        //end of quizzes part

    }

}
