package gestao_for.controle.web;

import java.io.IOException;
import java.io.PrintWriter;

import gestao_for.dominio.CNAE;
import gestao_for.dominio.Cidade;
import gestao_for.dominio.Contato;
import gestao_for.dominio.Departamento;
import gestao_for.dominio.Endereco;
import gestao_for.dominio.EntidadeDominio;
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
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FornecedorVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String id_for = request.getParameter("id_for");
		String status = request.getParameter("status");
		String razao_social = request.getParameter("razao_social");
		String nome_fantasia = request.getParameter("nome_fantasia");
		String tipo_empresa = request.getParameter("tipo_empresa");
		String tipo_forn = request.getParameter("tipo_fornecimento");
		String cnpj_emp = request.getParameter("cnpj");
		String cnae_emp = request.getParameter("cnae");
		String imunicipal = request.getParameter("imunicipal");
		String iestadual = request.getParameter("iestadual");
		
		String id_end = request.getParameter("id_end");
		int idend;
		if(id_end == null) {
			idend = 0;
		}else {
			idend = Integer.parseInt(id_end);
		}
		String tipo_end_emp = request.getParameter("tipo_endereco");
		String tipo_log_emp = request.getParameter("tipo_logradouro");
		String logradouro_emp = request.getParameter("logradouro_empresa");
		String numero_emp = request.getParameter("numero_empresa");
		String bairro_emp = request.getParameter("bairro_empresa");
		String complemento_emp = request.getParameter("complemento_empresa");
		String cep_emp = request.getParameter("cep_empresa");
		String cidade_emp = request.getParameter("cidade_empresa");
		String estado_emp = request.getParameter("estado_empresa");
		String pais_emp = request.getParameter("pais_empresa");
		
		String id_con = request.getParameter("id_con");
		int idcon;
		if(id_con == null) {
			idcon = 0;
		}else {
			idcon = Integer.parseInt(id_con);
		}

		String nome = request.getParameter("nome_contato");
		String email = request.getParameter("email");
		String depto = request.getParameter("departamento");
		String ddd = request.getParameter("ddd");
		String ddi = request.getParameter("ddi");
		String tipo_tel = request.getParameter("tipo_tel");
		String telefone = request.getParameter("telefone");
		String ramal = request.getParameter("ramal");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		//instanciando os objetos
		Pais pais = new Pais(pais_emp);
		Estado estado = new Estado(estado_emp, pais);
		Cidade cidade = new Cidade(cidade_emp, estado);
		TipoEndereco tipoEnd = new TipoEndereco(tipo_end_emp);
		TipoLogradouro tipoLog = new TipoLogradouro(tipo_log_emp);
		
		
		TipoTelefone tipoTel = new TipoTelefone(tipo_tel);
		Ramal tel_contato = new Ramal(ddd,telefone,ddi,tipoTel,ramal);
		Departamento deptoUsuario = new Departamento(depto);
		Usuario usuarioEmp = new Usuario(usuario, senha);
		
		
		boolean rascunho = false;
		if(status != null && status != "") {
			if(status.equals("rascunho")) {
				rascunho = true;
			}
		}
		CNAE cnae = new CNAE(cnae_emp);
		TipoFornecimento tipoFor = new TipoFornecimento(tipo_forn);
		TipoEmpresa tipoEmp = new TipoEmpresa(tipo_empresa);
		Status statusEmp = new Status(status);
		Fornecedor fornecedor;
//		System.out.println(id_for.isEmpty());
		if(id_for != null && id_for != "") {
			Endereco end = new Endereco(idend,tipoLog, logradouro_emp, numero_emp,bairro_emp,complemento_emp, cep_emp, cidade, tipoEnd);
			Contato contato = new Contato(idcon,nome, email,tel_contato, deptoUsuario,usuarioEmp);
			fornecedor = new Fornecedor(Integer.parseInt(id_for), rascunho,cnae,contato.getEmail(), cnpj_emp, iestadual, 
					imunicipal,razao_social, nome_fantasia,tipoFor,end,statusEmp,tipoEmp, contato);
		}else {
			Endereco end = new Endereco(tipoLog, logradouro_emp, numero_emp,bairro_emp,complemento_emp, cep_emp, cidade, tipoEnd);
			Contato contato = new Contato(nome, email,tel_contato, deptoUsuario,usuarioEmp);
			fornecedor = new Fornecedor(rascunho,cnae,contato.getEmail(), cnpj_emp, iestadual, 
					imunicipal,razao_social, nome_fantasia,tipoFor,end,statusEmp,tipoEmp, contato);
		}

		
		return fornecedor;
	}
	@Override
	public void setEntidade(HttpServletResponse response, HttpServletRequest request, Object msg) {
		PrintWriter out;
		
		try {
			out = response.getWriter();
			
				if(msg != null){
					out.print(msg);
				}else{
					response.sendRedirect("main");

				}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public EntidadeDominio editarEntidade(HttpServletResponse response, HttpServletRequest request, EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
		try {
			request.setAttribute("id_for", fornecedor.getId());
			request.setAttribute("razao_social", fornecedor.getRzSocial());
			request.setAttribute("nome_fantasia", fornecedor.getNmFantasia());
			request.setAttribute("cnpj", fornecedor.getCnpj());
			request.setAttribute("cnae", fornecedor.getCnae().getNumero());
			request.setAttribute("imunicipal", fornecedor.getInscricaoMunicipal());
			request.setAttribute("iestadual", fornecedor.getInscricaoEstadual());
			request.setAttribute("id_end", fornecedor.getEndereco().getId());
			request.setAttribute("tipo_endereco", fornecedor.getEndereco().getTipo().getNome());
			request.setAttribute("tipo_logradouro", fornecedor.getEndereco().getTipo_log().getDescricao());
			request.setAttribute("logradouro_empresa", fornecedor.getEndereco().getLogradouro());
			request.setAttribute("bairro_empresa", fornecedor.getEndereco().getBairro());
			request.setAttribute("numero_empresa", fornecedor.getEndereco().getNumero());
			request.setAttribute("complemento_empresa", fornecedor.getEndereco().getComplemento());
			request.setAttribute("cep_empresa", fornecedor.getEndereco().getCep());
			request.setAttribute("cidade_empresa", fornecedor.getEndereco().getCidade().getNome());
			request.setAttribute("estado_empresa", fornecedor.getEndereco().getCidade().getEstado().getNome());
			request.setAttribute("pais_empresa", fornecedor.getEndereco().getCidade().getEstado().getPais().getNome());
			request.setAttribute("id_con", fornecedor.getContato().getId());
			request.setAttribute("nome_contato", fornecedor.getContato().getNome());
			request.setAttribute("email", fornecedor.getContato().getEmail());
			request.setAttribute("departamento", fornecedor.getContato().getDepto().getDescricao());
			request.setAttribute("tipo_tel", fornecedor.getContato().getRamal().getTipo_tel().getDescricao());
			request.setAttribute("ddd", fornecedor.getContato().getRamal().getDdd());
			request.setAttribute("ddi", fornecedor.getContato().getRamal().getDdi());
			request.setAttribute("telefone", fornecedor.getContato().getRamal().getNumero());
			request.setAttribute("ramal", fornecedor.getContato().getRamal().getCodigo());
			request.setAttribute("usuario", fornecedor.getContato().getUsuario().getLogin());
			request.setAttribute("senha", fornecedor.getContato().getUsuario().getSenha());
			// enviar ao editar.jsp
			RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	
		
	}

}
