-- Eliminar la base de datos existente si existe y crear una nueva
DROP DATABASE IF EXISTS tce;
CREATE DATABASE tce;
USE tce;

-- tabla de roles
CREATE TABLE roles(
    id_rol int not null primary key,
    rol varchar (30) not null
);

-- tabla de generos
CREATE TABLE generos(
    id_genero int not null primary key,
    genero varchar (50) not null
);

-- Tabla de especialidad del doctor
CREATE TABLE especialidad (
    id_especialidad INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

-- Tabla de usuarios
CREATE TABLE usuarios (
    id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    primer_nombre VARCHAR(50) NOT NULL,
    segundo_nombre VARCHAR(50) NULL,
    primer_apellido VARCHAR(50) NOT NULL,
    segundo_apellido VARCHAR(50) NULL,
    fecha_nacimiento DATE NOT NULL,
    genero_id int NOT NULL,
    id_rol int not null,
    correo VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_especialidad int null,
    username varchar(20) not null;
    FOREIGN KEY (genero_id) REFERENCES generos(id_genero),
    FOREIGN KEY (id_rol) REFERENCES roles(id_rol),
    FOREIGN KEY (id_especialidad) REFERENCES especialidad(id_especialidad)
);

-- Tabla de categoría de juegos
CREATE TABLE categoria_juegos (
    id_categoriaJuego INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    categoria varchar(50) not null
);

-- Tabla de juegos
CREATE TABLE juegos (
    id_juego INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT,
    id_categoriaJuego int not null,
    foreign key (id_categoriaJuego) references categoria_juegos (id_categoriaJuego)
);

-- Tabla de juegos asignados
CREATE TABLE juegos_asignados (
    id_asignacion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_juego INT NOT NULL,
    fecha_asignacion DATE NOT NULL,
    id_paciente int not null,
    id_especialista int not null,
    FOREIGN KEY (id_paciente) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_especialista) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_juego) REFERENCES juegos(id_juego)
);

-- Tabla de avance historia clinica
CREATE TABLE avance (
    id_avance INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    avance text,
    id_paciente int not null,
    id_especialista int not null,
    FOREIGN KEY (id_paciente) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_especialista) REFERENCES usuarios(id_usuario)
);

-- Tabla de sesiones
CREATE TABLE sesiones (
    id_sesion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_paciente int not null,
    id_especialista int not null,
    fecha_sesion date NOT NULL,
    id_avance INT,
    info text, -- información de duración 
    FOREIGN KEY (id_avance) REFERENCES avance(id_avance),
    FOREIGN KEY (id_paciente) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_especialista) REFERENCES usuarios(id_usuario)
);

-- Tabla de puntajes de actividades
CREATE TABLE puntajes_actividades (
    idPuntaje INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idUsuario INT NOT NULL,
    idJuego INT NOT NULL,
    idCategoria INT NOT NULL,
    fecha_realizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    puntaje_juego INT not NULL default 0,
    puntaje_categoria INT not NULL default 0,
    FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario),
    FOREIGN KEY (idCategoria) REFERENCES categoria_juegos(id_categoriaJuego),
    FOREIGN KEY (idJuego) REFERENCES juegos(id_juego)
);

-- Inserción de datos
-- tabla generos
INSERT into generos (id_genero, genero) VALUES (1,'Maculino');
INSERT into generos (id_genero, genero) VALUES (2,'Femenino');

-- tabla rol
INSERT into roles (id_rol, rol) VALUES (1,'Usuario');
INSERT into roles (id_rol, rol) VALUES (2,'Paciente');
INSERT into roles (id_rol, rol) VALUES (3,'Terapeuta');
INSERT into roles (id_rol, rol) VALUES (4,'Administrador');

-- tabla especialidad
INSERT into especialidad (id_especialidad, nombre) VALUES (1,'ninguna');
INSERT into especialidad (id_especialidad, nombre) VALUES (2,'Neuropsicologo');
INSERT into especialidad (id_especialidad, nombre) VALUES (3,'Neurologo');
INSERT into especialidad (id_especialidad, nombre) VALUES (4,'psicólogo clinico');

alter table usuarios alter column id_rol set default 1;
alter table usuarios alter column id_especialidad set default 1;
/*se inserta categoria de juegos en la tabla categoria_juegos*/
insert into categoria_juegos (id_categoriaJuego, categoria) values (1, 'logica');
insert into categoria_juegos (id_categoriaJuego, categoria) values (2, 'memoria');
insert into categoria_juegos (id_categoriaJuego, categoria) values (3, 'resolucion');
/*se inserta juego en la tabla juegos*/
insert into juegos(id_juego, nombre, descripcion, id_categoriaJuego) values(1, 'torres Hanoi', 'juego para logica', 1);
insert into juegos(id_juego, nombre, descripcion, id_categoriaJuego) values(2, 'memoria', 'mejoramiento de memoria', 2);