/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AgroSesame.AgroSesame.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
public class Terrenos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idTerreno;

    private String coordenadas;
    
    private double area;

    @Column(name="es_de_riego")
    private boolean esDeRiego;  // Cambié el tipo a `boolean` para mayor claridad

    // Relación ManyToOne: Muchos Terrenos pertenecen a un Socio
    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    private Socios socio;  // Aquí defines la relación con la entidad Socio
}

