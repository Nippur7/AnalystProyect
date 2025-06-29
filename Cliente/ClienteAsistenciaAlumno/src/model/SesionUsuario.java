package model;

import config.NewHibernateUtil;
import java.time.DayOfWeek;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.Query;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.sql.Time.*;
import java.time.Duration;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Asistencia;
import org.hibernate.Transaction;
import model.DiaSemana;

public class SesionUsuario {

    private Alumno alumno;
    private LocalDateTime horaInicio,horaInicial;
    private LocalDateTime horaFin;
    private Alumno alumnoActual;
    private Inscripcion inscripcionActual;
    private boolean modoClase;


    /*public boolean iniciarSesion(String idAlumnoStr, String dniStr) {
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
    }*/
    
    private LocalDateTime convertToLocalDateTime(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
}
    
    private DiaSemana mapearDiaSemana(DayOfWeek diaIngles) {
    switch (diaIngles) {
        case MONDAY: return DiaSemana.LUNES;
        case TUESDAY: return DiaSemana.MARTES;
        case WEDNESDAY: return DiaSemana.MIERCOLES;
        case THURSDAY: return DiaSemana.JUEVES;
        case FRIDAY: return DiaSemana.VIERNES;
        case SATURDAY: return DiaSemana.SABADO;
        default: throw new IllegalArgumentException("Día no soportado: " + diaIngles);
    }
}

    
    public boolean iniciarSesion(String idAlumnoStr, String dniStr) {
    try {
        Integer idAlumno = Integer.parseInt(idAlumnoStr);
        Integer dni = Integer.parseInt(dniStr);

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Buscar al alumno
        Alumno alumno = (Alumno) session.createQuery(
            "FROM Alumno WHERE idAlumno = :id AND dni = :dni AND estado = 1")
            .setParameter("id", idAlumno)
            .setParameter("dni", dni)
            .uniqueResult();

        if (alumno == null) {
            session.close();
            return false;
        }

        this.alumnoActual = alumno;

        // Buscar inscripciones activas
        List<Inscripcion> activas = session.createQuery(
            "FROM Inscripcion WHERE alumno.idAlumno = :id AND estado = 1")
            .setParameter("id", alumno.getIdAlumno())
            .list();

        if (activas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El alumno no tiene inscripciones activas.");
            session.close();
            return false;
        }

        Inscripcion seleccionada;

        // Selección de inscripción si hay más de una
        if (activas.size() == 1) {
            seleccionada = activas.get(0);
        } else {
            DefaultComboBoxModel<Inscripcion> modeloCombo = new DefaultComboBoxModel<>();
            for (Inscripcion i : activas) {
                modeloCombo.addElement(i);
            }

            JComboBox<Inscripcion> comboBox = new JComboBox<>(modeloCombo);
            int opcion = JOptionPane.showConfirmDialog(
                null,
                comboBox,
                "Seleccioná una inscripción para registrar práctica:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (opcion != JOptionPane.OK_OPTION) {
                session.close();
                return false;
            }

            seleccionada = (Inscripcion) comboBox.getSelectedItem();
        }

        this.inscripcionActual = seleccionada;
        this.horaInicio = LocalDateTime.now();

        // Determinar si está en horario de clase
        Curso curso = seleccionada.getCurso();
        LocalDateTime ahora = LocalDateTime.now();
        DiaSemana diaActual = mapearDiaSemana(ahora.getDayOfWeek());
                //DiaSemana.valueOf(ahora.getDayOfWeek().name());

        List<CursoHorario> horarios = session.createQuery(
            "FROM CursoHorario WHERE curso.idcursos = :idCurso AND dia = :dia")
            .setParameter("idCurso", curso.getIdcursos())
            .setParameter("dia", diaActual.name())
            .list();

        this.modoClase = false; // por defecto es práctica
        for (CursoHorario horario : horarios) {
            Date horaInicio = horario.getHoraInicio();
            Date horaFin = horario.getHoraFin();

            Calendar calInicio = Calendar.getInstance();
            calInicio.setTime(horaInicio);
            int inicioHora = calInicio.get(Calendar.HOUR_OF_DAY);
            int inicioMinuto = calInicio.get(Calendar.MINUTE);

            Calendar calFin = Calendar.getInstance();
            calFin.setTime(horaFin);
            int finHora = calFin.get(Calendar.HOUR_OF_DAY);
            int finMinuto = calFin.get(Calendar.MINUTE);

            LocalTime ahoraTime = LocalTime.now();
            LocalTime inicio = LocalTime.of(inicioHora, inicioMinuto);
            LocalTime fin = LocalTime.of(finHora, finMinuto);

            if (!ahoraTime.isBefore(inicio) && !ahoraTime.isAfter(fin)) {
                this.modoClase = true;
                break;
            }
        }

        session.getTransaction().commit();
        session.close();

        return true;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error en inicio de sesión: " + e.getMessage());
        return false;
    }
}



    public void cerrarSesion() {
    if (horaInicio != null) {
        Duration duracion = Duration.between(horaInicio, LocalDateTime.now());
        System.out.println("Sesión finalizada. Duración: " + duracion.toMinutes() + " minutos.");
    } else {
        System.out.println("Hora de inicio de sesión no estaba seteada.");
    }

    // Reset de atributos
    this.inscripcionActual = null;
    this.horaInicio = null;
    this.alumnoActual = null;
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
    public void registrarAsistencia(boolean esClase) {
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;

    try {
        tx = session.beginTransaction();

        Asistencia asistencia = new Asistencia();
        asistencia.setInscripcion(inscripcionActual);
        asistencia.setFecha(new Date());
        asistencia.setHorario(new Date());
        asistencia.setMarca(esClase ? "Clase" : "Practica");
        asistencia.setAsistenciacol("Presente"); // activo
        asistencia.setCreateStamp(new Date());

        session.save(asistencia);

        // Guardamos en campo de sesión si querés reutilizarlo
        //this.asistenciaActual = asistencia;

        tx.commit();
    } catch (Exception ex) {
        if (tx != null) tx.rollback();
        ex.printStackTrace();
    } finally {
        session.close();
    }
}

    

    
}
