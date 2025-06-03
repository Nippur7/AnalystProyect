# 🎓 Sistema de Gestión Educativa - AICS

Este proyecto forma parte del desarrollo académico de la carrera de Análisis de Sistemas y propone un sistema informático para automatizar y mejorar la gestión educativa de la organización **AICS**.

## 📌 Objetivo

Desarrollar una solución de software modular que permita gestionar:

- Cursos
- Horarios de dictado
- Alumnos
- Inscripciones
- Evaluaciones
- Estados y asistencias
- Pagos

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java SE 8
- **IDE**: NetBeans 8.2
- **Base de Datos**: MySQL 8.x
- **ORM**: Hibernate (con mapeo XML `*.hbm.xml`)
- **Interfaz Gráfica**: Java Swing
- **Gestión de Proyecto**: PUD (Proceso Unificado de Desarrollo)

## 🧱 Estructura del Proyecto

```
src/
├── com.aics.model         # Clases de dominio (Curso, Alumno, etc.)
├── com.aics.view          # Interfaces gráficas (Swing)
├── com.aics.config        # Configuración de Hibernate y conexión
├── resources/             # Archivos hibernate.cfg.xml y .hbm.xml
└── docs/                  # Diagramas UML, DER, Estado, etc.
```

## 🚀 Funcionalidades Implementadas

- Alta y gestión de cursos con múltiples días y horarios
- Registro y estado de alumnos ('Activo', 'Inactivo', 'Baja')
- Visualización en tablas de cursos y sus horarios asociados
- Persistencia completa en base de datos MySQL
- Uso de estructuras de control, excepciones, objetos y colecciones

## 📊 Diagramas Incluidos

- Diagrama de Clases UML
- Diagrama Entidad-Relación (DER)
- Diagrama de Estados (Inscripción)

## 🧪 Requisitos

- Java JDK 8+
- NetBeans 8.2 o superior
- MySQL Server (con base de datos `aics`)
- Conector JDBC MySQL (`mysql-connector-java-X.X.X.jar`)

## 💡 Instalación

1. Clonar este repositorio:
   ```bash
   git clone https://github.com/Nippur7/AnalystProyect
   ```
2. Importar el proyecto en NetBeans.
3. Configurar la conexión a la base de datos en `hibernate.cfg.xml`.
4. Ejecutar el proyecto (`run` o botón ▶️ en NetBeans).

## 📁 Base de Datos

Incluye script SQL para crear la base de datos y tablas en:
```
docs/sql/aics_estructura.sql
```

## 📌 Estado del Proyecto

✅ Prototipo funcional  
🚧 En desarrollo (nuevos módulos: evaluaciones, asistencias, reportes)

## 📚 Referencias

> Kendall, K., & Kendall, J. (2011). *Análisis y diseño de sistemas*. Pearson Education.

---

**Autor**: Carlos Matich  
**Licencia**: MIT
