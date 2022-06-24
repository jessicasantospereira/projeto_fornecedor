package gestao_for.dominio;

public class Contato extends Pessoa {

	private String email;
		
	private Ramal ramal;
	
	private Departamento depto;
	
	private Usuario usuario;

	public Contato() {
		
	}
	
	public Contato(String nome, String email, Ramal ramal, Departamento depto, Usuario usuario) {
		super(nome);
		this.email = email;
		this.ramal = ramal;
		this.depto = depto;
		this.usuario = usuario;
	}

	public Contato(int id, String nome, String email, Ramal ramal, Departamento depto, Usuario usuario) {
		super(id, nome);
		this.email = email;
		this.ramal = ramal;
		this.depto = depto;
		this.usuario = usuario;
	
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Departamento getDepto() {
		return depto;
	}

	public void setDepto(Departamento depto) {
		this.depto = depto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ramal getRamal() {
		return ramal;
	}

	public void setRamal(Ramal ramal) {
		this.ramal = ramal;
	}
	
	
}
