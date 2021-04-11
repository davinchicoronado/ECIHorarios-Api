/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services.impl;

import edu.eci.ecihorarios.persistence.stub.PersistenceManagerStub;
import edu.eci.ecihorarios.model.bean.LoginUser;
import edu.eci.ecihorarios.services.ECIHorariosServices;
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
    
    
    @Override
    public LoginUser checkLogin(String username, String password) {
        return pms.checkLogin(username, password);
    }
    
    
    
}
