/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.cache.cachestub;
import edu.eci.ecihorarios.model.bean.Subject;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Coronado
 */ 
@Service
public class ECIHorariosCacheStub {
    
    
    ConcurrentHashMap<String,LocalTime> loggedUsers = new ConcurrentHashMap<>();
    ConcurrentHashMap<String,List<Subject>> availableSubjects = new ConcurrentHashMap<>();

    public void saveLoginUser(String username){
        loggedUsers.put(username, LocalTime.now());      
    }
   
    
    public boolean isLogged(String username){
        if(loggedUsers.get(username).getHour()-LocalTime.now().getHour()>=1){
            loggedUsers.remove(username);
            return false;
        } 
        loggedUsers.put(username, LocalTime.now());
        return true;
    }
    
    public boolean inCacheAvailableSubjects(String username){
        if(availableSubjects.containsKey(username)){
            return true;
        }
        return false;
    } 
    public List<Subject> getAvailableSubjects(String username){
        return availableSubjects.get(username);
    }
}
