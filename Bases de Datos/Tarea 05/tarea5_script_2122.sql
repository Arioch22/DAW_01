# 1. Elimina si existe la base de datos muebles_bd03

drop database if exists muebles_bd03;

# 2. Crea la base de datos muebles_bd03.

create database muebles_bd03;
use muebles_bd03;

# 3. Crea las tablas que se indican:

create table MUEBLE(
	id_mueble int primary key auto_increment,
    nombre varchar(250) unique not null,
    descripcion varchar(250),
    color varchar(250),
    valoracion_clientes tinyint,
    CONSTRAINT mue_val_CHK CHECK (valoracion_clientes BETWEEN 1 AND 5),
estado_catalogo enum('activo','descatalogado', 'en-proyecto')
);

create table COMPONENTE (
	id_componente int primary key auto_increment,
    id_mueble int not null,
    # las restricciones pueden ir en cualquier lugar, aunque habitualmente se pongan al final...
    constraint COM_IDM_FK foreign key COM_IDM_FK(id_mueble) references MUEBLE(id_mueble) on delete cascade on update cascade,
    nombre varchar(250) not null,
    descripcion varchar(250),
    alto double check(alto >= 0),
    ancho double check(ancho >= 0),
    fondo double check(fondo >= 0),
    peso double check(peso >= 0)
);

# OJO: hay que crear antes "fabricante" que "fabricado"; o bien, la clave foránea se debe crear aparte en un "alter table"
create table FABRICANTE (
	nif char(9) primary key,
    razon_social varchar(250) not null unique,
    localidad varchar(250),
    # IMPORTANTE: hay que poner paréntesis en default para indicar que es expresión
    #  si no, se debe usar datetime con current_timestamp o now
    fecha_alta date default (current_date),
    nivel_fidelizacion tinyint check ( nivel_fidelizacion >= 1 and nivel_fidelizacion <= 10)
);

create table FABRICADO (
	id_componente int,
    nif_fabricante char(10),
    constraint fab_idc_fk foreign key fab_idc_fk(id_componente) references COMPONENTE(id_componente) on update cascade on delete no action,
    constraint fab_nif_fk foreign key fab_nif_fk(nif_fabricante) references FABRICANTE(nif) on update cascade on delete cascade,
    primary key fab_pk(id_componente, nif_fabricante)
);

#OJO: "ubicación" antes de "localizado" o bien clave foránea en un alter table
create table UBICACION (
	referencia int primary key auto_increment,
    sala varchar(250) not null,
    pasillo int not null,
    estanteria int not null,
    balda int not null,
    unique UBI_UQ (sala, pasillo, estanteria, balda)
);

create table LOCALIZADO (
	id_componente int,
    referencia_ubicacion int,
    cantidad int unsigned not null default 0,
    constraint loc_idc_fk foreign key loc_idc_fk(id_componente) references COMPONENTE(id_componente) on delete cascade on update cascade,
    constraint loc_ref_fk foreign key loc_ref_fk(referencia_ubicacion) references UBICACION(referencia) on delete no action on update cascade,
    primary key loc_pk(id_componente, referencia_ubicacion)
);

/* INSERCCIÓN DE DATOS */

INSERT INTO MUEBLE VALUES (NULL,'Fuerteventura', 'Armario de pino, con doble puerta una balda interior y 3 cajones inferiores','marrón', 3, 'en-proyecto');
INSERT INTO MUEBLE VALUES (NULL,'Gomera-b', 'Sofa de tres plazas acabado en tela. Cojines que ofrecen un apoyo cómodo y recuperan la forma.', 'Beige', 3, 'activo');
INSERT INTO MUEBLE VALUES (NULL,'Palma', 'Recibidor con doble puerta y 2 baldas interiores.','Aguamarina', 3, 'Activo');
INSERT INTO MUEBLE VALUES (NULL,'Lanzarote', 'Mesa rectangular de cristal y acero inoxidable. Extensible por ambos lados.','metal-transparente', 3, 'en-proyecto');
INSERT INTO MUEBLE VALUES (NULL,'Roque', 'Mesa baja para salón, madera DM lacada, con ventana de cristal y cajón pasante interior visto.','Blanco', 4, 'en-proyecto');
INSERT INTO MUEBLE VALUES (NULL,'Alegranza', 'Silla con estructura en acero inoxidable, acabado brillo, con tapizados en cuero.', 'Negro', 5, 'activo');

INSERT INTO COMPONENTE VALUES (NULL, 2,'Pata', 'Pata de plástico resistente para sofá', 100, 75, 75, 0.080);
INSERT INTO COMPONENTE VALUES (NULL, 2,'Cojín', 'Cojín cómodo que recupera la forma.', 300, 300, 100, 0.150);
INSERT INTO COMPONENTE VALUES (NULL, 3,'Pata', 'Pata de madera lacada en blanco nuclear.', 150, 30, 30, 0.300);
INSERT INTO COMPONENTE VALUES (NULL, 4,'Pata', 'Pata de acero inoxidable con acabado brillo. Punta de apoyo en plástico resistente', 600, 150, 150, 4.650);
INSERT INTO COMPONENTE VALUES (NULL, 6,'Cojín', NULL, 300, 300, 100, 0.150);
INSERT INTO COMPONENTE VALUES (NULL, 4,'Tablero', 'Tablero de cristal templado para mesa', 12, 1300, 2200, 86.000);
INSERT INTO COMPONENTE VALUES (NULL, 3,'Puerta', NULL, 300, 300, 100, 0.150);

INSERT INTO FABRICANTE VALUES ('11111111Q','Componentes Garcia','Alcalá de Guadaíra',CURRENT_DATE,8);
INSERT INTO FABRICANTE VALUES ('22222222R','Tapizados Urbano', 'Fernán Núñez',CURRENT_DATE,5);
INSERT INTO FABRICANTE VALUES ('33333333W','Carpintería metálica Chromium','Marmolejo',CURRENT_DATE,9);
INSERT INTO FABRICANTE VALUES ('44444444G','Carpintería Madecom','Puete Genil',CURRENT_DATE,7);
INSERT INTO FABRICANTE VALUES ('45678920H','Carpintería El Pino','Córdoba',CURRENT_DATE,7);
INSERT INTO FABRICANTE VALUES ('78945612K','Tapizados Tela','Córdoba',CURRENT_DATE,7);
INSERT INTO FABRICANTE VALUES ('98765432P','Componentes Industriales del Sur','Lucena',CURRENT_DATE,7);

INSERT INTO FABRICADO VALUES (1, '11111111Q');
INSERT INTO FABRICADO VALUES (2, '22222222R');
INSERT INTO FABRICADO VALUES (3, '44444444G');
INSERT INTO FABRICADO VALUES (4, '33333333W');
INSERT INTO FABRICADO VALUES (5, '78945612K');
INSERT INTO FABRICADO VALUES (6, '11111111Q');
INSERT INTO FABRICADO VALUES (7, '45678920H');

INSERT INTO UBICACION VALUES (NULL, 'Almacen A',1,3,2);
INSERT INTO UBICACION VALUES (NULL, 'Almacen A',1,1,1);
INSERT INTO UBICACION VALUES (NULL, 'Almacen A',3,2,5);
INSERT INTO UBICACION VALUES (NULL, 'Almacen B',3,7,4);
INSERT INTO UBICACION VALUES (NULL, 'Almacen A',2,5,3);

INSERT INTO LOCALIZADO VALUES (1, 1, 1);
INSERT INTO LOCALIZADO VALUES (2, 2, 2);
INSERT INTO LOCALIZADO VALUES (3, 5, 2);
INSERT INTO LOCALIZADO VALUES (4, 3, 5);
INSERT INTO LOCALIZADO VALUES (5, 4, 2);
