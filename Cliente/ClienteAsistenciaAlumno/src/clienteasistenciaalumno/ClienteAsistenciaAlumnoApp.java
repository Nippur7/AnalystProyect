/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteasistenciaalumno;
import controller.LoginController;
import model.SesionUsuario;
import view.PantallaBloqueo;
/**
 *
 * @author tonym
 */
public class ClienteAsistenciaAlumnoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Control de Asistencia - AICS");
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true); // Para fullscreen sin bordes

            PantallaBloqueo vista = new PantallaBloqueo();
            frame.getContentPane().add(vista);
            frame.setVisible(true);

            SesionUsuario sesion = new SesionUsuario(); // usa Hibernate
            new LoginController(vista, sesion);
        });
    }
    
}
