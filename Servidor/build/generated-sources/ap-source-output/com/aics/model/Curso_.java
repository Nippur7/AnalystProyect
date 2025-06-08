package com.aics.model;

import com.aics.model.Inscripcion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-06-08T10:59:14")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, Date> modStamp;
    public static volatile SingularAttribute<Curso, Integer> idcursos;
    public static volatile SingularAttribute<Curso, Integer> idProfesor;
    public static volatile SingularAttribute<Curso, String> estado_curso;
    public static volatile SingularAttribute<Curso, String> curso;
    public static volatile ListAttribute<Curso, Inscripcion> inscripciones;
    public static volatile SingularAttribute<Curso, Date> inicio;
    public static volatile SingularAttribute<Curso, Date> finalizacion;
    public static volatile SingularAttribute<Curso, Date> createStamp;
    public static volatile SingularAttribute<Curso, Integer> capacidad;

}