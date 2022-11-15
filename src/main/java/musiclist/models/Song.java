package musiclist.models;

public class Song {
    private final String title;
    private Artist artist;
    private Album album;

    public Song(String title, Artist artist, Album album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public String getTitle() {
        return this.title;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public Album getAlbum() {
        return this.album;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
