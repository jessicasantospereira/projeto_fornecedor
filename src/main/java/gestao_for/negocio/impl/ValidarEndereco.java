package gestao_for.negocio.impl;

import gestao_for.dominio.Endereco;
import gestao_for.dominio.EntidadeDominio;

public class ValidarEndereco extends AbstractValidador {

	public String processar(EntidadeDominio entidade) {
		Endereco endereco = (Endereco)entidade;
		
		if(isNull(endereco.getLogradouro())){
			sb.append("� obrigat�rio o cadastro do logradouro do fornecedor \n");
		}
		if(isNull(endereco.getTipo_log().getDescricao())){
			sb.append("� obrigat�rio o cadastro do tipo do logradouro do fornecedor \n");
		}
		if(isNull(endereco.getCep())){
			sb.append("� obrigat�rio o cadastro do cep do fornecedor \n");
		}
		if(isNull(endereco.getBairro())){
			sb.append("� obrigat�rio o cadastro do bairro do fornecedor \n");
		}
		if(isNull(endereco.getNumero())){
			sb.append("� obrigat�rio o cadastro do numero do fornecedor \n");
		}
		if(isNull(endereco.getCidade().getNome())){
			sb.append("� obrigat�rio o cadastro da cidade do fornecedor \n");
		}
		
		if(isNull(endereco.getCidade().getEstado().getNome())){
			sb.append("� obrigat�rio o cadastro do estado do fornecedor \n");
		}
		if(isNull(endereco.getCidade().getEstado().getPais().getNome())){
			sb.append("� obrigat�rio o cadastro do Pa�s do fornecedor \n");
		}
		if(sb.length() != 0){
			return sb.toString();
		}
		return null;
	}

}
