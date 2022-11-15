package musiclist.services;

import musiclist.dtos.AlbumDto;
import musiclist.models.Album;
import musiclist.repositories.HardcodedSongsRepository;
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

    public Album addAlbum(AlbumDto albumDto) {
        return songsRepository.addAlbum(albumDto);
    }

    public void deleteAlbum(String name) {
        songsRepository.deleteAlbum(name);
    }
}
