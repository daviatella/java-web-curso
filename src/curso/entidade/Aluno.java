package curso.entidade;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Aluno {

	private Long id;
	private String email;
	private String hashSenha;
	private Set<Topico> concluidos = new HashSet<>();
	
	public Aluno( Long id, String email, String hashSenha) {

		this.id = id;
		this.email = email;
		this.hashSenha = hashSenha;
	}
	
	public void adicionarTopico( Topico topico) {
		
		this.concluidos.add( topico);
	}
	
	public Set<Topico> getConcluidos() {
		
		return Collections.unmodifiableSet( concluidos);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHashSenha() {
		return hashSenha;
	}
	
	public void setHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, hashSenha, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(email, other.email) && Objects.equals(hashSenha, other.hashSenha)
				&& Objects.equals(id, other.id);
	}
}