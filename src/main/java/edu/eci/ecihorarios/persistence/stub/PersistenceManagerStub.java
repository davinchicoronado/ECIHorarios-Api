/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.stub;


import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.Schedule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Coronado
 */
@Service
public class PersistenceManagerStub {
    
    private HashMap<String,String> passwords = new HashMap<>();
    private HashMap<String,List<Schedule>> disposablesSchedule = new HashMap<>();
    
    
    public PersistenceManagerStub(){
        
        passwords.put("admin","admin");
        
        Schedule s1 = new Schedule("Logica Calculativa",3,"LCAL");
        Schedule s2 = new Schedule("Calculo Diferencial",3,"CALD"); 
        
        Group g1 = new Group("Gerardo Sanchez",1,"G2-201");
        Group g2 = new Group("Wilmer Garzon",2,"F2-301");
        
        Group g3 = new Group("Edwin Perez",1,"C2-201");
        Group g4 = new Group("",2,"F2-301");
        
       
        List<Group> h1 = new ArrayList<>();
        List<Group> h2 = new ArrayList<>();
        
        h1.add(g1);
        h1.add(g2);
        h2.add(g3);
        h2.add(g4);

        s1.setGroups(h1);
        s2.setGroups(h2);
        
        List<Schedule> dSchedule = new ArrayList<>();
        
        dSchedule.add(s2);
        dSchedule.add(s1);
        
        disposablesSchedule.put("admin", dSchedule);
        
        
        
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
