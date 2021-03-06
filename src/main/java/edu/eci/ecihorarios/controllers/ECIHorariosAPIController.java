/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.controllers;

import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.error.ObjectError;
import edu.eci.ecihorarios.services.ECIHorariosServices;
import edu.eci.ecihorarios.services.ServicesException;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ECIHorariosAPIController {

    @Autowired
    ECIHorariosServices ecih;

    @RequestMapping(path = "/user/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("username") String username) {

        try {
            return new ResponseEntity<>(ecih.getUser(username), HttpStatus.ACCEPTED);
        } catch (ServicesException ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ObjectError(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    } 
    
    @RequestMapping(path = "/curriculum/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getCurriculum(@PathVariable("name") String name) {

        try {
            return new ResponseEntity<>(ecih.getCurriculum(name), HttpStatus.ACCEPTED);
        } catch (ServicesException ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ObjectError(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/subject/{code}", method = RequestMethod.GET)
    public ResponseEntity<?> getDetailsSubjects(@PathVariable("code") String code) {

        try {
            return new ResponseEntity<>(ecih.getSubject(code), HttpStatus.ACCEPTED);
        } catch (ServicesException ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ObjectError(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/availablesubject/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> availableSubjects(@PathVariable("username") String username) {

        try {
            return new ResponseEntity<>(ecih.getAvailableSubjects(username), HttpStatus.ACCEPTED);
        } catch (ServicesException ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ObjectError(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/schedule/{subjectid}", method = RequestMethod.GET)
    public ResponseEntity<?> getScheduleSubject(@PathVariable("subjectid") String subjectid) {

        try {

            return new ResponseEntity<>(ecih.getSchedule(subjectid), HttpStatus.ACCEPTED);
        } catch (ServicesException ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ObjectError(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/schedulesStudent/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getschedulesStudet(@PathVariable("username") String username) {

        try {

            return new ResponseEntity<>(ecih.getScheduleStudent(username), HttpStatus.ACCEPTED);
        } catch (ServicesException ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ObjectError(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(path = "/saveSchedule/{username}", method = RequestMethod.POST)
    public ResponseEntity<?> saveSchedule(@PathVariable("username") String username, @RequestBody List<SubjectStudent> subjectid) {

        try {
            ecih.saveScheduleStudent(subjectid, username);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ServicesException ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ObjectError(ex.getMessage()), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(path = "/enrollSubject/{username}", method = RequestMethod.PUT)
    public ResponseEntity<?> enrollSubject(@PathVariable("username") String username, @RequestBody SubjectStudent subjectgroup) {

        try {
            ecih.enrollSubject(subjectgroup, username);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ServicesException ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ObjectError(ex.getMessage()), HttpStatus.FORBIDDEN);
        }
    }  
    
    @RequestMapping(path = "/enrollSubjectStudent/{username}", method = RequestMethod.PUT)
    public ResponseEntity<?> enrollSubjectStudent(@PathVariable("username") String username, @RequestBody SubjectStudent subjectgroup) {

        try {
            ecih.enrollSubjectStudent(subjectgroup, username);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ServicesException ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ObjectError(ex.getMessage()), HttpStatus.FORBIDDEN);
        }
    } 
    
    
    
    @RequestMapping(path = "/deleteSubject/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSubject(@PathVariable("username") String username, @RequestBody SubjectStudent subjectgroup) {

        try {
            ecih.deleteSubject(subjectgroup, username);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (ServicesException ex) {
            Logger.getLogger(ECIHorariosAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ObjectError(ex.getMessage()), HttpStatus.FORBIDDEN);
        }
    } 
    

}
