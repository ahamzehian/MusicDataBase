package com.amirportfolio;

import com.amirportfolio.model.Artist;
import com.amirportfolio.model.DataSource;
import com.amirportfolio.model.DataSource1;
import com.amirportfolio.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        System.out.println();
        if(!dataSource.open()){
            System.out.println("Cannot open datasource");
            return;
        }

        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_ID);
        if(artists == null){
            System.out.println("No artists!");
            return;
        }

        for(Artist artist:artists) {
//            System.out.println("ID = " + artist.getId() + " | name = " + artist.getName());
            System.out.printf("ID = %-3d | name = %s\n",artist.getId(),artist.getName());
        }

        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Pink Floyd", DataSource.ORDER_BY_DESC);

        for(String album:albumsForArtist){
            System.out.println(album);
        }

        List<SongArtist> songArtists = dataSource.queryArtistFroSong("Go Your Own Way", DataSource.ORDER_BY_DESC);

        if(songArtists == null){
            System.out.println("Couldn't find the song!");
            return;
        }

        for(SongArtist songArtist:songArtists){
            System.out.println(songArtist.getArtistName() + " | " + songArtist.getAlbumName() + " | " + songArtist.getTrack());
        }

        dataSource.querySongsMetadata();


        int count = dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        dataSource.createViewForSongArtists();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String songTitle = scanner.nextLine();

        // TODO to do a SQL Injection Attack, Enter: " or 1=1 or "

        List<SongArtist> songArtists1 = dataSource.querySongInfoView(songTitle);
        if(songArtists1.isEmpty()){
            System.out.println("Couldn't find the song!");
            return;
        }

        for(SongArtist songArtist:songArtists1){
            System.out.println(songArtist.getArtistName() + "|" +
                    songArtist.getAlbumName() + "|" +
                    songArtist.getTrack());
        }

        dataSource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark",1);

        dataSource.close();

        // SELECT name, album, track FROM artist_list WHERE title = ? OR artist = ?
    }
}
