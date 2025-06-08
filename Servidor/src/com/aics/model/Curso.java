package com.aics.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcursos")
    private Integer idcursos;

    @Column(name = "Curso")
    private String curso;

    @Temporal(TemporalType.DATE)
    @Column(name = "Inicio")
    private Date inicio;

    @Column(name = "Capacidad")
    private Integer capacidad;

    @Temporal(TemporalType.DATE)
    @Column(name = "Finalizacion")
    private Date finalizacion;

    @Column(name = "estado_curso")
    private String estado_curso;
    
    
    @Column(name = "idProfesor")
    private Integer idProfesor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_Stamp")
    private Date createStamp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mod_stamp")
    private Date modStamp;

    // Relación opcional con Inscripcion
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Inscripcion> inscripciones;

    public Curso() {
    }

    public Curso(String curso, Date inicio, Integer capacidad, Date finalizacion, String estado_curso, Integer idProfesor, Date createStamp, Date modStamp) {
        this.curso = curso;
        this.inicio = inicio;
        this.capacidad = capacidad;
        this.finalizacion = finalizacion;
        this.estado_curso = estado_curso;
        this.idProfesor = idProfesor;
        this.createStamp = createStamp;
        this.modStamp = modStamp;
    }

    public Integer getIdcursos() {
        return idcursos;
    }

    public void setIdcursos(Integer idcursos) {
        this.idcursos = idcursos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Date getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(Date finalizacion) {
        this.finalizacion = finalizacion;
    }

    public String getEstado_curso() {
        return estado_curso;
    }

    public void setEstado_curso(String estado_curso) {
        this.estado_curso = estado_curso;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Date getCreateStamp() {
        return createStamp;
    }

    public void setCreateStamp(Date createStamp) {
        this.createStamp = createStamp;
    }

    public Date getModStamp() {
        return modStamp;
    }

    public void setModStamp(Date modStamp) {
        this.modStamp = modStamp;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
}
