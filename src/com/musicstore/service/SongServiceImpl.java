package com.musicstore.service;
 
import java.util.List;
 



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 



import com.musicstore.dao.SongDAO;
import com.musicstore.model.Song;
 
@Service
public class SongServiceImpl implements SongService {
     
    private SongDAO SongDAO;
 
    public void setSongDAO(SongDAO SongDAO) {
        this.SongDAO = SongDAO;
    }
 
    @Override
    @Transactional
    public void addSong(Song s) {
        this.SongDAO.addSong(s);
    }
 
    @Override
    @Transactional
    public void updateSong(Song s) {
        this.SongDAO.updateSong(s);
    }
 
    @Override
    @Transactional
    public List<Song> listSongs() {
        return this.SongDAO.listSongs();
    }
 
    @Override
    @Transactional
    public Song getSongById(int id) {
        return this.SongDAO.getSongById(id);
    }
 
    @Override
    @Transactional
    public void removeSong(int id) {
        this.SongDAO.removeSong(id);
    }
    
    @Transactional
    public List<Song> findSongs(String criteria){
    	return this.SongDAO.findSongs(criteria);
    }
 
}