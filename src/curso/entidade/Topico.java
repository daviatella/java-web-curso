package curso.entidade;

import java.util.Objects;

public class Topico implements Comparable<Topico> {
	
	private Long id;
	private Integer ordem;
	private String descricao;
	
	public Topico( Long id, Integer ordem, String descricao) {
		
		this.id = id;
		this.ordem = ordem;
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getOrdem() {
		return ordem;
	}
	
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(descricao, id, ordem);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(ordem, other.ordem);
	}

	@Override
	public int compareTo(Topico outroTopico) {
		
		return this.ordem.compareTo(outroTopico.ordem);
	}
}
