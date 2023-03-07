/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.song.service;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.song.repository.SongRepository;
import com.example.song.model.Song;
import com.example.song.repository.SongJpaRepository;

@Service
public class SongJpaService implements SongRepository{

@Autowired
public SongJpaRepository songJpaRepo;

@Override
    public ArrayList<Song> getSongs(){
        List<Song> tempList= songJpaRepo.findAll();
        ArrayList<Song> list=new ArrayList<>(tempList);
        return list;
    }

    @Override
    public Song postSong(Song song){
        Song song1 =songJpaRepo.save(song);
        return song1;
    }

    @Override
    public Song getSong(int id){
       try{     
        Song song = songJpaRepo.findById(id).get();
        return song;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song putSong(int id, Song song){
        
        try{
            Song existSong = songJpaRepo.findById(id).get();

            if(song.getSongName() != null)
            existSong.setSongName(song.getSongName());

            if(song.getLyricist() !=null)
            existSong.setLyricist(song.getLyricist());

            if(song.getSinger() !=null)
            existSong.setSinger(song.getSinger());

            if(song.getMusicDirector() !=null)
            existSong.setMusicDirector(song.getMusicDirector());

            songJpaRepo.save(existSong);

            return existSong;

        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteSong(int id){

        try{
            Song existSong = songJpaRepo.findById(id).get();

            songJpaRepo.deleteById(id);

        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
      
    }

}