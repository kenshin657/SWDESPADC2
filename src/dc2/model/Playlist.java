/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc2.model;

import dc2.model.Song;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Playlist {
    private String sPlaylistName;
    private String sPlaylistDescription; 
    private String sPlaylistImageCoverPath;
    private int  sPlaylistUserId;
    private ArrayList<Song> SongList;
    private boolean sPlaylistFavorite;
    private boolean sPlaylistDefault;

    public String getsPlaylistName() {
        return sPlaylistName;
    }

    public void setsPlaylistName(String sPlaylistName) {
        this.sPlaylistName = sPlaylistName;
    }

    public String getsPlaylistDescription() {
        return sPlaylistDescription;
    }

    public void setsPlaylistDescription(String sPlaylistDescription) {
        this.sPlaylistDescription = sPlaylistDescription;
    }

    public String getsPlaylistImageCoverPath() {
        return sPlaylistImageCoverPath;
    }

    public void setsPlaylistImageCoverPath(String sPlaylistImageCoverPath) {
        this.sPlaylistImageCoverPath = sPlaylistImageCoverPath;
    }

    public int getsUserId() {
        return sPlaylistUserId;
    }

    public void setsPlaylistUserId(int sPlaylistUserId) {
        this.sPlaylistUserId = sPlaylistUserId;
    }

    public ArrayList<Song> getSongList() {
        return SongList;
    }

    public void setSongList(ArrayList<Song> SongList) {
        this.SongList = SongList;
    }
    public boolean getFavorite(){
        return sPlaylistFavorite;
    }
    public void setFavorite(boolean fav){
     this.sPlaylistFavorite = fav;   
    }
    
        public boolean getDefault(){
        return sPlaylistDefault;
    }
        
        
    public void setDefault(boolean def){
     this.sPlaylistDefault = def;   
    }
    
}
