/* Script necesario para crear la base de datos de la tarea 6 - Oracle PL/SQL
 * Modulo de Base de Datos para los ciclos superiores DAW y DAM
 * IES Triassierra - Curso 2021/2022
 */

-- creacion de las tablas tal cual estan definidas en el diagrama de entidad/relacion y uml del enunciado (ver apartado informacion de interes)
-- ATENCION: es Oracle y por tanto, algunos tipados cambian con respecto a MySQL
CREATE TABLE clase_tipo  (
	clase_tipo  VARCHAR2(5) PRIMARY KEY,
	nombre VARCHAR2(50) UNIQUE,
	descripcion VARCHAR2(50)
);

CREATE TABLE gym (
	codigo_gym VARCHAR2(5) PRIMARY KEY,
	nombre VARCHAR2(50) UNIQUE
);

CREATE TABLE salas (
	codigo_salas VARCHAR2(5) PRIMARY KEY,
	id_gym VARCHAR2(5),
	nombre VARCHAR2(50) UNIQUE,
	descripcion VARCHAR2(50),
	cantidad NUMBER,
	CONSTRAINT gym_gym_fk FOREIGN KEY (id_gym) REFERENCES  gym (codigo_gym) ON DELETE CASCADE
);

CREATE TABLE monitor (
	codigo_monitor VARCHAR2(5) PRIMARY KEY,
	dni VARCHAR2(9),
	nombre VARCHAR2(50),
	apellidos VARCHAR2(50),
	fecha_nac DATE NOT NULL,
	telefono VARCHAR2(9),
	edad NUMBER
);

CREATE TABLE clases  (
	codigo_clase VARCHAR2(5) PRIMARY KEY,
	id_tipo  VARCHAR2(5) ,
	fecha DATE NOT NULL,
	h_inicio TIMESTAMP,
	h_fin TIMESTAMP,
	n_plazas NUMBER,
	id_sala VARCHAR2(5),
	CONSTRAINT cla_sal_fk FOREIGN KEY (id_sala) REFERENCES  salas (codigo_salas) ON DELETE CASCADE,
	CONSTRAINT cla_tip_fk FOREIGN KEY (id_tipo) REFERENCES clase_tipo (clase_tipo) ON DELETE CASCADE
);

CREATE TABLE monitor_clases (
	codigo_monitor VARCHAR2(5),
	codigo_clase VARCHAR2(5),
	cobra NUMBER(6,2),
	CONSTRAINT mon_pk PRIMARY KEY(codigo_monitor, codigo_clase),
	CONSTRAINT mon_mon_fk FOREIGN KEY (codigo_monitor) REFERENCES  monitor (codigo_monitor) ON DELETE CASCADE,
	CONSTRAINT mon_cla_fk FOREIGN KEY (codigo_clase) REFERENCES  clases (codigo_clase) ON DELETE CASCADE
);

CREATE TABLE usuario (
	codigo_u VARCHAR2(5) PRIMARY KEY,
	dni VARCHAR2(9),
	nombre VARCHAR2(50),
	apellidos VARCHAR(50),
	telefono VARCHAR2(9),
	cuota_mensual NUMBER(5,2) DEFAULT 20.00
);

CREATE TABLE reserva  (
	clase VARCHAR2(5),
	usuario VARCHAR2(5),
	precio NUMBER(4,2) DEFAULT 0.80,
	CONSTRAINT res_pk PRIMARY KEY(clase, usuario),
	CONSTRAINT res_cla_fk FOREIGN KEY (clase) REFERENCES  clases (codigo_clase) ON DELETE CASCADE,
	CONSTRAINT res_usu_fk FOREIGN KEY (usuario) REFERENCES usuario (codigo_u) ON DELETE CASCADE
);


-- mockeo de datos para que podais probar vuestros procedimientos/funciones y disparadores
-- INFORMACION: cuando se mockea, los datos obtenidos no tienen por que tener sentido; unicamente se utilizan para comprobar que tus queries/procedimientos/disparadores estan correctamente escritos
-- 4 tuplas mockeadas para la tabla clase_tipo
INSERT INTO clase_tipo (CLASE_TIPO, Nombre, Descripcion) VALUES ('00001','ZUMBA','CLASE DE ZUMBA');
INSERT INTO clase_tipo (CLASE_TIPO, Nombre, Descripcion) VALUES ('00002','BOX','CLASE DE BOX');
INSERT INTO clase_tipo (CLASE_TIPO, Nombre, Descripcion) VALUES ('00003','CARDIO','CLASE DE CARDIO');
INSERT INTO clase_tipo (CLASE_TIPO, Nombre, Descripcion) VALUES ('00004','PILATES','CLASE DE PILATES');

-- 6 tuplas mockeadas para la tabla gym
INSERT INTO gym (Codigo_Gym, Nombre) VALUES ('00111','Espartaco');
INSERT INTO gym (Codigo_Gym, Nombre) VALUES ('00112','Gofitness');
INSERT INTO gym (Codigo_Gym, Nombre) VALUES ('00113','Sur');
INSERT INTO gym (Codigo_Gym, Nombre) VALUES ('00114','Aire');
INSERT INTO gym (Codigo_Gym, Nombre) VALUES ('00115','Espartaco 2');
INSERT INTO gym (Codigo_Gym, Nombre) VALUES ('00116','Espartaco 3');

-- 10 tuplas mockeadas para la tabla salas
INSERT INTO salas (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00001','00111','SAla 1','SALA ZUMBA',50);
INSERT INTO salas (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00002','00112','Sala 2','SALA AEROBIC',25);
INSERT INTO salas (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00003','00113','Sala 3','SALA BOX',10);
INSERT INTO salas (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00004','00114','Sala 4','SALA AGUA',15);
INSERT INTO salas (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00005','00115','Sala 5','SALA CARDIO',30);
INSERT INTO salas (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00006','00111','Sala 6','SALA ZUMBA',50);
INSERT INTO salas (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00007','00112','Sala 7','SALA AEROBIC',25);
INSERT INTO salas (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00008','00113','Sala 8','SALA BOX',10);
INSERT INTO salas (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00009','00114','Sala 9','SALA AGUA',15);
INSERT INTO salas (Codigo_Salas,id_Gym, Nombre, Descripcion,Cantidad) VALUES ('00010','00115','Sala 10','SALA CARDIO',30);

-- 6 tuplas mockeadas para la tabla monitor
INSERT INTO monitor (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00001','11111111Q','Luis','Ramírez Pardo',TO_DATE('15-12-1980', 'DD-MM-YYYY'),'600259874',25);
INSERT INTO monitor (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00002','11122111Q','Rafa','Ramírez Pardo',TO_DATE('15-10-1980', 'DD-MM-YYYY'),'600259874',30);
INSERT INTO monitor (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00003','11133111Q','Pepe','Ramírez Pardo',TO_DATE('02-11-1980', 'DD-MM-YYYY'),'600259874',35);
INSERT INTO monitor (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00004','11144111Q','Alberto','Ramírez Pardo',TO_DATE('01-09-1980', 'DD-MM-YYYY'),'600259874',26);
INSERT INTO monitor (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00005','11155111Q','Fran','Ramírez Pardo',TO_DATE('15-11-1980', 'DD-MM-YYYY'),'600259874',24);
INSERT INTO monitor (Codigo_Monitor, DNI, Nombre, Apellidos, Fecha_nac, Telefono, Edad) VALUES ('00006','11166111Q','Luis','Ramírez Pardo',TO_DATE('15-11-1980',  'DD-MM-YYYY'),'600259874',40);

-- 18 tuplas mockeadas para la tabla clases
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00001','00001', TO_DATE('15-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('09:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('10:00:00', 'HH24:MI:SS') ,20,'00001');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00002','00002', TO_DATE('16-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('09:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('10:00:00', 'HH24:MI:SS'), 20,'00002');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00003','00003', TO_DATE('02-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('11:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('12:00:00', 'HH24:MI:SS'), 50,'00001');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00004','00001', TO_DATE('04-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('12:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('13:00:00', 'HH24:MI:SS'), 15,'00003');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00005','00004', TO_DATE('25-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('13:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('13:15:00', 'HH24:MI:SS'), 5,'00001');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00006','00002', TO_DATE('15-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00002');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00007','00002', TO_DATE('15-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00003');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00008','00003', TO_DATE('16-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00004');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00009','00004', TO_DATE('17-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00005');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00010','00003', TO_DATE('18-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00006');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00011','00002', TO_DATE('19-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00007');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00012','00003', TO_DATE('20-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00008');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00013','00002', TO_DATE('21-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00009');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00014','00002', TO_DATE('19-01-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00003');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00015','00003', TO_DATE('20-01-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00004');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00016','00002', TO_DATE('21-01-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00005');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00017','00002', TO_DATE('22-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00004');
INSERT INTO clases (Codigo_Clase, id_Tipo, Fecha, H_inicio, H_fin, N_plazas, id_Sala) VALUES ('00018','00002', TO_DATE('22-02-2022', 'DD-MM-YYYY'), TO_TIMESTAMP('19:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('20:00:00', 'HH24:MI:SS'), 32,'00003');

-- 20 tuplas mockeadas  para la tabla monitor_clases
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00001','00001',30);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00001','00002',50);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00003',50);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00004',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00003','00003',50);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00003','00005',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00004','00006',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00005','00007',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00006','00008',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00006','00009',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00006','00010',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00004','00011',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00004','00012',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00001','00013',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00013',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00014',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00015',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00016',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00017',10);
INSERT INTO monitor_clases (Codigo_Monitor, Codigo_Clase, Cobra) VALUES ('00002','00018',10);

-- 12 tuplas mockeadas para la tabla usuario
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U001','14188151T','Carlos','Sánchez Ruíz','600259874');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U002','11245621Q','Juan','Pardo Rubio','636254878');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U003','04477744T','Laura','Jiménez Jiménez','625874596');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U004','51235555J','Carmen','Capel Pío','669584712');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U005','55675675J','Juan','Sánchez López','625845632');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U006','99009900J','Alejandro','Pardo López','636985621');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U007','24138151T','Vicente','Sánchez Pelayo','61039874');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U008','21235421Q','Alfredo','Jiménez Rubio','616856878');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U009','64574744T','María','Jiménez Costa','623834596');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U010','71234545J','Lucía','Sonora Vigo','670684752');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U011','65675454K','Alejandro','Sánchez Ocaña','635845632');
INSERT INTO usuario (CODIGO_U, DNI, Nombre, Apellidos, Telefono) VALUES ('U012','34006800L','Javier','García Muñoz','636535281');

-- 22 tuplas mockeadas para la clase reserva
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00001','U001',10.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00001','U002',10.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00001','U003',10.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00001','U005',10.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00001','U006',5.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00002','U002',10.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00002','U003',10.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00002','U005',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00003','U004',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00003','U002',10.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00004','U003',10.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00005','U009',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00006','U007',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00007','U007',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00008','U007',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00009','U007',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00010','U007',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00011','U007',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00012','U007',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00013','U007',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00014','U009',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00015','U007',15.00);
INSERT INTO reserva (Clase, Usuario, precio) VALUES ('00016','U007',15.00);
