package com.example.song;

public class Song {

   private int songId;
   private String songName;
   private String lyricist;
   private String singer;
   private String musicDirection;

   public Song(int id, String name, String lyrics, String singer, String direction) {
      this.songId = id;
      this.songName = name;
      this.lyricist = lyrics;
      this.singer = singer;
      this.musicDirection = direction;
   }

   public void setSongId(int id) {
      this.songId = id;
   }

   public int getSongId() {
      return this.songId;
   }

   public void setSongName(String name) {
      this.songName = name;
   }

   public String getSongName() {
      return this.songName;
   }

   public void setLyricist(String lyrics) {
      this.lyricist = lyrics;
   }

   public String getLyricist() {
      return this.lyricist;
   }

   public void setSinger(String singer) {
      this.singer = singer;
   }

   public String getSinger() {
      return this.singer;
   }

   public void setMusicDirection(String direction) {
      this.musicDirection = direction;
   }

   public String getMusicDirection() {
      return this.musicDirection;
   }
}