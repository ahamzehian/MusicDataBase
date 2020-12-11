package com.amirportfolio.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static final String DB_NAME = "music.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\amirh\\IdeaProjects\\MusicDB\\" + DB_NAME;
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;
    public static final String ALBUMS_ID = TABLE_ALBUMS + "." + COLUMN_ALBUM_ID;
    public static final String ALBUMS_NAME = TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME;
    public static final String ALBUMS_ARTIST = TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;
    public static final String ARTISTS_ID = TABLE_ARTISTS + "." + COLUMN_ARTIST_ID;
    public static final String ARTISTS_NAME = TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_SONG = 3;
    public static final int INDEX_SONG_ALBUM = 4;
    public static final String SONGS_ID = TABLE_SONGS + "." + COLUMN_SONG_ID;
    public static final String SONGS_TRACK = TABLE_SONGS + "." + COLUMN_SONG_TRACK;
    public static final String SONGS_TITLE = TABLE_SONGS + "." + COLUMN_SONG_TITLE;
    public static final String SONGS_ALBUM = TABLE_SONGS + "." + COLUMN_SONG_ALBUM;

    public static final int ORDER_BY_ID = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                    " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " WHERE " +
                    TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = \"";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_FOR_SONG_ARTIST =
            "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONG_TRACK + " FROM " +
                    TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " +
                    TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " INNER JOIN " +
                    TABLE_ARTISTS + " ON " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " WHERE " +
                    TABLE_SONGS + "." + COLUMN_SONG_TITLE + "=\"";

    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
            " FROM " + TABLE_SONGS +
            " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS +
            "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
            " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
            " ORDER BY " +
            TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + " COLLATE NOCASE";

    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = ?";  // the code will replace ? with input.

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
            '(' + COLUMN_ARTIST_NAME + ") VALUES(?)";
    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS +
            '(' + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";

    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
            '(' + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM +
            ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";

    private Connection conn;

    private PreparedStatement querySongInfoView;

    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;

    public boolean open(){
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);

            return true;
        }catch(SQLException e){
            System.out.println("Error 001: Open method failed!");
            e.printStackTrace();
            return false;
        }
    }

    public void close(){
        try{

            if(querySongInfoView != null){
                querySongInfoView.close();
            }

            if(insertIntoArtists != null){
                insertIntoArtists.close();
            }

            if(insertIntoAlbums != null){
                insertIntoAlbums.close();
            }

            if(insertIntoSongs != null){
                insertIntoSongs.close();
            }

            if(queryArtist != null){
                queryArtist.close();
            }

            if(queryAlbum != null){
                queryAlbum.close();
            }

            if(conn != null)
                conn.close();
        }catch(SQLException e){
            System.out.println("Error 002: Close method failed!");
            e.printStackTrace();
        }
    }

    public List<Artist> queryArtists(int sortOrder){

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if(sortOrder != ORDER_BY_ID){
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else{
                sb.append("ASC");
            }
        }

        try(Statement statement = conn.createStatement();
        //ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS)
             ResultSet resultSet = statement.executeQuery(sb.toString())){

            List<Artist> artists = new ArrayList<>();
            while(resultSet.next()){
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;

        }catch(SQLException e){
            System.out.println("Error 003: query artist failed!");
            e.printStackTrace();
            return null;
        }
    }

    public List<String> queryAlbumsForArtist(String artistName, int sortOrder){

        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artistName);
        sb.append("\"");

        if(sortOrder != ORDER_BY_ID){
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            if(sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else{
                sb.append("ASC");
            }
        }

        System.out.println("SQL statement = " + sb.toString());

//        List<String> result = new ArrayList<>();
        try(Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sb.toString())){
            List<String> result = new ArrayList<>();
            while(resultSet.next()){
                result.add(resultSet.getString(1));
            }

            return result;

        }catch(SQLException e){
            System.out.println("Error 004: query albums for artist failed!");
            e.printStackTrace();
            return null;
        }

    }

    public List<SongArtist> queryArtistFroSong(String songName, int sortOrder){

        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_ARTIST);
        sb.append(songName);
        sb.append("\"");

        if(sortOrder != ORDER_BY_ID){
            sb.append(QUERY_ARTIST_FOR_SONG_SORT);
            if(sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else{
                sb.append("ASC");
            }
        }

        System.out.println("SQL statement: " + sb.toString());

        List<SongArtist> list = new ArrayList<>();

        try(Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sb.toString())){

            while(resultSet.next()){
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(resultSet.getString(1));
                songArtist.setAlbumName(resultSet.getString(2));
                songArtist.setTrack(resultSet.getInt(3));
                list.add(songArtist);
            }

            return list;

        }catch(SQLException e){
            System.out.println("Error 005: query artist for song failed!");
            e.printStackTrace();
            return null;
        }

    }

    public void querySongsMetadata(){

        String sql = "SELECT * FROM " + TABLE_SONGS;

        try(Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){

            ResultSetMetaData metaData = resultSet.getMetaData();
            int numColumns = metaData.getColumnCount();
            for(int i=1;i<=numColumns;i++){
                System.out.printf("Column %d in the songs table is names %s\n",i, metaData.getColumnName(i));
            }

        }catch(SQLException e){
            System.out.println("Error 006: Query songs metadata failed!");
            e.printStackTrace();
        }

    }

    public int getCount(String table){
        String sql = "SELECT COUNT(*) AS count, MIN(_id) AS min_id FROM " + table;
        try(Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){

//            int count = resultSet.getInt(1);
            int count = resultSet.getInt("count");

//            int min = resultSet.getInt(2);
            int min = resultSet.getInt("min_id");

            System.out.printf("Count = %d, Min = %d\n", count, min);
            return count;

        }catch(SQLException e){
            System.out.println("Error 007: get count method failed!");
            return -1;
        }
    }

    public boolean createViewForSongArtists(){
//        System.out.println(CREATE_ARTIST_FOR_SONG_VIEW);
        try(Statement statement = conn.createStatement()){

            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;

        }catch (SQLException e){
            System.out.println("Error 008: Create view for song artists failed!");
            e.printStackTrace();
            return false;
        }
    }

    // SELECT name, album, track FROM artist_list WHERE title = "title"
    public List<SongArtist> querySongInfoView(String title){
        StringBuilder sb = new StringBuilder(QUERY_VIEW_SONG_INFO);
        sb.append(title);
        sb.append("\"");

        System.out.println(sb.toString());

        // TODO This code is volnurable to SQL Injection Attack.
//        try(Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery(sb.toString())){
//
//            List<SongArtist> songArtists = new ArrayList<>();
//
//            while(resultSet.next()){
//                SongArtist songArtist = new SongArtist();
//                songArtist.setTrack(resultSet.getInt(3));
//                songArtist.setAlbumName(resultSet.getString(2));
//                songArtist.setArtistName(resultSet.getString(1));
//                songArtists.add(songArtist);
//            }
//
//            return songArtists;
//
//        }catch(SQLException e){
//            System.out.println("Error 008: query song info view failed!");
//            e.printStackTrace();
//            return null;
//        }


        try{
            querySongInfoView.setString(1, title);
            ResultSet resultSet = querySongInfoView.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();

            while(resultSet.next()){
                SongArtist songArtist = new SongArtist();
                songArtist.setTrack(resultSet.getInt(3));
                songArtist.setAlbumName(resultSet.getString(2));
                songArtist.setArtistName(resultSet.getString(1));
                songArtists.add(songArtist);
            }

            return songArtists;

        }catch(SQLException e){
            System.out.println("Error 008: query song info view failed!");
            e.printStackTrace();
            return null;
        }

    }

    private int insertArtist(String name) throws SQLException{

        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();
        if(results.next()){
            return results.getInt(1);
        }else{
            insertIntoArtists.setString(1,name);
            int affestRows = insertIntoArtists.executeUpdate();

            if(affestRows != 1){
                throw new SQLException("Error 009: Couldn't insert artist!");
            }

            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            }else{
                throw new SQLException("Error 010: Couldn't get _id for the artist!");
            }
        }

    }

    private int insertAlbum(String name, int artistId) throws SQLException{

        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();
        if(results.next()){
            return results.getInt(1);
        }else{
            insertIntoAlbums.setString(1,name);
            insertIntoAlbums.setInt(2, artistId);
            int affestRows = insertIntoAlbums.executeUpdate();

            if(affestRows != 1){
                throw new SQLException("Error 011: Couldn't insert album!");
            }

            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            }else{
                throw new SQLException("Error 012: Couldn't get _id for the album!");
            }
        }

    }

    public void insertSong(String title, String artist, String album, int track) {

        try{
            conn.setAutoCommit(false);

            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);
            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);
            int affectedRows = insertIntoSongs.executeUpdate();
            if(affectedRows == 1){
                conn.commit();
            }else{
                throw new SQLException("Error 012.5: The song insert failed!");
            }

        }catch(SQLException e){
            System.out.println("Error 013: Couldn't insert song!");
            e.printStackTrace();
            try{
                System.out.println("Performing rollback");
                conn.rollback();
            }catch(SQLException e1){
                System.out.println("Error 014: Things are really bad! ");
                e1.printStackTrace();
            }
        }finally{
            try{
                System.out.println("Resetting default commit behaviour");
                conn.setAutoCommit(true);
            }catch(SQLException e2){
                System.out.println("Error 015: Resetting auto-commit failed!");
                e2.printStackTrace();
            }
        }

    }

}
