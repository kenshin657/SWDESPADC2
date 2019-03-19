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
public class StandardPlaylistBuild extends PlaylistBuilder{

    @Override
    public void buildPlaylistName(String sPlaylistName) {
        playlist.setsPlaylistName(sPlaylistName);
    }

    @Override
    public void buildPlaylistDescription(String sPlaylistDescription) {
        playlist.setsPlaylistDescription(sPlaylistDescription);
    }

    @Override
    public void buildPlaylistImageCoverPath(String sPlaylistImageCoverPath) {
        playlist.setsPlaylistImageCoverPath(sPlaylistImageCoverPath);
    }
    @Override
    public void buildPlaylistUserId(int sPlaylistUserId) {
        playlist.setsPlaylistUserId(sPlaylistUserId);
    }

    @Override
    public void buildSongList(ArrayList<Song> SongList) {
        playlist.setSongList(SongList);
    }
    
    @Override
    public void buildDefault(boolean def){
        playlist.setDefault(def);
    }
    
}
