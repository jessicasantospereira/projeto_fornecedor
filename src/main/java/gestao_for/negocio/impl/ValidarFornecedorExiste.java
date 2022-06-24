package gestao_for.negocio.impl;

import java.util.List;

import gestao_for.dao.IDAO;
import gestao_for.dao.impl.FornecedorDAO;
import gestao_for.dominio.EntidadeDominio;
import gestao_for.negocio.IStrategy;

public class ValidarFornecedorExiste implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		IDAO fornecedorDao = new FornecedorDAO();
		
		List<EntidadeDominio> fornecedores = fornecedorDao.consultar(entidade);
		
		
		if(fornecedores != null && fornecedores.size() > 0){
			return "Fornecedor já cadastrado!";
		}
		return null;
	}

}
