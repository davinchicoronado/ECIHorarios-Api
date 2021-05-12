/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.model.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 *
 * @author David Coronado
 */ 
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodeSubject {
    
    private String code; 
    
    private List<String> prerequisites;

    public String getCode() {
        return code;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    @Override
    public String toString() {
        return "NodeSubject{" + "code=" + code + ", prerequisites=" + prerequisites + "}";
    }
    
    
    
    
}
