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
        places.add(new Place("Hachikō Statue", "Shibuya, Tokyo", "Hachikō (ハチ公, November 10, 1923 – March 8, 1935) was an Akita dog born on a farm near the city of Ōdate, Akita Prefecture,[2] Japan. He is remembered for his remarkable loyalty to his owner, Hidesaburō Ueno, for whom he continued to wait for over nine years following his death.[3] Hachikō is known in Japanese as chūken Hachikō (忠犬ハチ公) \"faithful dog Hachikō\", hachi meaning \"eight\" and the suffix -kō indicating affection.[4] During his lifetime, the dog was held up in Japanese culture as an example of loyalty and fidelity. Well after his death, he continues to be remembered in worldwide popular culture, with statues, movies, books, and appearances in various media.",
                R.drawable.t1));
        places.add(new Place("Sensō-ji", "Asakusa, Tokyo", "Sensō-ji (金龍山浅草寺 Kinryū-zan Sensō-ji) is an ancient Buddhist temple located in Asakusa, Tokyo, Japan. It is Tokyo's oldest temple, and one of its most significant. Formerly associated with the Tendai sect of Buddhism, it became independent after World War II. Adjacent to the temple is a five-story pagoda, Shinto shrine, the Asakusa Shrine,[1] as well as many shops with traditional goods in the Nakamise-dōri[2]\n" +
                "\n" +
                "The Sensoji Kannon temple is dedicated to Kannon Bosatsu, the Bodhisattva of compassion, and is the most widely visited spiritual site in the world with over 30 million visitors annually.[3][4]\n" +
                "\n" +
                "It ranks among the top 10 temples in Japan for the number of visitors in the new year.",
                R.drawable.t2asakusa));
        places.add(new Place("Shinjuku Golden Gai", "Shinjuku, Tokyo", "Shinjuku Golden Gai (新宿ゴールデン街) is a small area of Shinjuku, Tokyo, Japan,[1] famous both as an area of architectural interest and for its nightlife. It is composed of a network of six narrow alleys, connected by even narrower passageways which are just about wide enough for a single person to pass through. Over 200 tiny shanty-style bars, clubs and eateries[2] are squeezed into this area. In this area, shooting photographs and video for commercial purposes on the street is prohibited without permission of the area's business promotion association.",
                R.drawable.t3goldengai));
        places.add(new Place("Genki Sushi", "Shibuya, Tokyo", "Genki Sushi was founded in 1968 with the promise of bringing sushi to the masses.\n" +
                "Today, now that Kaiten Sushi has become more familiar to the general population,our nextaim is to make our brand synonymous with sushi.\n" +
                "We want our brand to be the first thing people think of every time they think of eating sushi.\n" +
                "In order to achieve this, weare focusing all our energy on our customers.\n" +
                "Nothing gives us greater pleasure than exciting and impressing our customers with each plate we serve,and we believe that remaining true to this commitment will serve to increase our fan base and secure a solid footing in the sushi market.\n" +
                "Each and every one of our staff is committed to raising the quality in everything we do in order to excite and impress.\n" +
                "Genki Sushi will continue to pursue the high level of quality commonly associated with sushi in Japan.",
                R.drawable.t4genki));
        places.add(new Place("Owl Cafe", "Toshima-ku, Tokyo", "You can meet up to more than 20 small animals (somewhat rare?) in the Ikemofu Animal Room♪\n" +
                "Our highly unique staff members interact, play, and run around with guests...Please enjoy our relaxing space.",
                R.drawable.t5owl));
        places.add(new Place("Akihabara", "Chiyoda ward, Tokyo", "Akihabara (Japanese: 秋葉原) is a common name for the area around Akihabara Station in the Chiyoda ward of Tokyo, Japan. Administratively, the area called Akihabara mainly belongs to the Sotokanda (外神田) and Kanda-Sakumachō districts in Chiyoda. There exists an administrative district called Akihabara in the Taitō ward further north of Akihabara Station, but it is not the place people generally refer to as Akihabara.",
                R.drawable.t6akihabara));
        places.add(new Place("Ueno", "Taitō Ward, Tokyo", "Ueno (上野 upper wild field) is a district in Tokyo's Taitō Ward, best known as the home of Ueno Park. Ueno is also home to some of Tokyo's finest cultural sites, including the Tokyo National Museum, the National Museum of Western Art, and the National Museum of Nature and Science, as well as a major public concert hall. Many Buddhist temples are in the area, including the Bentendo temple dedicated to goddess Benzaiten, on an island in Shinobazu Pond. The Kan'ei-ji, a major temple of the Tokugawa shōguns, stood in this area, and its pagoda is now within the grounds of the Ueno Zoo. Nearby is the Ueno Tōshō-gū, a Shinto shrine dedicated to Tokugawa Ieyasu. Near the Tokyo National Museum there is The International Library of Children's Literature. Just south of the station is the Ameya-yokochō, a street market district that evolved out of an open-air black market that sprung up after World War II. Just east is the Ueno motorcycle district, with English-speaking staff available in some stores.",
                R.drawable.t7uano));

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
                    case 5:
                        myIntent.putExtra("myTitle", places.get(i).getPlaceTitle());
                        myIntent.putExtra("mySubTitle", places.get(i).getPlaceSubtitle());
                        myIntent.putExtra("myDesc", places.get(i).getPlaceDesc());
                        myIntent.putExtra("myImg", places.get(i).getItemImage());
                        break;
                    case 6:
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
