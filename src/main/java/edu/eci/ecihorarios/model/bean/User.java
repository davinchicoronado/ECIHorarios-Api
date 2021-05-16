/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.bean;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 *
 * @author David Coronado
 */ 
@Document(collection = "Users") 
 
@JsonInclude(Include.NON_DEFAULT)
public class User {

    @Id
    private String username;
    private String identification;
    private char tipo;
    private String email; 
    private int semester; 
    private int limitCredits;
    private String name;  
    
    @JsonInclude(Include.NON_NULL) 
    private List<String> approvedSubjects; 
    private String carrer; 
    @Field("enrolled_subjects")
    private List<SubjectStudent> enrolledsubject;
    

    
    public User(){
    
    }
    
    public User(String name, String id, char tipo, String email, String username, int semester, int limitCredits) {
        this.name = name;
        this.identification = id;
        this.tipo = tipo;
        this.email = email;
        this.username = username;
        this.semester = semester;
        this.limitCredits = limitCredits;
    }

    public int getSemester() {
        return semester;
    }

    public int getLimitCredits() {
        return limitCredits;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setLimitCredits(int limitCredits) {
        this.limitCredits = limitCredits;
    }
    
    

    public String getName() {
        return name;
    }

  

    public char getTipo() {
        return tipo;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getApprovedSubjects() {
        return approvedSubjects;
    }

    public void setApprovedSubjects(List<String> approvedSubjects) {
        this.approvedSubjects = approvedSubjects;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
    
    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getCarrer() {
        return carrer;
    }

    public List<SubjectStudent> getEnrolledsubject() {
        return enrolledsubject;
    }

    public void setEnrolledsubject(List<SubjectStudent> enrolledsubject) {
        this.enrolledsubject = enrolledsubject;
    }


    
    
    
}
