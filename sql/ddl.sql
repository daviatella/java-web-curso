create database if not exists curso;

use curso;

create table curso ( 
  id integer not null primary key auto_increment, 
  sigla varchar(20) not null, 
  nome varchar(80) not null 
);

create table topico (
  id integer not null primary key auto_increment,
  id_curso integer not null,
  ordem integer not null,
  descricao varchar(80) not null,
  foreign key fk_curso (id_curso) references curso (id)
);

create table aluno (
  id integer not null primary key auto_increment,
  email varchar(80) not null,
  hash_senha varchar(80) not null
);

create table aluno_topico (
  id_topico integer not null,
  id_aluno integer not null,
  foreign key fk_topico (id_topico) references topico (id),
  foreign key fk_aluno (id_aluno) references aluno (id)
);