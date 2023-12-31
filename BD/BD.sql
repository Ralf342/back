create database sangreSegura;

use sangreSegura;

drop table persona;
create table persona(
    nombre varchar(60),
    apellido varchar(60),
    telefono varchar(30),
	correo varchar(60) primary key,
    contrasena varchar(60)
);

insert into persona (nombre,apellido,correo) values ('1','a','a');

drop table donaciones;
create table donaciones(Nombre varchar(255),
Direccion varchar (255),
Telefono varchar (255),
Correo varchar (255),
Imagen varchar(255),
Categoria varchar (255),
primary key (Nombre));

#Inserecion datos donaciones
insert into donaciones values('Paco Ramirez Rosas','Algun lugar','(228)459-00-75','pelican1183kookaburra@gmail.com','./Imagenes/persona1.webp','Persona');
insert into donaciones values('Luna Estrada','39388-672, Rua Agustina Roque, 500. Anexo
Franco do Leste - MT','(228)459-00-75','elizabeth33@pontes.net','./Imagenes/persona2.webp','Persona');
insert into donaciones values('Valeria Moreno','52614-694, R. Samanta Batista, 2182. Bc. 3 Ap. 43 Santa Mariana','(63) 93040-1313','pelican1183kookaburra@gmail.com','./Imagenes/persona3.webp','Persona');
insert into donaciones values('Natalia Luna','22319-720, Rua Aragão, 95134
Ivan do Norte - SC','(73) 95134-5209','francisco.benites@ig.com.br','./Imagenes/persona4.webp','Persona');
insert into donaciones values('Gustavo Guerrero','93346-869, Rua Colaço, 68. Bloco A
Santa Máximo do Sul - PA','(35) 4750-9553','antonieta68@avila.br','./Imagenes/persona5.webp','Persona');

#Insercion donaciones hospitales
insert into donaciones values('INSTITUTO MEXICANO DEL SEGURO SOCIAL','NICOLÁS BRAVO Y PROLONG.BARRAGÁN S/N COL. CENTRO C.P. 91000, XALAPA, VERAC NORTE','8187485','./Imagenes/localizacion1.webp','./Imagenes/hospital1.webp','Hospital');
insert into donaciones values('U.H. FOVISSSTE # 2 XALAPA','AND. ONIX S/N, COL. UH. FOVISSSTE','8404116','./Imagenes/localizacion2.webp','./Imagenes/hospital2.webp','Hospital');
insert into donaciones values('S.N.T.E.','SALTILLO S/N, COL. PROGRESO MACUILTEPETL','8426395','./Imagenes/localizacion3.webp','./Imagenes/hospital3.webp','Hospital');
insert into donaciones values('XALAPA-ENRÍQUEZ SEBASTIAN LERDO DE TEJADA','COYOACÁN NO. 62','8154223','./Imagenes/localizacion4.webp','./Imagenes/hospital4.webp','Hospital');