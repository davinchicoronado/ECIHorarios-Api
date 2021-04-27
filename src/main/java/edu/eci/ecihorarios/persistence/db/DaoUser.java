/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db;

import edu.eci.ecihorarios.model.bean.User;

/**
 *
 * @author David Coronado
 */
public interface DaoUser {
    
    public User getUser(String username);
    
}
