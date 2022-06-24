package gestao_for.negocio.impl;

import gestao_for.dominio.EntidadeDominio;
import gestao_for.dominio.Fornecedor;

public class ValidarDadosFornecedor extends AbstractValidador {

	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		if(isNull(fornecedor.getCnae().getNumero())){
			sb.append("É obrigatório o cadastro do CNAE \n");
		}

		if(isNull(fornecedor.getNmFantasia())){
			sb.append("É obrigatório o cadastro do Nome Fantasia \n");
		}
		
		if(isNull(fornecedor.getRzSocial())){
			sb.append("É obrigatório o cadastro da Razão Social \n");
		}
		if(isNull(fornecedor.getEmail())){
			sb.append("É obrigatório o cadastro de um e-mail \n");
		}
		if(isNull(fornecedor.getCnpj())){
			sb.append("É obrigatório o cadastro do CNPJ \n");
		}
		if(isNull(fornecedor.getInscricaoEstadual())){
			sb.append("É obrigatório o cadastro da Inscrição Estadual \n");
		}
		if(isNull(fornecedor.getInscricaoMunicipal())){
			sb.append("É obrigatório o cadastro da Inscricao Municipal \n");
		}
		if(isNull(fornecedor.getTipo_for())){
			sb.append("É obrigatório cadastrar o Tipo de Fornecimento \n");
		}
		if(isNull(fornecedor.getTipo_for())){
			sb.append("É obrigatório cadastrar o Tipo de Fornecimento \n");
		}
		if(isNull(fornecedor.getTipo_for())){
			sb.append("É obrigatório cadastrar o Tipo de Fornecimento \n");
		}
		if(isNull(fornecedor.getTipo_for())){
			sb.append("É obrigatório cadastrar o Tipo de Fornecimento \n");
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
