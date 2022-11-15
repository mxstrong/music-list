package musiclist.dtos;

import musiclist.models.Album;
import musiclist.models.Song;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumOutDto {
    public String name;
    public String artist;
    public List<String> songs;

    public AlbumOutDto(String name, String artist, List<String> songs) {
        this.name = name;
        this.artist = artist;
        this.songs = songs;
    }

    public static AlbumOutDto fromAlbum(Album album) {
        return new AlbumOutDto(album.getName(), album.getArtist().getName(), album.getSongs() == null ? null : album.getSongs().stream().map(Song::getTitle).collect(Collectors.toList()));
    }
}
