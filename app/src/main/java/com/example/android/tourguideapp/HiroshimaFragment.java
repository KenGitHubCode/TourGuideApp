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

public class HiroshimaFragment extends Fragment {

    //Note there are no global variables for this application

    public HiroshimaFragment() {
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
        final ArrayList<Place> places = new ArrayList<>();
        // Add values to the ArrayList item
        // Images by Ken Muckey, information from Wikipedia as of 7/2018
        places.add(new Place(getString(R.string.hiro_1), getString(R.string.hiro_11), getString(R.string.hiro_111),
                R.drawable.h1dome));
        places.add(new Place(getString(R.string.hiro_2), getString(R.string.hiro_22), getString(R.string.hiro_222),
                R.drawable.h2children));
        places.add(new Place(getString(R.string.hiro_3), getString(R.string.hiro_33), getString(R.string.hiro_333),
                R.drawable.h3park));
        places.add(new Place(getString(R.string.hiro_4), getString(R.string.hiro_44), getString(R.string.hiro_4444),
                R.drawable.h4museum));

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
