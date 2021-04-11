/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.stub;


import java.util.HashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Coronado
 */
@Service
public class PersistenceManagerStub {
    
    private HashMap<String,String> passwords = new HashMap<>();
    
    public PersistenceManagerStub(){
        passwords.put("admin","admin");

        
    }

    public boolean isLogin(String username, String password){
        
        if(passwords.containsKey(username)){
            if(passwords.get(username).equals(password)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    
    
}
