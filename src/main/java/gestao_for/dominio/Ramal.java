package gestao_for.dominio;

public class Ramal extends Telefone {

	private String codigo;

	private String descricao;

	public Ramal(String ddd, String numero, String ddi, TipoTelefone tipo_tel, String codigo) {
		super(ddd, numero, ddi, tipo_tel);
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
