<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaWebCurso - Plano de Aula</title>
<link rel="stylesheet" href="/java-web-curso/css/styles.css">
</head>
<body>
<div>
	<img src="/java-web-curso/imgs/JavaWebCurso.png"/>
	<br/>
	<a href="/java-web-curso/ListarCursos">Área do Administrador</a>&nbsp;|&nbsp;<a href="/java-web-curso/ListarPlanoAluno">Área do Aluno</a>
</div>
<h1>Aluno: ${aluno.email}</h1>

<table>
	<thead>
		<tr>
			<th>Curso </th>
			<th>&nbsp;</th>
			<th>Tópico </th>
			<th>&nbsp;</th>
		<tr>
	</thead>
	<tbody>
		<c:forEach var="curso" items="${cursos}">
			<c:forEach var="topico" items="${curso.topicos}">
				<tr>
					<td>${curso.nome}</td>
					<td>
						<c:choose>
							<c:when test="${aluno.concluidos.contains(topico)}">
								<img src="/java-web-curso/imgs/ok.png"/>
							</c:when>
							<c:otherwise><img src="/java-web-curso/imgs/waiting.png"/></c:otherwise>
						</c:choose>
					</td>
					<td>${topico.descricao}</td>
					<td>
						<c:choose>
							<c:when test="${aluno.concluidos.contains(topico)}">
								<form action="/java-web-curso/DesfazerConcluirTopico" method="post">
									<input type="hidden" name="idAluno" value="${aluno.id}"/>
									<input type="hidden" name="idTopico" value="${topico.id}"/>
									<input type="submit" value="Desfazer"/>
								</form>							
							</c:when>
							<c:otherwise>
								<form action="/java-web-curso/ConcluirTopico" method="post">
									<input type="hidden" name="idAluno" value="${aluno.id}"/>
									<input type="hidden" name="idTopico" value="${topico.id}"/>
									<input type="submit" value="Concluir"/>
								</form>							
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</tbody>
</table>

</body>
</html>