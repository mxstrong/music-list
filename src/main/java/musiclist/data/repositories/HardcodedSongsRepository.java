package musiclist.data.repositories;

import musiclist.data.models.Album;
import musiclist.data.models.Artist;
import musiclist.data.models.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HardcodedSongsRepository {
    private final SongCollection songCollection;

    public HardcodedSongsRepository() {
        songCollection = new SongCollection();
        songCollection.addArtist(new Artist("Polyphia"));
        songCollection.addAlbum(new Album("Remember That You Will Die", songCollection.getArtists().get(0)));
        songCollection.addSong(new Song("Playing God", songCollection.getArtists().get(0), songCollection.getAlbums().get(0)));
        songCollection.addSong(new Song("Reverie", songCollection.getArtists().get(0), songCollection.getAlbums().get(0)));
        songCollection.addAlbum(new Album("New Levels New Devils", songCollection.getArtists().get(0)));
        songCollection.addSong(new Song("G.O.A.T", songCollection.getArtists().get(0), songCollection.getAlbums().get(1)));
        songCollection.addArtist(new Artist("Architects"));
        songCollection.addAlbum(new Album("All Our Gods Have Abandoned Us", songCollection.getArtists().get(1)));
        songCollection.addSong(new Song("Gone With The Wind", songCollection.getArtists().get(1), songCollection.getAlbums().get(2)));
    }

    public List<Song> getSongsBySearch(String name, String album, String artist) {
        return songCollection.getSongs().stream()
                .filter(song -> name == null || song.title.toLowerCase().contains(name.toLowerCase()) || name.toLowerCase().contains(song.title.toLowerCase()))
                .filter(song -> album == null || song.album.name.toLowerCase().contains(album.toLowerCase()) || album.toLowerCase().contains(song.album.name.toLowerCase()))
                .filter(song -> artist == null || song.artist.name.toLowerCase().contains(artist.toLowerCase()) || artist.toLowerCase().contains(song.artist.name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Album> getAlbums(String name, String artist) {
        return songCollection.getAlbums().stream()
                .filter(album -> name == null || album.name.toLowerCase().contains(name.toLowerCase()) || name.toLowerCase().contains(album.name.toLowerCase()))
                .filter(album -> artist == null || album.artist.name.toLowerCase().contains(artist.toLowerCase()) || artist.toLowerCase().contains(album.artist.name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Artist> getArtists(String name) {
        return songCollection.getArtists().stream()
                .filter(artist -> name == null || artist.name.toLowerCase().contains(name.toLowerCase()) || name.toLowerCase().contains(artist.name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
