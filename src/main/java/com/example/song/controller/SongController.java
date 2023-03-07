/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 import java.util.*;

import com.example.song.service.SongJpaService;
import com.example.song.model.Song;

 @RestController
public class SongController{

    @Autowired
    public SongJpaService service;

@GetMapping("/songs")
public ArrayList<Song> totalSongs(){
return service.getSongs();
}

@PostMapping("/songs")

public Song createSong(@RequestBody Song song){
    return service.postSong(song);
}

@GetMapping("/songs/{songId}")
public Song getSongById(@PathVariable("songId") int songId){
    return service.getSong(songId);
}

@PutMapping("/songs/{songId}")
public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song){
    return service.putSong(songId,song);
}

@DeleteMapping("songs/{songId}")
public void deleteSongFromPlaylist(@PathVariable("songId") int songId){
    service.deleteSong(songId);
}

}