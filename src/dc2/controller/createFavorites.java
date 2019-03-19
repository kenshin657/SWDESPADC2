/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc2.controller;

import dc2.view.Login;
import dc2.view.MusicPlayerGUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Dustin Ampong
 */
public class createFavorites {
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
    public void newFavorite(int userID){
        createConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO playlist(playlistTitle,playlistDescrpt, accountId, userCreated)Values(?,?,?,?)");
            stmt.setString(1, "Favorites");
            stmt.setString(2, "Playlist of your Favorite songs");
             stmt.setInt(3, userID);
             stmt.setBoolean(4, false);
            
            stmt.executeUpdate();
            stmt.close();
          
        
            
       
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}


