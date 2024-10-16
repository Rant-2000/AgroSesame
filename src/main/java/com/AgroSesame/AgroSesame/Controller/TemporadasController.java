/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AgroSesame.AgroSesame.Controller;

import com.AgroSesame.AgroSesame.Models.Temporadas;
import com.AgroSesame.AgroSesame.Repository.TemporadasRepo;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.AgroSesame.AgroSesame.Models.Temporadas;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;

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

    @PostMapping("/Temporadas/guardar")
    public ResponseEntity<String> guardar(@RequestBody Temporadas temporada) {
        try {
            tempo.save(temporada);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Cliente no guardado", HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PutMapping("/Temporadas/editar/{idTemporada}")
    public ResponseEntity<String> editar(@PathVariable Long idTemporada,@RequestBody Temporadas temporada) {
        try {
            Temporadas tmp=tempo.findById(idTemporada).orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));
            tmp.setNombre(temporada.getNombre());
            tmp.setInicio(temporada.getInicio());
            tmp.setFin(temporada.getFin());
            
            tempo.save(tmp);
            return new ResponseEntity<>("Actualizado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
    }
    

}
