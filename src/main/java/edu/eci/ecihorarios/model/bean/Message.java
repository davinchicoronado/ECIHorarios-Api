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
public class Message {
    private String username;
    private String text;
 
    public Message(String username,String text){
        this.username=username;
        this.text=text;
    }
    public Message(){
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
