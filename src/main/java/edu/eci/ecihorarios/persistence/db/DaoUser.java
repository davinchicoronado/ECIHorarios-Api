/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db;

import edu.eci.ecihorarios.model.bean.CredentialsUser;
import edu.eci.ecihorarios.model.bean.User;

/**
 *
 * @author David Coronado
 */
public interface DaoUser {
    
    public CredentialsUser getUser(String username) throws PersistenceException; 
    
    public void saveUser(CredentialsUser user) throws PersistenceException;
    
    public User getUserDetails(String username) throws PersistenceException;
    
    public void saveUserDetails(User user) throws PersistenceException;
    
}
