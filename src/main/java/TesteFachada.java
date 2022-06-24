import gestao_for.controle.IFachada;
import gestao_for.controle.impl.Fachada;
import gestao_for.dominio.CNAE;
import gestao_for.dominio.Cidade;
import gestao_for.dominio.Contato;
import gestao_for.dominio.Departamento;
import gestao_for.dominio.Endereco;
import gestao_for.dominio.Estado;
import gestao_for.dominio.Fornecedor;
import gestao_for.dominio.Pais;
import gestao_for.dominio.Ramal;
import gestao_for.dominio.Status;
import gestao_for.dominio.TipoEmpresa;
import gestao_for.dominio.TipoEndereco;
import gestao_for.dominio.TipoFornecimento;
import gestao_for.dominio.TipoLogradouro;
import gestao_for.dominio.TipoTelefone;
import gestao_for.dominio.Usuario;

public class TesteFachada {

	public static void main(String[] args) {
		Pais pais = new Pais("Brasil");
		Estado estado = new Estado("São Paulo", pais);
		Cidade cidade = new Cidade("Suzano", estado);
		
		TipoEndereco tipoEnd = new TipoEndereco("Galpão");
		TipoLogradouro tipoLog = new TipoLogradouro("Rua");
		Endereco end = new Endereco(tipoLog, "Gato das Bananas", "759", "Vila das frutas", "bloco 5", "08615000", cidade, tipoEnd);
		
		TipoTelefone tipoTel = new TipoTelefone("Comercial");
		Ramal telefone = new Ramal("11","2222-3333","-",tipoTel,"255");
		Departamento depto = new Departamento("Administrativo");
		Usuario usuario = new Usuario("usuario2", "123456");
		Contato contato = new Contato("Usuario 2","usuario2@gmail.com",telefone,depto,usuario);
		
		CNAE cnae = new CNAE("7020400");
		TipoFornecimento tipoFor = new TipoFornecimento("Venda");
		Status status = new Status("Rascunho");
		TipoEmpresa tipoEmp = new TipoEmpresa("Matriz");
		
		Fornecedor fornecedor = new Fornecedor(true, cnae, contato.getEmail(), "12.345.678/9012-36", "123654", "98745", "Hortifrutti Ltda.", 
				"Fazendinha",tipoFor, end, status, tipoEmp, contato);
		
		IFachada fachada = new Fachada();
		String msg = fachada.salvar(fornecedor);
		
		if(msg != null) {
			System.out.println(msg);
		}
			
	}

}
