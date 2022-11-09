package musiclist.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Song {
    public String title;
    public Artist artist;
    public Album album;
}
