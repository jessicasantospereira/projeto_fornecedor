package gestao_for.controle;

import java.util.List;

import gestao_for.dominio.EntidadeDominio;
import gestao_for.dominio.Fornecedor;

public interface IFachada {
	public String salvar(EntidadeDominio entidade);
	public String alterar(EntidadeDominio entidade);
	public String excluir(EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
	public List<Fornecedor> consultar();
	public EntidadeDominio buscar(EntidadeDominio entidade);
}
