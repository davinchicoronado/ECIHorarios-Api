/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db;

import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.ScheduleStudent;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.persistence.PersistenceException;
import java.util.List;

/**
 *
 * @author David Coronado
 */
public interface DaoSubject {
    
    public Curriculum getCurriculum(String carrer) throws PersistenceException; 
    
    public Subject getSubject(String code) throws PersistenceException;
    
    public List<Group> getGroups(String code) throws PersistenceException; 
    
    public void saveScheduleStudent(List<SubjectStudent> schedule, String username) throws PersistenceException;
    
    public List<ScheduleStudent> getScheduleStudent(String username) throws PersistenceException;
    
    public void enrollSubject(SubjectStudent ss , String usernmae ) throws PersistenceException; 
    
    
}
