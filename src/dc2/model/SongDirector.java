/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc2.model;

/**
 *
 * @author kylet
 */
public class SongDirector {
    private SongBuilder songBuilder;
    
    public void setSongBuilder(SongBuilder sb) {
        songBuilder = sb;
    }
    
    public Song getSong() {
        return songBuilder.getSong();
    }
    
    public void constructSong(String title, String artist, String genre, int year, String album, String filePath) {
        songBuilder.createNewSongProduct();
        songBuilder.buildArtists(artist);
        songBuilder.buildTitle(title);
        songBuilder.buildFilePath(filePath);
        songBuilder.buildGenre(genre);
        songBuilder.buildYearReleased(year);
        songBuilder.buildAlbumName(album);
    }
}



