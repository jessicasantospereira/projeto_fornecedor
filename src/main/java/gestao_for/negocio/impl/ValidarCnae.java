package gestao_for.negocio.impl;

import gestao_for.dominio.EntidadeDominio;
import gestao_for.dominio.Fornecedor;
import gestao_for.negocio.IStrategy;

public class ValidarCnae implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		if(fornecedor.getCnae().getNumero().length()!=7){
			return "O CNAE dever ter 7 digitos!";
		}
		return null;
	}

}
