/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.AgroSesame.AgroSesame.Repository;

import com.AgroSesame.AgroSesame.Models.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacturasRepo extends JpaRepository<Facturas, Long>{
    
}
