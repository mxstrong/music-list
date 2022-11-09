package musiclist.data.models;

import lombok.Data;

import java.util.List;

@Data
public class Album {
    public String name;
    public Artist artist;
    public List<Song> songs;

    public Album(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }
}
