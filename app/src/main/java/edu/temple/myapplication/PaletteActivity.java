package edu.temple.myapplication;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.MainThread;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.colorInterface {
    boolean twoPanes;
    boolean firstRun = true;


    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPanes = (findViewById(R.id.canvasFragment)!=null);



        Fragment firstFragment = new PaletteFragment();
        loadFragment(R.id.paletteFragment,firstFragment,false);
        if(twoPanes)
        {
            loadFragment(R.id.canvasFragment,new canvasFragment(),false);
        }


    }

    private void loadFragment(int paneID, Fragment fragment, boolean backStack){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction().replace(paneID,fragment);
        if(backStack){
            ft.addToBackStack(null);
        }
        ft.commit();
        fm.executePendingTransactions();
    }

    @Override
    public void displayColor(View v, String color)
    {
        if(twoPanes){
            canvasFragment cf = (canvasFragment) getFragmentManager().findFragmentById(R.id.canvasFragment);
            View view = this.getWindow().getDecorView();
            cf.displayColor(view, color);
        }
        else{
            canvasFragment cf = new canvasFragment();
            loadFragment(R.id.paletteFragment, cf, true);
            View view = this.getWindow().getDecorView();
            cf.displayColor(view, color);
        }
    }
}
