
CREATE TABLE Afiliación
  (
    Codigo             VARCHAR2 (20) NOT NULL ,
    Nombre             VARCHAR2 (30) NOT NULL ,
    Telefono           VARCHAR2 (30) NOT NULL ,
    ServiciosIncluidos VARCHAR2 (2000) NOT NULL
  ) ;
ALTER TABLE Afiliación ADD CONSTRAINT Tipo_afiliación_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Cama
  (
    Codigo               VARCHAR2 (10) NOT NULL ,
    Numero               INTEGER NOT NULL ,
    Estado               CHAR (1) NOT NULL ,
    Descripción          VARCHAR2 (2000) ,
    Instalaciones_Codigo VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE Cama ADD CONSTRAINT Cama_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Cirugia
  (
    Codigo                 VARCHAR2 (10) NOT NULL ,
    Recuperación           VARCHAR2 (50) NOT NULL ,
    Anestesia              CHAR (1) ,
    Especialización_Codigo VARCHAR2 (10) NOT NULL ,
    TipoCirugia_Codigo     VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE Cirugia ADD CONSTRAINT Cirugia_PK PRIMARY KEY ( Codigo ) ;
ALTER TABLE Cirugia ADD CONSTRAINT Cirugia__UN UNIQUE ( Codigo ) ;


CREATE TABLE Cita
  (
    Codigo                  VARCHAR2 (20) NOT NULL ,
    Fecha                   DATE NOT NULL ,
    Hora_inicio             DATE NOT NULL ,
    Observación             VARCHAR2 (2000) ,
    hora_final              DATE NOT NULL ,
    Paciente_Usuario_Cedula VARCHAR2 (20) NOT NULL ,
    Medico_Usuario_Cedula   VARCHAR2 (20) NOT NULL ,
    Cita_Codigo             VARCHAR2 (20)
  ) ;
ALTER TABLE Cita ADD CONSTRAINT Cita_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Cita_avanzada
  (
    Codigo         VARCHAR2 (10) NOT NULL ,
    Nombre         VARCHAR2 (20) NOT NULL ,
    Observaciones  VARCHAR2 (1000) NOT NULL ,
    TiempoEstimado VARCHAR2 (50) NOT NULL
  ) ;
ALTER TABLE Cita_avanzada ADD CONSTRAINT Cita_avanzada_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE DiagnosticoCita
  (
    Cita_Codigo      VARCHAR2 (20) NOT NULL ,
    Patologia_Codigo VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE DiagnosticoCita ADD CONSTRAINT Item_patologia_PK PRIMARY KEY ( Cita_Codigo, Patologia_Codigo ) ;


CREATE TABLE Especialización
  (
    Codigo VARCHAR2 (10) NOT NULL ,
    Nombre VARCHAR2 (40) NOT NULL
  ) ;
ALTER TABLE Especialización ADD CONSTRAINT Especialización_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Examen
  (
    Codigo        VARCHAR2 (10) NOT NULL ,
    TipoExamen_Id VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE Examen ADD CONSTRAINT Examen_PK PRIMARY KEY ( Codigo ) ;
ALTER TABLE Examen ADD CONSTRAINT Examen__UN UNIQUE ( Codigo ) ;


CREATE TABLE Farmaceutico
  (
    cedula              VARCHAR2 (20) NOT NULL ,
    Tarjeta_profesional VARCHAR2 (30) ,
    Fecha_ingreso       DATE NOT NULL ,
    Farmacia_Codigo     VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE Farmaceutico ADD CONSTRAINT Farmaceutico_PK PRIMARY KEY ( cedula ) ;
ALTER TABLE Farmaceutico ADD CONSTRAINT Farmaceutico__UN UNIQUE ( cedula ) ;


CREATE TABLE Farmacia
  (
    Codigo    VARCHAR2 (10) NOT NULL ,
    Nombre    VARCHAR2 (40) NOT NULL ,
    Telefono  VARCHAR2 (10) NOT NULL ,
    Dirección VARCHAR2 (40)
  ) ;
ALTER TABLE Farmacia ADD CONSTRAINT Farmacia_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Habitacion
  (
    codigo      VARCHAR2 (10) NOT NULL ,
    Numero      INTEGER NOT NULL ,
    Piso        INTEGER NOT NULL ,
    Descripción VARCHAR2 (1000)
  ) ;
ALTER TABLE Habitacion ADD CONSTRAINT Habitaciones__UN UNIQUE ( codigo ) ;


CREATE TABLE Horario
  (
    Codigo_turno VARCHAR2 (10) NOT NULL ,
    Jornada      VARCHAR2 (30) NOT NULL ,
    Hora_Inicio  DATE NOT NULL ,
    Hora_final   DATE NOT NULL
  ) ;
ALTER TABLE Horario ADD CONSTRAINT Horario_PK PRIMARY KEY ( Codigo_turno ) ;


CREATE TABLE Hospitalización
  (
    Codigo VARCHAR2 (10) NOT NULL ,
    Causas VARCHAR2 (500) NOT NULL
  ) ;
ALTER TABLE Hospitalización ADD CONSTRAINT Hospitalización_PK PRIMARY KEY ( Codigo ) ;
ALTER TABLE Hospitalización ADD CONSTRAINT Hospitalización__UN UNIQUE ( Codigo ) ;


CREATE TABLE Instalación
  (
    Codigo                VARCHAR2 (10) NOT NULL ,
    Disponibilidad        CHAR (1) NOT NULL ,
    ObservacionDisponible VARCHAR2 (1000) NOT NULL
  ) ;
ALTER TABLE Instalación ADD CONSTRAINT Instalaciones_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Item_horario
  (
    Medico_Usuario_Cedula VARCHAR2 (20) NOT NULL ,
    Horario_Codigo_turno  VARCHAR2 (10) NOT NULL ,
    Fecha                 DATE NOT NULL
  ) ;
ALTER TABLE Item_horario ADD CONSTRAINT Item_horario_PK PRIMARY KEY ( Medico_Usuario_Cedula, Horario_Codigo_turno ) ;


CREATE TABLE Item_medico
  (
    Especialización_Codigo VARCHAR2 (10) NOT NULL ,
    Medico_Usuario_Cedula  VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE Item_medico ADD CONSTRAINT Item_medico_PK PRIMARY KEY ( Especialización_Codigo, Medico_Usuario_Cedula ) ;


CREATE TABLE Item_sintoma
  (
    Sintoma_Codigo   VARCHAR2 (10) NOT NULL ,
    Patologia_Codigo VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE Item_sintoma ADD CONSTRAINT Item_sintoma_PK PRIMARY KEY ( Sintoma_Codigo, Patologia_Codigo ) ;


CREATE TABLE Item_tratamiento
  (
    Patologia_Codigo   VARCHAR2 (10) NOT NULL ,
    Tratamiento_Codigo VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE Item_tratamiento ADD CONSTRAINT Item_tratamiento_PK PRIMARY KEY ( Patologia_Codigo, Tratamiento_Codigo ) ;


CREATE TABLE Medicamentos
  (
    Codigo           VARCHAR2 (10) NOT NULL ,
    Nombre           VARCHAR2 (40) NOT NULL ,
    Fecha_expedición DATE NOT NULL ,
    Fecha_expiración DATE NOT NULL ,
    Laboratorio      VARCHAR2 (40) NOT NULL ,
    Cantidad         INTEGER NOT NULL ,
    Estado           CHAR (1) NOT NULL ,
    Farmacia_Codigo  VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE Medicamentos ADD CONSTRAINT Medicamentos_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Medico
  (
    Carnet           VARCHAR2 (30) NOT NULL ,
    FacultadMedicina VARCHAR2 (60) ,
    Cedula           VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE Medico ADD CONSTRAINT Medico_PK PRIMARY KEY ( Cedula ) ;
ALTER TABLE Medico ADD CONSTRAINT Medico__UN UNIQUE ( Cedula ) ;


CREATE TABLE OrdenCitaAvanzada
  (
    Codigo                VARCHAR2 (10) NOT NULL ,
    Observaciones         VARCHAR2 (1000) ,
    Fecha                 DATE NOT NULL ,
    Hora_inicio           DATE NOT NULL ,
    Hora_final            DATE NOT NULL ,
    Medico_Usuario_Cedula VARCHAR2 (20) NOT NULL ,
    Instalación_Codigo    VARCHAR2 (10) ,
    Cita_Codigo           VARCHAR2 (20) NOT NULL ,
    Cita_avanzada_Codigo  VARCHAR2 (10) NOT NULL ,
    ResultadoExamen_Id    VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE OrdenCitaAvanzada ADD CONSTRAINT CitaAvanzada_PK PRIMARY KEY ( Codigo ) ;
ALTER TABLE OrdenCitaAvanzada ADD CONSTRAINT OrdenCitaAvanzada__UNv1 UNIQUE ( ResultadoExamen_Id ) ;


CREATE TABLE Orden_medicamento
  (
    id                  VARCHAR2 (20) NOT NULL ,
    Cantidad            INTEGER NOT NULL ,
    Formula             VARCHAR2 (2000) ,
    Cita_Codigo         VARCHAR2 (20) ,
    Medicamentos_Codigo VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE Orden_medicamento ADD CONSTRAINT Item_medicamento_PK PRIMARY KEY ( id ) ;


CREATE TABLE Paciente
  (
    cedula            VARCHAR2 (20) NOT NULL ,
    Estrato           VARCHAR2 (10) NOT NULL ,
    Afiliación_Codigo VARCHAR2 (20) NOT NULL ,
    Trabajo           VARCHAR2 (50)
  ) ;
ALTER TABLE Paciente ADD CONSTRAINT Paciente_PK PRIMARY KEY ( cedula ) ;
ALTER TABLE Paciente ADD CONSTRAINT Paciente__UN UNIQUE ( cedula ) ;


CREATE TABLE Patologia
  (
    Codigo      VARCHAR2 (10) NOT NULL ,
    Nombre      VARCHAR2 (50) NOT NULL ,
    Descripción VARCHAR2 (1000)
  ) ;
ALTER TABLE Patologia ADD CONSTRAINT Patologia_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE Post_OrdenMedicamento
  (
    codigoEntrega        VARCHAR2 (10) NOT NULL ,
    cantidad             INTEGER NOT NULL ,
    Fecha                DATE NOT NULL ,
    Orden_medicamento_id VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE Post_OrdenMedicamento ADD CONSTRAINT Post_OrdenMedicamento_PK PRIMARY KEY ( codigoEntrega ) ;
ALTER TABLE Post_OrdenMedicamento ADD CONSTRAINT Post_OrdenMedicamento__UN UNIQUE ( Orden_medicamento_id ) ;


CREATE TABLE Quirofano
  (
    codigo          VARCHAR2 (10) NOT NULL ,
    Caracteristicas VARCHAR2 (2000) NOT NULL ,
    Numero_aparatos INTEGER NOT NULL ,
    Cantidad_medico INTEGER
  ) ;
ALTER TABLE Quirofano ADD CONSTRAINT Quirofano__UNv1 UNIQUE ( codigo ) ;


CREATE TABLE ResultadoExamen
  (
    Id          VARCHAR2 (20) NOT NULL ,
    Descripcion VARCHAR2 (2000) NOT NULL ,
    Fecha       DATE NOT NULL
  ) ;
ALTER TABLE ResultadoExamen ADD CONSTRAINT ResultadoExamen_PK PRIMARY KEY ( Id ) ;
ALTER TABLE ResultadoExamen ADD CONSTRAINT ResultadoExamen__UN UNIQUE ( Id ) ;


CREATE TABLE Sintoma
  (
    Codigo      VARCHAR2 (10) NOT NULL ,
    Descripción VARCHAR2 (1000) ,
    Causa       VARCHAR2 (1000) NOT NULL
  ) ;
ALTER TABLE Sintoma ADD CONSTRAINT Sintoma_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE TipoCirugia
  (
    Codigo VARCHAR2 (20) NOT NULL ,
    Nombre VARCHAR2 (50) NOT NULL
  ) ;
ALTER TABLE TipoCirugia ADD CONSTRAINT TipoCirugia_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE TipoExamen
  (
    Id     VARCHAR2 (20) NOT NULL ,
    Nombre VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE TipoExamen ADD CONSTRAINT TipoExamen_PK PRIMARY KEY ( Id ) ;


CREATE TABLE Tratamiento
  (
    Codigo           VARCHAR2 (10) NOT NULL ,
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


ALTER TABLE Cama ADD CONSTRAINT Cama_Habitacion_FK FOREIGN KEY ( Instalaciones_Codigo ) REFERENCES Habitacion ( codigo ) ;

ALTER TABLE Cirugia ADD CONSTRAINT Cirugia_Cita_avanzada_FK FOREIGN KEY ( Codigo ) REFERENCES Cita_avanzada ( Codigo ) ;

ALTER TABLE Cirugia ADD CONSTRAINT Cirugia_Especialización_FK FOREIGN KEY ( Especialización_Codigo ) REFERENCES Especialización ( Codigo ) ;

ALTER TABLE Cirugia ADD CONSTRAINT Cirugia_TipoCirugia_FK FOREIGN KEY ( TipoCirugia_Codigo ) REFERENCES TipoCirugia ( Codigo ) ;

ALTER TABLE Cita ADD CONSTRAINT Cita_Cita_FK FOREIGN KEY ( Cita_Codigo ) REFERENCES Cita ( Codigo ) ;

ALTER TABLE Cita ADD CONSTRAINT Cita_Medico_FK FOREIGN KEY ( Medico_Usuario_Cedula ) REFERENCES Medico ( Cedula ) ;

ALTER TABLE Cita ADD CONSTRAINT Cita_Paciente_FK FOREIGN KEY ( Paciente_Usuario_Cedula ) REFERENCES Paciente ( cedula ) ;

ALTER TABLE Examen ADD CONSTRAINT Examen_Cita_avanzada_FK FOREIGN KEY ( Codigo ) REFERENCES Cita_avanzada ( Codigo ) ;

ALTER TABLE Examen ADD CONSTRAINT Examen_TipoExamen_FK FOREIGN KEY ( TipoExamen_Id ) REFERENCES TipoExamen ( Id ) ;

ALTER TABLE Farmaceutico ADD CONSTRAINT Farmaceutico_Farmacia_FK FOREIGN KEY ( Farmacia_Codigo ) REFERENCES Farmacia ( Codigo ) ;

ALTER TABLE Farmaceutico ADD CONSTRAINT Farmaceutico_Usuario_FK FOREIGN KEY ( cedula ) REFERENCES Usuario ( Cedula ) ;

ALTER TABLE Habitacion ADD CONSTRAINT Habitaciones_Instalaciones_FK FOREIGN KEY ( codigo ) REFERENCES Instalación ( Codigo ) ;

ALTER TABLE Hospitalización ADD CONSTRAINT Hospitalización_Cita_avanzada_FK FOREIGN KEY ( Codigo ) REFERENCES Cita_avanzada ( Codigo ) ;

ALTER TABLE Item_horario ADD CONSTRAINT Item_horario_Horario_FK FOREIGN KEY ( Horario_Codigo_turno ) REFERENCES Horario ( Codigo_turno ) ;

ALTER TABLE Item_horario ADD CONSTRAINT Item_horario_Medico_FK FOREIGN KEY ( Medico_Usuario_Cedula ) REFERENCES Medico ( Cedula ) ;

ALTER TABLE Orden_medicamento ADD CONSTRAINT Item_medicamento_Cita_FK FOREIGN KEY ( Cita_Codigo ) REFERENCES Cita ( Codigo ) ;

ALTER TABLE Orden_medicamento ADD CONSTRAINT Item_Medicamentos_FK FOREIGN KEY ( Medicamentos_Codigo ) REFERENCES Medicamentos ( Codigo ) ;

ALTER TABLE Item_medico ADD CONSTRAINT Item_medico_Especialización_FK FOREIGN KEY ( Especialización_Codigo ) REFERENCES Especialización ( Codigo ) ;

ALTER TABLE Item_medico ADD CONSTRAINT Item_medico_Medico_FK FOREIGN KEY ( Medico_Usuario_Cedula ) REFERENCES Medico ( Cedula ) ;

ALTER TABLE DiagnosticoCita ADD CONSTRAINT Item_patologia_Cita_FK FOREIGN KEY ( Cita_Codigo ) REFERENCES Cita ( Codigo ) ;

ALTER TABLE DiagnosticoCita ADD CONSTRAINT Item_patologia_Patologia_FK FOREIGN KEY ( Patologia_Codigo ) REFERENCES Patologia ( Codigo ) ;

ALTER TABLE Item_sintoma ADD CONSTRAINT Item_sintoma_Patologia_FK FOREIGN KEY ( Patologia_Codigo ) REFERENCES Patologia ( Codigo ) ;

ALTER TABLE Item_sintoma ADD CONSTRAINT Item_sintoma_Sintoma_FK FOREIGN KEY ( Sintoma_Codigo ) REFERENCES Sintoma ( Codigo ) ;

ALTER TABLE Item_tratamiento ADD CONSTRAINT Item_tratamiento_Patologia_FK FOREIGN KEY ( Patologia_Codigo ) REFERENCES Patologia ( Codigo ) ;

ALTER TABLE Item_tratamiento ADD CONSTRAINT Item_Tratamiento_FK FOREIGN KEY ( Tratamiento_Codigo ) REFERENCES Tratamiento ( Codigo ) ;

ALTER TABLE Medicamentos ADD CONSTRAINT Medicamentos_Farmacia_FK FOREIGN KEY ( Farmacia_Codigo ) REFERENCES Farmacia ( Codigo ) ;

ALTER TABLE Medico ADD CONSTRAINT Medico_Usuario_FK FOREIGN KEY ( Cedula ) REFERENCES Usuario ( Cedula ) ;

ALTER TABLE OrdenCitaAvanzada ADD CONSTRAINT OrdenCitaAvanzada_Resultado_FK FOREIGN KEY ( ResultadoExamen_Id ) REFERENCES ResultadoExamen ( Id ) ;

ALTER TABLE OrdenCitaAvanzada ADD CONSTRAINT OrdenCita_Cita_avanzada_FK FOREIGN KEY ( Cita_avanzada_Codigo ) REFERENCES Cita_avanzada ( Codigo ) ;

ALTER TABLE Paciente ADD CONSTRAINT Paciente_Afiliación_FK FOREIGN KEY ( Afiliación_Codigo ) REFERENCES Afiliación ( Codigo ) ;

ALTER TABLE Paciente ADD CONSTRAINT Paciente_Usuario_FK FOREIGN KEY ( cedula ) REFERENCES Usuario ( Cedula ) ;

ALTER TABLE Post_OrdenMedicamento ADD CONSTRAINT Post_OrdenMedicamento_FK FOREIGN KEY ( Orden_medicamento_id ) REFERENCES Orden_medicamento ( id ) ;

ALTER TABLE OrdenCitaAvanzada ADD CONSTRAINT Post_ordencita_Cita_FK FOREIGN KEY ( Cita_Codigo ) REFERENCES Cita ( Codigo ) ;

ALTER TABLE OrdenCitaAvanzada ADD CONSTRAINT Post_ordencita_Instalación_FK FOREIGN KEY ( Instalación_Codigo ) REFERENCES Instalación ( Codigo ) ;

ALTER TABLE OrdenCitaAvanzada ADD CONSTRAINT Post_ordencita_Medico_FK FOREIGN KEY ( Medico_Usuario_Cedula ) REFERENCES Medico ( Cedula ) ;

ALTER TABLE Quirofano ADD CONSTRAINT Quirofano_Instalación_FK FOREIGN KEY ( codigo ) REFERENCES Instalación ( Codigo ) ;
