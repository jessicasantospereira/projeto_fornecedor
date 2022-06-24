package gestao_for.negocio;

import gestao_for.dominio.EntidadeDominio;

public interface IStrategy {
	public String processar(EntidadeDominio entidade);
}
