package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by redne on 7/4/2018.
 */

public class PlaceInfoViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setting the content view to the matching XML file created
        setContentView(R.layout.activity_place_info);

        String newString;
        String newStringForSub;
        int newImg=0;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
                newStringForSub= null;
                //newImg = 0;
            } else {
                newString= extras.getString("myTitle");
                newStringForSub= extras.getString("mySubTitle");
                newImg =  extras.getInt("myImg"); //note: this value is an int
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
            newStringForSub= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }

        // tunes ArrayList initialize, using ArrayList for variable size array
        ArrayList<Place> tunes = new ArrayList<Place>();

        //Add values to the ArrayList Tune for each
        //tunes.add(new Tune(newString,newStringForSub, R.drawable.scars));
        tunes.add(new Place(newString,newStringForSub,newImg));

        //initialize itemsAdapter using tunes ArrayList
        PlaceViewerAdapter itemsAdapter = new PlaceViewerAdapter(this, tunes, R.color.white_background);

        //Initialize listView as the list View from the applicable xml file
        ListView mylistView = findViewById(R.id.place_info);

        //set the adapter for listView (which is "list" view in the applicable xml) to itemsView using tunes
        mylistView.setAdapter(itemsAdapter);

        //LOGCAT Loop for values recording
        for(int index = 0; index < tunes.size(); index++){
            Log.v("PlaySong: ","Value at index " + index + ": " + tunes.get(index));
        }
    }
}
