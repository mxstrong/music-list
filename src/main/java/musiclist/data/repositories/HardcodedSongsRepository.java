package musiclist.data.repositories;

import musiclist.data.models.Album;
import musiclist.data.models.Artist;
import musiclist.data.models.Song;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Scope("singleton")
public class HardcodedSongsRepository {
    private final SongCollection songCollection;

    public HardcodedSongsRepository() {
        songCollection = new SongCollection();
        songCollection.addArtist("Polyphia");
        songCollection.addAlbum("Remember That You Will Die", "Polyphia");
        songCollection.addSong("Playing God", "Remember That You Will Die", "Polyphia");
        songCollection.addSong("Reverie", "Remember That You Will Die", "Polyphia");
        songCollection.addAlbum("New Levels New Devils", "Polyphia");
        songCollection.addSong("G.O.A.T", "New Levels New Devils", "Polyphia");
        songCollection.addArtist("Architects");
        songCollection.addAlbum("All Our Gods Have Abandoned Us", "Architects");
        songCollection.addSong("Gone With The Wind","All Our Gods Have Abandoned Us", "Architects");
    }

    public List<Song> getSongsBySearch(String name, String album, String artist) {
        return songCollection.getSongs().stream()
                .filter(song -> name == null || song.getTitle().toLowerCase().contains(name.toLowerCase()) || name.toLowerCase().contains(song.getTitle().toLowerCase()))
                .filter(song -> album == null || song.getAlbum().getName().toLowerCase().contains(album.toLowerCase()) || album.toLowerCase().contains(song.getAlbum().getName().toLowerCase()))
                .filter(song -> artist == null || song.getTitle().toLowerCase().contains(artist.toLowerCase()) || artist.toLowerCase().contains(song.getArtist().getName().toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Album> getAlbums(String name, String artist) {
        return songCollection.getAlbums().stream()
                .filter(album -> name == null || album.getName().toLowerCase().contains(name.toLowerCase()) || name.toLowerCase().contains(album.getName().toLowerCase()))
                .filter(album -> artist == null || album.getArtist().getName().toLowerCase().contains(artist.toLowerCase()) || artist.toLowerCase().contains(album.getArtist().getName().toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Artist> getArtists(String name) {
        return songCollection.getArtists().stream()
                .filter(artist -> name == null || artist.getName().toLowerCase().contains(name.toLowerCase()) || name.toLowerCase().contains(artist.getName().toLowerCase()))
                .collect(Collectors.toList());
    }
}
