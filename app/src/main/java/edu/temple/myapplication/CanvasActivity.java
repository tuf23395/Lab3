package edu.temple.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Tom on 9/27/2016.
 */
public class CanvasActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);


        //  Retrieve the intent used to launch this instance of the activity
        Intent receivedIntent = getIntent();

        //  Grad the data that was passed.
        String intentDataString = receivedIntent.getExtras().getString("Color");

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor(intentDataString));

    }
}
