/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.cache;

import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.persistence.PersistenceException;

/**
 *
 * @author David Coronado
 */
public interface ECIHorariosCache {

    /**
     * Metodo que permite consultar el plan de estudios de una carrera si esta
     * en cache si no realiza la consulta a un DAO
     *
     * @param carrer
     * @return Curriculum de la carrera
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public Curriculum getCurriculum(String carrer) throws PersistenceException;

    /**
     * Metodo que permite consultar los detalles de una asignatura si esta en
     * cache si no realiza la consulta a un DAO
     *
     * @param code de la asignatura
     * @return Detalle de la asignatura
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public Subject getSubject(String code) throws PersistenceException;

}
