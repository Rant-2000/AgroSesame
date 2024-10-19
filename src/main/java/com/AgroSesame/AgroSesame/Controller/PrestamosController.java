/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AgroSesame.AgroSesame.Controller;

import com.AgroSesame.AgroSesame.Models.Prestamos;
import com.AgroSesame.AgroSesame.Repository.PrestamosRepo;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrestamosController {

    @Autowired
    private PrestamosRepo prerepo;

    @GetMapping("/Prestamos")
    public List<Prestamos> lista() {
        return prerepo.findAll();
    }

    @PostMapping("/Prestamos/guardar")
    public ResponseEntity<String> guardar(@RequestBody Prestamos prestamo) {
        try {
            prerepo.save(prestamo);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Prestamo no guardado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/Prestamos/editar/{idPrestamo}")
    public ResponseEntity<String> editar(@RequestBody Prestamos prestamo, @PathVariable Long idPrestamo) {
        try {
            Prestamos p = prerepo.findById(idPrestamo).orElseThrow(() -> new NoSuchElementException("Prestamo no encontrado"));
            p.setFecha(prestamo.getFecha());
            p.setMonto(prestamo.getMonto());
            p.setPagado(prestamo.isPagado());
            p.setSocio(prestamo.getSocio());

            prerepo.save(p);
            return new ResponseEntity<>("Editado correctamente", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Prestamo no guardado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Prestamos/eliminar/{idPrestamo}")
    public ResponseEntity<String> elimina(@PathVariable Long idPrestamo) {
        try {
            Prestamos p=prerepo.findById(idPrestamo).orElseThrow(()-> new NoSuchElementException("Prestamo no encontrado"));
            prerepo.delete(p);
            return new ResponseEntity<>("Borrado correctamente", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Prestamo no borrado", HttpStatus.NOT_FOUND);
        }
    }

}
