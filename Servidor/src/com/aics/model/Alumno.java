package com.aics.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno") // nombre exacto en la tabla MySQL
    private Integer idAlumno;

    @Column(name = "dni")
    private Integer dni;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Fecha_Nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    @Column(name = "Estado")
    private Byte estado;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email")
    private String email;

    @Column(name = "create_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createStamp;

    // Relación con Inscripcion (opcional pero recomendable si se necesita acceder desde Alumno)
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Inscripcion> inscripciones;

    public Alumno() {
    }

    public Alumno(Integer dni, String apellido, String nombre, Date fechaNac, Byte estado, String tel, String email, Date createStamp) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.estado = estado;
        this.tel = tel;
        this.email = email;
        this.createStamp = createStamp;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Byte getEstado() {
        return estado;
    }

    public void setEstado(Byte estado) {
        this.estado = estado;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateStamp() {
        return createStamp;
    }

    public void setCreateStamp(Date createStamp) {
        this.createStamp = createStamp;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
}
