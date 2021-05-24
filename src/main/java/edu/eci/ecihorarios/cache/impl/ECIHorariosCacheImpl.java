/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.cache.impl;

import edu.eci.ecihorarios.cache.ECIHorariosCache;
import edu.eci.ecihorarios.config.CacheConfig;
import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.persistence.db.DaoSubject;
import edu.eci.ecihorarios.persistence.db.DaoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Coronado
 */ 
@Service("ECIHorariosGuavaCache")
public class ECIHorariosCacheImpl implements ECIHorariosCache{ 
    
    @Autowired 
    DaoUser daoUser; 
    
    @Autowired 
    DaoSubject daoSubject; 

    @Override 
    @Cacheable(CacheConfig.CACHE_CURRICULUM)
    public Curriculum getCurriculum(String carrer) throws PersistenceException {
        return daoSubject.getCurriculum(carrer);
    }

    @Override 
    @Cacheable(CacheConfig.CACHE_SUBJECT)
    public Subject getSubject(String code) throws PersistenceException {
        return daoSubject.getSubject(code);
    }  
    
}
