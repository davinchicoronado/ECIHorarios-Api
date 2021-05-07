/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services.impl;

import edu.eci.ecihorarios.model.bean.CredentialsUser;
import edu.eci.ecihorarios.persistence.db.DaoUser;
import edu.eci.ecihorarios.persistence.db.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Coronado
 */  
@Service
@ImportResource("applicationContext.xml") 
public class ECIHorariosUserServicesImpl implements UserDetailsService{ 
    
    BCryptPasswordEncoder encoder;
    
    
    @Autowired 
    private DaoUser daouser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            CredentialsUser us = daouser.getUser(username); 
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(us.getRole()));
            
            UserDetails userDet = new User(us.getUsername(),us.getPassword(),roles);
            
            return userDet;
            
        } catch (PersistenceException ex) {
            Logger.getLogger(ECIHorariosUserServicesImpl.class.getName()).log(Level.SEVERE, null, ex); 
            throw new UsernameNotFoundException("No se pudo consultar el usuario" +username, ex);
        }
        
    }
    
}
