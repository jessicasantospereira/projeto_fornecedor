package gestao_for.controle.web;

import gestao_for.dominio.EntidadeDominio;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract interface IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request);
	public void setEntidade(HttpServletResponse response, HttpServletRequest request,
			Object msg);
	public EntidadeDominio editarEntidade(HttpServletResponse response, HttpServletRequest request, EntidadeDominio entidade);

	
}
