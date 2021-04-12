/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services;

import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.LoginUser;
import edu.eci.ecihorarios.model.bean.Subject;
import java.util.List;

/**
 *
 * @author David Coronado
 */
public interface ECIHorariosServices {
    
     /**
     * Metodo que permite saber si un usuario se logeó o no
     * @param username
     * @param password
     * @return LoginUser con el estado del login 
     */   
    public LoginUser isLogin(String username, String password);
    
      /**
     * Metodo que permite saber si un usuario esta logeado o no
     * @param username
     * @return LoginUser con el estado del login 
     */   
    public LoginUser checkLogin(String username);
    
    /**
     * Metodo que permite consultar las materias que puede ver el estudiante
     * @param username
     * @return List con las materias 
     */ 
    
    public List<Subject> getAvailableSubjects(String username);
    
    
     /**
     * Metodo que permite consultar los horarios de una materia
     * @param subjectid id de la materia
     * @return List con el horario de los distintos grupos de una materia 
     */ 
    
    public List<Group> getSchedule(String subjectid);
    
    
    
}
