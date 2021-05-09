/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db.mongoimpl;

import edu.eci.ecihorarios.model.bean.CredentialsUser;
import edu.eci.ecihorarios.model.bean.User;
import edu.eci.ecihorarios.persistence.db.DaoUser;
import edu.eci.ecihorarios.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


/**
 *
 * @author David Coronado
 */ 
@Component 
public class MongoDAOUser implements DaoUser {
    
    @Autowired 
    MongoOperations mongoTemplate;

    @Override
    public CredentialsUser getUser(String username) throws PersistenceException{ 
        
       
        
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(username)); 
        
        CredentialsUser user =  mongoTemplate.findOne(query, CredentialsUser.class);
        
        if(user == null){
            throw new PersistenceException("Error no se encontro usuario");
        }
        
        return mongoTemplate.findOne(query, CredentialsUser.class);
   
    } 

    @Override
    public void saveUser(CredentialsUser user) throws PersistenceException { 
        
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(user.getUsername())); 
        
        CredentialsUser u =  mongoTemplate.findOne(query, CredentialsUser.class);
        
        if(u!=null){
            throw new PersistenceException("Usuario exsitente");
        
        }
        
        mongoTemplate.save(user); 
            
    }  

    @Override
    public User getUserDetails(String username) throws PersistenceException { 
        
        Query query = new Query(); 
        query.addCriteria(Criteria.where("_id").is(username));
        
        User user = mongoTemplate.findOne(query,User.class);
        if(user == null){
            throw new PersistenceException("Error no se encontro usuario");
        }
        return user;
        
    } 

    @Override
    public void saveUserDetails(User user) throws PersistenceException {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(user.getUsername())); 
        
        User u =  mongoTemplate.findOne(query, User.class);
        
        if(u!=null){
            throw new PersistenceException("Detalles del usuario existentes");
        
        }
        mongoTemplate.save(user); 
        
    }
   
    
    

    
 
    

    
    
    
    
    
}
