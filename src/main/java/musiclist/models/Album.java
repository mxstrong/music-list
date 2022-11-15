package musiclist.models;

import java.util.List;

public class Album {
    private String name;
    private Artist artist;
    private List<Song> songs;

    public Album(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return this.name;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public List<Song> getSongs() {
        return this.songs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
