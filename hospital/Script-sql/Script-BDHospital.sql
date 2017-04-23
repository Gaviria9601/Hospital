CREATE TABLE Afiliacion
  (
    Codigo             INTEGER NOT NULL ,
    Nombre             VARCHAR2 (30) NOT NULL ,
    Telefono           VARCHAR2 (30) NOT NULL ,
    ServiciosIncluidos VARCHAR2 (2000) NOT NULL
  ) ;
ALTER TABLE Afiliacion ADD CONSTRAINT Tipo_afiliación_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Cama
  (
    Instalacion_Codigo INTEGER NOT NULL ,
    Numero             INTEGER NOT NULL ,
    Descripcion        VARCHAR2 (2000) ,
    Habitacion_codigo  INTEGER NOT NULL
  ) ;
ALTER TABLE Cama ADD CONSTRAINT Cama_PK PRIMARY KEY ( Instalacion_Codigo ) ;


CREATE TABLE Cirugia
  (
    Codigo                 INTEGER NOT NULL ,
    Recuperacion           VARCHAR2 (50) NOT NULL ,
    Anestesia              CHAR (1) ,
    Especializacion_Codigo INTEGER NOT NULL ,
    TipoCirugia_Codigo     INTEGER NOT NULL
  ) ;
ALTER TABLE Cirugia ADD CONSTRAINT Cirugia_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Cita
  (
    Codigo          INTEGER NOT NULL ,
    Fecha           DATE NOT NULL ,
    Hora_inicio     TIMESTAMP NOT NULL ,
    Observacion     VARCHAR2 (2000) ,
    hora_final      TIMESTAMP NOT NULL ,
    Cita_Codigo     INTEGER ,
    Medico_Cedula   VARCHAR2 (20) NOT NULL ,
    Paciente_cedula VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE Cita ADD CONSTRAINT Cita_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Cita_avanzada
  (
    Codigo         INTEGER NOT NULL ,
    Nombre         VARCHAR2 (20) NOT NULL ,
    Observaciones  VARCHAR2 (1000) NOT NULL ,
    TiempoEstimado VARCHAR2 (50) NOT NULL ,
    tipo           VARCHAR2 (20)
  ) ;
ALTER TABLE Cita_avanzada ADD CONSTRAINT Cita_avanzada_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE DiagnosticoCita
  (
    Cita_Codigo      INTEGER NOT NULL ,
    Patologia_Codigo INTEGER NOT NULL
  ) ;
ALTER TABLE DiagnosticoCita ADD CONSTRAINT Item_patologia_PK PRIMARY KEY ( Cita_Codigo, Patologia_Codigo ) ;


CREATE TABLE Especializacion
  (
    Codigo INTEGER NOT NULL ,
    Nombre VARCHAR2 (40) NOT NULL
  ) ;
ALTER TABLE Especializacion ADD CONSTRAINT Especialización_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Examen
  (
    Codigo        INTEGER NOT NULL ,
    TipoExamen_Id INTEGER NOT NULL
  ) ;
ALTER TABLE Examen ADD CONSTRAINT Examen_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Farmaceutico
  (
    cedula              VARCHAR2 (20) NOT NULL ,
    Tarjeta_profesional VARCHAR2 (30) ,
    Fecha_ingreso       DATE NOT NULL ,
    Farmacia_Codigo     INTEGER NOT NULL
  ) ;
ALTER TABLE Farmaceutico ADD CONSTRAINT Farmaceutico_PK PRIMARY KEY ( cedula ) ;


CREATE TABLE Farmacia
  (
    Codigo    INTEGER NOT NULL ,
    Nombre    VARCHAR2 (40) NOT NULL ,
    Telefono  VARCHAR2 (10) NOT NULL ,
    Direccion VARCHAR2 (40)
  ) ;
ALTER TABLE Farmacia ADD CONSTRAINT Farmacia_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Habitacion
  (
    codigo      INTEGER NOT NULL ,
    Numero      INTEGER NOT NULL ,
    Piso        INTEGER NOT NULL ,
    Descripcion VARCHAR2 (1000)
  ) ;
ALTER TABLE Habitacion ADD CONSTRAINT Habitacion_PK PRIMARY KEY ( codigo ) ;


CREATE TABLE Horario
  (
    Codigo_turno INTEGER NOT NULL ,
    Hora_Inicio  TIMESTAMP NOT NULL ,
    Hora_final   TIMESTAMP NOT NULL
  ) ;
ALTER TABLE Horario ADD CONSTRAINT Horario_PK PRIMARY KEY ( Codigo_turno ) ;


CREATE TABLE Hospitalizacion
  (
    Codigo INTEGER NOT NULL ,
    Causas VARCHAR2 (500) NOT NULL
  ) ;
ALTER TABLE Hospitalizacion ADD CONSTRAINT Hospitalización_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Instalacion
  (
    Codigo                INTEGER NOT NULL ,
    Disponibilidad        CHAR (1) NOT NULL ,
    ObservacionDisponible VARCHAR2 (1000) NOT NULL ,
    tipo                  VARCHAR2 (20)
  ) ;
ALTER TABLE Instalacion ADD CONSTRAINT Instalaciones_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Item_horario
  (
    Horario_Codigo_turno INTEGER NOT NULL ,
    Medico_Cedula        VARCHAR2 (20) NOT NULL ,
    Fecha                DATE NOT NULL ,
    estado               CHAR (1)
  ) ;
ALTER TABLE Item_horario ADD CONSTRAINT Item_horario_PK PRIMARY KEY ( Horario_Codigo_turno, Medico_Cedula ) ;


CREATE TABLE Item_medico
  (
    Especializacion_Codigo INTEGER NOT NULL ,
    Medico_Cedula          VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE Item_medico ADD CONSTRAINT Item_medico_PK PRIMARY KEY ( Especializacion_Codigo, Medico_Cedula ) ;


CREATE TABLE Item_sintoma
  (
    Sintoma_Codigo   INTEGER NOT NULL ,
    Patologia_Codigo INTEGER NOT NULL
  ) ;
ALTER TABLE Item_sintoma ADD CONSTRAINT Item_sintoma_PK PRIMARY KEY ( Sintoma_Codigo, Patologia_Codigo ) ;


CREATE TABLE Item_tratamiento
  (
    Patologia_Codigo   INTEGER NOT NULL ,
    Tratamiento_Codigo INTEGER NOT NULL
  ) ;
ALTER TABLE Item_tratamiento ADD CONSTRAINT Item_tratamiento_PK PRIMARY KEY ( Patologia_Codigo, Tratamiento_Codigo ) ;


CREATE TABLE Medicamento
  (
    Codigo           INTEGER NOT NULL ,
    Nombre           VARCHAR2 (40) NOT NULL ,
    Fecha_expedicion DATE NOT NULL ,
    Fecha_expiracion DATE NOT NULL ,
    Laboratorio      VARCHAR2 (40) NOT NULL ,
    Cantidad         INTEGER NOT NULL ,
    Estado           CHAR (1) NOT NULL ,
    Farmacia_Codigo  INTEGER NOT NULL
  ) ;
ALTER TABLE Medicamento ADD CONSTRAINT Medicamentos_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Medico
  (
    Cedula           VARCHAR2 (20) NOT NULL ,
    Carnet           VARCHAR2 (30) NOT NULL ,
    FacultadMedicina VARCHAR2 (60) ,
    estado           CHAR (1)
  ) ;
ALTER TABLE Medico ADD CONSTRAINT Medico_PK PRIMARY KEY ( Cedula ) ;


CREATE TABLE OrdenCirugia
  (
    OrdenProce                    INTEGER NOT NULL ,
    Cirugia_Codigo                INTEGER NOT NULL ,
    Medico_Cedula                 VARCHAR2 (20) NOT NULL ,
    horafinal                     TIMESTAMP ,
    horaInicio                    TIMESTAMP ,
    Quirofanoo_Instalacion_Codigo INTEGER NOT NULL
  ) ;
ALTER TABLE OrdenCirugia ADD CONSTRAINT OrdenCirugia_PK PRIMARY KEY ( OrdenProce ) ;


CREATE TABLE OrdenExamen
  (
    OrdenProcedimiento_codigo INTEGER NOT NULL ,
    Examen_Codigo             INTEGER NOT NULL ,
    hora                      TIMESTAMP
  ) ;
ALTER TABLE OrdenExamen ADD CONSTRAINT OrdenExamen_PK PRIMARY KEY ( OrdenProcedimiento_codigo ) ;


CREATE TABLE OrdenHospitalizacion
  (
    OrdenProcedimiento_codigo INTEGER NOT NULL ,
    Hora_inicio               TIMESTAMP NOT NULL ,
    Hospitalizacion_Codigo    INTEGER NOT NULL ,
    Cama_Instalacion_Codigo   INTEGER NOT NULL
  ) ;
ALTER TABLE OrdenHospitalizacion ADD CONSTRAINT OrdenCitaAvanzada_PK PRIMARY KEY ( OrdenProcedimiento_codigo ) ;


CREATE TABLE OrdenProcedimiento
  (
    codigo        INTEGER NOT NULL ,
    observaciones VARCHAR2 (2000) ,
    fecha         DATE ,
    estado        CHAR (1) ,
    Cita_Codigo   INTEGER NOT NULL
  ) ;
ALTER TABLE OrdenProcedimiento ADD CONSTRAINT OrdenProce_PK PRIMARY KEY ( codigo ) ;


CREATE TABLE Orden_medicamento
  (
    Medicamentos_Codigo INTEGER NOT NULL ,
    Cita_Codigo         INTEGER NOT NULL ,
    Cantidad            INTEGER NOT NULL ,
    Formula             VARCHAR2 (2000) ,
    estado              CHAR (1)
  ) ;
ALTER TABLE Orden_medicamento ADD CONSTRAINT Item_medicamento_PK PRIMARY KEY ( Medicamentos_Codigo, Cita_Codigo ) ;


CREATE TABLE Paciente
  (
    cedula            VARCHAR2 (20) NOT NULL ,
    Estrato           VARCHAR2 (10) NOT NULL ,
    Afiliacion_Codigo INTEGER NOT NULL ,
    Trabajo           VARCHAR2 (50)
  ) ;
ALTER TABLE Paciente ADD CONSTRAINT Paciente_PK PRIMARY KEY ( cedula ) ;


CREATE TABLE Patologia
  (
    Codigo      INTEGER NOT NULL ,
    Nombre      VARCHAR2 (50) NOT NULL ,
    Descripcion VARCHAR2 (1000)
  ) ;
ALTER TABLE Patologia ADD CONSTRAINT Patologia_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Quirofano
  (
    Instalacion_Codigo    INTEGER NOT NULL ,
    Caracteristicas       VARCHAR2 (2000) ,
    NumeroAparatos        INTEGER NOT NULL ,
    CantidadMedicosAcompa INTEGER
  ) ;
ALTER TABLE Quirofano ADD CONSTRAINT Quirofanoo_PK PRIMARY KEY ( Instalacion_Codigo ) ;


CREATE TABLE ResultadoExamen
  (
    codigo            INTEGER NOT NULL ,
    Observaciones     VARCHAR2 (2000) ,
    fecha             DATE ,
    OrdenProce_codigo INTEGER NOT NULL
  ) ;
ALTER TABLE ResultadoExamen ADD CONSTRAINT ResultadoExamen_PK PRIMARY KEY ( codigo ) ;
ALTER TABLE ResultadoExamen ADD CONSTRAINT ResultadoExamen__UN UNIQUE ( OrdenProce_codigo ) ;


CREATE TABLE Sintoma
  (
    Codigo      INTEGER NOT NULL ,
    Descripcion VARCHAR2 (1000) ,
    Causa       VARCHAR2 (1000) NOT NULL
  ) ;
ALTER TABLE Sintoma ADD CONSTRAINT Sintoma_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE TipoCirugia
  (
    Codigo INTEGER NOT NULL ,
    Nombre VARCHAR2 (50) NOT NULL
  ) ;
ALTER TABLE TipoCirugia ADD CONSTRAINT TipoCirugia_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE TipoExamen
  (
    codigo INTEGER NOT NULL ,
    Nombre VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE TipoExamen ADD CONSTRAINT TipoExamen_PK PRIMARY KEY ( codigo ) ;


CREATE TABLE Tratamiento
  (
    Codigo           INTEGER NOT NULL ,
    Tipo             VARCHAR2 (50) ,
    Farmacos_aplicar VARCHAR2 (500) NOT NULL ,
    Problema         VARCHAR2 (500) NOT NULL
  ) ;
ALTER TABLE Tratamiento ADD CONSTRAINT Tratamiento_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Usuario
  (
    Cedula      VARCHAR2 (20) NOT NULL ,
    Apellido    VARCHAR2 (50) ,
    Clave       VARCHAR2 (20) NOT NULL ,
    Correo      VARCHAR2 (100) NOT NULL ,
    Edad        INTEGER ,
    Nickname    VARCHAR2 (30) NOT NULL ,
    Nombre      VARCHAR2 (30) NOT NULL ,
    Telefono    VARCHAR2 (20) NOT NULL ,
    TipoUsuario VARCHAR2 (30)
  ) ;
ALTER TABLE Usuario ADD CONSTRAINT Usuario_PK PRIMARY KEY ( Cedula ) ;


ALTER TABLE Cama ADD CONSTRAINT Cama_Habitacion_FK FOREIGN KEY ( Habitacion_codigo ) REFERENCES Habitacion ( codigo ) ;

ALTER TABLE Cama ADD CONSTRAINT Cama_Instalacion_FK FOREIGN KEY ( Instalacion_Codigo ) REFERENCES Instalacion ( Codigo ) ;

ALTER TABLE Cirugia ADD CONSTRAINT Cirugia_Cita_avanzada_FK FOREIGN KEY ( Codigo ) REFERENCES Cita_avanzada ( Codigo ) ;

ALTER TABLE Cirugia ADD CONSTRAINT Cirugia_Especialización_FK FOREIGN KEY ( Especializacion_Codigo ) REFERENCES Especializacion ( Codigo ) ;

ALTER TABLE Cirugia ADD CONSTRAINT Cirugia_TipoCirugia_FK FOREIGN KEY ( TipoCirugia_Codigo ) REFERENCES TipoCirugia ( Codigo ) ;

ALTER TABLE Cita ADD CONSTRAINT Cita_Cita_FK FOREIGN KEY ( Cita_Codigo ) REFERENCES Cita ( Codigo ) ;

ALTER TABLE Cita ADD CONSTRAINT Cita_Medico_FK FOREIGN KEY ( Medico_Cedula ) REFERENCES Medico ( Cedula ) ;

ALTER TABLE Cita ADD CONSTRAINT Cita_Paciente_FK FOREIGN KEY ( Paciente_cedula ) REFERENCES Paciente ( cedula ) ;

ALTER TABLE Examen ADD CONSTRAINT Examen_Cita_avanzada_FK FOREIGN KEY ( Codigo ) REFERENCES Cita_avanzada ( Codigo ) ;

ALTER TABLE Examen ADD CONSTRAINT Examen_TipoExamen_FK FOREIGN KEY ( TipoExamen_Id ) REFERENCES TipoExamen ( codigo ) ;

ALTER TABLE Farmaceutico ADD CONSTRAINT Farmaceutico_Farmacia_FK FOREIGN KEY ( Farmacia_Codigo ) REFERENCES Farmacia ( Codigo ) ;

ALTER TABLE Farmaceutico ADD CONSTRAINT Farmaceutico_Usuario_FK FOREIGN KEY ( cedula ) REFERENCES Usuario ( Cedula ) ;

ALTER TABLE Hospitalizacion ADD CONSTRAINT HospitalizaciónCitaAvan_FK FOREIGN KEY ( Codigo ) REFERENCES Cita_avanzada ( Codigo ) ;

ALTER TABLE Orden_medicamento ADD CONSTRAINT Item_Medicamentos_FK FOREIGN KEY ( Medicamentos_Codigo ) REFERENCES Medicamento ( Codigo ) ;

ALTER TABLE Item_tratamiento ADD CONSTRAINT Item_Tratamiento_FK FOREIGN KEY ( Tratamiento_Codigo ) REFERENCES Tratamiento ( Codigo ) ;

ALTER TABLE Item_horario ADD CONSTRAINT Item_horario_Horario_FK FOREIGN KEY ( Horario_Codigo_turno ) REFERENCES Horario ( Codigo_turno ) ;

ALTER TABLE Item_horario ADD CONSTRAINT Item_horario_Medico_FK FOREIGN KEY ( Medico_Cedula ) REFERENCES Medico ( Cedula ) ;

ALTER TABLE Orden_medicamento ADD CONSTRAINT Item_medicamento_Cita_FK FOREIGN KEY ( Cita_Codigo ) REFERENCES Cita ( Codigo ) ;

ALTER TABLE Item_medico ADD CONSTRAINT Item_medico_FK FOREIGN KEY ( Especializacion_Codigo ) REFERENCES Especializacion ( Codigo ) ;

ALTER TABLE Item_medico ADD CONSTRAINT Item_medico_Medico_FK FOREIGN KEY ( Medico_Cedula ) REFERENCES Medico ( Cedula ) ;

ALTER TABLE DiagnosticoCita ADD CONSTRAINT Item_patologia_Cita_FK FOREIGN KEY ( Cita_Codigo ) REFERENCES Cita ( Codigo ) ;

ALTER TABLE DiagnosticoCita ADD CONSTRAINT Item_patologia_Patologia_FK FOREIGN KEY ( Patologia_Codigo ) REFERENCES Patologia ( Codigo ) ;

ALTER TABLE Item_sintoma ADD CONSTRAINT Item_sintoma_Patologia_FK FOREIGN KEY ( Patologia_Codigo ) REFERENCES Patologia ( Codigo ) ;

ALTER TABLE Item_sintoma ADD CONSTRAINT Item_sintoma_Sintoma_FK FOREIGN KEY ( Sintoma_Codigo ) REFERENCES Sintoma ( Codigo ) ;

ALTER TABLE Item_tratamiento ADD CONSTRAINT Item_tratamiento_Patologia_FK FOREIGN KEY ( Patologia_Codigo ) REFERENCES Patologia ( Codigo ) ;

ALTER TABLE Medicamento ADD CONSTRAINT Medicamentos_Farmacia_FK FOREIGN KEY ( Farmacia_Codigo ) REFERENCES Farmacia ( Codigo ) ;

ALTER TABLE Medico ADD CONSTRAINT Medico_Usuario_FK FOREIGN KEY ( Cedula ) REFERENCES Usuario ( Cedula ) ;

ALTER TABLE OrdenCirugia ADD CONSTRAINT OrdenCirugia_Cirugia_FK FOREIGN KEY ( Cirugia_Codigo ) REFERENCES Cirugia ( Codigo ) ;

ALTER TABLE OrdenCirugia ADD CONSTRAINT OrdenCirugia_Medico_FK FOREIGN KEY ( Medico_Cedula ) REFERENCES Medico ( Cedula ) ;

ALTER TABLE OrdenCirugia ADD CONSTRAINT OrdenCirugia_Quirofanoo_FK FOREIGN KEY ( Quirofanoo_Instalacion_Codigo ) REFERENCES Quirofano ( Instalacion_Codigo ) ;

ALTER TABLE OrdenExamen ADD CONSTRAINT OrdenExamen_Examen_FK FOREIGN KEY ( Examen_Codigo ) REFERENCES Examen ( Codigo ) ;

ALTER TABLE ResultadoExamen ADD CONSTRAINT OrdenExamen_FK FOREIGN KEY ( OrdenProce_codigo ) REFERENCES OrdenExamen ( OrdenProcedimiento_codigo ) ;

ALTER TABLE OrdenHospitalizacion ADD CONSTRAINT OrdenHospitalizacion_Cama_FK FOREIGN KEY ( Cama_Instalacion_Codigo ) REFERENCES Cama ( Instalacion_Codigo ) ;

ALTER TABLE OrdenProcedimiento ADD CONSTRAINT OrdenProcedimiento_Cita_FK FOREIGN KEY ( Cita_Codigo ) REFERENCES Cita ( Codigo ) ;

ALTER TABLE OrdenHospitalizacion ADD CONSTRAINT OrdenProcedimiento_FK FOREIGN KEY ( OrdenProcedimiento_codigo ) REFERENCES OrdenProcedimiento ( codigo ) ;

ALTER TABLE OrdenExamen ADD CONSTRAINT OrdenProcedimiento_FKv2 FOREIGN KEY ( OrdenProcedimiento_codigo ) REFERENCES OrdenProcedimiento ( codigo ) ;

ALTER TABLE OrdenCirugia ADD CONSTRAINT OrdenProcedimiento_FKv3 FOREIGN KEY ( OrdenProce ) REFERENCES OrdenProcedimiento ( codigo ) ;

ALTER TABLE OrdenHospitalizacion ADD CONSTRAINT Orden_Hospitalización_FK FOREIGN KEY ( Hospitalizacion_Codigo ) REFERENCES Hospitalizacion ( Codigo ) ;

ALTER TABLE Paciente ADD CONSTRAINT Paciente_Afiliación_FK FOREIGN KEY ( Afiliacion_Codigo ) REFERENCES Afiliacion ( Codigo ) ;

ALTER TABLE Paciente ADD CONSTRAINT Paciente_Usuario_FK FOREIGN KEY ( cedula ) REFERENCES Usuario ( Cedula ) ;

ALTER TABLE Quirofano ADD CONSTRAINT Quirofanoo_Instalacion_FK FOREIGN KEY ( Instalacion_Codigo ) REFERENCES Instalacion ( Codigo ) ;
