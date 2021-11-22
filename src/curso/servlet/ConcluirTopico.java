package curso.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.repositorio.AlunoRepo;

@WebServlet("/ConcluirTopico")
public class ConcluirTopico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		Long idAluno = Long.valueOf( request.getParameter( "idAluno"));
		Long idTopico = Long.valueOf( request.getParameter( "idTopico"));
		
		AlunoRepo repo = new AlunoRepo();
		repo.concluirTopico( idAluno, idTopico);
		
		response.sendRedirect("/java-web-curso/ListarPlanoAluno");
	}
}
