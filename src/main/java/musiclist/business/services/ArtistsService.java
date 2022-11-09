package musiclist.business.services;

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
}
