/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.AgroSesame.AgroSesame.Repository;

import com.AgroSesame.AgroSesame.Models.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rant
 */
public interface PrestamosRepo extends JpaRepository<Prestamos, Long>{
    
}
