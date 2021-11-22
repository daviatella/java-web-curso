<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaWebCurso - Tópicos</title>
<link rel="stylesheet" href="/java-web-curso/css/style.css">
</head>
<body>
<div>
	<img src="/java-web-curso/imgs/JavaWebCurso.png"/>
	<br/>
	<a href="/java-web-curso/ListarCursos">Área do Administrador</a>&nbsp;|&nbsp;<a href="/java-web-curso/ListarPlanoAluno">Área do Aluno</a>
</div>
<h1>Curso: ${curso.sigla} - ${curso.nome}</h1>

<table>
	<thead>
		<tr>
			<th> </th>
			<th> </th>
			<th>Descrição</th>
		<tr>
	</thead>
	<tbody>
		<c:forEach var="topico" items="${curso.topicos}">
			<tr>
				<td>
					<form action="MoverTopico" method="post">
						<input type="hidden" name="idCurso" value="${curso.id}" />
						<input type="hidden" name="idTopico" value="${topico.id}" />
						<input type="hidden" name="direcao" value="SUBIR" />
						<input type="submit" value="&uarr;" 
							<c:if test='${topico == curso.topicos.first()}'>disabled="disabled"</c:if> />
					</form>
				</td>
				<td>
					<form action="MoverTopico" method="post">
						<input type="hidden" name="idCurso" value="${curso.id}" />
						<input type="hidden" name="idTopico" value="${topico.id}" />
						<input type="hidden" name="direcao" value="DESCER" />
						<input type="submit" value="&darr;" 
							<c:if test='${topico == curso.topicos.last()}'>disabled="disabled"</c:if> />
					</form>
				</td>
				<td>${topico.descricao}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<form class="botao" action="/java-web-curso/novo-topico.jsp" method="get">
	<input type="hidden" name="idCurso" value="${curso.id}" />
	<input type="submit" value="Novo Tópico"/>
</form>

<form class="botao" action="/java-web-curso/excluir-topico.jsp" method="get">
	<input type="hidden" name="idCurso" value="${curso.id}" />
	<input type="submit" value="Excluir Tópico"/>
</form>

</body>
</html>