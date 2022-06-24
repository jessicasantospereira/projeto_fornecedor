package gestao_for.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gestao_for.dao.IDAO;
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

public class FornecedorDAO implements IDAO {
	// Parametros de conexão
//	private String driver = "com.mysql.cj.jdbc.Driver";
//	private String url = "jdbc:mysql://127.0.0.1:3306/cad_fornecedor?useTimezone=true&serverTimezone=UTC";
//	private String user = "root";
//	private String password = "123456";
	private Connection connection = null;

	@Override
	public void salvar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Fornecedor fornecedor = (Fornecedor)entidade;
		
		try {
			connection = Conexao.conectar();

			connection.setAutoCommit(false);
			
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_fornecedor(cnpj, nome_fantasia,razao_social,iestadual,imunicipal,cnae, tipo_fornecimento,");
			sql.append("status, tipo_empresa) VALUES (?,?,?,?,?,?,?,?,?)");
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, fornecedor.getCnpj());
			pst.setString(2, fornecedor.getNmFantasia());
			pst.setString(3, fornecedor.getRzSocial());
			pst.setString(4, fornecedor.getInscricaoEstadual());
			pst.setString(5, fornecedor.getInscricaoMunicipal());
			pst.setString(6, fornecedor.getCnae().getNumero());
			pst.setString(7, fornecedor.getTipo_for().getDescricao());
			pst.setString(8, fornecedor.getStatus().getDescricao());
			pst.setString(9, fornecedor.getTipo_empresa().getDescricao());


			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			int idFor = 0;
			if (rs.next())
				idFor = rs.getInt(1);
			fornecedor.setId(idFor);
			
			EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
			enderecoDAO.salvar(fornecedor.getEndereco(), fornecedor.getId());
			
			ContatoDAO contatoDAO = new ContatoDAO(connection);
			contatoDAO.salvar(fornecedor.getContato(), fornecedor.getId());
			
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		PreparedStatement pst = null;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_fornecedor SET cnpj=?, nome_fantasia=?, razao_social=?, iestadual=?, imunicipal=?, cnae=?, tipo_fornecimento=?, ");
		sql.append("status=?, tipo_empresa=? WHERE id_for=?;");
		try {
			connection = Conexao.conectar();
			pst = connection.prepareStatement(sql.toString());
			
			pst.setString(1, fornecedor.getCnpj());
			pst.setString(2, fornecedor.getNmFantasia());
			pst.setString(3, fornecedor.getRzSocial());
			pst.setString(4, fornecedor.getInscricaoEstadual());
			pst.setString(5, fornecedor.getInscricaoMunicipal());
			pst.setString(6, fornecedor.getCnae().getNumero());
			pst.setString(7, fornecedor.getTipo_for().getDescricao());
			pst.setString(8, fornecedor.getStatus().getDescricao());
			pst.setString(9, fornecedor.getTipo_empresa().getDescricao());
			pst.setInt(10, fornecedor.getId());


			pst.executeUpdate();

			EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
			enderecoDAO.alterar(fornecedor.getEndereco());
			
			ContatoDAO contatoDAO = new ContatoDAO(connection);
			contatoDAO.alterar(fornecedor.getContato());

			connection.commit();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		PreparedStatement pst = null;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE from tb_fornecedor where id_for = ?;");

		try {
			connection = Conexao.conectar();
			pst = connection.prepareStatement(sql.toString()); 
			pst.setInt(1, fornecedor.getId());	
			pst.executeUpdate();
			
			EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
			enderecoDAO.excluir(fornecedor);
			
			ContatoDAO contatoDAO = new ContatoDAO(connection);
			contatoDAO.excluir(fornecedor);

			connection.commit();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> consultar() {
		List<Fornecedor> fornecedor = new ArrayList<>();

		PreparedStatement pst = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT f.*, c.*, e.* from tb_fornecedor as f, tb_enderecos as e, tb_contatos c ");
		sql.append("WHERE f.id_for = c.for_id and c.for_id = e.for_id and f.id_for=e.for_id;");
	
		try {
			connection = Conexao.conectar();
			pst = connection.prepareStatement(sql.toString()); 
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				//variaveis de apoio
				String idfor = rs.getString(1);
				String cnpj = rs.getString(2);
				String nome_fantasia = rs.getString(3);
				String razao_social = rs.getString(4);
				String iestadual = rs.getString(5);
				String imunicipal = rs.getString(6);
				String cnae_bd = rs.getString(7);
				String tipo_for = rs.getString(8);
				String status = rs.getString(9);
				String tipo_emp = rs.getString(10);
				String idcon = rs.getString(11);
				String nome = rs.getString(12);
				String dddcon = rs.getString(13);
				String ddicon = rs.getString(14);
				String telcon = rs.getString(15);
				String tipo_telecon = rs.getString(16);
				String ramalcon = rs.getString(17);
				String email = rs.getString(18);
				String deptocon = rs.getString(19);
				String usuario = rs.getString(20);
				String senha = rs.getString(21); //22 é o FORID tabela de contatos
				String id_end = rs.getString(23);
				String tipo_end = rs.getString(24);
				String tipo_log = rs.getString(25);
				String log = rs.getString(26);
				String numero = rs.getString(27);
				String complemento = rs.getString(28);
				String bairro = rs.getString(29);
				String cep = rs.getString(30);
				String cidadebd = rs.getString(31);
				String estadobd = rs.getString(32);
				String paisbd = rs.getString(33);//34 é o FORID tabela de enderecos
				Pais pais = new Pais(paisbd);
				Estado estado = new Estado(estadobd, pais);
				Cidade cidade = new Cidade(cidadebd, estado);
				TipoEndereco tipoEnd = new TipoEndereco(tipo_end);
				TipoLogradouro tipoLog = new TipoLogradouro(tipo_log);
				Endereco end = new Endereco(tipoLog, log, numero,bairro,complemento, cep, cidade, tipoEnd);
				
				TipoTelefone tipoTel = new TipoTelefone(tipo_telecon);
				Ramal tel_contato = new Ramal(dddcon,telcon,ddicon,tipoTel,ramalcon);
				Departamento deptoUsuario = new Departamento(deptocon);
				Usuario usuarioEmp = new Usuario(usuario, senha);
				Contato contato = new Contato(nome, email,tel_contato, deptoUsuario,usuarioEmp);
				CNAE cnae = new CNAE(cnae_bd);
				TipoFornecimento tipoFor = new TipoFornecimento(tipo_for);
				TipoEmpresa tipoEmp = new TipoEmpresa(tipo_emp);
				Status statusEmp = new Status(status);
				boolean rascunho = false;
				if(status.equals("rascunho")) {
					rascunho = true;
				}
				
				//populando arraylist
				fornecedor.add(new Fornecedor(Integer.parseInt(idfor),rascunho,cnae,contato.getEmail(), cnpj, iestadual,imunicipal,razao_social, 
						nome_fantasia,tipoFor,end,statusEmp,tipoEmp, contato));
				
				

			}
			connection.close();
			return fornecedor;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public EntidadeDominio buscar(EntidadeDominio entidade) {
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco endereco = (Endereco) endDAO.buscar(entidade);
		ContatoDAO conDAO = new ContatoDAO();
		Contato contato = (Contato) conDAO.buscar(entidade);
		
		PreparedStatement pst = null;
		Fornecedor fornecedor = (Fornecedor)entidade;
		StringBuilder sql = new StringBuilder();
		sql.append("select * from tb_fornecedor WHERE id_for=?;");
		try {
			connection = Conexao.conectar();
			pst = connection.prepareStatement(sql.toString()); 
			pst.setInt(1, entidade.getId());
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				fornecedor.setId(Integer.parseInt(rs.getString(1)));
				fornecedor.setCnpj(rs.getString(2));
				fornecedor.setNmFantasia(rs.getString(3));
				fornecedor.setRzSocial(rs.getString(4));
				fornecedor.setInscricaoEstadual(rs.getString(5));
				fornecedor.setInscricaoMunicipal(rs.getString(6));
				CNAE cnae = new CNAE(rs.getString(7));
				fornecedor.setCnae(cnae);
				TipoFornecimento tipoFor = new TipoFornecimento(rs.getString(8));
				fornecedor.setTipo_for(tipoFor);
				Status status = new Status(rs.getString(9));
				fornecedor.setStatus(status);
				TipoEmpresa tipoEmp = new TipoEmpresa(rs.getString(10));
				fornecedor.setTipo_empresa(tipoEmp);
			}
			fornecedor.setEndereco(endereco);
			fornecedor.setContato(contato);
			connection.close();
			return fornecedor;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	


}
