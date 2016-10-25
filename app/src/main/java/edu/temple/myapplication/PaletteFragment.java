package edu.temple.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;


public class PaletteFragment extends Fragment {
    static final String[] actualColors = {"White","Red","Green","Yellow","Blue"};
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    colorInterface activity;

    public PaletteFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PaletteFragment newInstance(String param1, String param2) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Resources res = getResources();
        String[] colorStrings = res.getStringArray(R.array.colorStrings);

       // CustomAdapter colors = new CustomAdapter(this.getContext(),);
         View v = inflater.inflate(R.layout.fragment_palette, container, false);
        ListView listView = (ListView) v.findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(getActivity().getApplicationContext(), R.layout.list_black_text, colorStrings);
        final CustomAdapter adapter2 = adapter;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String color = actualColors[position];
                activity.displayColor(null, color);
            }
        });

        return v;
    }



    @Override
    public void onAttach(Activity c) {
        super.onAttach(c);
        activity = (colorInterface) c;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    public interface colorInterface{
       void displayColor(View v, String color);
    }
}
