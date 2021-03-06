/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.services;

import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Group;
import edu.eci.ecihorarios.model.bean.ScheduleStudent;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.SubjectStudent;
import edu.eci.ecihorarios.model.bean.User;
import java.util.List;

/**
 *
 * @author David Coronado
 */
public interface ECIHorariosServices {

    /**
     * Metodo que permite consultar las materias que puede ver el estudiante
     *
     * @param username del estudiante
     * @return List con las materias
     * @throws edu.eci.ecihorarios.services.ServicesException
     */
    public List<Subject> getAvailableSubjects(String username) throws ServicesException;

    /**
     * Metodo que permite consultar los horarios de una materia
     *
     * @param subjectid id de la materia
     * @return List con el horario de los distintos grupos de una materia
     * @throws edu.eci.ecihorarios.services.ServicesException
     */
    public List<Group> getSchedule(String subjectid) throws ServicesException;

    /**
     * Metodo que permite consultar los datos de un usuario
     *
     * @param username del usuario
     * @return List con el horario de los distintos grupos de una materia
     * @throws edu.eci.ecihorarios.services.ServicesException
     */
    public User getUser(String username) throws ServicesException;

    /**
     * Metodo que guarda horarios de un estudiante
     *
     * @param schedule
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.services.ServicesException
     */
    public void saveScheduleStudent(List<SubjectStudent> schedule, String username) throws ServicesException;

    /**
     * Metodo que permite consultar el plan de estudios de una carrera
     *
     * @param carrer
     * @return Curriculum de la carrera
     * @throws edu.eci.ecihorarios.services.ServicesException
     */
    public Curriculum getCurriculum(String carrer) throws ServicesException;

    /**
     * Metodo que permite consultar los detalles de una asignatura
     *
     * @param code de la asignatura
     * @return Detalle de la asignatura
     * @throws edu.eci.ecihorarios.services.ServicesException
     */
    public Subject getSubject(String code) throws ServicesException;

    /**
     * Metodo que permite inscribir una asignatura a un estudiante
     *
     * @param subStudent grupo asignatura
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.services.ServicesException
     */
    public void enrollSubject(SubjectStudent subStudent, String username) throws ServicesException;

    /**
     * Metodo que permite inscribir una asignatura, un administrador a un
     * estudiante
     *
     * @param subStudent grupo asignatura
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.services.ServicesException
     */
    public void enrollSubjectStudent(SubjectStudent subStudent, String username) throws ServicesException;

    /**
     * Metodo que permite consultar el horario de un estudiante
     *
     * @param username
     * @return Listado de asignaturas con su respectivo grupo
     * @throws edu.eci.ecihorarios.services.ServicesException
     */
    public List<ScheduleStudent> getScheduleStudent(String username) throws ServicesException;

    /**
     * Metodo que permite borrar una asignatura  inscrita
     *
     * @param subStudent grupo asignatura
     * @param username del estudiante
     * @throws edu.eci.ecihorarios.services.ServicesException
     */
    public void deleteSubject(SubjectStudent subStudent, String username) throws ServicesException;
}
