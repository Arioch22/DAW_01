/*Apartado A*/

###########################################################
#Ejericio 01 .- Obtener un listado de todas los gimnasios.#
###########################################################
SELECT
	Codigo_Gym, Nombre 
FROM
	GYM g
ORDER BY
	Nombre;

##########################################################################################
#Ejericio 02 .-  Obtener el código de reservas que se realizaron el mes de Enero de 2021.#
##########################################################################################
SELECT
	r.Clase ,
	r.Usuario
FROM
	RESERVA r
JOIN CLASES c on
	c.Codigo_Clase = r.Clase
WHERE
	YEAR (c.Fecha) = 2021
	AND MONTH (c.Fecha) = 01
ORDER BY
	r.Clase ;

#####################################################################################
#Ejericio 03 .- Obtener todos los datos de los usuarios abonados mayores de 30 años.#
#####################################################################################
SELECT
	CODIGO_U, DNI, CONCAT_WS(' ', Nombre, Apellidos) AS Usuario, Telefono, edad 
FROM
	USUARIO u
WHERE
	edad > 30
ORDER BY
	CODIGO_U ;

#################################################################################################
#Ejericio 04 .- Obtener el nombre de los monitores y el sueldo que hayan ganado este año (2022).#
#################################################################################################
SELECT
	CONCAT_WS(' ', Apellidos, nombre) AS "Nombre Mon.",
	SUM(mc.Cobra) AS Sueldo
FROM
	MONITOR m
JOIN MONITOR_CLASES mc on
	mc.Codigo_Monitor = m.Codigo_Monitor
JOIN CLASES c on
	mc.Codigo_Clase = c.Codigo_Clase
WHERE
	YEAR (c.Fecha) = 2022
GROUP BY
	mc.Codigo_Monitor;

/*Apartado B*/

################################################################################################################################
#Ejericio 05 .- Obtener un listado con el nombre y apellidos de todos los usuarios que hayan participado en la clase de zumba. #
################################################################################################################################
SELECT
	CONCAT(u.Nombre, ' ', u.Apellidos) AS "Usuarios de Zumba"
FROM
	USUARIO u
JOIN RESERVA r on
	r.Usuario = u.CODIGO_U
JOIN CLASES c on
	c.Codigo_Clase = r.Clase
JOIN CLASE_TIPO ct on
	ct.CLASE_TIPO = c.id_Tipo
WHERE
	ct.Nombre = 'ZUMBA'
GROUP BY
	u.CODIGO_U
ORDER BY
	u.Nombre ;

####################################################################################################################################
#Ejericio 06 .- Obtener el número de usuarios que se han apuntado hasta el momento, por cada tipo de clase (a cardio, a box, etc.).#
####################################################################################################################################
SELECT
	Nombre AS 'Tipo de clases',
	COUNT(r.Usuario)
FROM
	CLASE_TIPO ct
JOIN CLASES c on
	c.id_Tipo = ct.CLASE_TIPO
JOIN RESERVA r on
	r.Clase = c.Codigo_Clase
GROUP BY
	ct.CLASE_TIPO
ORDER BY
	COUNT(r.Usuario) ;

###############################################################################
#Ejericio 07 .- Obtener por cada gimnasio el número total de clases ofertadas.#
###############################################################################
SELECT
	g.Nombre as 'Nombre Gimnasio',
	COUNT(c.id_Tipo) AS 'Total de clases'
FROM
	GYM g
LEFT JOIN SALAS s on
	s.id_Gym = g.Codigo_Gym
LEFT JOIN CLASES c on
	c.id_Sala = s.Codigo_Salas
GROUP BY
	g.Nombre ;

/*Aqui podemos ver con otro método diferente del de arriba en el que sacamos tambien el GYM que no tiene clases*/

SELECT
	g.Nombre AS 'Nombre del gimnasio',
	COUNT(c.id_Tipo) AS 'Número de clases ofertadas'
FROM
	GYM g
LEFT JOIN SALAS s ON
	s.id_Gym = g.Codigo_Gym
LEFT JOIN CLASES c ON
	c.id_Sala = s.Codigo_Salas
GROUP BY
	g.Nombre;

###############################################################################################################################################################
#Ejericio 08 .- Obtener por cada gimnasio los  monitores que han realizado al menos una clase en ese gimnasio, 												  #
#ordenando el número de clases de mayor a menor.																											  #
###############################################################################################################################################################
SELECT
	g.nombre AS 'Nombre Gimnasio',
	m.nombre AS 'Monitor',
	COUNT(c.Codigo_Clase)
FROM
	GYM g
JOIN SALAS s on
	s.id_Gym = g.Codigo_Gym
JOIN CLASES c on
	c.id_Sala = s.Codigo_Salas
JOIN MONITOR_CLASES mc on
	mc.Codigo_Clase = c.Codigo_Clase
JOIN MONITOR m on
	m.Codigo_Monitor = mc.Codigo_Monitor
GROUP BY
	g.Nombre,
	m.Codigo_Monitor
HAVING
	COUNT(c.Codigo_Clase) > 0
ORDER BY
	COUNT(c.Codigo_Clase) DESC ;

################################################################################################################################################
#Ejericio 09 .- Obtener un listado con el total de clases que se han impartido en gimnasio de la forma 										   #
#Nombre gimnasio "-" + Sala "-" + TipoClase "-" +Monitor. 																					   #
################################################################################################################################################
SELECT
	CONCAT_WS(' - ', g.Nombre, s.Nombre, ct.nombre, m.nombre ) AS 'Clases Impartidas'
FROM
	GYM g
JOIN SALAS s on
	s.id_Gym = g.Codigo_Gym
JOIN CLASES c on
	c.id_Sala = s.Codigo_Salas
JOIN MONITOR_CLASES mc on
	mc.Codigo_Clase = c.Codigo_Clase
JOIN MONITOR m on
	m.Codigo_Monitor = mc.Codigo_Monitor
JOIN CLASE_TIPO ct on
	ct.CLASE_TIPO = c.id_Tipo
ORDER BY
	g.Nombre,
	c.id_Sala,
	ct.Nombre,
	m.Nombre ;

#############################################################################################################################
#Ejericio 10 .- Obtener el nombre, descripción y sueldo del monitor que ha impartido  en clases  que superen los 4 usuarios.#
#############################################################################################################################
SELECT
	m.Nombre ,
	ct.Descripcion ,
	mc.Cobra
FROM
	MONITOR m
JOIN MONITOR_CLASES mc on
	mc.Codigo_Monitor = m.Codigo_Monitor
JOIN CLASES c on
	c.Codigo_Clase = mc.Codigo_Clase
JOIN CLASE_TIPO ct on
	ct.CLASE_TIPO = c.id_Tipo
JOIN RESERVA r on
	r.Clase = c.Codigo_Clase
HAVING
	COUNT(r.Usuario) >4;

#########################################################################################################
#Ejericio 11 .- Obtener un listado con el nombre y DNI de los abonados que no han realizado nunca clase.#
#########################################################################################################
SELECT
	u.nombre ,
	u.dni
FROM
	USUARIO u
LEFT JOIN RESERVA r on
	r.Usuario = u.CODIGO_U
GROUP BY
	u.DNI
HAVING
	COUNT(r.Clase) = 0
ORDER BY
	u.Nombre;

#########################################################################################################
#Ejericio 12 .- Obtener un listado con el nombre de todas las clases en las que no se ha apuntado nadie.#
#########################################################################################################
SELECT
	c.Codigo_Clase,
	ct.Nombre
FROM
	CLASES c
LEFT JOIN CLASE_TIPO ct on
	ct.CLASE_TIPO = c.id_Tipo
LEFT JOIN RESERVA r on
	r.Clase = c.Codigo_Clase
GROUP BY
	c.Codigo_Clase
HAVING
	COUNT(r.Usuario) = 0;

#################################################################################################################
#Ejericio 13 .- Obtener por abonado el pago que se ha hecho a cada uno  de los gimnasios en los últimos 90 días.#
#################################################################################################################
SELECT
	u.CODIGO_U ,
	CONCAT_WS(' ', u.Nombre, u.Apellidos) AS Abonado,
	g.Nombre ,
	SUM(r.Precio)
FROM
	USUARIO u
JOIN RESERVA r on
	r.Usuario = u.CODIGO_U
JOIN CLASES c on
	c.Codigo_Clase = r.Clase
JOIN SALAS s on
	s.Codigo_Salas = c.id_Sala
JOIN GYM g on
	g.Codigo_Gym = s.id_Gym
WHERE
	DATE (c.fecha) > curdate() - INTERVAL 90 DAY
GROUP BY
	u.CODIGO_U,
	g.Nombre;

#######################################################################################################
#Ejericio 14 .- Obtener por cada tipo_clase, los monitores que la han realizado y cuánto  han cobrado.#
#######################################################################################################
SELECT
	ct.Nombre AS 'Tipo de Clase' ,
	CONCAT_WS(' ', m.Nombre, m.Apellidos) AS Nombre,
	SUM(mc.Cobra) AS Cobrado
FROM
	CLASE_TIPO ct
JOIN CLASES c on
	c.id_Tipo = ct.CLASE_TIPO
JOIN MONITOR_CLASES mc on
	mc.Codigo_Clase = c.Codigo_Clase
JOIN MONITOR m on
	m.Codigo_Monitor = mc.Codigo_Monitor
GROUP By
	ct.CLASE_TIPO,
	Nombre
ORDER BY
	ct.CLASE_TIPO ,
	ct.Nombre,
	Cobrado ;

########################################################################################################################
#Ejericio 15 .- Obtener un listado ordenado por importe que ha generado la clase, indicando a qué gimnasio corresponde.#
########################################################################################################################
SELECT
	c.Codigo_Clase AS 'Ref. Clase' ,
	g.Nombre ,
	SUM(IFNULL(r.Precio, 0.00)) AS Beneficio
FROM
	GYM g
JOIN SALAS s on
	s.id_Gym = g.Codigo_Gym
JOIN CLASES c on
	c.id_Sala = s.Codigo_Salas
LEFT JOIN RESERVA r on
	r.Clase = c.Codigo_Clase
GROUP BY
	c.Codigo_Clase
ORDER BY
	Beneficio ,
	c.Codigo_Clase ;

#################################################################################################################################################
#Ejericio 16 .- Obtener un listado de las clases y monitores en las  que menos usuarios se han apuntado, del 1 al 15 del mes de Febrero de 2022.#
#################################################################################################################################################
SELECT
	c.Codigo_Clase,
	COUNT(r.Usuario) AS Usuarios ,
	CONCAT_WS(' ', m.Nombre, m.Apellidos) AS Nombre_Monitor ,
	ct.Nombre,
	c.fecha
FROM
	MONITOR m
JOIN MONITOR_CLASES mc on
	mc.Codigo_Monitor = m.Codigo_Monitor
JOIN CLASES c on
	c.Codigo_Clase = mc.Codigo_Clase
JOIN CLASE_TIPO ct on
	ct.CLASE_TIPO = c.id_Tipo
JOIN RESERVA r on
	r.Clase = c.Codigo_Clase
JOIN USUARIO u on
	u.CODIGO_U = r.Usuario
WHERE
	DATE (c.fecha) BETWEEN '2022-02-01' AND '2022-02-15'
GROUP BY
	mc.Codigo_Monitor ,
	c.Codigo_Clase
ORDER BY
	Usuarios;

/*Ejercicio 16 realizado acotando al menor número de usuarios que pueda tener una clase (1) */
SELECT
	c.Codigo_Clase,
	COUNT(r.Usuario) AS Usuarios ,
	CONCAT_WS(' ', m.Nombre, m.Apellidos) AS Nombre_Monitor ,
	ct.Nombre,
	c.fecha
FROM
	MONITOR m
JOIN MONITOR_CLASES mc on
	mc.Codigo_Monitor = m.Codigo_Monitor
JOIN CLASES c on
	c.Codigo_Clase = mc.Codigo_Clase
JOIN CLASE_TIPO ct on
	ct.CLASE_TIPO = c.id_Tipo
JOIN RESERVA r on
	r.Clase = c.Codigo_Clase
JOIN USUARIO u on
	u.CODIGO_U = r.Usuario
WHERE
	DATE (c.fecha) BETWEEN '2022-02-01' AND '2022-02-15'
GROUP BY
	mc.Codigo_Monitor ,
	c.Codigo_Clase
HAVING
 Usuarios = 1 
ORDER BY
	Usuarios;

/*Apartado C*/

##########################################################################################################################################
#Ejericio 17 .- Mostrar un listado de  las clases impartidas en los que se hayan apuntado más de 2 usuarios, agrupados por tipo de clase.#
##########################################################################################################################################
SELECT
	c.Codigo_Clase ,
	ct.Nombre,
	COUNT (r.Usuario) AS Usuarios
FROM
	CLASE_TIPO ct
JOIN CLASES c on
	c.id_Tipo = ct.CLASE_TIPO
JOIN RESERVA r on
	r.Clase = c.Codigo_Clase
GROUP BY
	c.Codigo_Clase
HAVING
	Usuarios > 2;

############################################################################################################################################
#Ejericio 18 .- Mostrar un listado de los usuarios en el que se desglose lo que han pagado por tipo de clases en cada uno de los gimnasios.#
############################################################################################################################################
SELECT
	CONCAT_WS(' ', u.Nombre, u.Apellidos) AS Usuarios ,
	Sum (r.Precio) AS Cuota_Total ,
	ct.Nombre ,
	g.Nombre
From
	USUARIO u
JOIN RESERVA r on
	r.Usuario = u.CODIGO_U
JOIN CLASES c on
	c.Codigo_Clase = r.Clase
JOIN CLASE_TIPO ct on
	ct.CLASE_TIPO = c.id_Tipo
JOIN SALAS s on
	s.Codigo_Salas = c.id_Sala
JOIN GYM g on
	g.Codigo_Gym = s.id_Gym
GROUP BY
	u.CODIGO_U,
	g.Codigo_Gym,
	ct.CLASE_TIPO
ORDER BY
	Usuarios,
	g.Nombre;

/*SELECT r.Usuario , count (r.Usuario) AS Usuario  FROM RESERVA r 
group by r.Usuario
ORDER BY Usuario;*/



