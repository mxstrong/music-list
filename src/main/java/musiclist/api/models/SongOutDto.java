package musiclist.api.models;

import lombok.AllArgsConstructor;
import musiclist.data.models.Song;

@AllArgsConstructor
public class SongOutDto {
    public String title;
    public String artist;
    public String album;

    public static SongOutDto fromSong(Song song) {
        return new SongOutDto(song.title, song.artist.name, song.album.name);
    }
}
