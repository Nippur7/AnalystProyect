package com.aics.model;

import com.aics.model.Alumno;
import com.aics.model.Curso;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-06-08T10:59:14")
@StaticMetamodel(Inscripcion.class)
public class Inscripcion_ { 

    public static volatile SingularAttribute<Inscripcion, Integer> estado;
    public static volatile SingularAttribute<Inscripcion, Curso> curso;
    public static volatile SingularAttribute<Inscripcion, Alumno> alumno;
    public static volatile SingularAttribute<Inscripcion, Date> createStamp;
    public static volatile SingularAttribute<Inscripcion, Date> modTimestamp;
    public static volatile SingularAttribute<Inscripcion, Integer> idinscripciones;

}