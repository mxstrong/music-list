package musiclist.application.services;

import musiclist.api.models.ArtistDto;
import musiclist.data.models.Artist;
import musiclist.data.repositories.HardcodedSongsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistsService {
    private final HardcodedSongsRepository songsRepository;

    public ArtistsService(HardcodedSongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }

    public List<Artist> getArtists(String name) {
        return this.songsRepository.getArtists(name);
    }

    public Artist addArtist(ArtistDto artistDto) {
        return this.songsRepository.addArtist(artistDto);
    }

    public void deleteArtist(String name) {
        songsRepository.deleteArtist(name);
    }
}
