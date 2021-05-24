/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.cache;


import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.persistence.PersistenceException;

/**
 *
 * @author David Coronado
 */ 
public interface ECIHorariosCache { 
    
    
    public Curriculum getCurriculum(String carrer) throws PersistenceException;
     
    
    public Subject getSubject(String code) throws PersistenceException; 
    
}
