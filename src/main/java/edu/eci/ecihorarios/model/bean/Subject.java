/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author David Coronado
 */
@Document(collection = "Subjects")
public class Subject {
    
    @Id
    private String code;
    private String name;
    private int credits;
    private int level;

    public Subject(String name,int credits,String id,int level){
        this.name=name;
        this.credits=credits;
        this.code=id;
        this.level=level;
    }
    

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
