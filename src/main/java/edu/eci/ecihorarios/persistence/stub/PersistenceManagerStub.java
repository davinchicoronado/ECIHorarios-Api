/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.stub;


import edu.eci.ecihorarios.model.bean.ClassSchedule;
import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.ScheduleStudent;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.bean.User;
import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.persistence.PersistenceManager;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;


/**
 *
 * @author David Coronado
 */ 
@Repository("persistenceManagerStub")
public class PersistenceManagerStub implements PersistenceManager{
    
    private HashMap<String,String> passwords = new HashMap<>();
    private HashMap<String,List<Subject>> availableSubject = new HashMap<>();
    private HashMap<String,List<Group>>  schedules = new HashMap<>();
    private HashMap<String,User> users = new HashMap<>();
    private HashMap<String,List<SubjectStudent>> scheduleStudents = new HashMap<>();
    public PersistenceManagerStub(){
        
        
        User u = new User("pepito perez","1234567",'E',"pepito.perez@mail.escuelaing.edu.co","admin",3,4); 
        users.put("admin", u);
        
        
        //-----------------------------------------
        passwords.put("admin","admin");
        
        Subject s1 = new Subject("Logica Calculativa",3,"LCAT",2);
        Subject s2 = new Subject("Calculo Diferencial",4,"CALD",1); 
        
        List<Subject> dSchedule = new ArrayList<>();
        
        dSchedule.add(s2);
        dSchedule.add(s1);
        
        availableSubject.put("admin", dSchedule);
        
        //------------------------------------------------------------
        
        Group g1 = new Group("Gerardo Sanchez",1,25);
        Group g2 = new Group("Wilmer Garzon",2,30);  
        Group g3 = new Group("Edwin Perez",1,20);
        Group g4 = new Group("Andres Pacheco",2,15);
        
        ClassSchedule cs1 = new ClassSchedule(LocalTime.of(10, 00, 00).toString(),"Lunes","F-202");
        ClassSchedule cs2 = new ClassSchedule(LocalTime.of(11, 30, 00).toString(),"Martes","F-202");
        ClassSchedule cs3 = new ClassSchedule(LocalTime.of(10, 00, 00).toString(),"Miercoles","G-102");
        ClassSchedule cs4 = new ClassSchedule(LocalTime.of(8, 30, 00).toString(),"Jueves","C-202");
        ClassSchedule cs5 = new ClassSchedule(LocalTime.of(7, 00, 00).toString(),"Viernes","H-302");
        ClassSchedule cs6 = new ClassSchedule(LocalTime.of(10, 00, 00).toString(),"Miercoles","H-203");
        ClassSchedule cs7 = new ClassSchedule(LocalTime.of(1, 00, 00).toString(),"Viernes","G-302");
        ClassSchedule cs8 = new ClassSchedule(LocalTime.of(4, 00, 00).toString(),"Miercoles","D-203");
        
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
        
        //----------------------------------------------------
        List<SubjectStudent> schedules1 = new ArrayList<>();
        
        scheduleStudents.put("admin", schedules1);
        
        
    }

    
    @Override
    public List<Subject> getAvailableSubjects(String username)throws PersistenceException{
        return availableSubject.get(username);
    }
    
    @Override
    public List<Group> getSchedule(String nameSubject)throws PersistenceException{
        return schedules.get(nameSubject);
    }  
    
    @Override 
    public User getUser(String username){
        return users.get(username);
    } 
    
    @Override
    public void saveScheduleStudent(List<SubjectStudent> schedule, String username)throws PersistenceException{
        System.out.println(schedule.toString());
    }

    @Override
    public Curriculum getCurriculum(String carrer) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subject getSubject(String code) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ScheduleStudent> getScheduleStudent(String username) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enrollSubject(SubjectStudent ss, String username) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSubject(SubjectStudent ss, String username) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enrollSubjectStudent(SubjectStudent ss, String username) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
