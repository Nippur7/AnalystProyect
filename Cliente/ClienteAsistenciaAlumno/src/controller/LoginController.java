/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.SesionUsuario;
import view.PantallaBloqueo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class LoginController {

    private PantallaBloqueo vista;
    private SesionUsuario sesion;

    public LoginController(PantallaBloqueo vista, SesionUsuario sesion) {
        this.vista = vista;
        this.sesion = sesion;

        this.vista.setLoginAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = vista.getUsuario();
                String pass = vista.getPassword();

                if (sesion.iniciarSesion(user, pass)) {
                    vista.mostrarMensaje("Bienvenido " + user);
                    vista.setModoClase(sesion.estaEnHorarioClase());
                    vista.mostrarPantallaDesbloqueada();
                } else {
                    vista.mostrarMensaje("Credenciales inválidas.");
                }
            }
        });

        this.vista.setLogoutAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sesion.cerrarSesion();
                vista.mostrarMensaje("Sesión cerrada. Tiempo registrado.");
                vista.mostrarPantallaBloqueo();
            }
        });
    }
}
