package edu.temple.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Tom on 9/27/2016.
 */
public    class CustomAdapter extends ArrayAdapter {
    static final String[] actualColors = {"White","Red","Green","Yellow","Blue"};
    String[] Colors;
    public CustomAdapter(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
        Colors = (String[]) objects;
    }

    @Override
      public View getView(int position, View convertView, ViewGroup parent){
        View v = super.getView(position, convertView, parent);
        v.setBackgroundColor(Color.parseColor(actualColors[position]));
        return v;
    }

    public String getColor(int position, View convertView, ViewGroup parent){
        View v = super.getView(position, convertView, parent);
        return Colors[position];
    }
}
