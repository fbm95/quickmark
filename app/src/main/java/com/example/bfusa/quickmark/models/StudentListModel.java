package com.example.bfusa.quickmark.models;

/**
 * Created by bfusa on 31-Oct-17.
 */

public class StudentListModel {
    private String firstName;
    private String lastName;
    private double grade;

    public StudentListModel(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
