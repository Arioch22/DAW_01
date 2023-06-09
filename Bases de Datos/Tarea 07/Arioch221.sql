/*1. Declara un objeto Persona del que puedan heredar otros. Debe tener dos campos,
"dni" y "nombre", de tipo cadena de caracteres. Asimismo debe contener una función de orden "comparar".*/
CREATE OR REPLACE TYPE Persona AS OBJECT(
    dni CHAR(9),
    nombre VARCHAR2(400),
    
    order member FUNCTION comparar(unPersona Persona) RETURN INTEGER)
    NOT FINAL;
/
/*2. Define el cuerpo del objeto Persona. La función "comparar" debe ordenar por dni.*/
CREATE OR REPLACE TYPE BODY Persona IS
    order member FUNCTION comparar(unPersona Persona) RETURN INTEGER IS
    resultado_comparacion INTEGER;
    
    BEGIN
        IF SELF.dni > unPersona.dni THEN
            resultado_comparacion := 1;
        ELSIF SELF.dni < unPersona.dni THEN
            resultado_comparacion := -1;
        ELSE
            resultado_comparacion := 0;
        END IF;
        RETURN resultado_comparacion;
    END;
END;
/
/*3. Declara un objeto Empleado que hereda de Persona,
con campo "fechaIncorporacion" de tipo fecha, y una función miembro,
"getAntiguedad" sin parámetros de entrada que devuelve un entero.*/
CREATE OR REPLACE TYPE Empleado under Persona(
    fechaIncorporacion DATE,
    member FUNCTION getAntiguedad RETURN INTEGER
);
/
/*4. Crea una tabla "empleados" de objetos Empleado,
con las siguientes restricciones: "dni" debe ser clave primaria,
"nombre" no puede ser nulo y "fechaIncorporacion" no puede ser nulo.*/
CREATE TABLE empleados of Empleado(
PRIMARY KEY (dni),
CHECK (nombre IS NOT NULL),
CHECK (fechaIncorporacion IS NOT NULL));
/
/*5. Define el cuerpo de Empleado.

la función "getAntiguedad" debe devolver los años que lleva el empleado desde la fecha de incorporación (Sugerencia: usar las funciones "MONTHS_BETWEEN" y "FLOOR").
*/
CREATE OR REPLACE TYPE BODY Empleado IS
    member FUNCTION getAntiguedad RETURN INTEGER IS
    resultado_antiguedad INTEGER;
    
    BEGIN
   
    resultado_antiguedad := FLOOR (MONTHS_BETWEEN (SYSDATE, fechaIncorporacion) /12);
        return resultado_antiguedad;
    END;
END;
/
/*6. Crea el tipo "ListaTelefonosTipo" como array de 10 enteros.*/
CREATE OR REPLACE TYPE ListaTelefonosTipo AS VARRAY (10) OF Persona;
/
/*7. Declara el objeto Cliente que hereda de Persona. Debe tener como campos "listaTelefonos" de tipo "ListaTelefonosTipo",
"volumen" de tipo numérico de tamaño 20 y dos decimales, y "fechaIncorporacion" de tipo fecha.
Además debe contar con un constructor que recibe como parámetros todos los campos salvo "listaTelefonos"
(Nota: no olvidar los campos heredados de Persona). También tendrá dos funciones miembro, "setEmpleado" 
que recibe como parámetro un Empleado y devuelve un boolean, y "getEmpleado", que devuelve un Empleado.*/
CREATE OR REPLACE TYPE Cliente UNDER Persona(
    listaTelefonos ListaTelefonosTipo,
    volumen number (20,2),
    fechaIncorporacion DATE,
    MEMBER FUNCTION setEmpleado(unEmpleado Empleado) RETURN BOOLEAN,
    MEMBER FUNCTION getEmpleado RETURN Empleado,
    CONSTRUCTOR FUNCTION Cliente(dni VARCHAR2, nombre VARCHAR2, volumen NUMBER, fechaIncorporacion DATE)RETURN SELF AS result);
/
/*8. Crea la tabla clientes con dos campos, uno de tipo Cliente y otro de tipo referencia a Empleado. Como restricciones tenemos
que la referencia a Empleado no puede ser nula, la clave primaria es el dni del cliente, 
y tanto el nombre como la fecha de incorporación del cliente no pueden ser nulas.*/
 CREATE TABLE clientes (
    cliente Cliente,
    empleado ref Empleado NOT NULL,
    PRIMARY KEY (cliente.dni),
    CHECK (cliente.nombre IS NOT NULL),
    CHECK (cliente.fechaIncorporacion IS NOT NULL));
/
/*9. Crea el cuerpo de la clase Cliente.

el constructor asignará los campos que aparecen como parámetros a los campos del objeto. Si el parámetro "fechaIncorporacion" es nulo, se asignará la fecha actual al campo correspondiente. El campo "listaTelefono" se inicializa como array vacío.
la función "setEmpleado" recibe un empleado como parámetro. Se debe encontrar la referencia en la tabla empleados y, si se encuentra, se actualiza dicha referencia en la tabla clientes (para el objeto que coincide con el actual). Si se actualiza (se encuentra el empleado y se actualiza el cliente en sus respectivas tablas), la función devuelve el valor verdadero.
la función "getEmpleado" obtiene el valor correspondiente de la tabla clientes. Si el cliente actual no se encuentra en la tabla, se devuelve nulo.
*/
CREATE OR REPLACE TYPE BODY cliente IS
    CONSTRUCTOR FUNCTION Cliente(dni VARCHAR2, nombre VARCHAR2, volumen NUMBER, fechaIncorporacion DATE) RETURN SELF AS result IS
    BEGIN
        SELF.dni := dni;
        SELF.nombre := nombre;
        SELF.volumen := volumen;
        
        IF fechaIncorporacion IS NULL THEN
            SELF.fechaIncorporacion := SYSDATE;
        ELSE
            SELF.fechaIncorporacion := fechaIncorporacion;
        END IF;
        SELF.listaTelefonos := listaTelefonosTipo();
        RETURN;
    END;
    
    MEMBER FUNCTION setEmpleado(unEmpleado Empleado) RETURN BOOLEAN IS
        resultado BOOLEAN;
        ref_empleado ref Empleado;
    BEGIN 
        resultado := false;
        SELECT ref(e) INTO ref_empleado FROM empleados e WHERE VALUE(e) = unEmpleado;
        UPDATE clientes c SET c.empleado = ref_empleado WHERE c.cliente = SELF;
        
        IF SQL%ROWCOUNT = 1 THEN
            resultado := true;
        END IF;
        RETURN resultado;
        EXCEPTION 
            WHEN no_data_found THEN
                resultado := false;
                RETURN resultado;
    END;
    
    MEMBER FUNCTION getEmpleado RETURN Empleado IS
        unEmpleado Empleado;
    
    BEGIN
        SELECT DEREF(c.empleado) INTO unEmpleado FROM clientes c WHERE c.cliente = SELF;
        RETURN unEmpleado;
        EXCEPTION
            WHEN no_data_found THEN
                unEmpleado := NULL;
                RETURN unEmpleado;
    END;
END;
/
/*10. Inserta dos empleados en la tabla empleados:

"11111111A", "Antonio López", 22-12-2002
"22222222B", "Ana Gómez", 12-03-2005*/
DECLARE
	u1 empleado;
	u2 empleado;
BEGIN
	u1 := NEW empleado ('11111111A', 'Antonio Lopez', TO_DATE('22-12-2002', 'DD-MM-YYYY'));
	u2 := NEW empleado ('22222222B', 'Ana Gomez', TO_DATE('12-03-2005', 'DD-MM-YYYY'));
	INSERT INTO empleados VALUES (u1);
	INSERT INTO empleados VALUES (u2);
END;
/
/*11. Inserta dos clientes en la tabla clientes:

'33333333C', 'Juan Pérez', 30000.00, 01-12-2018, asociado a Antonio López
'44444444D', 'María Sánchez', 45000.00, 03-04-2020, asociada a Ana Gómez*/
INSERT INTO clientes VALUES(NEW Cliente('33333333C', 'Juan Pérez Gómez', 30000.00, '01-12-2018'), (SELECT ref(e) FROM empleados e WHERE e.dni = '11111111A'));
INSERT INTO clientes VALUES(NEW Cliente('44444444D', 'María Sánchez', 45000.00, '03-04-2020'), (SELECT ref(e) FROM empleados e WHERE e.dni = '22222222B'));
INSERT INTO clientes VALUES (NEW Cliente ('33333333C', 'Juan Pérez Gómez', 30000.00, '01-12-2018'), setEmpleado('11111111A'));

/
/* Aquí otra manera de insertar los datos en la tabla clientes
DECLARE
	c1 cliente;
	c2 cliente;
    u1 REF empleado;
    u2 REF empleado;
BEGIN

    SELECT REF(e) INTO u1 FROM empleados e WHERE dni='11111111A';
	SELECT REF(e) INTO u2 FROM empleados e WHERE dni='22222222B';
	c1 := NEW Cliente('33333333C', 'Juan Pérez Gómez','30000,00', '01-12-2018');
	c2 := NEW Cliente('44444444D', 'María Sánchez', '45000,00', '03-04-2020');
	
    
    INSERT INTO clientes VALUES (c1,u1);
    INSERT INTO clientes VALUES (c2,u2);
END;*/


