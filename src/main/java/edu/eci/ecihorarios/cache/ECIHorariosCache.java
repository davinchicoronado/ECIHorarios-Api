/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.cache;
import java.time.LocalTime;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Coronado
 */ 
@Service
public class ECIHorariosCache {
    
    
    ConcurrentHashMap<String,LocalTime> loggedUsers = new ConcurrentHashMap<>();

    public void saveLoginUser(String username){
        loggedUsers.put(username, LocalTime.now());      
    }
   
    
    public boolean isLogged(String username){
        if(loggedUsers.get(username).getHour()-LocalTime.now().getHour()>1){
            loggedUsers.remove(username);
            return false;
        } 
        loggedUsers.put(username, LocalTime.now());
        return true;
    }
    
}
