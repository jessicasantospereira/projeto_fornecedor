package gestao_for.controle.web;

import gestao_for.dominio.EntidadeDominio;

public class SalvarCommand extends AbstractCommand {
	
	public Object executar(EntidadeDominio entidade) {
		return fachada.salvar(entidade);
	}

}
