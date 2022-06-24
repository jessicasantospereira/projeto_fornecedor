package gestao_for.dominio;

public class Telefone {

	private String ddd;

	private String numero;

	private String ddi;
	
	private TipoTelefone tipo_tel;
	
	
	public Telefone(String ddd, String numero, String ddi, TipoTelefone tipo_tel) {
		this.ddd = ddd;
		this.numero = numero;
		this.ddi = ddi;
		this.tipo_tel = tipo_tel;
	}

	public TipoTelefone getTipo_tel() {
		return tipo_tel;
	}

	public void setTipo_tel(TipoTelefone tipo_tel) {
		this.tipo_tel = tipo_tel;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}
	

}
