/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.bean;

/**
 *
 * @author David Coronado
 */
public class LoginUser {
    
    private boolean status;
    
    public LoginUser(boolean status){
        this.status=status;
        
    }
    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
