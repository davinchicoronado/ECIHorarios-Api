/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services;

import edu.eci.ecihorarios.model.Curriculum;
import edu.eci.ecihorarios.model.Student;
import java.util.List;
import javax.security.auth.Subject;

/**
 *
 * @author David Coronado
 */
public interface EciScheduleServices {
    
    
    
   public abstract void registerSubject(Student student, Subject subject) throws ExceptionEciSheduleServices;
   
   
   public abstract List<Subject> consultShedules(String name)  throws ExceptionEciSheduleServices;
   
   
   public abstract void registerCurriculum(Curriculum curriculum) throws ExceptionEciSheduleServices;
   
   
   
   
    

}
