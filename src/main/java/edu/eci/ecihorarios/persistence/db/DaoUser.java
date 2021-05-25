/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db;

import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.CredentialsUser;
import edu.eci.ecihorarios.model.bean.User;

/**
 *
 * @author David Coronado
 */
public interface DaoUser {

    /**
     * Metodo que permite consultar las credenciales de un usuario a una base de
     * datos
     *
     * @param username
     * @return credenciales del usuario
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public CredentialsUser getUser(String username) throws PersistenceException;

    /**
     * Metodo que permite registrar las credenciales de un nuevo usuario a una
     * base de datos
     *
     * @param user credenciales
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public void saveUser(CredentialsUser user) throws PersistenceException;

    /**
     * Metodo que permite consultar la información de un usuario a una base de
     * datos
     *
     * @param username del usuario
     * @return detalles del usuario
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public User getUserDetails(String username) throws PersistenceException;

    /**
     * Metodo que permite registrar información de un usuario a una base de
     * datos
     *
     * @param user detalles del usuario
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public void saveUserDetails(User user) throws PersistenceException;

}
