/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David Coronado
 */
@RestController
public class ECIHorariosUserController {

    @GetMapping(value = "/")
    public String publico() {
        return "Hello world";
    }

    @GetMapping(value = "/private")
    public String privateArea() {
        return "Private area";
    }

    @GetMapping(value = "/prueba")
    public String prueba() {
        return "Private area";
    }
}
