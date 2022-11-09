package musiclist.api.models;

import lombok.AllArgsConstructor;
import musiclist.data.models.Artist;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ArtistOutDto {
    public String name;
    public List<String> albums;

    public static ArtistOutDto fromArtist(Artist artist) {
        return new ArtistOutDto(artist.name, artist.albums.stream().map(album -> album.name).collect(Collectors.toList()));
    }
}
