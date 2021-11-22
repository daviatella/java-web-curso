package curso.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.entidade.Curso;
import curso.entidade.Topico;
import curso.repositorio.CursoRepo;

@WebServlet("/MoverTopico")
public class MoverTopico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Long idCurso = Long.parseLong( request.getParameter("idCurso"));
		Long idTopico = Long.parseLong( request.getParameter("idTopico"));
		String direcao = request.getParameter("direcao");
		
		CursoRepo repo = new CursoRepo();
		Curso curso = repo.obterCurso( idCurso);
		
		Topico topicoAMover = curso.getTopicos().stream()
				.filter( t -> t.getId().equals( idTopico)).findFirst().orElseThrow();
		
		List<Topico> lista = new ArrayList<>( curso.getTopicos());

		ListIterator<Topico> it = lista.listIterator();
		while( !it.next().getId().equals( idTopico));
		
		Topico adjacente;
		if( "SUBIR".equals( direcao)) {
			
			adjacente = lista.get( it.previousIndex()-1); 
		} else {
			
			adjacente = lista.get( it.nextIndex());
		}
		Integer ordemAdjacente = adjacente.getOrdem(); 
		adjacente.setOrdem( topicoAMover.getOrdem());
		topicoAMover.setOrdem( ordemAdjacente);
		
		repo.salvarOrdemTopico( topicoAMover);
		repo.salvarOrdemTopico( adjacente);
		
		response.sendRedirect("/java-web-curso/ListarTopicos?idCurso=" + idCurso);
	}
}
