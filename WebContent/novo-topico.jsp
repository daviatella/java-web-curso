<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaWebCurso - Novo Tópico</title>
<link rel="stylesheet" href="/java-web-curso/css/styles.css">
</head>
<body>
<div>
	<img src="/java-web-curso/imgs/JavaWebCurso.png"/>
	<br/>		
	<a href="/java-web-curso/ListarCursos">Área do Administrador</a>&nbsp;|&nbsp;<a href="/java-web-curso/ListarPlanoAluno">Área do Aluno</a>
</div>
	<form action="/java-web-curso/AdicionarTopico" method="post">
	
		<input type="hidden" name="idCurso" value="${param.idCurso}" />
	
		<label for="descricao">Descrição</label>
		<input id="descricao" type="text" name="descricao"/> 
	
		<input type="submit" value="Salvar"/>
		<a href="/java-web-curso/ListarTopicos?idCurso=${param.idCurso}">Cancelar</a>
	
	</form>
</body>
</html>