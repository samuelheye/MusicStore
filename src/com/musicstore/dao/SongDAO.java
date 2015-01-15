package com.musicstore.dao;
 
import java.util.List;
 


import com.musicstore.model.Song;
 
public interface SongDAO {
 
    public void addSong(Song p);
    public void updateSong(Song p);
    public List<Song> listSongs();
    public Song getSongById(int id);
    public void removeSong(int id);
    public List<Song> findSongs(String criteria);
}