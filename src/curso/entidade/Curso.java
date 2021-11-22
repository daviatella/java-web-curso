package curso.entidade;

import java.util.Collections;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Curso {
	
	private Long id;
	private String sigla;
	private String nome;
	
	private SortedSet<Topico> topicos = new TreeSet<>();
	
	public Curso(Long id, String sigla, String nome) {

		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
	}
	
	public boolean adicionarTopico( Topico topico) {
		
		return topicos.add( topico);
	}
	
	public SortedSet<Topico> getTopicos() {
		
		return Collections.unmodifiableSortedSet( topicos);
	}

	public Long getId() {
		
		return id;
	}
	
	public void setId(Long id) {
		
		this.id = id;
	}
	
	public String getSigla() {
		
		return sigla;
	}
	
	public void setSigla(String sigla) {
		
		this.sigla = sigla;
	}
	
	public String getNome() {
		
		return nome;
	}
	
	public void setNome(String nome) {
		
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, sigla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id) && 
				Objects.equals(nome, other.nome) && Objects.equals(sigla, other.sigla);
	}
}