package gestao_for.controle.web;

import gestao_for.dominio.EntidadeDominio;

public class ConsultarCommand extends AbstractCommand {

	public Object executar(EntidadeDominio entidade) {
		return fachada.consultar(entidade);
	}

}
