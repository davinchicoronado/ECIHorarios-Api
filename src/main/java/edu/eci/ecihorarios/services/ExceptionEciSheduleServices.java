/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services;

/**
 *
 * @author David Coronado
 */
public class ExceptionEciSheduleServices extends Exception {
    
    public ExceptionEciSheduleServices(String message, Throwable cause){
        super(message, cause);
    }
    public ExceptionEciSheduleServices(String message){
        super(message);
    }
    
    
}
