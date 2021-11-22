package curso.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import curso.entidade.Topico;
import curso.entidade.Aluno;

public class AlunoRepo {

	private static final String QUERY_BASE = "select a.id,a.email,a.hash_senha,t.id,t.ordem,t.descricao \n" + 
			"from aluno a left outer join (aluno_topico at inner join topico t on at.id_topico=t.id) \n" + 
			"on at.id_aluno = a.id";

	public Aluno obterPorId( Long id) {

		Connection conn = BancoCurso.getConnection();

		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement( QUERY_BASE + " where a.id=?");
			
			ps.setLong( 1 , id);
			ResultSet rs = ps.executeQuery();
			boolean continua = rs.next();
			if( continua) {

				Aluno usuario = new Aluno( rs.getLong("a.id"), rs.getString("a.email"), rs.getString("a.hash_senha"));
				do {
					
					Long idTopico = rs.getObject( "t.id", Long.class);	
					if( idTopico != null ) {
					
						Topico topico = new Topico( idTopico, rs.getInt("t.ordem"), rs.getString("t.descricao"));
						usuario.adicionarTopico( topico);
					}
					continua = rs.next();
				} while( continua);
				
				return usuario;
				
			} else {
				
				throw new IllegalStateException( String.format( "Aluno de id=%d nao existe", id));
			}
		
		} catch (SQLException e) {

			throw new RuntimeException( e);
		}
	}

	public void concluirTopico(Long idAluno, Long idTopico) {

		final String INSERT = "insert into aluno_topico (id_topico,id_aluno) values (?,?)";
		
		Connection conn = BancoCurso.getConnection();

		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement( INSERT);
			ps.setLong( 1, idTopico);
			ps.setLong( 2, idAluno);
			if( ps.executeUpdate() != 1) {
				
				throw new IllegalStateException( 
					String.format( "Topico ja concluido. Aluno id=%d - Topico id=%d", idAluno, idTopico));
			}
		} catch (SQLException e) {

			throw new RuntimeException( e);
		}
	}

	public void desfazerConcluirTopico(Long idAluno, Long idTopico) {

		final String DELETE = "delete from aluno_topico where id_topico=? and id_aluno=?";
		
		Connection conn = BancoCurso.getConnection();

		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement( DELETE);
			ps.setLong( 1, idTopico);
			ps.setLong( 2, idAluno);
			if( ps.executeUpdate() != 1) {
				
				throw new IllegalStateException( 
					String.format( "Topico ja nao existia como concluido. "
						+ "Aluno id=%d - Topico id=%d", idAluno, idTopico));
			}
		} catch (SQLException e) {

			throw new RuntimeException( e);
		}
	}
}
