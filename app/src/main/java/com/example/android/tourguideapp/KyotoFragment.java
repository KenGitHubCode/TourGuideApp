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

public class KyotoFragment extends Fragment {

    //Note there are no global variables for this application

    public KyotoFragment() {
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
        places.add(new Place("Yasaka Shrine", "Gion, Kyoto", "Gion is a district of Kyoto, Japan, originally developed in the Sengoku period, in front of Yasaka Shrine. The district was built to accommodate the needs of travelers and visitors to the shrine.",
                R.drawable.k1));
        places.add(new Place("Neko Café Time", "Fushimi ward, Kyoto", "We are a cat café of 13 cats near Fushimi Inari in Kyoto! The cat staff that often appears in front of the camera includes Goma (black), Rai (orange and white) and Mikan (calico) with many others! Watch them play, sleep and enjoy themselves like only cats do!",
                R.drawable.k3));
        places.add(new Place("Fushimi Inari-taisha", "Fushimi-ku, Kyoto", "Fushimi Inari Taisha (伏見稲荷大社) is the head shrine of the god Inari, located in Fushimi Ward in Kyoto, Japan. The shrine sits at the base of a mountain also named Inari which is 233 metres (764 ft) above sea level, and includes trails up the mountain to many smaller shrines which span 4 kilometres (2.5 mi) and take approximately 2 hours to walk up.[1]\n" +
                "\n" +
                "First and foremost, Inari is the god of rice, but merchants and manufacturers have traditionally worshiped Inari as the patron of business. Each of the torii at Fushimi Inari Taisha has been donated by a Japanese business.\n" +
                "\n" +
                "This popular shrine is said to have as many as 32,000 sub-shrines (bunsha (分社)) throughout Japan.[2]",
                R.drawable.k2));
        places.add(new Place("Kyoto Station", "Shimogyo Ward, Kyoto", "Kyoto Station (京都駅 Kyōto-eki) is a major railway station and transportation hub in Kyoto, Japan. It has Japan's second-largest station building (after Nagoya Station) and is one of the country's largest buildings, incorporating a shopping mall, hotel, movie theater, Isetan department store, and several local government facilities under one 15-story roof. It also housed the Kyoto City Air Terminal until August 31, 2002.",
                R.drawable.k4));
        places.add(new Place("Sagano Scenic Railway", "Kyoto, Kyoto Prefecture", "The Sagano Scenic Railway (嵯峨野観光鉄道 Sagano Kankō Tetsudō) or Sagano Sightseeing Railway is a wholly owned subsidiary of West Japan Railway Company (JR West) that operates the Sagano Scenic Line (嵯峨野観光線 Sagano Kankō-sen), Sagano Sight-seeing Line, or Sagano Romantic Train (嵯峨野トロッコ列車 Sagano Torokko Ressha) in Kyoto.\n" +
                "\n" +
                "The line uses superseded tracks of the Sagano Line (officially a portion of the San'in Main Line) of JR West, from Torokko Saga in Arashiyama, and passes a gorge offering a scenic view along the Hozu River, then enters and terminates in the basin of Kameoka. It is closed on Wednesdays and in the winter.\n" +
                "\n" +
                "The line is locally known as \"Torokko in Hozu gorge\". Torokko is a Japanese word derived from the English \"truck\" once used for mining cars hauling ore, but presently means rail carriages basic accommodation and open sides.",
                R.drawable.k5sagano));

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
                    case 3:
                        myIntent.putExtra("myTitle", places.get(i).getPlaceTitle());
                        myIntent.putExtra("mySubTitle", places.get(i).getPlaceSubtitle());
                        myIntent.putExtra("myDesc", places.get(i).getPlaceDesc());
                        myIntent.putExtra("myImg", places.get(i).getItemImage());
                        break;
                    case 4:
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

