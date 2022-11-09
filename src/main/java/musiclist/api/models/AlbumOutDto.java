package musiclist.api.models;

import lombok.AllArgsConstructor;
import musiclist.data.models.Album;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AlbumOutDto {
    public String name;
    public String artist;
    public List<String> songs;

    public static AlbumOutDto fromAlbum(Album album) {
        return new AlbumOutDto(album.name, album.artist.name, album.songs.stream().map(song -> song.title).collect(Collectors.toList()));
    }
}
