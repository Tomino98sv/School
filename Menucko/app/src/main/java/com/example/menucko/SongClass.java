package com.example.menucko;

import java.io.Serializable;

public class SongClass implements Serializable {

    //serializable for converting object to sequence of bytes(remember type of data in object,stored data in object and type of object itself)

    //INTRISTING
    //After a serialized object has been written into a file,
    // it can be read from the file and deserialized that is,
    // the type information and bytes that represent the object
    // and its data can be used to recreate the object in memory.

    //Parcelable is faster(in way of procesing)

    private String songName;
    private String album;
    private int imageSource;

    public SongClass(String songName, String album, int imageSource) {
        this.songName = songName;
        this.album = album;
        this.imageSource = imageSource;
    }

    public String getSongName() {
        return songName;
    }

    public String getAlbum() {
        return album;
    }

    public int getImageSource() {
        return imageSource;
    }
}
