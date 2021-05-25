/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.persistence.db;

import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.ScheduleStudent;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.persistence.PersistenceException;
import java.util.List;

/**
 *
 * @author David Coronado
 */
public interface DaoSubject {

    /**
     * Metodo que permite consultar el plan de estudios de una carrera en una
     * base de datos
     *
     * @param carrer
     * @return Curriculum de la carrera
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public Curriculum getCurriculum(String carrer) throws PersistenceException;

    /**
     * Metodo que permite consultar los detalles de una asignatura en una base
     * de datos
     *
     * @param code de la asignatura
     * @return Detalle de la asignatura
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public Subject getSubject(String code) throws PersistenceException;

    /**
     * Metodo que permite consultar los horarios de una materia en una base de
     * datos
     *
     * @param code id de la materia
     * @return List con el horario de los distintos grupos de una materia
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public List<Group> getGroups(String code) throws PersistenceException;

    /**
     * Metodo que guarda horarios de un estudiante en una base de datos
     *
     * @param schedule
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public void saveScheduleStudent(List<SubjectStudent> schedule, String username) throws PersistenceException;

    /**
     * Metodo que permite consultar el horario de un estudiante en una base de
     * datos y mapearlo a un respectivo objeto
     *
     * @param username
     * @return Listado de asignaturas con su respectivo grupo
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public List<ScheduleStudent> getScheduleStudent(String username) throws PersistenceException;

    /**
     * Metodo que permite inscribir una asignatura de un estudiante a una base
     * de datos
     *
     * @param subStudent grupo asignatura
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public void enrollSubject(SubjectStudent subStudent, String username) throws PersistenceException;

    /**
     * Metodo que permite borrar una asignatura inscrita en una base de datos
     *
     * @param subStudent grupo asignatura
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public void deleteSubject(SubjectStudent subStudent, String username) throws PersistenceException;

    /**
     * Metodo que permite inscribir una asignatura, sin restricciones a una base
     * de datos
     *
     * @param subStudent grupo asignatura
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.persistence.PersistenceException
     */
    public void enrollSubjectStudent(SubjectStudent subStudent, String username) throws PersistenceException;

}
