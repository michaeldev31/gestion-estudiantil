create database sdge;
use sdge;


create table estudiantes(
id INT AUTO_INCREMENT PRIMARY KEY,
dni varchar(8) not null,
nombre varchar(100) not null,
apellido varchar(100) not null,
email varchar(100) unique,
grado varchar(10) not null,
promedio decimal(10,2) not null
);
select*from estudiantes;

create table profesores(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre varchar(100) not null,
apellido varchar(100) not null,
email varchar(100) unique,
telefono varchar(20)
);

select*from profesores;

create table asignaturas(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre varchar(100) not null,
descripcion varchar(255)
);

select*from asignaturas;

create table recursos_educativos(
id INT AUTO_INCREMENT PRIMARY KEY,
titulo varchar(100) not null,
tipo varchar(100) not null,
contenido text not null,
id_asignaturas int,
foreign key (id_asignaturas) references asignaturas(id)
);
drop table recursos_educativos;
CREATE TABLE recursos_educativos (
id INT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(100) NOT NULL,
tipo VARCHAR(100) NOT NULL,
contenido TEXT NOT NULL,
nombre_asignatura VARCHAR(100),
FOREIGN KEY (nombre_asignatura) REFERENCES asignaturas(nombre)
);

select * from recursos_educativos;
/*--------------------------------PROCEDIMEINTOS ALMACENADOS ESTUDIANTES-------------------------------------------*/
DELIMITER //
CREATE PROCEDURE GetAllEstudiantes()
BEGIN
    SELECT * FROM estudiantes; -- Reemplaza 'estudiantes' con el nombre correcto de tu tabla
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetEstudiante(IN estudiante_id INT)
BEGIN
    SELECT id, dni, nombre, apellido, email, grado, promedio
    FROM estudiantes
    WHERE id = estudiante_id;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE InsertEstudiante(
    IN p_dni VARCHAR(8),
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_grado VARCHAR(10),
    IN p_promedio DECIMAL(10,2)
)
BEGIN
    INSERT INTO estudiantes (dni, nombre, apellido, email, grado, promedio)
    VALUES (p_dni, p_nombre, p_apellido, p_email, p_grado, p_promedio);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE UpdateEstudiante(
    IN p_id INT,
    IN p_dni VARCHAR(8),
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_grado VARCHAR(10),
    IN p_promedio DECIMAL(10,2)
)
BEGIN
    UPDATE estudiantes
    SET dni = p_dni,
        nombre = p_nombre,
        apellido = p_apellido,
        email = p_email,
        grado = p_grado,
        promedio = p_promedio
    WHERE id = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE DeleteEstudiante(IN estudiante_id INT)
BEGIN
    DELETE FROM estudiantes
    WHERE id = estudiante_id;
END //
DELIMITER ;
/*------------------------------------------------------------------------------------------------------------------------*/

/*--------------------------------PROCEDIMEINTOS ALMACENADOS PROFESORES-------------------------------------------*/
DELIMITER //
CREATE PROCEDURE GetProfesor(IN profesor_id INT)
BEGIN
    SELECT id, nombre, apellido, email, telefono
    FROM profesores
    WHERE id = profesor_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE InsertProfesor(
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_telefono VARCHAR(20)
)
BEGIN
    INSERT INTO profesores (nombre, apellido, email, telefono)
    VALUES (p_nombre, p_apellido, p_email, p_telefono);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE UpdateProfesor(
    IN p_id INT,
    IN p_nombre VARCHAR(100),
    IN p_apellido VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_telefono VARCHAR(20)
)
BEGIN
    UPDATE profesores
    SET nombre = p_nombre,
        apellido = p_apellido,
        email = p_email,
        telefono = p_telefono
    WHERE id = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE DeleteProfesor(IN profesor_id INT)
BEGIN
    DELETE FROM profesores
    WHERE id = profesor_id;
END //
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE GetAllProfesores()
BEGIN
    SELECT id, nombre, apellido, email, telefono
    FROM profesores;
END $$
DELIMITER ;


/*------------------------------------------------------------------------------------------------------------------------*/

/*--------------------------------PROCEDIMEINTOS ALMACENADOS RECURSOS-------------------------------------------*/

DELIMITER $$
select * from recursos_educativos;
CREATE PROCEDURE GetRecursoEducativo(IN r_id INT)
BEGIN
    SELECT * 
    FROM recursos_educativos 
    WHERE id = r_id;
END $$

CREATE PROCEDURE InsertRecursoEducativo(IN titulo VARCHAR(255), IN tipo VARCHAR(255), IN contenido TEXT, IN nombreAsignatura VARCHAR(100))
BEGIN
    INSERT INTO recursos_educativos (titulo, tipo, contenido, nombre_asignatura)
    VALUES (titulo, tipo, contenido, nombreAsignatura);
END $$

CREATE PROCEDURE UpdateRecursoEducativo(IN id INT, IN titulo VARCHAR(255), IN tipo VARCHAR(255), IN contenido TEXT, IN nombreAsignatura VARCHAR(100))
BEGIN
    UPDATE recursos_educativos
    SET titulo = titulo, tipo = tipo, contenido = contenido, nombre_asignatura = nombreAsignatura
    WHERE id = id;
END $$
DELIMITER $$
CREATE PROCEDURE DeleteRecursoEducativo(IN r_id INT)
BEGIN
    DELETE FROM recursos_educativos WHERE id = r_id;
END $$
drop procedure if exists DeleteRecursoEducativo;
CREATE PROCEDURE GetAllRecursosEducativos()
BEGIN
    SELECT id, titulo, tipo, contenido, nombre_asignatura FROM recursos_educativos;
END $$

DELIMITER ;


/*------------------------------------------------------------------------------------------------------------------------*/

/*--------------------------------PROCEDIMEINTOS ALMACENADOS ASIGNATURAS-------------------------------------------*/
DELIMITER //

CREATE PROCEDURE GetAsignatura(IN p_id INT)
BEGIN
    SELECT * 
    FROM asignaturas 
    WHERE id = p_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertAsignatura(IN p_nombre VARCHAR(100), IN p_descripcion VARCHAR(255))
BEGIN
    INSERT INTO asignaturas (nombre, descripcion)
    VALUES (p_nombre, p_descripcion);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE UpdateAsignatura(IN p_id INT, IN p_nombre VARCHAR(100), IN p_descripcion VARCHAR(255))
BEGIN
    UPDATE asignaturas
    SET nombre = p_nombre, descripcion = p_descripcion
    WHERE id = p_id;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE DeleteAsignatura(IN p_id INT)
BEGIN
    DELETE FROM asignaturas
    WHERE id = p_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE GetAllAsignaturas()
BEGIN
    SELECT * 
    FROM asignaturas;
END //

DELIMITER ;




/*------------------------------------------------------------------------------------------------------------------------*/

DELIMITER $$

CREATE PROCEDURE mostrarAlumnosPorGrado(IN p_grado VARCHAR(20))
BEGIN
    SELECT *
    FROM estudiantes
    WHERE grado = p_grado;
END $$

DELIMITER ;
DROP PROCEDURE IF EXISTS mostrarAlumnosPorGrado;

call mostrarAlumnosPorGrado('PRIMERO');

