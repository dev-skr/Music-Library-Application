/*
 * 
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.song.model;
import javax.persistence.*;

import javax.persistence.GenerationType;

@Entity
@Table(name="playlist")
public class Song{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="songid")
    private int songId;

    @Column(name="songname")
    private String songName;

    @Column(name="lyricist")
    private String lyricist;

    @Column(name="singer")
    private String singer;

    @Column(name="musicdirector")
    private String musicDirector;

    public Song(){}
    

    public void setSongId(int songId){
        this.songId=songId;
    }

    public int getSongId(){
        return songId;
    }

    public void setSongName(String songName){
        this.songName=songName;
    }

    public String getSongName(){
        return songName;
    }

    public void setLyricist(String name){
        this.lyricist=name;
    }

    public String getLyricist(){
        return lyricist;
    }

    public void setSinger(String name){
        this.singer=name;
    }

    public String getSinger(){
        return singer;
    }

    public void setMusicDirector(String name){
        this.musicDirector=name;
    }

    public String getMusicDirector(){
        return musicDirector;
    }
}