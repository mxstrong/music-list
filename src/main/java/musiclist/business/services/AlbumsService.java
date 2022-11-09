package musiclist.business.services;

import musiclist.data.models.Album;
import musiclist.data.repositories.HardcodedSongsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsService {
    private final HardcodedSongsRepository songsRepository;

    public AlbumsService(HardcodedSongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }

    public List<Album> getAlbums(String name, String artist) {
        return songsRepository.getAlbums(name, artist);
    }
}
