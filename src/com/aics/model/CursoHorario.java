/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aics.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tonym
 */
@Entity
@Table(name = "curso_horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoHorario.findAll", query = "SELECT c FROM CursoHorario c")
    , @NamedQuery(name = "CursoHorario.findById", query = "SELECT c FROM CursoHorario c WHERE c.id = :id")
    , @NamedQuery(name = "CursoHorario.findByDia", query = "SELECT c FROM CursoHorario c WHERE c.dia = :dia")
    , @NamedQuery(name = "CursoHorario.findByHoraInicio", query = "SELECT c FROM CursoHorario c WHERE c.horaInicio = :horaInicio")
    , @NamedQuery(name = "CursoHorario.findByHoraFin", query = "SELECT c FROM CursoHorario c WHERE c.horaFin = :horaFin")})
public class CursoHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @Enumerated(EnumType.STRING) // Aquí está el truco
    @Column(name = "dia", nullable = false)
    private DiaSemana dia;
    //*@Basic(optional = false)
    //*@Column(name = "dia")
    //*private String dia;
    @Basic(optional = false)
    @Column(name = "horaInicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "horaFin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;

    public CursoHorario() {
    }

    public CursoHorario(Integer id) {
        this.id = id;
    }

    public CursoHorario(Curso curso, DiaSemana dia, Date horaInicio, Date horaFin) {
        this.curso = curso;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoHorario)) {
            return false;
        }
        CursoHorario other = (CursoHorario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aics.model.CursoHorario[ id=" + id + " ]";
    }
    
}
