/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import CRUD.Conectar;
import com.aics.User;
import aics.vistas.login;

/**
 *
 * @author tonym
 */
public class Aics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        login inicio = new login();        
        User usuario = new User();
        Conectar conect = new Conectar();
        inicio.setVisible(true);
    }
    //login inicio = new login();
    //inicio.new();
}
