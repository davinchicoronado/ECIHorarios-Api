/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.bean;

/**
 *
 * @author David Coronado
 */
public class Subject {
    
    private String name;
    private int credits;
    private String id;
    private int level;

    public Subject(String name,int credits,String id,int level){
        this.name=name;
        this.credits=credits;
        this.id=id;
        this.level=level;
    }
    

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getId() {
        return id;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
