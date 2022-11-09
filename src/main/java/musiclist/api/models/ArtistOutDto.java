package musiclist.api.models;

import lombok.AllArgsConstructor;
import musiclist.data.models.Album;
import musiclist.data.models.Artist;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ArtistOutDto {
    public String name;
    public List<String> albums;

    public static ArtistOutDto fromArtist(Artist artist) {
        return new ArtistOutDto(artist.getName(), artist.getAlbums().stream().map(Album::getName).collect(Collectors.toList()));
    }
}
