/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author David Coronado
 */
@Configuration
public class MongoConnection { 
    
    @Autowired 
    private MongoClient mongoClient;
    
    private final String urlMongoDb = "mongodb+srv://ProjectEciHorarios:admin123@clusterecihorarios.gdwta.mongodb.net/ECIHorarios?w=majority"; 
    //private final String urlMongoDb = "mongodb://127.0.0.1:27017/?gssapiServiceName=mongodb"; 
        
    @Bean
    public MongoClient mongoClient() {
        ConnectionString connString = new ConnectionString(urlMongoDb);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build(); 
        
        MongoClient mongoC = (MongoClient) MongoClients.create(settings);  
        
        return mongoC;
      
    }

    @Bean
    public MongoTemplate mongoTemplate() {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "ECIHorarios");
        return mongoTemplate;

    }

}
