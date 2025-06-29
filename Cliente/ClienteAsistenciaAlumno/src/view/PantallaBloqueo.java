/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author tonym
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PantallaBloqueo extends javax.swing.JPanel {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnLogout;
    private JLabel lblMensaje;
    private JLabel lblModo;
    private JPanel panel;
    /**
     * Creates new form PantallaBloqueo1
     */
    public PantallaBloqueo() {
        initComponents();
        inicializarComponentes();
    }
private void inicializarComponentes() {
        
        panel = new JPanel();
        setLayout(null);
        setBackground(new Color(30, 30, 30));

        JLabel lblTitulo = new JLabel("ACCESO AL SISTEMA EDUCATIVO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(400, 100, 500, 30);
        add(lblTitulo);

        JLabel lblUsuario = new JLabel("ID Alumno:");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setBounds(400, 180, 100, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(520, 180, 150, 25);
        add(txtUsuario);

        JLabel lblPassword = new JLabel("DNI:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(400, 220, 100, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(520, 220, 150, 25);
        add(txtPassword);

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(520, 260, 150, 30);
        add(btnLogin);

        btnLogout = new JButton("Cerrar sesión");
        btnLogout.setBounds(520, 320, 150, 30);
        btnLogout.setVisible(false);
        add(btnLogout);

        lblMensaje = new JLabel("");
        lblMensaje.setForeground(Color.YELLOW);
        lblMensaje.setBounds(400, 370, 400, 25);
        add(lblMensaje);

        lblModo = new JLabel("");
        lblModo.setForeground(Color.CYAN);
        lblModo.setBounds(400, 400, 400, 25);
        add(lblModo);
    }

    // Métodos para el controlador
    public String getUsuario() {
        return txtUsuario.getText().trim();
    }

    public String getPassword() {
        return new String(txtPassword.getPassword()).trim();
    }

    public void mostrarMensaje(String mensaje) {
        lblMensaje.setText(mensaje);
    }

    public void setModoClase(boolean esClase) {
        lblModo.setText(esClase ? "Modo: Clase" : "Modo: Práctica");
    }

    /*public void mostrarPantallaDesbloqueada() {
        txtUsuario.setEnabled(false);
        txtPassword.setEnabled(false);
        btnLogin.setEnabled(false);
        btnLogout.setVisible(true);
        //this.setVisible(false);
        java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
        if (window instanceof javax.swing.JFrame) {
            ((javax.swing.JFrame) window).setExtendedState(javax.swing.JFrame.ICONIFIED);
        }
    }*/
    
    public void mostrarPantallaDesbloqueada() {
    // Ocultar campos de login
    txtUsuario.setVisible(false);
    txtPassword.setVisible(false);
    btnLogin.setVisible(false);

    // Mostrar botón de logout y mensajes
    lblMensaje.setText("Sesión activa.");
    lblMensaje.setVisible(true);
    lblMensaje.setBounds(20, 20, 360, 25);

    lblModo.setVisible(true);
    lblModo.setBounds(20, 50, 360, 25);

    btnLogout.setBounds(250, 100, 120, 30); // nueva ubicación
    btnLogout.setVisible(true);

    panel.setBackground(new Color(30, 30, 30));

    // Redimensionar la ventana
    java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
    if (window instanceof javax.swing.JFrame) {
        javax.swing.JFrame frame = (javax.swing.JFrame) window;
        frame.setSize(400, 200);
        frame.setLocation(10, 10);
       // frame.setUndecorated(false);
        frame.dispose(); // para poder cambiar undecorated
        frame.setUndecorated(true);
        frame.setVisible(true);

    }

    panel.revalidate();
    panel.repaint();
}



    /*public void mostrarPantallaBloqueo() {
        txtUsuario.setText("");
        txtPassword.setText("");
        txtUsuario.setEnabled(true);
        txtPassword.setEnabled(true);
        btnLogin.setEnabled(true);
        btnLogout.setVisible(false);
        lblModo.setText("");
    }*/
    
    public void mostrarPantallaBloqueo() {
    txtUsuario.setText("");
    txtPassword.setText("");

    txtUsuario.setVisible(true);
    txtPassword.setVisible(true);
    btnLogin.setVisible(true);
    btnLogout.setVisible(false);

    lblMensaje.setText("");
    lblModo.setText("");

    // Restaurar ventana completa
    java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
    if (window instanceof javax.swing.JFrame) {
        javax.swing.JFrame frame = (javax.swing.JFrame) window;
        frame.dispose();
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    this.revalidate();
    this.repaint();
}



    public void setLoginAction(ActionListener listener) {
        btnLogin.addActionListener(listener);
    }

    public void setLogoutAction(ActionListener listener) {
        btnLogout.addActionListener(listener);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
