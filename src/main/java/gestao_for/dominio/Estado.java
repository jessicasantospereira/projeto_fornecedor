package gestao_for.dominio;

public class Estado {

	private String descricao;

	private String nome;
	
	private Pais pais;

	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
