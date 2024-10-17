/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AgroSesame.AgroSesame.Controller;

import com.AgroSesame.AgroSesame.Models.Socios;
import com.AgroSesame.AgroSesame.Repository.SociosRepo;
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
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SociosController {
    
    @Autowired
    private SociosRepo sorepo;
    
    @GetMapping("/Socios")
    public List<Socios> inicio(){
        return sorepo.findAll();
    }
    
    
    @PostMapping("Socios/guardar")
    public ResponseEntity<String> guardar(@RequestBody Socios socio) {
        try {
            sorepo.save(socio);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Socio no guardado", HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/Socios/editar/{idSocio}")
    public ResponseEntity<String> editar(@PathVariable Long idSocio, @RequestBody Socios socio) {
        try {
            Socios soc = sorepo.findById(idSocio).orElseThrow(() -> new NoSuchElementException("Socio no encontrado"));
            soc.setNombre(socio.getNombre());
            soc.setTelefono(socio.getTelefono());
            soc.setDireccion(socio.getDireccion());
            
            
            sorepo.save(socio);
            return new ResponseEntity<>("Actualizado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Socio no encontrado", HttpStatus.NOT_FOUND);
        }
    }
    
    
     @DeleteMapping("/Socios/borrar/{idSocio}")
    public ResponseEntity<String> eliminar(@PathVariable Long idSocio) {
        try {
            Socios soc = sorepo.findById(idSocio).orElseThrow(() -> new NoSuchElementException("Socio no encontrado"));
            sorepo.delete(soc);
            return new ResponseEntity<>("Socio borrado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Socio no encontrado", HttpStatus.NOT_FOUND);
        }
        
    }
    
}
