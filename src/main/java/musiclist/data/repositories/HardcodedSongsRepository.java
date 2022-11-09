package musiclist.data.repositories;

import musiclist.data.models.Album;
import musiclist.data.models.Artist;
import musiclist.data.models.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HardcodedSongsRepository {
    private final List<Song> songs;

    public HardcodedSongsRepository() {
        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Polyphia"));
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Remember That You Will Die", artists.get(0)));
        songs = new ArrayList<>();
        songs.add(new Song("Playing God", artists.get(0), albums.get(0)));
    }

    public List<Song> getSongsBySearch(String name, String album, String artist) {
        return songs.stream()
                .filter(song -> name == null || song.title.toLowerCase().contains(name.toLowerCase()) || name.toLowerCase().contains(song.title.toLowerCase()))
                .filter(song -> album == null || song.album.name.toLowerCase().contains(album.toLowerCase()) || album.toLowerCase().contains(song.album.name.toLowerCase()))
                .filter(song -> artist == null || song.artist.name.toLowerCase().contains(artist.toLowerCase()) || artist.toLowerCase().contains(song.artist.name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
