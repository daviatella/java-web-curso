package curso.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.entidade.Curso;
import curso.entidade.Topico;
import curso.repositorio.CursoRepo;

@WebServlet("/ExcluirTopico")
public class ExcluirTopico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		Long idCurso = Long.valueOf( request.getParameter("idCurso"));
		String descricao = request.getParameter("descricao");
		
		CursoRepo repo = new CursoRepo();
		Curso curso = repo.obterCurso(idCurso);
		Topico del = curso.getTopicos().stream().filter(t -> t.getDescricao().equals(descricao)).findFirst().orElseThrow();
		repo.excluirTopico(curso, del);
		
		response.sendRedirect("/java-web-curso/ListarTopicos?idCurso=" + idCurso);
	}
}
