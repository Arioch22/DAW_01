# 1. Elimina si existe la base de datos gimnasio 

drop database if exists gimnasio;

# 2. Crea la base de datos gimnasio.

create database gimnasio;
use gimnasio;

CREATE TABLE IF NOT EXISTS CLASE_TIPO  (
CLASE_TIPO  char(5) PRIMARY KEY,
Nombre VARCHAR(50) UNIQUE,
Descripcion VARCHAR(50)
);
INSERT INTO CLASE_TIPO (CLASE_TIPO, Nombre, Descripcion) VALUES ('00001','ZUMBA','CLASE DE ZUMBA');
INSERT INTO CLASE_TIPO (CLASE_TIPO, Nombre, Descripcion) VALUES ('00002','BOX','CLASE DE BOX');
INSERT INTO CLASE_TIPO (CLASE_TIPO, Nombre, Descripcion) VALUES ('00003','CARDIO','CLASE DE CARDIO');
INSERT INTO CLASE_TIPO (CLASE_TIPO, Nombre, Descripcion) VALUES ('00004','PILATES','CLASE DE PILATES');


CREATE TABLE IF NOT EXISTS GYM (
Codigo_Gym char(5) PRIMARY KEY,
Nombre VARCHAR(50) UNIQUE
);


INSERT INTO GYM (Codigo_Gym, Nombre) VALUES ('00111','Espartaco');
INSERT INTO GYM (Codigo_Gym, Nombre) VALUES ('00112','Gofitness');
INSERT INTO GYM (Codigo_Gym, Nombre) VALUES ('00113','Sur');
INSERT INTO GYM (Codigo_Gym, Nombre) VALUES ('00114','Aire');
INSERT INTO GYM (Codigo_Gym, Nombre) VALUES ('00115','Espartaco 2');
INSERT INTO GYM (Codigo_Gym, Nombre) VALUES ('00116','Espartaco 3');



CREATE TABLE IF NOT EXISTS SALAS (
Codigo_Salas char(5) PRIMARY KEY,
id_Gym char(5),
Nombre VARCHAR(50) UNIQUE,
Descripcion VARCHAR(50),
Cantidad Tinyint,
CONSTRAINT GYM_GYM_FK FOREIGN KEY (id_Gym) REFERENCES  GYM (Codigo_Gym) ON DELETE CASCADE
);
INSERT INTO SALAS (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00001','00111','SAla 1','SALA ZUMBA',50);
INSERT INTO SALAS (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00002','00112','Sala 2','SALA AEROBIC',25);
INSERT INTO SALAS (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00003','00113','Sala 3','SALA BOX',10);
INSERT INTO SALAS (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00004','00114','Sala 4','SALA AGUA',15);
INSERT INTO SALAS (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00005','00115','Sala 5','SALA CARDIO',30);
INSERT INTO SALAS (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00006','00111','Sala 6','SALA ZUMBA',50);
INSERT INTO SALAS (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00007','00112','Sala 7','SALA AEROBIC',25);
INSERT INTO SALAS (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00008','00113','Sala 8','SALA BOX',10);
INSERT INTO SALAS (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00009','00114','Sala 9','SALA AGUA',15);
INSERT INTO SALAS (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00010','00115','Sala 10','SALA CARDIO',30);


CREATE TABLE IF NOT EXISTS  MONITOR (
Codigo_Monitor CHAR(5) PRIMARY KEY,
DNI CHAR(9),
Nombre VARCHAR(50),
Apellidos VARCHAR(50),
Fecha_nac DATE NOT NULL,
Telefono CHAR(9),
Edad tinyint
);
INSERT INTO MONITOR (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00001','11111111Q','Luis','Ramírez Pardo','1980-12-15','600259874',25);
INSERT INTO MONITOR (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00002','11122111Q','Rafa','Ramírez Pardo','1980-10-15','600259874',30);
INSERT INTO MONITOR (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00003','11133111Q','Pepe','Ramírez Pardo','1980-11-02','600259874',35);
INSERT INTO MONITOR (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00004','11144111Q','Alberto','Ramírez Pardo','1980-09-01','600259874',26);
INSERT INTO MONITOR (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00005','11155111Q','Fran','Ramírez Pardo','1980-11-15','600259874',24);
INSERT INTO MONITOR (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00006','11166111Q','Luis','Ramírez Pardo','1980-11-15','600259874',40);

CREATE TABLE IF NOT EXISTS CLASES  (
Codigo_Clase char(5) PRIMARY KEY,
id_Tipo  char(5) ,
Fecha DATE NOT NULL,
H_inicio TIME,
H_fin TIME,
N_plazas TINYINT,
id_Sala CHAR(5),
CONSTRAINT CLA_SAL_FK FOREIGN KEY (id_Sala) REFERENCES  SALAS (Codigo_Salas) ON DELETE CASCADE,
CONSTRAINT CLA_TIP_FK FOREIGN KEY (id_Tipo) REFERENCES CLASE_TIPO (CLASE_TIPO) ON DELETE CASCADE
);

INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00001','00001','2022-02-15','09:00:00','10:00:00',20,'00001');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00002','00002','2022-02-16','09:00:00','10:00:00',20,'00002');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00003','00003','2022-02-02','11:00:00','12:00:00',50,'00001');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00004','00001','2022-02-04','12:00:00','13:00:00',15,'00003');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00005','00004','2022-02-25','13:00:00','13:15:00',5,'00001');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00006','00002','2022-02-15','19:00:00','20:00:00',32,'00002');

INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00007','00002','2022-02-15','19:00:00','20:00:00',32,'00003');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00008','00003','2022-02-16','19:00:00','20:00:00',32,'00004');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00009','00004','2022-02-17','19:00:00','20:00:00',32,'00005');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00010','00003','2022-02-18','19:00:00','20:00:00',32,'00006');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00011','00002','2022-02-19','19:00:00','20:00:00',32,'00007');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00012','00003','2022-02-20','19:00:00','20:00:00',32,'00008');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00013','00002','2022-02-21','19:00:00','20:00:00',32,'00009');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00014','00002','2021-01-19','19:00:00','20:00:00',32,'00003');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00015','00003','2021-01-20','19:00:00','20:00:00',32,'00004');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00016','00002','2021-01-21','19:00:00','20:00:00',32,'00005');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00017','00002','2021-02-22','19:00:00','20:00:00',32,'00004');
INSERT INTO CLASES (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00018','00002','2021-02-22','19:00:00','20:00:00',32,'00003');

CREATE TABLE IF NOT EXISTS MONITOR_CLASES (
Codigo_Monitor char(5),
Codigo_Clase char(5),
Cobra Tinyint,
CONSTRAINT MON_PK PRIMARY KEY(codigo_Monitor, codigo_Clase),
CONSTRAINT MON_MON_FK FOREIGN KEY (codigo_Monitor) REFERENCES  MONITOR (Codigo_monitor) ON DELETE CASCADE,
CONSTRAINT MON_CLA_FK FOREIGN KEY (codigo_Clase) REFERENCES  CLASES (Codigo_Clase) ON DELETE CASCADE
);

INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00001','00001',30);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00001','00002',50);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00003',50);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00004',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00003','00003',50);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00003','00005',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00004','00006',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00005','00007',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00006','00008',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00006','00009',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00006','00010',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00004','00011',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00004','00012',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00001','00013',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00013',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00014',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00015',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00016',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00017',10);
INSERT INTO MONITOR_CLASES (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00018',10);


CREATE TABLE IF NOT EXISTS  USUARIO (
CODIGO_U CHAR(5) PRIMARY KEY,
DNI CHAR(9),
Nombre VARCHAR(50),
Apellidos VARCHAR(50),
Telefono CHAR(9),
edad tinyint
);
/* INSERCIÓN DE DATOS*/
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U001','14188151T','Carlos','Sánchez Ruíz','600259874',25);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U002','11245621Q','Juan','Pardo Rubio','636254878',30);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U003','04477744T','Laura','Jiménez Jiménez','625874596',14);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U004','51235555J','Carmen','Capel Pío','669584712',16);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U005','55675675J','Juan','Sánchez López','625845632',45);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U006','99009900J','Alejandro','Pardo López','636985621',62);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U007','24138151T','Vicente','Sánchez Pelayo','61039874',42);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U008','21235421Q','Alfredo','Jiménez Rubio','616856878',29);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U009','64574744T','María','Jiménez Costa','623834596',16);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U010','71234545J','Lucía','Sonora Vigo','670684752',34);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U011','65675454K','Alejandro','Sánchez Ocaña','635845632',55);
INSERT INTO USUARIO (CODIGO_U, DNI, Nombre, Apellidos, Telefono, edad) VALUES ('U012','34006800L','Javier','García Muñoz','636535281',43);

CREATE TABLE IF NOT EXISTS RESERVA  (
Clase char(5),
Usuario char(5),
precio FLOAT(6,2),

CONSTRAINT RES_PK PRIMARY KEY(clase, USUARIO),
CONSTRAINT RES_CLA_FK FOREIGN KEY (CLASE) REFERENCES  CLASES (Codigo_Clase) ON DELETE CASCADE,
CONSTRAINT RES_USU_FK FOREIGN KEY (USUARIO) REFERENCES USUARIO (CODIGO_U) ON DELETE CASCADE


);


INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00001','U001',10.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00001','U002',10.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00001','U003',10.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00001','U005',10.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00001','U006',5.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00002','U002',10.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00002','U003',10.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00002','U005',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00003','U004',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00003','U002',10.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00004','U003',10.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00005','U009',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00006','U007',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00007','U007',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00008','U007',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00009','U007',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00010','U007',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00011','U007',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00012','U007',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00013','U007',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00014','U009',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00015','U007',15.00);
INSERT INTO RESERVA (Clase, Usuario, precio) VALUES ('00016','U007',15.00);