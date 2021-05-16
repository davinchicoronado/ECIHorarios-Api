/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.bean;

import java.util.Objects;

/**
 *
 * @author David Coronado
 */
public class SubjectStudent {
    
    private int group;
    private String subjectid; 
    



    public SubjectStudent(int group, String subjectid) {
        this.group = group;
        this.subjectid = subjectid;
    }
  
    public int getGroup() {
        return group;
    }

    public String getSubjectid() {
        return subjectid;
    }


    public void setGroup(int group) {
        this.group = group;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    @Override
    public String toString() {
        return "SubjectStudent{" + "group=" + group + ", subjectid=" + subjectid + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SubjectStudent other = (SubjectStudent) obj;
        if (this.group != other.group) {
            return false;
        }
        if (!Objects.equals(this.subjectid, other.subjectid)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.group;
        hash = 89 * hash + Objects.hashCode(this.subjectid);
        return hash;
    }

    



    
    
    
    
    
}
