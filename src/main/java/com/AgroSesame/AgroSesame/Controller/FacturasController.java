/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AgroSesame.AgroSesame.Controller;
import com.AgroSesame.AgroSesame.Models.Facturas;
import com.AgroSesame.AgroSesame.Repository.FacturasRepo;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
public class FacturasController {
    @Autowired
    private FacturasRepo farepo;
    
    @GetMapping("/Facturas")
    public List<Facturas> lista(){
        return farepo.findAll();
    }
    
     @PostMapping("/Facturas/guardar")
    public ResponseEntity<String> guardar(@RequestBody Facturas factura) {
        try {
            farepo.save(factura);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("No guardado", HttpStatus.NOT_FOUND);
        }
    }
    
    
        @PutMapping("/Facturas/editar/{idFactura}")
    public ResponseEntity<String> editar(@RequestBody Facturas factura, @PathVariable Long idFactura) {
        try {
            Facturas p = farepo.findById(idFactura).orElseThrow(() -> new NoSuchElementException("Factura no encontrado"));
            p.setMonto(factura.getMonto());
            p.setFecha(factura.getFecha());
            p.setSocio(factura.getSocio());
            
            farepo.save(p);
            return new ResponseEntity<>("Editado correctamente", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("No guardada", HttpStatus.NOT_FOUND);
        }
    }
    
    
        @DeleteMapping("/Facturas/eliminar/{idFactura}")
    public ResponseEntity<String> elimina(@PathVariable Long idFactura) {
        try {
            Facturas p=farepo.findById(idFactura).orElseThrow(()-> new NoSuchElementException("No encontrado"));
            farepo.delete(p);
            return new ResponseEntity<>("Borrado correctamente", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("No borrado", HttpStatus.NOT_FOUND);
        }
    }
    
    
}
