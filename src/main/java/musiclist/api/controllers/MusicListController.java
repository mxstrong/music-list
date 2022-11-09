package musiclist.api.controllers;

import musiclist.api.models.SongOutDto;
import musiclist.business.services.SongsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MusicListController {
    private final SongsService songsService;

    public MusicListController(SongsService songsService) {
        this.songsService = songsService;
    }

    @GetMapping("/songs")
    public List<SongOutDto> findSongs(@RequestParam(required = false) String name, @RequestParam(required = false) String album, @RequestParam(required = false) String artist) {
        return songsService.getSongsBySearch(name, album, artist).stream().map(SongOutDto::fromSong).collect(Collectors.toList());
    }
}
