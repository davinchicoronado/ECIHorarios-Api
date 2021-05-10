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
@Document(collection = "Curriculum")
public class Curriculum { 
    @Id
    private String carrer;
    private List<NodeSubject> list;

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }
    
    public List<NodeSubject> getList() {
        return list;
    }

    public void setList(List<NodeSubject> list) {
        this.list = list;
    } 

    @Override
    public String toString() {
        return "Curriculum{" + "carrer=" + carrer + ", list=" + list + "}";
    }
    
    
    
    
    
}
