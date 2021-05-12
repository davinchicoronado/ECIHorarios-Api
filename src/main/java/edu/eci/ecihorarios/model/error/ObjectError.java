/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.error;

/**
 *
 * @author David Coronado
 */
public class ObjectError {
    
    private String error;
    private String error_description; 
    
    public ObjectError(String error_description){
        this.error="services_exception";
        this.error_description=error_description;
    }
    public ObjectError(){}

    public String getError() {
        return error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }
    
    
    
    
}
