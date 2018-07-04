package com.example.android.tourguideapp;

/**
 * Created by redne on 3/27/2018.
 *
 * */


/**
 * {@link Place} Stores and provides a single translation, from English to Japanese
 * */
public class Place {
    private String placeTitle;
    private String placeSubtitle;
    private int imageResourceID=-1;
    private int audioResourceID=-1;

    //constructor with two elemnets
    public Place(String jwordinput, String eWordInput){
        placeTitle = jwordinput;
        placeSubtitle = eWordInput;
    }

    //constructor with THREE elemnets
    public Place(String jWordInput, String eWordInput, int itemImageInput){
        placeTitle = jWordInput;
        placeSubtitle = eWordInput;
        imageResourceID = itemImageInput;
    }

    //constructor with THREE elemnets
    public Place(String jWordInput, int itemAudioInput, String eWordInput ){
        placeTitle = jWordInput;
        placeSubtitle = eWordInput;
        audioResourceID = itemAudioInput;
    }

    //constructor with FOUR elemnets
    public Place(String jWordInput, String eWordInput, int itemImageInput, int itemAudioInput){
        placeTitle = jWordInput;
        placeSubtitle = eWordInput;
        imageResourceID = itemImageInput;
        audioResourceID = itemAudioInput;
    }

    //Sets the Japanese Place
    public void setPlaceTitle(String jWordInput){
        placeTitle = jWordInput;
    }
    //Sets the English Place
    public void setWord(String eWordInput){
        placeSubtitle = eWordInput;
    }
    //sets the image
    public void setItemImage(int itemImageInput) { imageResourceID = itemImageInput; }
    //sets the audio
    public void setItemAudio(int itemAudioInput) { audioResourceID = itemAudioInput; }

    //Gets the Japanese Place
    public String getPlaceTitle(){
        return placeTitle;
    }
    //Gets the English word
    public String getPlaceSubtitle(){
        return placeSubtitle;
    }
    //get image
    public int getItemImage(){return imageResourceID; }
    //get image
    public int getItemAudio(){return audioResourceID; }

    //Checks if a resource has been assigned to the variable
    public boolean hasImage() {
        if (imageResourceID == -1)
            return false;
        else
            return true;
    }

    //Checks if a resource has been assigned to the variable
    public boolean hasAudio() {
        if (audioResourceID == -1)
            return false;
        else
            return true;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeTitle='" + placeTitle + '\'' +
                ", placeSubtitle='" + placeSubtitle + '\'' +
                ", imageResourceID=" + imageResourceID +
                ", audioResourceID=" + audioResourceID +
                '}';
    }
}
