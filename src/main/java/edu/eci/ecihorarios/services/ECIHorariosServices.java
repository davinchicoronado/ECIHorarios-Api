/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services;

import edu.eci.ecihorarios.model.bean.LoginUser;

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
    
}
