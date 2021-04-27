/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db.mongoimpl;

import edu.eci.ecihorarios.model.bean.User;
import edu.eci.ecihorarios.persistence.db.DaoUser;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;


/**
 *
 * @author David Coronado
 */ 
@Component 
//@ImportResource("applicationContext.xml")
public class MongoDAOUser implements DaoUser {
    
    

    @Override
    public User getUser(String username) { 
       
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
