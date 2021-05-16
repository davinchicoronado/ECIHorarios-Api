/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.bean;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author David Coronado
 */ 
@Document(collection="SchedulesStudents")
public class ScheduleStudent { 
    @Field("username")
     String username; 
     @Field("list")
     List<SubjectStudent> list; 

    public String getUsername() {
        return username;
    }

    public List<SubjectStudent> getList() {
        return list;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setList(List<SubjectStudent> list) {
        this.list = list;
    }
     
     
     
    
    
}
