package com.ujjani.studentattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<StudentsData> arrayList = new ArrayList<>();
    MyAdapter adapter;

    public int mYear;
    public int mMonth;
    public int mDay;

    public TextView mDateDisplay;
    public Button mPickDate;


    static final int DATE_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        arrayList.add(new StudentsData(1, "Prajwal"));
        arrayList.add(new StudentsData(2, "Bhuvana"));
        arrayList.add(new StudentsData(4, "Jayaramu"));
        arrayList.add(new StudentsData(5, "Rathna"));
        arrayList.add(new StudentsData(5, "Sam"));
        arrayList.add(new StudentsData(6, "Ramu"));
        arrayList.add(new StudentsData(7, "Sham"));
        arrayList.add(new StudentsData(8, "Manu"));
        arrayList.add(new StudentsData(9, "Steve"));
        arrayList.add(new StudentsData(10, "Jackson"));

        adapter = new MyAdapter(this, arrayList);
        listView.setAdapter(adapter);


        mDateDisplay = (TextView) findViewById(R.id.showMyDate);
        mPickDate = (Button) findViewById(R.id.myDatePickerButton);

        mPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date
        updateDisplay();

    }

    private void updateDisplay() {
        this.mDateDisplay.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mMonth + 1).append("-")
                        .append(mDay).append("-")
                        .append(mYear).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
        }
        return null;
    }
}