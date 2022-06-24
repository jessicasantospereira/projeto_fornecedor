package gestao_for.controle.web;

import gestao_for.dominio.EntidadeDominio;

public interface ICommand {

	public Object executar(EntidadeDominio entidade); 
	
}
