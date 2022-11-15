package musiclist.dtos;

import musiclist.models.Song;

public class SongOutDto {
    public String title;
    public String artist;
    public String album;

    public SongOutDto(String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public static SongOutDto fromSong(Song song) {
        return new SongOutDto(song.getTitle(), song.getArtist().getName(), song.getAlbum().getName());
    }
}
