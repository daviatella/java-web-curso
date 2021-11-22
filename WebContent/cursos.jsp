<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaWebCurso - Cursos</title>
<link rel="stylesheet" href="/java-web-curso/css/styles.css">
</head>
<body>
<div>
	<img src="/java-web-curso/imgs/JavaWebCurso.png"/>
	<br/>
	<a href="/java-web-curso/ListarCursos">Área do Administrador</a>&nbsp;|&nbsp;<a href="/java-web-curso/ListarPlanoAluno">Área do Aluno</a>
</div>
<table>
	<thead>
		<tr>
			<th>Sigla</th>
			<th>Nome</th>
			<th>&nbsp;</th>
		<tr>
	</thead>
	<tbody>
		<c:forEach var="curso" items="${cursos}">
			<tr>
				<td>${curso.sigla}</td>
				<td>${curso.nome}</td>
				<td><a href="/java-web-curso/ListarTopicos?idCurso=${curso.id}">Ver tópicos</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>