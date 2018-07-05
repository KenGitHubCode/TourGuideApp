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
        places.add(new Place("Genbaku Dome", "Hiroshima Peace Memorial Park, Hiroshima", "The Hiroshima Peace Memorial (広島平和記念碑 Hiroshima Heiwa Kinenhi), originally the Hiroshima Prefectural Industrial Promotion Hall, and now commonly called the Genbaku Dome, Atomic Bomb Dome or A-Bomb Dome (原爆ドーム Genbaku Dōmu), is part of the Hiroshima Peace Memorial Park in Hiroshima, Japan and was designated a UNESCO World Heritage Site in 1996.[1] The ruin of the hall serves as a memorial to the people who were killed in the atomic bombing of Hiroshima on 6 August 1945. Over 70,000 people were killed instantly, and another 70,000 suffered fatal injuries from the radiation.[2]",
                R.drawable.h1dome));
        places.add(new Place("Children's Peace Monument", "Hiroshima Peace Memorial Park, Hiroshima", "The Children's Peace Monument (原爆の子の像 Genbaku no Ko no Zō, lit. \"Atomic Bomb Children Statue\") is a monument for peace to commemorate Sadako Sasaki and the thousands of child victims of the atomic bombing of Hiroshima. This monument is located in Hiroshima, Japan. Sadako Sasaki, a young girl, died of leukemia from radiation of the atomic bomb dropped on Hiroshima on 6 August 1945.",
                R.drawable.h2children));
        places.add(new Place("Hiroshima Peace Memorial Park", "Hiroshima Peace Memorial Park, Hiroshima", "Hiroshima Peace Memorial Park (広島平和記念公園 Hiroshima Heiwa Kinen Kōen) is a memorial park in the center of Hiroshima, Japan. It is dedicated to the legacy of Hiroshima as the first city in the world to suffer a nuclear attack, and to the memories of the bomb's direct and indirect victims (of whom there may have been as many as 140,000). The Hiroshima Peace Memorial Park is visited by thousands of people each year. The park is there in memory of the victims of the nuclear attack on August 6, 1945. On August 6,1945 the US dropped an atomic bomb on Hiroshima Japan.[1] The Hiroshima Peace Memorial Park was planned and designed by the Japanese Architect Kenzō Tange at Tange Lab.",
                R.drawable.h3park));
        places.add(new Place("Hiroshima Peace Memorial Museum", "Hiroshima Peace Memorial Park, Hiroshima", "The Hiroshima Peace Memorial Museum is a museum located in Hiroshima Peace Memorial Park, in central Hiroshima, Japan, dedicated to documenting the atomic bombing of Hiroshima in World War II.\n" +
                "\n" +
                "The museum was established in August 1955 with the Hiroshima Peace Memorial Hall (now the International Conference Center Hiroshima (ja)). It is the most popular of Hiroshima's destinations for school field-trips from all over Japan and for international visitors. 53 million people had visited the museum from its opening in 1955 through 2005, averaging over one million visitors per year. The architect of the main building was Kenzō Tange..",
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
