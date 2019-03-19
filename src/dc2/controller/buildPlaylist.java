/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc2.controller;

import dc2.model.Playlist;
import dc2.model.PlaylistDirector;
import dc2.model.Song;
import dc2.model.StandardPlaylistBuild;
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
public class buildPlaylist {
      buildSong songarray = new buildSong();
    ArrayList<Song> songlist= new ArrayList<>();
    ArrayList<String> title= new ArrayList<>();
            ArrayList<String> descript= new ArrayList<>();
            ArrayList<String> picturePath = new ArrayList<>();
                   ArrayList<Integer> playlistId= new ArrayList<>();
                 ArrayList<Boolean> favorite= new ArrayList<>();

 Connection con;
    void createConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + "playlistdb" + "?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Asia/Hong_Kong", "root", "aurawave657"
            );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public ArrayList<Playlist> playlistBuild(ArrayList<Playlist> playlist, int userId) {
         PlaylistDirector pd = new PlaylistDirector();
        StandardPlaylistBuild pb = new StandardPlaylistBuild();
        
        createConnection();
        int i;
         try {
           
            
            PreparedStatement stmt1 = con.prepareStatement("Select * from playlist where accountId=(?)");
            stmt1.setInt(1, userId);
           
            ResultSet rs = stmt1.executeQuery();
        
            while(rs.next()){

               title.add(rs.getString("playlistTitle"));
               descript.add(rs.getString("playlistDescrpt"));
               picturePath.add(rs.getString("pictureFilePath"));
               playlistId.add(rs.getInt("playlistId"));
               favorite.add(rs.getBoolean("favorite"));
               
               
                    
               
              
           
            }
            
              for(i=1; i<playlist.size(); i++){
            
        songlist= songarray.songbuild(songlist, i, playlistId.get(i));
      pd.setPlaylistBuilder(pb);
      pd.constructPlaylist(title.get(i), descript.get(i), picturePath.get(i), userId , songlist, false);
      
          playlist.add(pd.getPlaylist());
            
           
        }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return playlist;
    }
}


