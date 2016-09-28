package edu.temple.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class PaletteActivity extends AppCompatActivity {
    boolean firstRun = true;
    String[] strings = {"White", "Red", "Yellow", "Green", "Blue"};
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner = (Spinner) findViewById(R.id.colorPicker);



        adapter = new CustomAdapter(PaletteActivity.this, android.R.layout.simple_spinner_dropdown_item, strings);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(firstRun)
                {
                    firstRun = false;
                }
                else{
                String color = adapter.getColor(position, view, parent);
                Intent launchActivityIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                launchActivityIntent.putExtra("Color", color);
                startActivity(launchActivityIntent);}

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }
}
