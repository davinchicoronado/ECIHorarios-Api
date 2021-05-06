/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.controllers;

import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.services.ECIHorariosServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David Coronado
 */

@RestController
@RequestMapping(value = "/ecihorarios")
//@CrossOrigin(origins = "http://localhost:3000")
public class ECIHorariosAPIController {
    
    @Autowired 
    ECIHorariosServices ecih;
    
    
    @RequestMapping(path ="/{username}/{password}",method = RequestMethod.GET)
    public ResponseEntity<?> isLoginUser(@PathVariable ("username") String username, @PathVariable ("password") String password){
       
        try {
            return new ResponseEntity<>(ecih.isLogin(username, password),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(path ="/{username}",method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable ("username") String username){
       
        try {
            return new ResponseEntity<>(ecih.getUser(username),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }        
    }
    
    
    @RequestMapping(path ="/subjects/{username}",method = RequestMethod.GET)
    public ResponseEntity<?> availableSubjects(@PathVariable ("username") String username){
       
        try { 
          
            return new ResponseEntity<>(ecih.getAvailableSubjects(username),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }        
    } 
    
    @RequestMapping(path ="/schedule/{subjectid}",method = RequestMethod.GET)
    public ResponseEntity<?> schedule(@PathVariable ("subjectid") String subjectid){
       
        try { 
          
            return new ResponseEntity<>(ecih.getSchedule(subjectid),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }        
    } 
    
     @RequestMapping(path="/{username}",method = RequestMethod.POST) 
     public ResponseEntity<?> schedule(@PathVariable ("username") String username,@RequestBody List<SubjectStudent> subjectid){
       
     try { 
           ecih.saveScheduleStudent(subjectid);
           return new ResponseEntity<>(HttpStatus.CREATED);      
        } catch (Exception ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }        
    }  
    
     
     
    
    
    
}
