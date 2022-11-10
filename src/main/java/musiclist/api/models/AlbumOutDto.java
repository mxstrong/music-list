package musiclist.api.models;

import lombok.AllArgsConstructor;
import musiclist.data.models.Album;
import musiclist.data.models.Song;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AlbumOutDto {
    public String name;
    public String artist;
    public List<String> songs;

    public static AlbumOutDto fromAlbum(Album album) {
        return new AlbumOutDto(album.getName(), album.getArtist().getName(), album.getSongs() == null ? null : album.getSongs().stream().map(Song::getTitle).collect(Collectors.toList()));
    }
}
