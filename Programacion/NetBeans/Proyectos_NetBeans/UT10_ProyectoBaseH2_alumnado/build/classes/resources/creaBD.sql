/*DROP TABLE IF EXISTS PILOTA ;
DROP TABLE IF EXISTS NAVE ;
DROP TABLE IF EXISTS PERSONAJE ;

CREATE TABLE IF NOT EXISTS NAVE(
idnave int primary key,
nombre varchar (100),
motores int);

CREATE TABLE IF NOT EXISTS PERSONAJE(
codigo int primary key,
nombre varchar (100),
descripcion varchar (100),
tipo varchar (100));

CREATE TABLE IF NOT EXISTS PILOTA(
codpersonaje int,
codnave int,
fecha datetime,
navesabatidas int,
PRIMARY KEY pil_pk (fecha, codpersonaje, codnave),
CONSTRAINT pil_codp_fk FOREIGN KEY pil_codp_fk(codpersonaje) REFERENCES PERSONAJE(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT pil_codn_fk FOREIGN KEY pil_codn_fk(codnave) REFERENCES NAVE(idnave) ON DELETE CASCADE ON UPDATE CASCADE);*/

DROP TABLE IF EXISTS PILOTA ;
DROP TABLE IF EXISTS NAVE ;
DROP TABLE IF EXISTS PERSONAJE ;

CREATE TABLE NAVE (
IDNAVE              INT AUTO_INCREMENT,
NOMBRE              VARCHAR(255),
MOTORES             INT,

CONSTRAINT PK_NAVE PRIMARY KEY (IDNAVE)
);

CREATE TABLE PERSONAJE (
CODIGO              INT AUTO_INCREMENT,
NOMBRE              VARCHAR(255),
DESCRIPCION         VARCHAR(255),
TIPO                VARCHAR(255),

CONSTRAINT PK_PERSONAJE PRIMARY KEY (CODIGO)
);

CREATE TABLE PILOTA (
CODPERSONAJE        INT,
CODNAVE             INT,
FECHA               DATETIME,
NAVESABATIDAS       INT,

CONSTRAINT PK_PILOTA PRIMARY KEY (CODPERSONAJE, CODNAVE, FECHA),
CONSTRAINT FK1_PILOTA FOREIGN KEY (CODPERSONAJE) REFERENCES PERSONAJE(CODIGO) ON DELETE CASCADE,
CONSTRAINT FK2_PILOTA FOREIGN KEY (CODNAVE)REFERENCES NAVE(IDNAVE) ON DELETE CASCADE
);