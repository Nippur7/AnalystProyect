package com.aics.model;
// Generated 16/12/2023 00:26:11 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Inscripcion generated by hbm2java
 */
public class Inscripcion  implements java.io.Serializable {


     private Integer idinscripciones;
     private Integer idCursos;
     private Integer idAlumnos;
     private Integer estado; //en tabla tinyint(4)
     private Date createStamp;
     private Date modTimestamp;

    public Inscripcion() {
    }

    public Inscripcion(Integer idCursos, Integer idAlumnos, Integer estado, Date createStamp, Date modTimestamp) {
       this.idCursos = idCursos;
       this.idAlumnos = idAlumnos;
       this.estado = estado;
       this.createStamp = createStamp;
       this.modTimestamp = modTimestamp;
    }
   
    public Integer getIdinscripciones() {
        return this.idinscripciones;
    }
    
    public void setIdinscripciones(Integer idinscripciones) {
        this.idinscripciones = idinscripciones;
    }
    public Integer getIdCursos() {
        return this.idCursos;
    }
    
    public void setIdCursos(Integer idCursos) {
        this.idCursos = idCursos;
    }
    public Integer getIdAlumnos() {
        return this.idAlumnos;
    }
    
    public void setIdAlumnos(Integer idAlumnos) {
        this.idAlumnos = idAlumnos;
    }
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public Date getCreateStamp() {
        return this.createStamp;
    }
    
    public void setCreateStamp(Date createStamp) {
        this.createStamp = createStamp;
    }
    
    public Date getModTimestamp() {
        return this.modTimestamp;
    }
    
    public void setModTimestamp(Date modTimestamp) {
        this.modTimestamp = modTimestamp;
    }




}


