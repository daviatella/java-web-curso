insert into curso (id,sigla,nome) values (1,'java','Java Básico');
insert into curso (id,sigla,nome) values (2,'php','PHP Básico');
insert into curso (id,sigla,nome) values (3,'redes','Redes de Computadores');

insert into topico (id,id_curso,ordem,descricao) values (1, 1, 1, 'Swing');
insert into topico (id,id_curso,ordem,descricao) values (2, 1, 2, 'JDBC');
insert into topico (id,id_curso,ordem,descricao) values (3, 1, 3, 'Servlet e JSP');
insert into topico (id,id_curso,ordem,descricao) values (4, 1, 4, 'Threads');
insert into topico (id,id_curso,ordem,descricao) values (5, 1, 5, 'Generics');

insert into topico (id,id_curso,ordem,descricao) values (6, 2, 1, 'Arrays associativos');
insert into topico (id,id_curso,ordem,descricao) values (7, 2, 2, 'Funções de Filtro');
insert into topico (id,id_curso,ordem,descricao) values (8, 2, 3, 'PDO');
insert into topico (id,id_curso,ordem,descricao) values (9, 2, 4, 'Gerenciamento de Sessão');

insert into topico (id,id_curso,ordem,descricao) values (10, 3, 1, 'UDP');
insert into topico (id,id_curso,ordem,descricao) values (11, 3, 2, 'TCP');
insert into topico (id,id_curso,ordem,descricao) values (12, 3, 3, 'Roteamento');
insert into topico (id,id_curso,ordem,descricao) values (13, 3, 4, 'Camada Física');

insert into aluno (id,email,hash_senha) values (1,'mbelo.br@gmail.com','62f0cbf600ee574d20a6c1bfcf083085');

insert into aluno_topico (id_topico,id_aluno) values (1, 1);