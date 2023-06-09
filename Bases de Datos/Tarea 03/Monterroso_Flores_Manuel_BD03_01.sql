/*Primero eliminamos la BBDD si ya esta creada una con este nombre*/
DROP DATABASE IF EXISTS muebles_bd03;
/*Creamos la BBDD con nombre muebles_bd03*/
CREATE  DATABASE IF NOT EXISTS muebles_bd03;
/*Ponemos la BBDD como por defecto*/
USE muebles_bd03;
/*Creamos las tablas de la BBDD, las iremos primero haciendo las que no tienen FK para que primero se creen las PK que se 
 * basaran despues las FK.*/

CREATE TABLE IF NOT EXISTS MUEBLE(
id_mueble MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(250) NOT NULL UNIQUE,
descripcion VARCHAR(250),
color VARCHAR(250),
valoracion_clientes TINYINT /*CHECK (valoracion_clientes BETWEEN 1 AND 5)*/,
estado_catalogo ENUM ('activo','descatalogado','en-proyecto'),
CONSTRAINT mue_val_CHK CHECK (valoracion_clientes BETWEEN 1 AND 5)
);
CREATE TABLE IF NOT EXISTS FABRICANTE(
/*aunque no se especifique en la tarea, por lógica asumo que los NIF son de 9 carácteres como el DNI*/
nif CHAR(9) PRIMARY KEY,
/*Con el CHECK se comprueba que no se quede en blanco la fila razon_social*/
razon_social VARCHAR(250) NOT NULL UNIQUE CHECK (razon_social <> ''),
localidad VARCHAR(250),
fecha_alta DATE DEFAULT (CURRENT_DATE),
nivel_fidelizacion TINYINT CHECK (nivel_fidelizacion BETWEEN 1 AND 10)
);
CREATE TABLE IF NOT EXISTS UBICACION(
referencia MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
sala VARCHAR(250) UNIQUE NOT NULL CHECK (sala <> ''),
/*En estas filas no quito el cero al entender que si pueda exister el pasillo 0, estanteria 0 y balda 0*/
pasillo MEDIUMINT UNSIGNED UNIQUE NOT NULL,
estanteria MEDIUMINT UNSIGNED UNIQUE NOT NULL,
balda MEDIUMINT UNSIGNED UNIQUE NOT NULL
);
CREATE TABLE IF NOT EXISTS COMPONENTE (
id_componente MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
id_mueble MEDIUMINT UNSIGNED,
nombre VARCHAR (250) NOT NULL,
descripcion VARCHAR (250),
alto  float (5,2) NOT NULL CHECK (alto > 0),
ancho float (5,2) NOT NULL CHECK (ancho > 0),
fondo float (5,2) NOT NULL CHECK (fondo > 0),
peso  float (5,2) NOT NULL CHECK (peso > 0),
CONSTRAINT mueble_id_FK FOREIGN KEY (id_mueble) REFERENCES MUEBLE(id_mueble) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS FABRICADO (
id_componente MEDIUMINT UNSIGNED,
nif_fabricante CHAR (9),
CONSTRAINT PRIMARY KEY(id_componente,nif_fabricante),
CONSTRAINT componente_id_FK FOREIGN KEY (id_componente) REFERENCES COMPONENTE (id_componente) ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT fabricante_nif_FK FOREIGN KEY (nif_fabricante) REFERENCES FABRICANTE (nif) ON UPDATE CASCADE ON DELETE RESTRICT
);
CREATE TABLE IF NOT EXISTS LOCALIZADO(
id_componente MEDIUMINT UNSIGNED, 
referencia_ubicacion MEDIUMINT UNSIGNED,
cantidad MEDIUMINT UNSIGNED CHECK (cantidad >0),
CONSTRAINT PRIMARY KEY (id_componente, referencia_ubicacion),
CONSTRAINT ubicacion_ref_FK FOREIGN KEY (referencia_ubicacion) REFERENCES UBICACION (referencia) ON UPDATE CASCADE ON DELETE RESTRICT,
CONSTRAINT componente2_id_FK FOREIGN KEY (id_componente) REFERENCES COMPONENTE (id_componente) ON UPDATE CASCADE ON DELETE CASCADE
);

