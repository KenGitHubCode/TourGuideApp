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

public class OsakaFragment extends Fragment {

    //Note there are no global variables for this application

    public OsakaFragment() {
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
        places.add(new Place("Osaka Castle", "Osaka Prefecture", "Osaka Castle (大坂城 or 大阪城, Ōsaka-jō) is a Japanese castle in Chūō-ku, Osaka, Japan. The castle is one of Japan's most famous landmarks and it played a major role in the unification of Japan during the sixteenth century of the Azuchi-Momoyama period.[1]",
                R.drawable.o1));
        places.add(new Place("Umeda Sky Building", "Umeda district of Kita-ku, Osaka", "The Umeda Sky Building (梅田スカイビル Umeda Sukai Biru) is the nineteenth-tallest[1] building in Osaka Prefecture, Japan, and one of the city's most recognizable landmarks. It consists of two 40-story towers that connect at their two uppermost stories, with bridges and an escalator crossing the wide atrium-like space in the center.[2] It is located in Umeda district of Kita-ku, Osaka.",
                R.drawable.o2building));
        places.add(new Place("Dōtonbori", "Osaka Prefecture", "Dōtonbori or Dōtombori (道頓堀, pronounced [doːtomboɾi]) is one of the principal tourist destinations in Osaka, Japan, running along the Dōtonbori canal from Dōtonboribashi Bridge to Nipponbashi Bridge in the Namba district of the city's Chuo ward. Historically a theater district, it is now a popular nightlife and entertainment area characterized by its eccentric atmosphere and large illuminated signboards.\n" +
                "\n" +
                "One of the area's most prominent features, a billboard for confectionery company Glico displaying the image of a runner crossing a finishing line, is seen as an icon of Osaka within Japan.",
                R.drawable.o3dotonbori));

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

                //Switch based on position in ListView, hardcoded based on ArrayList addition order
                switch (i) {
                    case 0:
                        myIntent.putExtra("myTitle", places.get(i).getPlaceTitle());
                        myIntent.putExtra("mySubTitle", places.get(i).getPlaceSubtitle());
                        myIntent.putExtra("myDesc", places.get(i).getPlaceDesc());
                        myIntent.putExtra("myImg", places.get(i).getItemImage());
                        break;
                    case 1:
                        myIntent.putExtra("myTitle", places.get(i).getPlaceTitle());
                        myIntent.putExtra("mySubTitle", places.get(i).getPlaceSubtitle());
                        myIntent.putExtra("myDesc", places.get(i).getPlaceDesc());
                        myIntent.putExtra("myImg", places.get(i).getItemImage());
                        break;
                    case 2:
                        myIntent.putExtra("myTitle", places.get(i).getPlaceTitle());
                        myIntent.putExtra("mySubTitle", places.get(i).getPlaceSubtitle());
                        myIntent.putExtra("myDesc", places.get(i).getPlaceDesc());
                        myIntent.putExtra("myImg", places.get(i).getItemImage());
                        break;
                    default:
                        myIntent.putExtra("myTitle", "Item is missing.");
                        myIntent.putExtra("mySubTitle", places.get(0).getPlaceSubtitle());
                        myIntent.putExtra("myDesc", places.get(i).getPlaceDesc());
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
