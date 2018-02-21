package com.example.bfusa.quickmark;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.bfusa.quickmark.adapters.StudentListAdapter;
import com.example.bfusa.quickmark.models.StudentListModel;

import java.util.ArrayList;

public class StudentsActivity extends AppCompatActivity {

    public ScrollView scrollView;
    public Button sortByGradeButton;
    public Button sortByNameButton;

    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        scrollView = findViewById(R.id.scrollView);
        assert scrollView != null;

        assert sortByGradeButton != null;
        sortByGradeButton = findViewById(R.id.sortByGradeButton);
        sortByGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click start intent for selecting quiz type or add another quizz

            }
        });

        assert sortByNameButton != null;
        sortByNameButton = findViewById(R.id.sortByNameButton);
        sortByNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click start intent for selecting quiz type or add another quizz

            }
        });

        //end of students part

        populateListView();
    }

    private void populateListView(){
        ArrayList<StudentListModel> students = new ArrayList<>();
        students.add(new StudentListModel("prenume1", "nume1", 1));
        students.add(new StudentListModel("prenume2", "nume2", 2));
        students.add(new StudentListModel("prenume3", "nume3", 3));
        students.add(new StudentListModel("prenume4", "nume4", 4));
        students.add(new StudentListModel("prenume5", "nume5", 5));
        students.add(new StudentListModel("prenume6", "nume6", 6));
        students.add(new StudentListModel("prenume7", "nume7", 7));
        students.add(new StudentListModel("prenume8", "nume8", 8));
        students.add(new StudentListModel("prenume9", "nume9", 9));
        students.add(new StudentListModel("prenume10", "nume10", 10));
        students.add(new StudentListModel("prenume11", "nume11", 11));
        students.add(new StudentListModel("prenume12", "nume12", 12));
        students.add(new StudentListModel("prenume13", "nume13", 13));
        students.add(new StudentListModel("prenume14", "nume14", 14));


        assert  listView != null;
        listView = findViewById(R.id.studentsListView);

        StudentListAdapter studentListAdapter = new StudentListAdapter(students, this);

        listView.setAdapter(studentListAdapter);


    }
}
