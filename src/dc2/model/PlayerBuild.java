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
public class PlayerBuild extends SongBuilder {

    @Override
    public void buildTitle(String title) {
        song.setTitle(title);
    }

    @Override
    public void buildFilePath(String filepath) {
        song.setFilePath(filepath);
    }
    
    
    @Override
    public void buildArtists(String artist) {
        song.setArtist(artist);
    }

    @Override
    public void buildGenre(String genre) {
        song.setGenre(genre);
    }

    @Override
    public void buildYearReleased(int year) {
        song.setYearReleased(year);
    }

    @Override
    public void buildAlbumName(String album) {
        song.setAlbumName(album);
    }
    
    
}



