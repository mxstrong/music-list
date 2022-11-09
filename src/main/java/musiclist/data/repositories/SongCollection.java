package musiclist.data.repositories;

import lombok.Getter;
import musiclist.data.models.Album;
import musiclist.data.models.Artist;
import musiclist.data.models.Song;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SongCollection {
    private final List<Song> songs;
    private final List<Artist> artists;
    private final List<Album> albums;

    public SongCollection() {
        songs = new ArrayList<>();
        artists = new ArrayList<>();
        albums = new ArrayList<>();
    }
    public void addSong(Song song) {
        songs.add(song);
        var album = albums.stream().filter(a -> a.equals(song.album)).findAny();
        if (album.isPresent()) {
            if (album.get().songs == null) {
                album.get().songs = new ArrayList<>();
            }
            album.get().songs.add(song);
        }
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public void addAlbum(Album album) {
        albums.add(album);
        var artist = artists.stream().filter(a -> a.equals(album.artist)).findFirst();
        if (artist.isPresent()) {
            if (artist.get().albums == null) {
                artist.get().albums = new ArrayList<>();
            }
            artist.get().albums.add(album);
        }
    }
}
