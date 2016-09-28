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


        ListView listView = (ListView) findViewById(R.id.listView);



        adapter = new CustomAdapter(PaletteActivity.this, android.R.layout.simple_list_item_1, strings);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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



        });
    }
}
