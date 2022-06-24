package gestao_for.controle.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gestao_for.controle.IFachada;
import gestao_for.dao.IDAO;
import gestao_for.dao.impl.ContatoDAO;
import gestao_for.dao.impl.EnderecoDAO;
import gestao_for.dao.impl.FornecedorDAO;
import gestao_for.dominio.Contato;
import gestao_for.dominio.Endereco;
import gestao_for.dominio.EntidadeDominio;
import gestao_for.dominio.Fornecedor;
import gestao_for.negocio.IStrategy;
import gestao_for.negocio.impl.ValidarCNPJ;
import gestao_for.negocio.impl.ValidarCnae;
import gestao_for.negocio.impl.ValidarDadosFornecedor;
import gestao_for.negocio.impl.ValidarFornecedorExiste;

public class Fachada implements IFachada {
	/* Mapa de daos indexado pelo nome da classe 
	 * e tem como valor um DAO */	
	private Map<String, IDAO> daos = new HashMap<String, IDAO>();
	
	/* Mapa de regras de negocio indexado pelo nome da classe 
	 * e tem como valor uma lista de strategies */	
	private Map<String, List<IStrategy>> rns = new HashMap<String, List<IStrategy>>();
	
	public Fachada() {
		String nmFornecedor = Fornecedor.class.getName();
		String endereco = Endereco.class.getName();
		String contato = Contato.class.getName();
		
		daos.put(nmFornecedor, new FornecedorDAO());
		daos.put(endereco, new EnderecoDAO());
		daos.put(contato, new ContatoDAO());
		
		ValidarDadosFornecedor vFornecedor = new ValidarDadosFornecedor();
		ValidarCNPJ vCnpj = new ValidarCNPJ();
		ValidarCnae vCnae = new ValidarCnae();
		ValidarFornecedorExiste vExistencia = new ValidarFornecedorExiste();
		
		ArrayList<IStrategy> rnsFornecedor = new ArrayList<IStrategy>();
		rnsFornecedor.add(vFornecedor);
		rnsFornecedor.add(vCnpj);
		rnsFornecedor.add(vCnae);
		rnsFornecedor.add(vExistencia);
	
		
		rns.put(nmFornecedor, rnsFornecedor);
		
		
	}
	@Override
	public String salvar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		String nmEntidade = entidade.getClass().getName();
		List<IStrategy> regras = rns.get(nmEntidade);
		
		for(IStrategy s: regras){
			String msg = s.processar(entidade);
			if(msg != null){
				sb.append(msg);
				sb.append("\n");
			}
		}
		
		if(sb.length() == 0){
			IDAO dao = daos.get(nmEntidade);
			dao.salvar(entidade);
		}else{
			return sb.toString();
		}
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		String nmEntidade = entidade.getClass().getName();
		List<IStrategy> regras = rns.get(nmEntidade);
		for(IStrategy s: regras){
			String msg = s.processar(entidade);
			if(msg != null){
				sb.append(msg);
				sb.append("\n");
			}
		}
		
		if(sb.length() == 0){
			System.out.println("aqui");
			IDAO dao = daos.get(nmEntidade);
			dao.alterar(entidade);
		}else{
			return sb.toString();
		}

		return null;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		String nmEntidade = entidade.getClass().getName();
		IDAO dao = daos.get(nmEntidade);

		dao.excluir(entidade);
		return null;
	}
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Fornecedor> consultar() {

		IDAO dao = daos.get(Fornecedor.class.getName());
		List<Fornecedor> fornecedor = dao.consultar();

		return fornecedor;
	}
	@Override
	public EntidadeDominio buscar(EntidadeDominio entidade) {
		String nmEntidade = entidade.getClass().getName();
		IDAO dao = daos.get(nmEntidade);

		dao.buscar(entidade);

		
		return null;
	}

}
