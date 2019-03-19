/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author user
 */
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import java.net.MalformedURLException;
import java.net.URL;


public class Player {
    public static void main(String[] args) {
        String songName = "standout.mp3";
        String pathToFile = "C:\\Users\\kylet\\Desktop\\Songs\\" + songName;

        BasicPlayer basicPlayer = new BasicPlayer();
        try{
            basicPlayer.open(new URL("file:///" + pathToFile));
            basicPlayer.play();
        } catch (BasicPlayerException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

