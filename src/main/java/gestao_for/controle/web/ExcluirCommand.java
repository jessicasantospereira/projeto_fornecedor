package gestao_for.controle.web;

import gestao_for.dominio.EntidadeDominio;

public class ExcluirCommand extends AbstractCommand {

	public Object executar(EntidadeDominio entidade) {
		return fachada.excluir(entidade);
	}

}
