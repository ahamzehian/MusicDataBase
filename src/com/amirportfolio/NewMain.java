package com.amirportfolio;

import com.amirportfolio.model.DataSource1;

public class NewMain {
    public static void main(String[] args) {
        DataSource1 dataSource1 = new DataSource1();

        dataSource1.createViewForSongArtists();
        
        if(!dataSource1.open()){
            System.out.println("Couldn't open the file.");
            return;
        }
        dataSource1.insertSong("Touch of Grey", "Grateful Dead", "In The Dark",1);
        dataSource1.close();
    }
}
