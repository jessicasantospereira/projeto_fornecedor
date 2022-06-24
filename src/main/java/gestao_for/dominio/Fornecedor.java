package gestao_for.dominio;

import java.util.List;

public class Fornecedor extends EntidadeDominio{

	private boolean isRascunho;
	private CNAE cnae;
	
	private String email;

	private String cnpj;

	private String inscricaoEstadual;

	private String inscricaoMunicipal;

	private String rzSocial;

	private String nmFantasia;
	
	private TipoFornecimento tipo_for;
	
	private Endereco endereco;
	
	private Status status;
	
	private TipoEmpresa tipo_empresa;
	
	private Contato contato;
	public Fornecedor() {
		
	}
	public Fornecedor(boolean isRascunho, CNAE cnae, String email, String cnpj, String inscricaoEstadual,
			String inscricaoMunicipal, String rzSocial, String nmFantasia, TipoFornecimento tipo_for, Endereco endereco,
			Status status, TipoEmpresa tipo_empresa, Contato contato) {
		this.isRascunho = isRascunho;
		this.cnae = cnae;
		this.email = email;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.rzSocial = rzSocial;
		this.nmFantasia = nmFantasia;
		this.tipo_for = tipo_for;
		this.endereco = endereco;
		this.status = status;
		this.tipo_empresa = tipo_empresa;
		this.contato = contato;
	}

	public Fornecedor(int id, boolean isRascunho, CNAE cnae, String email, String cnpj, String inscricaoEstadual,
			String inscricaoMunicipal, String rzSocial, String nmFantasia, TipoFornecimento tipo_for, Endereco endereco,
			Status status, TipoEmpresa tipo_empresa, Contato contato) {
		this.setId(id);
		this.isRascunho = isRascunho;
		this.cnae = cnae;
		this.email = email;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.rzSocial = rzSocial;
		this.nmFantasia = nmFantasia;
		this.tipo_for = tipo_for;
		this.endereco = endereco;
		this.status = status;
		this.tipo_empresa = tipo_empresa;
		this.contato = contato;
	}

	public CNAE getCnae() {
		return cnae;
	}

	public void setCnae(CNAE cnae) {
		this.cnae = cnae;
	}

	public TipoEmpresa getTipo_empresa() {
		return tipo_empresa;
	}

	public void setTipo_empresa(TipoEmpresa tipo_empresa) {
		this.tipo_empresa = tipo_empresa;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipoFornecimento getTipo_for() {
		return tipo_for;
	}

	public void setTipo_for(TipoFornecimento tipo_for) {
		this.tipo_for = tipo_for;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	//m�todos de acesso 
	public boolean isRascunho() {
		return isRascunho;
	}

	public void setRascunho(boolean isRascunho) {
		this.isRascunho = isRascunho;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getRzSocial() {
		return rzSocial;
	}

	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial;
	}

	public String getNmFantasia() {
		return nmFantasia;
	}

	public void setNmFantasia(String nmFantasia) {
		this.nmFantasia = nmFantasia;
	}

	//metodos
	public void salvar() {

	}

	public void alterar() {

	}

	public Fornecedor[] consultar() {
		return null;
	}

	public void excluir() {

	}

	public void inativar() {

	}

	public void ativar() {

	}

	public void addContato(Contato contato) {

	}

	public void validarCNPJ() {

	}

	/**
	 * Implementação da RN-1005:
	 * 
	 * Registro de fornecimento
	 * 
	 * Apenas é possível concluir o cadastro do fornecedor caso a lista de fornecimentos (produto e/ou serviço) oferecidos esteja preenchida com, no mínimo, um item.
	 */
	public void validarListaFornecimento() {

	}

}
