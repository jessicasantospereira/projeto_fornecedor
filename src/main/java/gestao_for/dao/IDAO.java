package gestao_for.dao;

import java.util.List;

import gestao_for.dominio.EntidadeDominio;
import gestao_for.dominio.Fornecedor;

public interface IDAO {
	public void salvar(EntidadeDominio entidade);
	public void alterar(EntidadeDominio entidade);
	public void excluir(EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
	public List<Fornecedor> consultar();
	public EntidadeDominio buscar(EntidadeDominio entidade);
}
