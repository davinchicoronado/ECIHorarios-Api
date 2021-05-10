/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services.impl;

import edu.eci.ecihorarios.cache.ECIHorariosCache;
import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.bean.User;
import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.persistence.PersistenceManager;
import edu.eci.ecihorarios.services.ECIHorariosServices;
import edu.eci.ecihorarios.services.ServicesException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service; 

/**
 *
 * @author David Coronado
 */
@Service
public class ECIHorariosServicesImpl implements ECIHorariosServices{

    @Autowired 
    @Qualifier("persistenceManagerDB")        
    PersistenceManager pms;
    
    @Autowired
    ECIHorariosCache cacheEci;

    @Override
    public List<Subject> getAvailableSubjects(String username) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Group> getSchedule(String subjectid) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(String username) throws ServicesException {
    
        try {
            return pms.getUser(username);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex); 
            throw new ServicesException("No se pudo consultar los detalles del usuario: "+username,ex);
        }
    }
    

    @Override
    public void saveScheduleStudent(List<SubjectStudent> ss) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curriculum getCurriculum(String carrer) throws ServicesException {
        try {
            return pms.getCurriculum(carrer);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex); 
            throw new ServicesException("No se pudo consultar el plan de estudios de la carrera: "+carrer,ex);
        }
    }
      
    


    
    
    
    
    
    
    
    
}
