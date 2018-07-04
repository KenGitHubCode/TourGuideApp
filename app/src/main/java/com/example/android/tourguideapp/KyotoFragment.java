package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
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

public class KyotoFragment extends Fragment {

    /**
     * global variables
     */
    //private Context mContext;

    //REQUIRED empty public constructor
    public KyotoFragment() {
        // REQUIRED empty public constructor
    }

    /**
     * OnCreateView - used instead of OnCreate due to fragment requirements
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create and set rootView to inflate the list within the container
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Set context
        // mContext = getActivity().getApplicationContext();

        // Create ArrayList  , using ArrayList for variable size array
        final ArrayList<Place> places = new ArrayList<Place>();
        // Add values to the ArrayList item
        places.add(new Place("Neko Café Time", "Fushimi ward, Kyoto", R.drawable.k5));
        places.add(new Place("Fushimi Inari-taisha", "Fushimi-ku, Kyoto", R.drawable.k2));
        places.add(new Place("Kyoto Station", "Shimogyo Ward, Kyoto", R.drawable.k4));

        //initialize itemsAdapter using places ArrayList
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.white_background);
        //Initialize listView as the list View from the applicable xml file
        ListView listView = (ListView) rootView.findViewById(R.id.list);
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

                //Switch based on position in ListView, hardcoded based on ArrayList addition order
                switch (i) {
                    case 0:
                        myIntent.putExtra("myTitle", places.get(i).getPlaceTitle());
                        myIntent.putExtra("mySubTitle", places.get(i).getPlaceSubtitle());
                        myIntent.putExtra("myImg", places.get(i).getItemImage());
                        break;
                    case 1:
                        myIntent.putExtra("myTitle", places.get(i).getPlaceTitle());
                        myIntent.putExtra("mySubTitle", places.get(i).getPlaceSubtitle());
                        myIntent.putExtra("myImg", places.get(i).getItemImage());
                        break;
                    default:
                        myIntent.putExtra("myTitle", "Item is missing.");
                        myIntent.putExtra("mySubTitle", places.get(0).getPlaceSubtitle());
                        myIntent.putExtra("myImg", places.get(0).getItemImage());
                        break;
                } // End Switch
                // Start the new activity
                startActivity(myIntent);

            }
        }); // END setOnItemClickListener

        // Inflate the layout for this fragment
        return rootView;
    } // End OnCreateView

} // END class

