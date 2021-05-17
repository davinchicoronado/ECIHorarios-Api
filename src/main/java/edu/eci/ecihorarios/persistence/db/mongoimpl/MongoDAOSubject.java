/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db.mongoimpl;

import edu.eci.ecihorarios.config.CacheConfig;
import edu.eci.ecihorarios.model.bean.CredentialsUser;
import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.ScheduleStudent;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.bean.User;
import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.persistence.db.DaoSubject;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

        if (sub == null) {
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
        if (groups.isEmpty()) {
            throw new PersistenceException("Error no se encontraron registros de la asignatura : " + code);
        }

        return groups;
    }

    @Override
    public void saveScheduleStudent(List<SubjectStudent> schedule, String username) throws PersistenceException {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(username));

        CredentialsUser user = mongoTemplate.findOne(query, CredentialsUser.class);

        if (user == null) {
            throw new PersistenceException("Error no se encontro usuario");
        }
        ScheduleStudent ss = new ScheduleStudent();
        ss.setUsername(username);
        ss.setList(schedule);

        mongoTemplate.save(ss);

    }

    @Override
    public List<ScheduleStudent> getScheduleStudent(String username) throws PersistenceException {

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(username));

        CredentialsUser user = mongoTemplate.findOne(query, CredentialsUser.class);

        if (user == null) {
            throw new PersistenceException("Error no se encontro usuario");
        }

        Query query2 = new Query();
        query2.addCriteria(Criteria.where("username").is(username));

        List<ScheduleStudent> shstudent = mongoTemplate.find(query2, ScheduleStudent.class);

        if (shstudent.isEmpty()) {
            throw new PersistenceException("No se encontraron registros de horarios del estudiante " + username);
        }

        return shstudent;

    }

    @Override
    public void enrollSubject(SubjectStudent ss, String username) throws PersistenceException {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(username));

        User user = mongoTemplate.findOne(query, User.class);

        if (user == null) {
            throw new PersistenceException("Error no se encontro usuario");
        }
        Query query3 = new Query();
        query3.fields().include("teacher");
        query3.fields().include("numGroup");
        query3.fields().include("lessons");
        query3.fields().include("limit");
        query3.addCriteria(Criteria.where("code").is(ss.getSubjectid()));
        query3.addCriteria(Criteria.where("numGroup").is(ss.getGroup()));

        Group gr = mongoTemplate.findOne(query3, Group.class);

        if (gr.getLimit() <= 0) {
            throw new PersistenceException("Error no hay cupos");
        }

        //System.out.println(getSubject(ss.getSubjectid()).getCredits());
        if (user.getEnrolledsubject() == null) {
            Query query2 = new Query();
            query2.addCriteria(Criteria.where("_id").is(username));

            List<SubjectStudent> enrolled = new ArrayList<>();
            enrolled.add(ss);

            Update update = new Update();

            update.set("enrolled_subjects", enrolled);

            update.set("limitCredits", user.getLimitCredits() - getSubject(ss.getSubjectid()).getCredits());

            mongoTemplate.updateFirst(query2, update, User.class);

            Update update2 = new Update();
            update2.set("limit", gr.getLimit() - 1);
            mongoTemplate.updateFirst(query3, update2, Group.class);

        } else {
            Query query2 = new Query();
            query2.addCriteria(Criteria.where("_id").is(username));

            List<SubjectStudent> enrolled = user.getEnrolledsubject();

            if (enrolled.contains(ss)) {
                throw new PersistenceException("Materia ya inscrita");
            }

            enrolled.add(ss);
            Update update = new Update();
            update.set("enrolled_subjects", enrolled);
            update.set("limitCredits", user.getLimitCredits() - getSubject(ss.getSubjectid()).getCredits());
            mongoTemplate.updateFirst(query2, update, User.class);

            Update update2 = new Update();
            update2.set("limit", gr.getLimit() - 1);
            mongoTemplate.updateFirst(query3, update2, Group.class);

        }

    }

    @Override
    public void deleteSubject(SubjectStudent ss, String username) throws PersistenceException {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(username));

        User user = mongoTemplate.findOne(query, User.class);

        if (user == null) {
            throw new PersistenceException("Error no se encontro usuario");
        }
        Query query3 = new Query();
        query3.fields().include("teacher");
        query3.fields().include("numGroup");
        query3.fields().include("lessons");
        query3.fields().include("limit");
        query3.addCriteria(Criteria.where("code").is(ss.getSubjectid()));
        query3.addCriteria(Criteria.where("numGroup").is(ss.getGroup()));

        Group gr = mongoTemplate.findOne(query3, Group.class);


        if (user.getEnrolledsubject() == null) {
                throw new PersistenceException("No se encontro ningun registro de la asignatura");
            
        } else {
            Query query2 = new Query();
            query2.addCriteria(Criteria.where("_id").is(username));

            List<SubjectStudent> enrolled = user.getEnrolledsubject();

            if (enrolled.contains(ss)) { 
                enrolled.remove(ss);
              
            } 
            else{
                throw new PersistenceException("No se encontro ningun registro de la asignatura");
            } 
            
            
            Update update = new Update();
            update.set("enrolled_subjects", enrolled);
            update.set("limitCredits", user.getLimitCredits() + getSubject(ss.getSubjectid()).getCredits());
            mongoTemplate.updateFirst(query2, update, User.class);

            Update update2 = new Update();
            update2.set("limit", gr.getLimit() + 1);
            mongoTemplate.updateFirst(query3, update2, Group.class);

        }

    }

    @Override
    public void enrollSubjectStudent(SubjectStudent ss, String username) throws PersistenceException {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(username));

        User user = mongoTemplate.findOne(query, User.class);

        if (user == null) {
            throw new PersistenceException("Error no se encontro usuario");
        }
        Query query3 = new Query();
        query3.fields().include("teacher");
        query3.fields().include("numGroup");
        query3.fields().include("lessons");
        query3.fields().include("limit");
        query3.addCriteria(Criteria.where("code").is(ss.getSubjectid()));
        query3.addCriteria(Criteria.where("numGroup").is(ss.getGroup()));

        Group gr = mongoTemplate.findOne(query3, Group.class);


        
        if (user.getEnrolledsubject() == null) {
            Query query2 = new Query();
            query2.addCriteria(Criteria.where("_id").is(username));

            List<SubjectStudent> enrolled = new ArrayList<>();
            enrolled.add(ss);

            Update update = new Update();

            update.set("enrolled_subjects", enrolled);

            update.set("limitCredits", user.getLimitCredits() - getSubject(ss.getSubjectid()).getCredits());

            mongoTemplate.updateFirst(query2, update, User.class);

            Update update2 = new Update();
            update2.set("limit", gr.getLimit() - 1);
            mongoTemplate.updateFirst(query3, update2, Group.class);

        } else {
            Query query2 = new Query();
            query2.addCriteria(Criteria.where("_id").is(username));

            List<SubjectStudent> enrolled = user.getEnrolledsubject();

            if (enrolled.contains(ss)) {
                throw new PersistenceException("Materia ya inscrita");
            }

            enrolled.add(ss);
            Update update = new Update();
            update.set("enrolled_subjects", enrolled);
            update.set("limitCredits", user.getLimitCredits() - getSubject(ss.getSubjectid()).getCredits());
            mongoTemplate.updateFirst(query2, update, User.class);

            Update update2 = new Update();
            update2.set("limit", gr.getLimit() - 1);
            mongoTemplate.updateFirst(query3, update2, Group.class);

        }
    }

}
