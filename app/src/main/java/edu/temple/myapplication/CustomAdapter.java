package edu.temple.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Tom on 9/27/2016.
 */
public    class CustomAdapter extends ArrayAdapter {
    String[] Colors;
    public CustomAdapter(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
        Colors = (String[]) objects;
    }

    @Override
      public View getView(int position, View convertView, ViewGroup parent){
        View v = super.getView(position, convertView, parent);

        v.setBackgroundColor(Color.parseColor(Colors[position]));
        return v;
    }

    public String getColor(int position, View convertView, ViewGroup parent){
        View v = super.getView(position, convertView, parent);

        return Colors[position];
    }
}
