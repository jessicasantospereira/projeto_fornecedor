package gestao_for.negocio.impl;

import gestao_for.dominio.EntidadeDominio;
import gestao_for.dominio.Fornecedor;
import gestao_for.negocio.IStrategy;

public class ValidarCNPJ implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		if(fornecedor.getCnpj().length()!=18){
			return "O CNPJ dever ter 18 digitos!";
		}
		return null;
	}

}
