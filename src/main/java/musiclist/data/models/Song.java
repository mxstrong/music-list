package musiclist.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Song {
    private String title;
    private Artist artist;
    private Album album;
}
