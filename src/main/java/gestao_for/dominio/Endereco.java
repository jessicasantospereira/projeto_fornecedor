package gestao_for.dominio;

public class Endereco extends EntidadeDominio{

	private String cep;

	private String logradouro;

	private String numero;

	private String bairro;

	private String complemento;
	
	private Cidade cidade;
	
	private TipoEndereco tipo;
	
	private TipoLogradouro tipo_log;
	
	public Endereco() {
		
	}
	public Endereco(TipoLogradouro tipo_log, String logradouro, String numero, String bairro, String complemento,String cep, 
			Cidade cidade, TipoEndereco tipo) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.tipo = tipo;
		this.tipo_log = tipo_log;
	}
	public Endereco(int id, TipoLogradouro tipo_log, String logradouro, String numero, String bairro, String complemento,String cep, 
			Cidade cidade, TipoEndereco tipo) {
		this.setId(id);
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.tipo = tipo;
		this.tipo_log = tipo_log;
	}
	
	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}

	public TipoLogradouro getTipo_log() {
		return tipo_log;
	}

	public void setTipo_log(TipoLogradouro tipo_log) {
		this.tipo_log = tipo_log;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	

}
