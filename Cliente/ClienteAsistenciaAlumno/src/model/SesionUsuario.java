package model;

import config.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SesionUsuario {

    private Alumno alumno;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;

    public boolean iniciarSesion(String idAlumnoStr, String dniStr) {
        try {
            int idAlumno = Integer.parseInt(idAlumnoStr);
            int dni = Integer.parseInt(dniStr);

            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(
                    "FROM Alumno WHERE idAlumno = :id AND dni = :dni");
            query.setParameter("id", idAlumno);
            query.setParameter("dni", dni);

            alumno = (Alumno) query.uniqueResult();
            session.close();

            if (alumno != null) {
                horaInicio = LocalDateTime.now();
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void cerrarSesion() {
        horaFin = LocalDateTime.now();
        long minutos = java.time.Duration.between(horaInicio, horaFin).toMinutes();

        // Aquí podrías persistir el registro en la tabla asistencia
        System.out.println("Alumno ID: " + alumno.getIdAlumno());
        System.out.println("Sesión cerrada. Duración: " + minutos + " minutos.");

        alumno = null;
        horaInicio = null;
        horaFin = null;
    }

    public boolean estaEnHorarioClase() {
        // Horario fijo de clase para el prototipo (puede vincularse con la tabla CursoHorario más adelante)
        LocalTime ahora = LocalTime.now();
        LocalTime inicio = LocalTime.of(19, 0);
        LocalTime fin = LocalTime.of(21, 0);
        return ahora.isAfter(inicio) && ahora.isBefore(fin);
    }

    public boolean isSesionActiva() {
        return alumno != null && horaInicio != null;
    }

    public String getNombreAlumno() {
        return alumno != null ? alumno.getNombre() + " " + alumno.getApellido() : "";
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public long getDuracionSesionMinutos() {
        if (horaInicio != null && horaFin != null) {
            return java.time.Duration.between(horaInicio, horaFin).toMinutes();
        }
        return 0;
    }

    public boolean isEnHorarioClase() {
        return estaEnHorarioClase();
    }
}
