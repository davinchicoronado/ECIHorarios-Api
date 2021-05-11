/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db.mongoimpl;

import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.persistence.db.DaoSubject;
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
public class MongoDAOSubject implements DaoSubject {

    @Autowired
    MongoOperations mongoTemplate;

    @Override
    public Curriculum getCurriculum(String carrer) throws PersistenceException {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(carrer));

        Curriculum cur = mongoTemplate.findOne(query, Curriculum.class);

        if (cur == null) {
            throw new PersistenceException("Error no se encontro el plan de estudios de la carrera: " + carrer);
        }

        return cur;
    }

    @Override
    public Subject getSubject(String code) throws PersistenceException {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(code));
        
        Subject sub = mongoTemplate.findOne(query, Subject.class);
        
        if(sub==null){
            throw new PersistenceException("Error no se encontro la asignatura : " + code);
        }

        return sub;
    }

}
