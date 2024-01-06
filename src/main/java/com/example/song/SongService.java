
/*
 * import org.springframework.http.HttpStatus;
 * import org.springframework.web.server.ResponseStatusException;
 * You can use the following import statements
 */

package com.example.song;

import java.util.*;

import com.example.song.Song;
import com.example.song.SongRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code

    // Write your code here
    int uniqueSongId = 6;

    @Override
    public ArrayList<Song> getSongs() {
        Collection<Song> songCollection = playlist.values();
        ArrayList<Song> songs = new ArrayList<>(songCollection);
        return songs;
    }

    @Override
    public Song getSongById(int songId) {
        Song song = playlist.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;
    }

    @Override
    public Song addSong(Song song) {
        song.setSongId(uniqueSongId);
        playlist.put(song.getSongId(), song);
        uniqueSongId++;
        return song;

    }

    @Override
    public Song updateSong(int songId, Song song) {

        Song exisitingSong = playlist.get(songId);

        if (exisitingSong == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (song.getLyricist() != null) {
            exisitingSong.setLyricist(song.getLyricist());
        }
        if (song.getSinger() != null) {
            exisitingSong.setSong(song.getSong());
        }
        if (song.getSongName() != null) {
            exisitingSong.setSongName(song.getSongName());
        }
        if (song.getMusicDirection() != null) {
            exisitingSong.setMusicDirection(song.getMusicDirection());
        }

        return exisitingSong;
    }

    @Override
    public void deleteSong(int songId) {
        Song song = playlist.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}