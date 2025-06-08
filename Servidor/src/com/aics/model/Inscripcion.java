package com.aics.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inscripcion")
public class Inscripcion implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinscripciones")
    private Integer idinscripciones;

    @ManyToOne
    @JoinColumn(name = "idCursos", referencedColumnName = "idcursos")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "IdAlumnos", referencedColumnName = "idAlumno")
    private Alumno alumno;

    @Column(name = "estado")
    private Integer estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_stamp")
    private Date createStamp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mod_timestamp")
    private Date modTimestamp;

    public Inscripcion() {}

    public Inscripcion(Curso curso, Alumno alumno, Integer estado, Date createStamp, Date modTimestamp) {
        this.curso = curso;
        this.alumno = alumno;
        this.estado = estado;
        this.createStamp = createStamp;
        this.modTimestamp = modTimestamp;
    }

    public Integer getIdinscripciones() {
        return idinscripciones;
    }

    public void setIdinscripciones(Integer idinscripciones) {
        this.idinscripciones = idinscripciones;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getCreateStamp() {
        return createStamp;
    }

    public void setCreateStamp(Date createStamp) {
        this.createStamp = createStamp;
    }

    public Date getModTimestamp() {
        return modTimestamp;
    }

    public void setModTimestamp(Date modTimestamp) {
        this.modTimestamp = modTimestamp;
    }
}