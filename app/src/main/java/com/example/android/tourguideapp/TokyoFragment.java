package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Ken Muckey on 7/1/2018.
 */

public class TokyoFragment extends Fragment {

    //Note there are no global variables for this application

    public TokyoFragment() {
        // REQUIRED empty public constructor
    }

    /**
     * OnCreateView - used instead of OnCreate due to fragment requirements
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create and set rootView to inflate the list within the container
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create ArrayList  , using ArrayList for variable size array
        final ArrayList<Place> places = new ArrayList<Place>();
        // Add values to the ArrayList item
        places.add(new Place(getString(R.string.tokyo_1), getString(R.string.tokyo_fg), getString(R.string.tokyo_f),
                R.drawable.t1));
        places.add(new Place(getString(R.string.tokyo_2), getString(R.string.tokyodd), getString(R.string.tokyo_e) +
                getString(R.string.tokyo_dbrd),
                R.drawable.t2asakusa));
        places.add(new Place(getString(R.string.tokyo_3), getString(R.string.tokyo_mm), getString(R.string.tokyo_eee),
                R.drawable.t3goldengai));
        places.add(new Place(getString(R.string.tokyo_4), getString(R.string.tokyo_mmmm), getString(R.string.tokyo_w3) +
                getString(R.string.tokyo_qwe) +
                getString(R.string.tokyo_nm),
                R.drawable.t4genki));
        places.add(new Place(getString(R.string.tokyo_5), getString(R.string.tokyo_4yh), getString(R.string.tokyo_tfjrty) +
                getString(R.string.tokyo_nhgfde),
                R.drawable.t5owl));
        places.add(new Place(getString(R.string.tokyo_6), getString(R.string.tokyo_hil), getString(R.string.tokyo_45tg),
                R.drawable.t6akihabara));
        places.add(new Place(getString(R.string.tokyo_7), getString(R.string.tokyo_57j76), getString(R.string.tokyo_get4egr),
                R.drawable.t7uano));
        places.add(new Place(getString(R.string.tokyo_8), getString(R.string.tokyo_r45h5), getString(R.string.tokyo_r56yh),
                R.drawable.t8harajuku));
        places.add(new Place(getString(R.string.tokyo_9), getString(R.string.tokyo_45ret), getString(R.string.tokyo_y6k87),
                R.drawable.t9ghibli));

        //initialize itemsAdapter using places ArrayList
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        //Initialize listView as the list View from the applicable xml file
        ListView listView = rootView.findViewById(R.id.list);
        //set the adapter for listView (which is "list" view in the applicable xml) to itemsView using places
        listView.setAdapter(adapter);


        /**
         *  Set on item click listener block
         *  Creates Variable of clicked item, assigns intent values and starts activity
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Creating a Class variable to hold the destination activity depending on Switch below
                Class myActivityToIntent = PlaceInfoViewer.class;

                // Create a new intent to open the {@link applicable activity}
                Intent myIntent = new Intent(getActivity().getApplicationContext(), myActivityToIntent);

                //Assign values based on position in ListView, hardcoded based on ArrayList addition order
                myIntent.putExtra(getString(R.string.myTitle), places.get(i).getPlaceTitle());
                myIntent.putExtra(getString(R.string.mySubTitle), places.get(i).getPlaceSubtitle());
                myIntent.putExtra(getString(R.string.myDesc), places.get(i).getPlaceDesc());
                myIntent.putExtra(getString(R.string.myImg), places.get(i).getItemImage());

                // Start the new activity
                startActivity(myIntent);

            }
        }); // END setOnItemClickListener

        // Inflate the layout for this fragment
        return rootView;
    } // End OnCreateView

} // END class
