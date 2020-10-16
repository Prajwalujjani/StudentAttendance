package com.ujjani.studentattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<StudentsData> arrayList;
    public TextView studentName, rollNumber;

    public MyAdapter(Context context, ArrayList<StudentsData> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row, viewGroup, false);
        studentName = convertView.findViewById(R.id.studentName);
        rollNumber = convertView.findViewById(R.id.rollNumber);
        studentName.setText(arrayList.get(position).getStudentName());


        return convertView;
    }
}
