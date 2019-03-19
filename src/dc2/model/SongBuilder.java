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
public abstract class SongBuilder {
    protected Song song;
    
    public Song getSong() {
        return song;
    }
    
    public void createNewSongProduct() {
        song = new Song();
    }
   
    public abstract void buildTitle(String title);
    public abstract void buildArtists(String artist);
    public abstract void buildGenre(String genre);
    public abstract void buildYearReleased(int year);
    public abstract void buildAlbumName(String album);
    public abstract void buildFilePath(String filepath);
    
}



