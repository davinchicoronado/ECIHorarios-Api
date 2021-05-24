/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services.impl;

import edu.eci.ecihorarios.cache.ECIHorariosCache;
import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.NodeSubject;
import edu.eci.ecihorarios.model.bean.ScheduleStudent;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.bean.User;
import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.persistence.PersistenceManager;
import edu.eci.ecihorarios.services.ECIHorariosServices;
import edu.eci.ecihorarios.services.ServicesException;
import java.util.ArrayList;
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
public class ECIHorariosServicesImpl implements ECIHorariosServices {

    @Autowired
    @Qualifier("persistenceManagerDB")
    PersistenceManager pms;

    @Autowired
    @Qualifier("ECIHorariosGuavaCache")
    ECIHorariosCache ecicache;

    @Override
    public List<Subject> getAvailableSubjects(String username) throws ServicesException { 
        
        try {
            List<Subject> list = new ArrayList<>();
            User us = pms.getUser(username);
            List<String> approved = us.getApprovedSubjects();
            Curriculum curl = ecicache.getCurriculum(us.getCarrer());
            
            Subject sb;
            String code;
            for (NodeSubject nd : curl.getList()) {
                code = nd.getCode();
                if (nd.getPrerequisites() != null) {
                    if (approved.containsAll(nd.getPrerequisites())) {
                        sb = ecicache.getSubject(code);
                        list.add(sb);
                    }
                }
            }
            
            return list;
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex); 
            throw new ServicesException("No se pudo consultar las asignaturas disponibles del usuario: "+username,ex);
        }
        
        
        
    }

    @Override
    public List<Group> getSchedule(String subjectid) throws ServicesException {
        try {
            return pms.getSchedule(subjectid);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesException("No se pudo consultar los horarios de la asignatura: " + subjectid, ex);
        }
    }

    @Override
    public User getUser(String username) throws ServicesException {

        try {
            return pms.getUser(username);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesException("No se pudo consultar los detalles del usuario: " + username, ex);
        }
    }

    @Override
    public Curriculum getCurriculum(String carrer) throws ServicesException {
        try {
            return ecicache.getCurriculum(carrer);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesException("No se pudo consultar el plan de estudios de la carrera: " + carrer, ex);
        }
    }

    @Override
    public Subject getSubject(String code) throws ServicesException {
        try {
            return ecicache.getSubject(code);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesException("No se pudo consultar la asignatura: " + code, ex);
        }
    }

    @Override
    public void saveScheduleStudent(List<SubjectStudent> schedule, String username) throws ServicesException {

        try {
            pms.saveScheduleStudent(schedule, username);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesException("No se pudo guardar el horario al estudiante: " + username, ex);
        }

    }

    @Override
    public void enrollSubject(SubjectStudent ss, String username) throws ServicesException {
        try {
            pms.enrollSubject(ss, username);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesException("No se pudo inscribir la asignatura: " + ss.getSubjectid(), ex);
        }
    }

    @Override
    public List<ScheduleStudent> getScheduleStudent(String username) throws ServicesException {
        try {
            return pms.getScheduleStudent(username);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesException("No se pudo consultar los prehorarios del usuario: " + username, ex);
        }
    }

    @Override
    public void deleteSubject(SubjectStudent ss, String username) throws ServicesException {
        try {
            pms.deleteSubject(ss, username);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesException("No se pudo  la asignatura: " + ss.getSubjectid(), ex);
        }
    }

    @Override
    public void enrollSubjectStudent(SubjectStudent ss, String username) throws ServicesException {
        try {
            pms.enrollSubjectStudent(ss, username);
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesException("No se pudo inscribir la asignatura: " + ss.getSubjectid(), ex);
        }
    }

}
