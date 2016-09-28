package edu.temple.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

/**
 * Created by Tom on 9/27/2016.
 */
public class CanvasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Canvas Activity");
        setContentView(R.layout.activity_canvas);


        //  Retrieve the intent used to launch this instance of the activity
        Intent receivedIntent = getIntent();

        //  Grad the data that was passed.
        String intentDataString = receivedIntent.getExtras().getString("Color");

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor(intentDataString));;

    }
}
