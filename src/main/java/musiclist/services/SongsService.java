package musiclist.services;

import musiclist.dtos.SongDto;
import musiclist.models.Song;
import musiclist.repositories.HardcodedSongsRepository;
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

    public Song addSong(SongDto songDto) {
        return songsRepository.addSong(songDto);
    }

    public void deleteSong(String name) {
        songsRepository.deleteSong(name);
    }
}
