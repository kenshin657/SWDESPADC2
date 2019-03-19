/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc2.controller;
import dc2.model.*;
import dc2.view.Login;
import dc2.view.MusicPlayerGUI;
import dc2.view.SignUp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Dustin Ampong
 */
public class AllSongPlaylist {
    buildSong songarray = new buildSong();
    ArrayList<Song> songlist= new ArrayList<>();

 
   
    public ArrayList<Playlist> playlistBuild(ArrayList<Playlist> playlist, int userId) {
         PlaylistDirector pd = new PlaylistDirector();
        StandardPlaylistBuild pb = new StandardPlaylistBuild();
        
    
        songlist= songarray.songbuild(songlist, 0, 0);
      pd.setPlaylistBuilder(pb);
      pd.constructPlaylist("All Songs", "Default Playlist for All songs", "", userId, songlist, true);
          playlist.add(pd.getPlaylist());
            
           
        
        return playlist;
    }
}
