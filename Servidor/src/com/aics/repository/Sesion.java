/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aics.repository;

import com.aics.model.User;

/**
 *
 * @author tonym
 */
public class Sesion {
    int id;
    String user;
    boolean Iniciado;

    public Sesion() {
        this.Iniciado = false;
        this.id = 0;
        this.user = "";
    }
    
    
    
}
