/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorariosapi;

import edu.eci.ecihorarios.model.bean.BeanC;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.config.AnnotationRepositoryConfigurationSource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.env.Environment;
import java.lang.Class;

/**
 *
 * @author David Coronado
 */

@SpringBootApplication 
@ComponentScan(basePackages = {"edu.eci.ecihorarios"})
@ImportResource("applicationContext.xml")
public class ECIHorariosAPIApplication {
    
    @Autowired 
    MongoTemplate mongoTemplate;
    
    public static void main(String[] args) { 
        
        SpringApplication app = new SpringApplication(ECIHorariosAPIApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port",getPort()));
        app.run(args);
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
