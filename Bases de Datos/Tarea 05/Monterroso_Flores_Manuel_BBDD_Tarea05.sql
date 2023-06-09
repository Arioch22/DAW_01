###########################################################################################################################
#1.- Inserta los siguientes datos en la tabla COMPONENTE teniendo en cuenta que debes insertar sólo los valores necesarios#
# en los campos correspondientes. Agrega el primero en su propia sentencia y los dos siguientes en una única sentencia.   #
###########################################################################################################################
-- Al meter todos los datos no es necesario indicar los valores que se van indicar despues de la tabla ya que considero null como un tipo de dato.
INSERT INTO
	COMPONENTE
VALUES (0,
		3,
		'Puerta',
		'Puerta de madera DM lacada.',
		650,
		350,
		null,
		1.500);
	
-- Asigando solo un nuevo componente, indicando los campos que queremos que solo se inserten.
INSERT INTO
	COMPONENTE (id_componente,id_mueble,nombre,descripcion,alto,ancho,peso)
VALUES (0,
		3,
		'Puerta',
		'Puerta de madera DM lacada.',
		650,
		350,
		1.500);

-- Asignando los dos componentes en una misma sentencia.
INSERT
	INTO
	COMPONENTE
VALUES (0,
		5,
		'Asiento',
		'Asiento para silla tapizado en cuero',
		70,
		450,
		500,
		null),
	   (0,
		5,
		'Respaldo',
		'Respaldo para silla tapizado en cuero',
		56,
		450,
		750,
		1.975);
############################################################################################################################
#2.- Inserta para el último mueble creado todos los componentes del mueble Gomera-b. Debes hacerlo con una única sentencia.#
############################################################################################################################
INSERT INTO COMPONENTE 
SELECT
	NULL,
	-- forzamos de esta manera a que coja el valor máximo de id_mueble de muebles que será el último componente introducido 
	(SELECT MAX(id_mueble) FROM MUEBLE m),
	c.nombre,
	c.descripcion,
	c.alto,
	c.ancho,
	c.fondo,
	c.peso
FROM 
	COMPONENTE c
JOIN 
	MUEBLE m ON 
	m.id_mueble = c.id_mueble 
WHERE 
	m.nombre = 'Gomera-b';

#############################################################################
#3.- Duplica el ancho del último componente insertado (usar last_insert_id).#
#############################################################################
UPDATE 
	COMPONENTE
SET
	ancho = (ancho*2)
WHERE  
	id_componente = LAST_INSERT_ID();

/*Como sabemos que el último insert fue de dos para que se modifique el úlitmo insert y no el primero del grupo
 * pues le sumamos la cantidas de insert de mas que se han introducido y como fueron solo dos pues sumo uno mas.
UPDATE 
	COMPONENTE
SET
	ancho = (ancho*2)
WHERE  
	id_componente = LAST_INSERT_ID()+1;*/

######################################################################################################################
#4.- Para el mueble Palma, actualiza los campos 'descripción', 'color' y 'valoración_cliente' 						 #
#con los valores "Recibidor con doble pueta", "Turquesa" y 4, respectivamente. Debes hacerlo con una única sentencia.#
######################################################################################################################
UPDATE 
	MUEBLE 
SET
	descripcion = 'Recibidor con doble puerta',
	color = 'Turquesa',
	valoracion_clientes = 4
WHERE
	nombre = 'Palma';

##########################################################################################################################
#5.- Aumenta en 1 punto, sin pasarse de 5, la valoración de clientes de todos los muebles con id entre 2 y 5 (inclusive).#
#Debes hacerlo con una única sentencia.																					 #
##########################################################################################################################
UPDATE
	MUEBLE
SET 
	valoracion_clientes = valoracion_clientes +1 
WHERE 	
	id_mueble BETWEEN 2 AND 5 
AND
	valoracion_clientes < 5;

#####################################################################################################################################
#6.- Disminuye a la mitad el peso de todos los componentes de muebles cuyo nombre sea 'Pata'. Debes hacerlo con una única sentencia.#
#####################################################################################################################################
UPDATE 
	COMPONENTE 
SET 
	peso = peso/2
WHERE 
	nombre = 'Pata';

#####################################################################################################################################
#7.- Para todos los componentes cuyo fabricante tiene localidad "Córdoba", si la descripción de componente está en blanco o es nula,#
#poner en 'descripción' el texto contenido en el campo 'nombre'. Debes hacerlo con una única sentencia.								#
#####################################################################################################################################
UPDATE COMPONENTE c
	JOIN 
		FABRICADO f ON 
		c.id_componente = f.id_componente 
	JOIN 
		FABRICANTE fa ON
		fa.nif = f.nif_fabricante
SET 
	descripcion = nombre
WHERE 
	fa.localidad = 'Córdoba' AND (descripcion IS NULL OR descripcion = ' ');

##############################################################################################################
#8.- Muestra los componentes que son fabricados por el fabricante 'Componentes Garcia'. 					 #
#A continuación, actualiza el NIF de dicho frabricante a '12341234A'. 										 #
#Finalmente, muestra el NIF del fabricante (comprueba que se ha actualizado) y 								 #
#vuelve a mostrar los componentes que son fabricados por dicho fabricante: verifica siguen siendo los mismos,#
#habiéndose actualizado en cascada la relación (captura de pantalla).										 #
##############################################################################################################		

SELECT 
	c.id_componente, c.nombre, f2.nif, f2.razon_social  
FROM 
	COMPONENTE c
JOIN 
	FABRICADO f ON c.id_componente = f.id_componente 
JOIN 
	FABRICANTE f2 ON f.nif_fabricante = f2.nif 
GROUP BY 
	f2.razon_social, c.id_mueble 
HAVING 
	f2.razon_social = 'Componentes Garcia';

UPDATE 
	FABRICANTE 
SET 
	nif = '12341234A'
WHERE 
	razon_social = 'Componentes Garcia';

SELECT 
	nif, razon_social 
FROM 
	FABRICANTE f 
WHERE 
	f.razon_social = 'Componentes Garcia';

SELECT 
	c.id_componente, c.nombre, f2.nif, f2.razon_social  
FROM
	COMPONENTE c 
JOIN 
	FABRICADO f ON
	c.id_componente = f.id_componente 
JOIN 
	FABRICANTE f2 ON
	f.nif_fabricante = f2.nif 
GROUP BY 
	f2.razon_social, c.id_mueble 
HAVING 
	f2.razon_social = 'Componentes Garcia';

##############################################################################################
#9.- Elimina aquellos fabricantes que nunca han fabricado un componente para nuestra empresa.#
#Debes hacerlo con una única sentencia.														 #
##############################################################################################

DELETE
FROM
	FABRICANTE
WHERE
	nif NOT IN 
		(SELECT
			nif_fabricante
		FROM
			FABRICADO);

###############################################################################################
#10.- Crea la sentencia para borrar todas las ubicaciones de los componentes con nombre 'Pata'#
#y comprueba que no se puede (captura de pantalla del error).								  #
###############################################################################################
DELETE FROM 
	UBICACION
WHERE 
	referencia IN 
		(SELECT 
			l.referencia_ubicacion
		FROM 
			LOCALIZADO l
		JOIN 
			COMPONENTE c ON
			l.id_componente = c.id_componente
		WHERE 
			c.nombre = 'Pata');
		
###############################################################################
#11.- Inicia una transacción. Inserta un nuevo registro en la tabla mueble.   #
#Pon un savepoint con etiqueta 'b_11' e inserta un segundo registro en mueble.#
#Haz rollback hasta el savepoint y, a continuación, ejecuta commit. 		  #
#Verifica que existe el primer mueble insertado y no el segundo en una select.#
###############################################################################
START TRANSACTION;

INSERT INTO
	MUEBLE
VALUES 
	(0,
	'Roca Alto',
	'Mueble alto para cuarto de baño',
	'Blanco',
	4,
	'activo');

SAVEPOINT b_11;

INSERT INTO
	MUEBLE
VALUES 
	(0,
	'Roca Bajo',
	'Mueble bajo para cuarto de baño',
	'Blanco',
	5,
	'activo');

ROLLBACK TO SAVEPOINT b_11;

COMMIT;

#########################################################################################################################
#12.- Inicia una transacción. Haz un SELECT ... FOR UPDATE en la tabla mueble. 											#
#Conéctate con otro usuario (abre otra sesión) y haz SELECT de todos los registros de la tabla mueble. 					#
#A continuación, con este segundo usuario, trata de actualizar a 'verde' el color del mueble con nombre 'Fuerteventura' #
#(verifica, en una captura de pantalla, que esta última sentencia da error de tiempo excedido, esto es, TIMEOUT).		#
#########################################################################################################################
START TRANSACTION;

SELECT
	* 
FROM
	MUEBLE 
FOR UPDATE;

/* Consulta y actualización con el otro usuario
SELECT * FROM MUEBLE;

UPDATE MUEBLE 
SET color = 'verde'
WHERE nombre = 'Fuerteventura';*/