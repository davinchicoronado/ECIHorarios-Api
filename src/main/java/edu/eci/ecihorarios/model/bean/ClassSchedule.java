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
public class ClassSchedule {
    
    private String hour;
    private String classRoom;
    private String day;
    
    public ClassSchedule(String hour,String day,String classRoom){
        this.hour=hour;
        this.day=day;
        this.classRoom=classRoom;    
    }

    public String getHour() {
        return hour;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public String getDay() {
        return day;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public void setDay(String day) {
        this.day = day;
    }
    
    
}
