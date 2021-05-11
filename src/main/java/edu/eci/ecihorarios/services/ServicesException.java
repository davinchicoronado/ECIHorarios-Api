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
public class ServicesException extends Exception{ 
    
    
    public ServicesException(String message) {
        super(message);
    }

    public ServicesException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicesException(Throwable cause) {
        super(cause);
    }

    public ServicesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
