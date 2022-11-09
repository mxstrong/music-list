package musiclist.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Artist {
    public String name;
    public List<Album> albums;

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }
}
