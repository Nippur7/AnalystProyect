package com.aics.model;

import com.aics.model.Curso;
import com.aics.model.DiaSemana;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-06-07T22:47:23")
@StaticMetamodel(CursoHorario.class)
public class CursoHorario_ { 

    public static volatile SingularAttribute<CursoHorario, Date> horaFin;
    public static volatile SingularAttribute<CursoHorario, Curso> curso;
    public static volatile SingularAttribute<CursoHorario, Integer> id;
    public static volatile SingularAttribute<CursoHorario, DiaSemana> dia;
    public static volatile SingularAttribute<CursoHorario, Date> horaInicio;

}