/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.bean;


import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author David Coronado
 */ 
@Document(collection = "Users")
public class User {


    
      
    
    @Id
    private String username;
    private String id;
    private char tipo;
    private String email; 
    private int semester;
    private int limitCredits;
    private String name; 
    private List<String> approvedSubjects;
    
    public User(){
    
    }
    
    public User(String name, String id, char tipo, String email, String username, int semester, int limitCredits) {
        this.name = name;
        this.id = id;
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

    public String getId() {
        return id;
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

    public void setId(String id) {
        this.id = id;
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
    
    
    
}
