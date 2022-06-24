package gestao_for.controle.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gestao_for.controle.IFachada;
import gestao_for.controle.impl.Fachada;
import gestao_for.dominio.EntidadeDominio;
import gestao_for.dominio.Fornecedor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controle
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/SalvarFornecedor", "/AlterarFornecedor", "/ExcluirFornecedor", 
		"/EditarFornecedor"})
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, IViewHelper> vhs = new HashMap<String, IViewHelper>();
	private Map<String, ICommand> cmds = new HashMap<String, ICommand>();   
  
    public Controle() {

    	vhs.put("/ProjetoFornecedor/SalvarFornecedor", new FornecedorVH());  
    	vhs.put("/ProjetoFornecedor/AlterarFornecedor", new FornecedorVH());  
    	vhs.put("/ProjetoFornecedor/ExcluirFornecedor", new FornecedorVH()); 
    	vhs.put("/ProjetoFornecedor/EditarFornecedor", new FornecedorVH());    
    	
    	cmds.put("Salvar", new SalvarCommand());
    	cmds.put("Alterar", new AlterarCommand());
    	cmds.put("Consultar", new ConsultarCommand());
    	cmds.put("Editar", new BuscarCommand());
    	cmds.put("Excluir", new ExcluirCommand());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String action = request.getServletPath();
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String operacao = request.getParameter("operacao");
		System.out.println(operacao);
		ICommand cmd;
		IViewHelper vh = null;
//		EntidadeDominio entidade = null;
		if(operacao == null) {
			IFachada fachada = new Fachada();
			List<Fornecedor> fornecedor = fachada.consultar();
			// encaminhar lista a fornecedores.jsp
			request.setAttribute("fornecedor", fornecedor);
			RequestDispatcher rd = request.getRequestDispatcher("fornecedor.jsp");
			rd.forward(request, response);
			
		}else {
			vh = vhs.get(uri);	
			cmd = cmds.get(operacao);
			
			EntidadeDominio entidade = vh.getEntidade(request);
			if(operacao.equals("Editar")) {
				cmd.executar(entidade);
				vh.editarEntidade(response, request, entidade);

			}else {
				Object msg = cmd.executar(entidade);
				vh.setEntidade(response, request, msg);
			}
			
		}
		
		
		
		
	}

}
