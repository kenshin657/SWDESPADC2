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
public class PlaylistDirector {
    private PlaylistBuilder playlistBuilder;
    
    public void setPlaylistBuilder(PlaylistBuilder pb) {
        playlistBuilder = pb;
    }
    
    public Playlist getPlaylist() {
        return playlistBuilder.getPlaylist();
    }
    
    public void constructPlaylist(String sPlaylistName, String sPlaylistDescription, String sPlaylistImageCoverPath, int sPlaylistUserId, ArrayList<Song> SongList, boolean def) {
        playlistBuilder.createNewPlaylistProduct();
        playlistBuilder.buildPlaylistName(sPlaylistName);
        playlistBuilder.buildPlaylistDescription(sPlaylistDescription);
        playlistBuilder.buildPlaylistImageCoverPath(sPlaylistImageCoverPath);
        playlistBuilder.buildPlaylistUserId(sPlaylistUserId);
        playlistBuilder.buildSongList(SongList);
        playlistBuilder.buildDefault(def);
     
    }
}
