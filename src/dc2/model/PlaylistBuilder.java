/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc2.model;

import dc2.model.Playlist;
import dc2.model.Song;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public abstract class PlaylistBuilder {
    protected Playlist playlist;
    
    public Playlist getPlaylist() {
        return playlist;
    }
    
    public void createNewPlaylistProduct() {
        playlist = new Playlist();
    }
   
    public abstract void buildPlaylistName(String sPlaylistName);
    public abstract void buildPlaylistDescription(String sPlaylistDescription);
    public abstract void buildPlaylistImageCoverPath(String sPlaylistImageCoverPath);
    public abstract void buildPlaylistUserId(int sPlaylistUserid);
    public abstract void buildSongList(ArrayList<Song> SongList);
   
    public abstract void buildDefault(boolean def);
}
