package curso.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.entidade.Curso;
import curso.entidade.Aluno;
import curso.repositorio.CursoRepo;
import curso.repositorio.AlunoRepo;

@WebServlet("/ListarPlanoAluno")
public class ListarPlanoAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CursoRepo cursoRepo = new CursoRepo();
		List<Curso> cursos = cursoRepo.obterCursos();
		
		AlunoRepo usuarioRepo = new AlunoRepo();
		Aluno aluno = usuarioRepo.obterPorId( 1L);
		
		request.setAttribute( "cursos", cursos);
		request.setAttribute( "aluno", aluno);
		
		RequestDispatcher view = request.getRequestDispatcher("plano-aluno.jsp");
		view.forward(request, response);
	}
}
