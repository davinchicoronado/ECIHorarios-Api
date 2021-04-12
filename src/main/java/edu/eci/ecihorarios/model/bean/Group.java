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
public class Group {
    
    private String teacher;
    private int numGroup;
    private List<ClassSchedule> lessons;
    
    public Group(String teacher,int numGroup){
        this.teacher=teacher;
        this.numGroup=numGroup;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getNumGroup() {
        return numGroup;
    }



    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setNumGroup(int numGroup) {
        this.numGroup = numGroup;
    }

    public List<ClassSchedule> getLessons() {
        return lessons;
    }

    public void setLessons(List<ClassSchedule> lessons) {
        this.lessons = lessons;
    }
   
}
