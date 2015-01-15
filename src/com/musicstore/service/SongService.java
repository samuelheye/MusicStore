package com.musicstore.service;
 
import java.util.List;
 


import com.musicstore.model.Song;
 
public interface SongService {
 
    public void addSong(Song s);
    public void updateSong(Song s);
    public List<Song> listSongs();
    public Song getSongById(int id);
    public void removeSong(int id);
    public List<Song> findSongs(String criteria);
     
}