package com.example.bfusa.quickmark.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfusa.quickmark.R;
import com.example.bfusa.quickmark.models.StudentListModel;

import java.util.ArrayList;

/**
 * Created by bfusa on 31-Oct-17.
 */

public class StudentListAdapter extends ArrayAdapter<StudentListModel> implements View.OnClickListener {

    private ArrayList<StudentListModel> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtFirstName;
        TextView txtLastName;
        TextView txtGrade;
        ImageView info;
    }

    public StudentListAdapter(ArrayList<StudentListModel> data, Context context) {
        super(context, R.layout.students_row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        StudentListModel studentListModel=(StudentListModel)object;

        switch (v.getId())
        {
            case R.id.item_info:
                Toast.makeText(mContext, "Will open the test", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        StudentListModel studentListModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.students_row_item, parent, false);
            viewHolder.txtFirstName = convertView.findViewById(R.id.name);
            viewHolder.txtLastName = convertView.findViewById(R.id.type);
            viewHolder.txtGrade = convertView.findViewById(R.id.version_number);
            viewHolder.info = convertView.findViewById(R.id.item_info);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.txtFirstName.setText(studentListModel.getFirstName());
        viewHolder.txtLastName.setText(studentListModel.getLastName());
        viewHolder.txtGrade.setText(Double.toString(studentListModel.getGrade()));
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }

}
