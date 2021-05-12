/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db.mongoimpl;

import edu.eci.ecihorarios.config.CacheConfig;
import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.persistence.db.DaoSubject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author David Coronado
 */
@Component
public class MongoDAOSubject implements DaoSubject {

    @Autowired
    MongoOperations mongoTemplate;

    @Override 
    @Cacheable(CacheConfig.CACHE_CURRICULUM)
    public Curriculum getCurriculum(String carrer) throws PersistenceException {
        Query query = new Query();
        
        query.addCriteria(Criteria.where("_id").is(carrer));
        
        Curriculum cur = mongoTemplate.findOne(query, Curriculum.class); 
        

        if (cur == null) {
            throw new PersistenceException("Error no se encontro el plan de estudios de la carrera: " + carrer);
        }
        Criteria i = new Criteria();
       
        return cur;
    }

    @Override 
    @Cacheable(CacheConfig.CACHE_SUBJECT)
    public Subject getSubject(String code) throws PersistenceException { 
  
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(code));
        
        Subject sub = mongoTemplate.findOne(query, Subject.class);
        
        if(sub==null){
            throw new PersistenceException("Error no se encontro la asignatura : " + code);
        }

        return sub;
    }

    @Override
    public List<Group> getGroups(String code) throws PersistenceException {
        Query query = new Query(); 
        query.fields().include("teacher"); 
        query.fields().include("numGroup");
        query.fields().include("lessons");
        query.fields().include("limit"); 
        query.addCriteria(Criteria.where("code").is(code)); 
        
        List<Group> groups = mongoTemplate.find(query, Group.class);  
        if(groups.isEmpty()){
            throw new PersistenceException("Error no se encontraron registros de la asignatura : " + code);
        }
        
        return groups;
    }

}
