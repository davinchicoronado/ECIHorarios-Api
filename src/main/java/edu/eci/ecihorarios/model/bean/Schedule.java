/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.bean;

import java.util.List;

/**
 *
 * @author David Coronado
 */
public class Schedule {
    
    private String name;
    private int credits;
    private String id;
    private List<Group> groups;

    public Schedule(String name,int credits,String id){
        this.name=name;
        this.credits=credits;
        this.id=id;
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

    public List<Group> getGroups() {
        return groups;
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

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    
}
