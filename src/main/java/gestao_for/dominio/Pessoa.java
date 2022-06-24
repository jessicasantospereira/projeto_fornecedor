package gestao_for.dominio;

public class Pessoa extends EntidadeDominio{

	private String nome;
	public Pessoa() {
		
	}
	public Pessoa(int id, String nome) {
		this.setId(id);
		this.nome = nome;
	}
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
