package musiclist.business.services;

import musiclist.data.models.Song;
import musiclist.data.repositories.HardcodedSongsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongsService {
    private final HardcodedSongsRepository songsRepository;

    public SongsService(HardcodedSongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }

    public List<Song> getSongsBySearch(String name, String album, String artist) {
        return songsRepository.getSongsBySearch(name, album, artist);
    }
}
