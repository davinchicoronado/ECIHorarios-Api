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
public class Group {
    
    private String teacher;
    private int numGroup;
    private String salon;
    
    public Group(String teacher,int numGroup,String salon){
        this.teacher=teacher;
        this.numGroup=numGroup;
        this.salon=salon;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getNumGroup() {
        return numGroup;
    }

    public String getSalon() {
        return salon;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setNumGroup(int numGroup) {
        this.numGroup = numGroup;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
    
    
}
