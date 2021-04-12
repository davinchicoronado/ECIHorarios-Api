/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.stub;


import edu.eci.ecihorarios.model.bean.ClassSchedule;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.Subject;
import java.time.LocalTime;
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
    private HashMap<String,List<Subject>> availableSubject = new HashMap<>();
    private HashMap<String,List<Group>>  schedules = new HashMap<>();
    
    public PersistenceManagerStub(){
        
        passwords.put("admin","admin");
        
        Subject s1 = new Subject("Logica Calculativa",3,"LCAT",2);
        Subject s2 = new Subject("Calculo Diferencial",4,"CALD",1); 
        
        List<Subject> dSchedule = new ArrayList<>();
        
        dSchedule.add(s2);
        dSchedule.add(s1);
        
        availableSubject.put("admin", dSchedule);
        
        //------------------------------------------------------------
        
        Group g1 = new Group("Gerardo Sanchez",1);
        Group g2 = new Group("Wilmer Garzon",2);  
        Group g3 = new Group("Edwin Perez",1);
        Group g4 = new Group("Andres Pacheco",2);
        
        ClassSchedule cs1 = new ClassSchedule(LocalTime.of(10, 00, 00),"Lunes","F-202");
        ClassSchedule cs2 = new ClassSchedule(LocalTime.of(11, 30, 00),"Martes","F-202");
        ClassSchedule cs3 = new ClassSchedule(LocalTime.of(10, 00, 00),"Miercoles","G-102");
        ClassSchedule cs4 = new ClassSchedule(LocalTime.of(8, 30, 00),"Jueves","C-202");
        ClassSchedule cs5 = new ClassSchedule(LocalTime.of(7, 00, 00),"Viernes","H-302");
        ClassSchedule cs6 = new ClassSchedule(LocalTime.of(10, 00, 00),"Miercoles","H-203");
        ClassSchedule cs7 = new ClassSchedule(LocalTime.of(7, 00, 00),"Viernes","H-302");
        ClassSchedule cs8 = new ClassSchedule(LocalTime.of(10, 00, 00),"Miercoles","H-203");
        
        List<ClassSchedule> css1 = new ArrayList<>();
        List<ClassSchedule> css2 = new ArrayList<>();
        List<ClassSchedule> css3 = new ArrayList<>();
        List<ClassSchedule> css4 = new ArrayList<>();
        
        css1.add(cs1);
        css1.add(cs2);
        
        css2.add(cs3);
        css2.add(cs4);
        
        css3.add(cs5);
        css3.add(cs6);
        
        css4.add(cs7);
        css4.add(cs8);
        
        g1.setLessons(css1);
        g2.setLessons(css2); 
        g3.setLessons(css3); 
        g4.setLessons(css4);
        
        
        List<Group> sh1 = new ArrayList<>();
        List<Group> sh2 = new ArrayList<>();
        
        sh1.add(g1);
        sh1.add(g2);
        sh2.add(g3);
        sh2.add(g4);
        
        
        
        schedules.put("LCAT", sh1);     
        schedules.put("CALD", sh2);

        
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
    
    public List<Subject> getAvailableSubjects(String username){
        return availableSubject.get(username);
    }
    
    
}
