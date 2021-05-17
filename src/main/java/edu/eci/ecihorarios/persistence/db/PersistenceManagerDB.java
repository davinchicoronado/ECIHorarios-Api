/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db;

import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.NodeSubject;
import edu.eci.ecihorarios.model.bean.ScheduleStudent;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.bean.User;
import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.persistence.PersistenceManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author David Coronado
 */ 
@Repository("persistenceManagerDB")
public class PersistenceManagerDB implements PersistenceManager {
    
    
    
    @Autowired 
    DaoUser daoUser; 
    
    @Autowired 
    DaoSubject daoSubject;

    @Override
    public List<Subject> getAvailableSubjects(String username) throws PersistenceException {
        
       
        List<Subject> list = new ArrayList<>();
        User us = daoUser.getUserDetails(username);
        List<String>approved = us.getApprovedSubjects();
        Curriculum curl = daoSubject.getCurriculum(us.getCarrer()); 
   
        Subject sb;
        String code;
        for(NodeSubject nd : curl.getList()){ 
            code = nd.getCode(); 
            if(nd.getPrerequisites()!=null){
                if(approved.containsAll(nd.getPrerequisites())){
                    sb = daoSubject.getSubject(code);
                    list.add(sb);
                }
            }
        }
        
        
        return list;
    }

    @Override
    public List<Group> getSchedule(String codeSubject) throws PersistenceException {
        return daoSubject.getGroups(codeSubject);
    }

    @Override
    public User getUser(String username) throws PersistenceException {  
        return daoUser.getUserDetails(username);
    }

    @Override
    public Curriculum getCurriculum(String carrer) throws PersistenceException {
        return daoSubject.getCurriculum(carrer);
    }

    @Override
    public Subject getSubject(String code) throws PersistenceException {
        return daoSubject.getSubject(code);
    }

    @Override
    public void saveScheduleStudent(List<SubjectStudent> ss, String username) throws PersistenceException {
        daoSubject.saveScheduleStudent(ss, username);
    }

    @Override
    public List<ScheduleStudent> getScheduleStudent(String username) throws PersistenceException {
        return daoSubject.getScheduleStudent(username);
    }

    @Override
    public void enrollSubject(SubjectStudent ss, String username) throws PersistenceException {
        daoSubject.enrollSubject(ss, username);
    }

    @Override
    public void deleteSubject(SubjectStudent ss, String username) throws PersistenceException {
        daoSubject.deleteSubject(ss,username);
    }
    



    
}
