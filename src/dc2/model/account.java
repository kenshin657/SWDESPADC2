/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc2.model;

/**
 *
 * @author Dustin Ampong
 */
public class account {
    
    private int accountid;
    private String username;
    
    public void setAccountId(int accountId){
        accountid= accountId;
    }
    public void setUsername(String Username){
        username= Username;
    }
    
    public int getAccountId(){
        return accountid;
    }
    public String getusername(){
        return username;
    }
}
