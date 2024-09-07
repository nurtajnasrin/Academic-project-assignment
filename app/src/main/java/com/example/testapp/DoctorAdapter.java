package com.example.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DoctorAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private ArrayList<String> mDoctorNames;

    public DoctorAdapter(Context context, ArrayList<String> doctorNames) {
        super(context, R.layout.list_item_doctor, doctorNames);
        this.mContext = context;
        this.mDoctorNames = doctorNames;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_doctor, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.doctorImage = convertView.findViewById(R.id.doctorImage);
            viewHolder.doctorName = convertView.findViewById(R.id.doctorName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set data to views
        viewHolder.doctorName.setText(mDoctorNames.get(position));
        viewHolder.doctorImage.setImageResource(R.drawable.default_image); // Set your image resource here

        return convertView;
    }

    static class ViewHolder {
        ImageView doctorImage;
        TextView doctorName;
    }
}
