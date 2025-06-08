package com.aics.model;

import com.aics.model.Inscripcion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-06-07T22:47:23")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, Date> fechaNac;
    public static volatile SingularAttribute<Alumno, Integer> idAlumno;
    public static volatile SingularAttribute<Alumno, Byte> estado;
    public static volatile SingularAttribute<Alumno, String> apellido;
    public static volatile ListAttribute<Alumno, Inscripcion> inscripciones;
    public static volatile SingularAttribute<Alumno, String> tel;
    public static volatile SingularAttribute<Alumno, Date> createStamp;
    public static volatile SingularAttribute<Alumno, String> nombre;
    public static volatile SingularAttribute<Alumno, Integer> dni;
    public static volatile SingularAttribute<Alumno, String> email;

}