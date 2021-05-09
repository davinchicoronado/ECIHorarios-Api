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
/**
 *
 * @author David Coronado
 */ 
@Configuration
public class MongoConnection {

    @Bean
    public MongoTemplate mongoTemplate() {
        ConnectionString connString = new ConnectionString("mongodb+srv://ProjectEciHorarios:admin123@clusterecihorarios.gdwta.mongodb.net/ECIHorarios?w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build(); 
        
        MongoClient mongoClient = (MongoClient) MongoClients.create(settings); 
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient,"ECIHorarios");
        return mongoTemplate;

    }

}
