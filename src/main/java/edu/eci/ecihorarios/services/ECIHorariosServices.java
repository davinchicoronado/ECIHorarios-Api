/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services;

import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.bean.User;
import java.util.List;

/**
 *
 * @author David Coronado
 */
public interface ECIHorariosServices {
    


    
    /**
     * Metodo que permite consultar las materias que puede ver el estudiante
     * @param username
     * @return List con las materias 
     * @throws edu.eci.ecihorarios.services.ServicesException 
     */ 
    
    public List<Subject> getAvailableSubjects(String username)throws ServicesException;
    
    
     /**
     * Metodo que permite consultar los horarios de una materia
     * @param subjectid id de la materia
     * @return List con el horario de los distintos grupos de una materia 
     * @throws edu.eci.ecihorarios.services.ServicesException 
     */ 
    public List<Group> getSchedule(String subjectid)throws ServicesException;
    
      /**
     * Metodo que permite consultar los datos de un usuario
     * @param username del usuario
     * @return List con el horario de los distintos grupos de una materia 
     * @throws edu.eci.ecihorarios.services.ServicesException 
     */  
    public User getUser(String username)throws ServicesException; 
    
     /**
     * Metodo que guardar horarios de un estudiante
     *  
     * @param ss 
     * @throws edu.eci.ecihorarios.services.ServicesException 
     */  
    public void saveScheduleStudent(List<SubjectStudent> ss)throws ServicesException;
    
}
