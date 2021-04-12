/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services.impl;

import edu.eci.ecihorarios.cache.ECIHorariosCache;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.persistence.stub.PersistenceManagerStub;
import edu.eci.ecihorarios.model.bean.LoginUser;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.services.ECIHorariosServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Coronado
 */
@Service
public class ECIHorariosServicesImpl implements ECIHorariosServices{

    @Autowired
    PersistenceManagerStub pms;
    
    @Autowired
    ECIHorariosCache cacheEci;
    
    
    @Override
    public LoginUser isLogin(String username, String password) { 
        
        boolean status = pms.isLogin(username, password);
        
        if(status){ 
            cacheEci.saveLoginUser(username);
        } 
        return new LoginUser(status);
    }

    @Override
    public LoginUser checkLogin(String username) {     
        boolean status = cacheEci.isLogged(username);
        return new LoginUser(status);
    }

    @Override
    public List<Subject> getAvailableSubjects(String username) {
        
        if(cacheEci.inCacheAvailableSubjects(username)){
            return cacheEci.getAvailableSubjects(username);    
        }
        else{ 
            return pms.getAvailableSubjects(username);
        
        }

    }

    @Override
    public List<Group> getSchedule(String subjectid) {
        return pms.getSchedule(subjectid);
    }
    
    
    
    
    
    
    
    
}
