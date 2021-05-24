/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence;

import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.ScheduleStudent;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.bean.User;
import java.util.List;

/**
 *
 * @author David Coronado
 */
public interface PersistenceManager {

    public List<Group> getSchedule(String codeSubject) throws PersistenceException;

    public User getUser(String username) throws PersistenceException;

    public void saveScheduleStudent(List<SubjectStudent> ss, String username) throws PersistenceException;

    public List<ScheduleStudent> getScheduleStudent(String username) throws PersistenceException;

    public void enrollSubject(SubjectStudent ss, String username) throws PersistenceException; 
    
    public void deleteSubject(SubjectStudent ss, String username) throws PersistenceException; 
    
    public void enrollSubjectStudent(SubjectStudent ss, String username) throws PersistenceException; 

}
