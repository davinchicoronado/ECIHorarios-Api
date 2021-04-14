/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorariosapi;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author David Coronado
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.ecihorarios"})
public class ECIHorariosAPIApplication {

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
