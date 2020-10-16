package com.ujjani.studentattendance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "attendanceManager";
    private static final String TABLE_STUDENTS = "studentName";
    private static final String STUDENT_NAME = "name";
    private static final String KEY_ROLL_NO = "roll_number";
    private static final String TABLE_DATE = "date";
    private static final String ATTENDANCE_DATE = "date";
    private static final String ATTENDANCE_STATUS = "status";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " + TABLE_STUDENTS + "("
                + KEY_ROLL_NO + " INTEGER PRIMARY KEY," + STUDENT_NAME + " TEXT" + ")";
        db.execSQL(CREATE_STUDENTS_TABLE);

        String CREATE_ATTENDANCE_TABLE = "CREATE TABLE " + TABLE_DATE + "("
                + KEY_ROLL_NO + " INTEGER NOT NULL,"  + ATTENDANCE_DATE + " DATE PRIMARY KEY," + ATTENDANCE_STATUS + " BOOLEAN NOT NULL" + ")";

        db.execSQL(CREATE_STUDENTS_TABLE);
        db.execSQL(CREATE_ATTENDANCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {



    }
}
