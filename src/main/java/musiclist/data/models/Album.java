package musiclist.data.models;

import lombok.Data;

import java.util.List;

@Data
public class Album {
    private String name;
    private Artist artist;
    private List<Song> songs;

    public Album(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }
}
