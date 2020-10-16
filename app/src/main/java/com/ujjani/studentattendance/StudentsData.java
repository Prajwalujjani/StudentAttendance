package com.ujjani.studentattendance;

public class StudentsData {

    private int rollNumber;
    private String studentName;

    public StudentsData(int rollNumber, String studentName) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
