/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.AgroSesame.AgroSesame.Repository;

import com.AgroSesame.AgroSesame.Models.Socios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rant
 */
public interface SociosRepo extends JpaRepository<Socios, Long>{
    
}
