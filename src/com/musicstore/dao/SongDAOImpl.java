package com.musicstore.dao;
 
import java.util.List;
 


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
 


import com.musicstore.model.Song;
 
@Repository
public class SongDAOImpl implements SongDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(SongDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addSong(Song s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
        logger.info("Song saved successfully, Song Details="+s);
    }
 
    @Override
    public void updateSong(Song s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
        logger.info("Song updated successfully, Song Details="+s);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Song> listSongs() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Song> SongsList = session.createQuery("from Song").list();
        for(Song s : SongsList){
            logger.info("Song List::"+s);
        }
        return SongsList;
    }
 
    @Override
    public Song getSongById(int id) {
        Session session = this.sessionFactory.getCurrentSession();     
        Song p = (Song) session.load(Song.class, new Integer(id));
        logger.info("Song loaded successfully, Song details="+p);
        return p;
    }
 
    @Override
    public void removeSong(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Song s = (Song) session.load(Song.class, new Integer(id));
        if(null != s){
            session.delete(s);
        }
        logger.info("Song deleted successfully, Song details="+s);
    }
    
    //finds song by song name or artist name
    @SuppressWarnings("unchecked")
    public List<Song> findSongs(String criteria) {
    	Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"from Song s where s.id IN (SELECT s1.id from Song s1 where UPPER(s1.name) LIKE :name) " +
		"OR s.id IN (SELECT s2.id from Song s2 where UPPER(s2.artist) LIKE :name)");
		query.setString("name", criteria.toUpperCase() + "%");
		List<Song> songsList = query.list();
		return songsList;
	}
 
}