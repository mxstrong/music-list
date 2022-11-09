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
    public void addSong(String name, String albumName, String artistName) {
        var album = albums.stream().filter(a -> a.getName().equals(albumName)).findAny();
        var artist = artists.stream().filter(a -> a.getName().equals(artistName)).findAny();
        if (album.isEmpty() || artist.isEmpty()) {
            return;
        }
        var song = new Song(name, artist.get(), album.get());
        songs.add(song);
        if (album.get().getSongs() == null) {
            album.get().setSongs(new ArrayList<>());
        }
        album.get().getSongs().add(song);
    }

    public void addArtist(String name) {
        artists.add(new Artist(name));
    }

    public void addAlbum(String name, String artistName) {
        var artist = artists.stream().filter(a -> a.getName().equals(artistName)).findFirst();
        if (artist.isEmpty()) {
            return;
        }
        var album = new Album(name, artist.get());
        albums.add(album);
        if (artist.get().getAlbums() == null) {
            artist.get().setAlbums(new ArrayList<>());
        }
        artist.get().getAlbums().add(album);
    }
}
