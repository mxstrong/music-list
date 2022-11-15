package musiclist.dtos;

import musiclist.models.Album;
import musiclist.models.Artist;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistOutDto {
    public String name;
    public List<String> albums;

    public ArtistOutDto(String name, List<String> albums) {
        this.name = name;
        this.albums = albums;
    }

    public static ArtistOutDto fromArtist(Artist artist) {
        return new ArtistOutDto(artist.getName(), artist.getAlbums().stream().map(Album::getName).collect(Collectors.toList()));
    }
}
