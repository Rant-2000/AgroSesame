/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AgroSesame.AgroSesame.Controller;

import com.AgroSesame.AgroSesame.Models.Terrenos;
import com.AgroSesame.AgroSesame.Repository.TerrenosRepo;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TerrenosController {

    @Autowired
    private TerrenosRepo terepo;

    @GetMapping("/Terrenos")
    public List<Terrenos> inicio() {
        return terepo.findAll();
    }

    @PostMapping("/Terrenos/guardar")
    public ResponseEntity<String> save(@RequestBody Terrenos terreno) {
        try {
            terepo.save(terreno);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Terreno no guardado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/Terrenos/editar/{idTerreno}")
    public ResponseEntity<String> editar(@PathVariable Long idTerreno, @RequestBody Terrenos terreno) {
        try {
            Terrenos ter = terepo.findById(idTerreno).orElseThrow(() -> new NoSuchElementException("Terreno no encontrado"));
            ter.setArea(terreno.getArea());
            ter.setCoordenadas(terreno.getCoordenadas());
            ter.setEsDeRiego(terreno.isEsDeRiego());
            ter.setSocio(terreno.getSocio());
            terepo.save(ter);
            return new ResponseEntity<>("Actualizado", HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Terreno no encontrado", HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/Terrenos/borrar/{idTerreno}")
    public ResponseEntity<String> borrar(@PathVariable Long idTerreno){
        try {
            Terrenos terreno = terepo.findById(idTerreno).orElseThrow(() -> new NoSuchElementException("Terreno no encontrado"));
            terepo.delete(terreno);
            
            return new ResponseEntity<>("Terreno borrado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Terreno no encontrado", HttpStatus.NOT_FOUND);
        }
    }
    
    

}
