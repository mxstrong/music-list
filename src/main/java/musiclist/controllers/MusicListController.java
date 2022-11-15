package musiclist.controllers;

import musiclist.dtos.*;
import musiclist.services.AlbumsService;
import musiclist.services.ArtistsService;
import musiclist.services.SongsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MusicListController {
    private final SongsService songsService;
    private final AlbumsService albumsService;
    private final ArtistsService artistsService;

    public MusicListController(SongsService songsService, AlbumsService albumsService, ArtistsService artistsService) {
        this.songsService = songsService;
        this.albumsService = albumsService;
        this.artistsService = artistsService;
    }

    @GetMapping("/songs")
    public List<SongOutDto> findSongs(@RequestParam(required = false) String name, @RequestParam(required = false) String album, @RequestParam(required = false) String artist) {
        return songsService.getSongsBySearch(name, album, artist).stream().map(SongOutDto::fromSong).collect(Collectors.toList());
    }

    @GetMapping("/albums")
    public List<AlbumOutDto> findAlbums(@RequestParam(required = false) String name, @RequestParam(required = false) String artist) {
        return albumsService.getAlbums(name, artist).stream().map(AlbumOutDto::fromAlbum).collect(Collectors.toList());
    }

    @GetMapping("/artists")
    public List<ArtistOutDto> findArtists(@RequestParam(required = false) String name) {
        return artistsService.getArtists(name).stream().map(ArtistOutDto::fromArtist).collect(Collectors.toList());
    }

    @PostMapping("/songs")
    public SongOutDto addSong(@RequestBody SongDto songDto) {
        return SongOutDto.fromSong(songsService.addSong(songDto));
    }

    @PostMapping("/albums")
    public AlbumOutDto addAlbum(@RequestBody AlbumDto albumDto) {
        return AlbumOutDto.fromAlbum(albumsService.addAlbum(albumDto));
    }

    @PostMapping("/artists")
    public ArtistOutDto addArtist(@RequestBody ArtistDto artistDto) {
        return ArtistOutDto.fromArtist(artistsService.addArtist(artistDto));
    }

    @DeleteMapping("/songs/{name}")
    public void deleteSong(@PathVariable String name) {
        songsService.deleteSong(name);
    }

    @DeleteMapping("/albums/{name}")
    public void deleteAlbum(@PathVariable String name) {
        albumsService.deleteAlbum(name);
    }

    @DeleteMapping("/artists/{name}")
    public void deleteArtist(@PathVariable String name) {
        artistsService.deleteArtist(name);
    }
}
