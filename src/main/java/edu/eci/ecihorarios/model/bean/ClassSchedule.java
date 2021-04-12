/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.bean;

import java.time.LocalTime;

/**
 *
 * @author David Coronado
 */
public class ClassSchedule {
    
    private LocalTime hour;
    private String classRoom;
    private String day;
    
    public ClassSchedule(LocalTime hour,String day,String classRoom){
        this.hour=hour;
        this.day=day;
        this.classRoom=classRoom;    
    }

    public LocalTime getHour() {
        return hour;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public String getDay() {
        return day;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public void setDay(String day) {
        this.day = day;
    }
    
    
}
