/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc2.controller;

import dc2.model.*;
import dc2.view.Login;
import dc2.view.MusicPlayerGUI;
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
public class buildSong {
    
          Connection con;
          ArrayList<Integer> songId = new ArrayList<>();
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
    
    public ArrayList<Song> songbuild(ArrayList<Song> songlist, int playlistnum, int playlistId){
        // connection for loop
        createConnection();
        int i;
        SongDirector songdirector= new SongDirector();
        PlayerBuild songbuilder = new PlayerBuild();
        
        
        if (playlistnum==0){
          try {
            PreparedStatement stmt = con.prepareStatement("Select * from songlist");
            
            
            ResultSet rs = stmt.executeQuery();
          
            while(rs.next()){
                songdirector.setSongBuilder(songbuilder);
                songdirector.constructSong(rs.getString("songTitle"), rs.getString("artist"), rs.getString("genre"), rs.getInt("year"), rs.getString("album"), rs.getString("filePath"));
              songlist.add(songdirector.getSong());
              System.out.println("Artist"+ rs.getString("artist"));
              System.out.println("Album"+rs.getString("album"));
               System.out.println("year"+rs.getInt("year"));
            }
           
             rs.close();
        stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
        
        else{
             try {
            PreparedStatement stmt1 = con.prepareStatement("Select * from songtoplaylist where playlistId(?)");
            stmt1.setInt(1, playlistId);
           
            
            ResultSet rs1 = stmt1.executeQuery();
          
            while(rs1.next()){
                songId.add(rs1.getInt("songId"));
               
            }
               for(i=0; i<songId.size(); i++){
                 PreparedStatement stmt2 = con.prepareStatement("Select * from songlist where songId(?)");
                 stmt2.setInt(1, songId.get(i));
                    ResultSet rs2 = stmt2.executeQuery();
                    
                    
                    while(rs2.next()){
                         songdirector.setSongBuilder(songbuilder);
                songdirector.constructSong(rs2.getString("songTitle"), rs2.getString("artist"), rs2.getString("genre"), rs2.getInt("year"), rs2.getString("album"), rs2.getString("filePath"));
              songlist.add(songdirector.getSong());
                    }
               
            }
             rs1.close();
        stmt1.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
     
       //, rs.getString("genre"), rs.getInt("year"), rs.getString("album"), rs.getString("filePath"));
        return songlist;
    }
}


