package gestao_for.negocio.impl;

import gestao_for.dominio.Contato;
import gestao_for.dominio.EntidadeDominio;

public class ValidarContato extends AbstractValidador {

	public String processar(EntidadeDominio entidade) {
		
		Contato contato = (Contato)entidade;

		if(isNull(contato.getNome())){
			sb.append("É obrigatório o cadastro de um nome para o contato \n");
		}
		if(isNull(contato.getEmail())){
			sb.append("É obrigatório o cadastro de um e-mail para o contato \n");
		}
		
		if(isNull(contato.getRamal().getTipo_tel())){
			sb.append("É obrigatório escolher um tipo para o telefone \n");
		}
		if(isNull(contato.getRamal().getNumero())){
			sb.append("É obrigatório o cadastro de um numero para o telefone \n");
		}
		if(isNull(contato.getDepto().getDescricao())){
			sb.append("É obrigatório o cadastro de um numero para o telefone \n");
		}
		if(isNull(contato.getUsuario().getLogin())){
			sb.append("É obrigatório o cadastro de um login para o contato \n");
		}
		if(isNull(contato.getUsuario().getSenha())){
			sb.append("É obrigatório o cadastro de uma senha para o contato \n");
		}
		return null;
	}

}
