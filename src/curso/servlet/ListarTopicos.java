package curso.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.entidade.Curso;
import curso.repositorio.CursoRepo;

@WebServlet("/ListarTopicos")
public class ListarTopicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Long idCurso = Long.valueOf( request.getParameter("idCurso"));
		
		CursoRepo repo = new CursoRepo();
		Curso curso = repo.obterCurso( idCurso);
		
		request.setAttribute( "curso", curso);
		
		RequestDispatcher view = request.getRequestDispatcher("topicos.jsp");
		view.forward(request, response);
	}
}
