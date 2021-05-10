/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence;



import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.bean.User;
import java.util.List;


/**
 *
 * @author David Coronado
 */

public interface PersistenceManager {
    
 
     
    public List<Subject> getAvailableSubjects(String username) throws PersistenceException;
    
    
    
    
    public List<Group> getSchedule(String nameSubject) throws PersistenceException;
    
    
    
    
    public User getUser(String username) throws PersistenceException;
    
    
    
    
    public void saveScheduleStudent(List<SubjectStudent> ss) throws PersistenceException; 
    
    
    
    public Curriculum getCurriculum(String carrer) throws PersistenceException;
    
}
