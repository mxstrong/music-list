package musiclist.services;

import musiclist.dtos.ArtistDto;
import musiclist.models.Artist;
import musiclist.repositories.HardcodedSongsRepository;
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
