/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence;

import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.ScheduleStudent;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.bean.User;
import java.util.List;

/**
 *
 * @author David Coronado
 */
public interface PersistenceManager {

    /**
     * Metodo que permite consultar los horarios de una materia
     *
     * @param codeSubject id de la materia
     * @return List con el horario de los distintos grupos de una materia
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public List<Group> getSchedule(String codeSubject) throws PersistenceException;

    /**
     * Metodo que permite consultar los datos de un usuario
     *
     * @param username del usuario
     * @return List con el horario de los distintos grupos de una materia
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public User getUser(String username) throws PersistenceException;

    /**
     * Metodo que guarda horarios de un estudiante
     *
     * @param subStudent
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public void saveScheduleStudent(List<SubjectStudent> subStudent, String username) throws PersistenceException;

    /**
     * Metodo que permite consultar el horario de un estudiante
     *
     * @param username
     * @return Listado de asignaturas con su respectivo grupo
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public List<ScheduleStudent> getScheduleStudent(String username) throws PersistenceException;

    /**
     * Metodo que permite inscribir una asignatura a un estudiante
     *
     * @param subStudent grupo asignatura
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public void enrollSubject(SubjectStudent subStudent, String username) throws PersistenceException;

    /**
     * Metodo que permite borrar una asignatura eliminada
     *
     * @param subStudent grupo asignatura
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public void deleteSubject(SubjectStudent subStudent, String username) throws PersistenceException;

    /**
     * Metodo que permite inscribir una asignatura, un administrador a un
     * estudiante
     *
     * @param subStudent grupo asignatura
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public void enrollSubjectStudent(SubjectStudent subStudent, String username) throws PersistenceException;

}
