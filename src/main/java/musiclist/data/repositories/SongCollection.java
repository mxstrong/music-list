package musiclist.data.repositories;

import lombok.Getter;
import musiclist.data.models.Album;
import musiclist.data.models.Artist;
import musiclist.data.models.Song;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Getter
@Scope("singleton")
public class SongCollection {
    private final List<Song> songs;
    private final List<Artist> artists;
    private final List<Album> albums;

    public SongCollection() {
        songs = new ArrayList<>();
        artists = new ArrayList<>();
        albums = new ArrayList<>();
    }
    public Song addSong(String name, String albumName, String artistName) {
        var album = albums.stream().filter(a -> a.getName().equals(albumName)).findAny();
        var artist = artists.stream().filter(a -> a.getName().equals(artistName)).findAny();
        if (album.isEmpty() || artist.isEmpty()) {
            return null;
        }
        var song = new Song(name, artist.get(), album.get());
        songs.add(song);
        if (album.get().getSongs() == null) {
            album.get().setSongs(new ArrayList<>());
        }
        album.get().getSongs().add(song);
        return song;
    }

    public Artist addArtist(String name) {
        var artist = new Artist(name);
        artists.add(artist);
        return artist;
    }

    public Album addAlbum(String name, String artistName) {
        var artist = artists.stream().filter(a -> a.getName().equals(artistName)).findFirst();
        if (artist.isEmpty()) {
            return null;
        }
        var album = new Album(name, artist.get());
        albums.add(album);
        if (artist.get().getAlbums() == null) {
            artist.get().setAlbums(new ArrayList<>());
        }
        artist.get().getAlbums().add(album);
        return album;
    }

    public void deleteSong(String name) {
        getSongs().removeIf(song -> song.getTitle().equalsIgnoreCase(name));
    }

    public void deleteAlbum(String name) {
        getSongs().removeIf(song -> song.getAlbum().getName().equalsIgnoreCase(name));
        getAlbums().removeIf(album -> album.getName().equalsIgnoreCase(name));
    }

    public void deleteArtist(String name) {
        getSongs().removeIf(song -> song.getArtist().getName().equalsIgnoreCase(name));
        getAlbums().removeIf(album -> album.getArtist().getName().equalsIgnoreCase(name));
        getArtists().removeIf(artist -> artist.getName().equalsIgnoreCase(name));
    }
}
