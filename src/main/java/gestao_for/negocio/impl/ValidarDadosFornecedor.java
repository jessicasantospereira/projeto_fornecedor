package gestao_for.negocio.impl;

import gestao_for.dominio.EntidadeDominio;
import gestao_for.dominio.Fornecedor;

public class ValidarDadosFornecedor extends AbstractValidador {

	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		if(isNull(fornecedor.getCnae().getNumero())){
			sb.append("� obrigat�rio o cadastro do CNAE \n");
		}

		if(isNull(fornecedor.getNmFantasia())){
			sb.append("� obrigat�rio o cadastro do Nome Fantasia \n");
		}
		
		if(isNull(fornecedor.getRzSocial())){
			sb.append("� obrigat�rio o cadastro da Raz�o Social \n");
		}
		if(isNull(fornecedor.getEmail())){
			sb.append("� obrigat�rio o cadastro de um e-mail \n");
		}
		if(isNull(fornecedor.getCnpj())){
			sb.append("� obrigat�rio o cadastro do CNPJ \n");
		}
		if(isNull(fornecedor.getInscricaoEstadual())){
			sb.append("� obrigat�rio o cadastro da Inscri��o Estadual \n");
		}
		if(isNull(fornecedor.getInscricaoMunicipal())){
			sb.append("� obrigat�rio o cadastro da Inscricao Municipal \n");
		}
		if(isNull(fornecedor.getTipo_for())){
			sb.append("� obrigat�rio cadastrar o Tipo de Fornecimento \n");
		}
		if(isNull(fornecedor.getTipo_for())){
			sb.append("� obrigat�rio cadastrar o Tipo de Fornecimento \n");
		}
		if(isNull(fornecedor.getTipo_for())){
			sb.append("� obrigat�rio cadastrar o Tipo de Fornecimento \n");
		}
		if(isNull(fornecedor.getTipo_for())){
			sb.append("� obrigat�rio cadastrar o Tipo de Fornecimento \n");
		}
		
		ValidarEndereco vEndereco = new ValidarEndereco();
		ValidarContato vContato = new ValidarContato();
		
		String msgValidacaoEnd = vEndereco.processar(fornecedor.getEndereco());
		String msgValidacaoCont = vContato.processar(fornecedor.getContato());
		
		if( msgValidacaoEnd != null ){
			sb.append(msgValidacaoEnd);
		}
		if( msgValidacaoCont != null ){
			sb.append(msgValidacaoCont);
		}
		return null;
	}

}
