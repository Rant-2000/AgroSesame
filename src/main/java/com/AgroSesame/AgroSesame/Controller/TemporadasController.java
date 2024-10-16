/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AgroSesame.AgroSesame.Controller;

import com.AgroSesame.AgroSesame.Models.Temporadas;
import com.AgroSesame.AgroSesame.Repository.TemporadasRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemporadasController {
    @Autowired
    private TemporadasRepo tempo;
    
    @GetMapping("/")
    public String inicio() {

        return "Conectado";
    }

    @GetMapping("/Temporadas")
    public List<Temporadas> temporadasLista() {

        return tempo.findAll();
    }
    
}
