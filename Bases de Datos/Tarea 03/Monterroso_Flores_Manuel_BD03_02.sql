/*Primero nos aseguramos de trabajar con la BBDD de la tarea*/
USE muebles_bd03;
ALTER TABLE MUEBLE DROP CONSTRAINT mue_val_CHK;
ALTER TABLE MUEBLE CHANGE COLUMN valoracion_clientes  estrellas TINYINT;
ALTER TABLE MUEBLE ADD CONSTRAINT mub_est_CK CHECK (estrellas BETWEEN 1 AND 2);
ALTER TABLE MUEBLE DROP COLUMN color;
ALTER TABLE MUEBLE MODIFY estado_catalogo TINYINT;
CREATE INDEX ind_mueb ON MUEBLE (estrellas, estado_catalogo);
/*En la tarea nos pide que creemos una nueva fila siendo esta la PK, entonces para eso 
 * primero quitamos las FK y las PK*/
ALTER TABLE FABRICADO DROP CONSTRAINT componente_id_FK;
ALTER TABLE FABRICADO DROP CONSTRAINT fabricante_nif_FK;
ALTER TABLE FABRICADO DROP PRIMARY KEY;
ALTER TABLE FABRICADO ADD id_fabricado MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY;
/*Aquí vuelvo a crear las dos FK que tuve que quitar antes para poner la nueva PK*/
ALTER TABLE FABRICADO ADD CONSTRAINT componente_id_FK FOREIGN KEY (id_componente) REFERENCES COMPONENTE (id_componente) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE FABRICADO ADD CONSTRAINT fabricante_nif_FK FOREIGN KEY (nif_fabricante) REFERENCES FABRICANTE (nif) ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE FABRICADO RENAME ELABORADO;
CREATE VIEW SALAS AS SELECT sala, pasillo FROM UBICACION;
/*creo los dos usuarios en el grupo % (ALL) al no declarar nada en la tarea si debe de ser por ejemplo localhost*/
CREATE USER gerente@'%' IDENTIFIED BY 'gerente';
GRANT ALL ON muebles_bd03.* TO gerente@'%';
CREATE USER empleado@'%' IDENTIFIED BY 'empleado';
GRANT SELECT, INSERT, UPDATE, DELETE ON muebles_bd03.* TO empleado@'%';
REVOKE ALL ON muebles_bd03.* FROM empleado@'%';




