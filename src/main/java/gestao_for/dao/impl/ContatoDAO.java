package gestao_for.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import gestao_for.dao.IDAO;
import gestao_for.dominio.Cidade;
import gestao_for.dominio.Contato;
import gestao_for.dominio.Departamento;
import gestao_for.dominio.Endereco;
import gestao_for.dominio.EntidadeDominio;
import gestao_for.dominio.Estado;
import gestao_for.dominio.Fornecedor;
import gestao_for.dominio.Pais;
import gestao_for.dominio.Ramal;
import gestao_for.dominio.TipoTelefone;
import gestao_for.dominio.Usuario;

public class ContatoDAO implements IDAO {
	private Connection connection;
	private boolean ctrlTransaction = true;
	
	public ContatoDAO(){}
	
	public ContatoDAO(Connection connection){
		this.connection = connection;
	}
	public void salvar(EntidadeDominio entidade, int id) {
		PreparedStatement pst=null;
		Contato contato = (Contato)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tb_contatos(nome,ddd,ddi,tel,tipo_telefone,ramal, email, depto, usuario, senha, for_id)");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?,?)");	
		
		try {
			if(connection == null){
				connection = Conexao.conectar();
				 
			}else{
				ctrlTransaction = false;
			}
		
			connection.setAutoCommit(false);
			
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getRamal().getDdd());
			pst.setString(3, contato.getRamal().getDdi());	
			pst.setString(4, contato.getRamal().getNumero());	
			pst.setString(5, contato.getRamal().getTipo_tel().getDescricao());
			pst.setString(6, contato.getRamal().getCodigo());
			pst.setString(7, contato.getEmail());
			pst.setString(8, contato.getDepto().getDescricao());
			pst.setString(9, contato.getUsuario().getLogin());
			pst.setString(10, contato.getUsuario().getSenha());
			pst.setInt(11, id);
			
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idCon=0;
			if(rs.next())
				idCon = rs.getInt(1);
			contato.setId(idCon);
			
			connection.commit();					
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		PreparedStatement pst=null;
		Contato contato = (Contato)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE tb_contatos SET nome=?,ddd=?,ddi=?,tel=?,tipo_telefone=?,ramal=?, email=?, depto=?, usuario=?, senha=? ");
		sql.append("WHERE id_con=?");	
		
		try {
			if(connection == null){
				connection = Conexao.conectar();
				 
			}else{
				ctrlTransaction = false;
			}
		
			connection.setAutoCommit(false);
				
			pst = connection.prepareStatement(sql.toString());
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getRamal().getDdd());
			pst.setString(3, contato.getRamal().getDdi());	
			pst.setString(4, contato.getRamal().getNumero());	
			pst.setString(5, contato.getRamal().getTipo_tel().getDescricao());
			pst.setString(6, contato.getRamal().getCodigo());
			pst.setString(7, contato.getEmail());
			pst.setString(8, contato.getDepto().getDescricao());
			pst.setString(9, contato.getUsuario().getLogin());
			pst.setString(10, contato.getUsuario().getSenha());
			pst.setInt(11, contato.getId());
			
			pst.executeUpdate();		

			connection.commit();					
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}

	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE from tb_contatos where for_id=?;");

		try {
			if(connection == null){
				connection = Conexao.conectar();
				 
			}else{
				ctrlTransaction = false;
			}
			connection.setAutoCommit(false);
			pst = connection.prepareStatement(sql.toString());
			pst.setInt(1, entidade.getId());	
			pst.executeUpdate();
			connection.commit();	
			
		} catch (Exception e) {
			
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeDominio buscar(EntidadeDominio entidade) {

		PreparedStatement pst=null;
		Contato contato = new Contato();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from tb_contatos WHERE for_id=?;");
		try {
			connection = Conexao.conectar();
			
			pst = connection.prepareStatement(sql.toString()); 
			pst.setInt(1, entidade.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				contato.setId(Integer.parseInt(rs.getString(1)));
				contato.setNome(rs.getString(2));
				String ddd = rs.getString(3);
				String ddi = rs.getString(4);
				String telefone = rs.getString(5);
				String codigo = rs.getString(6);
				TipoTelefone tipo_tel = new TipoTelefone(rs.getString(7));
				Ramal ramal = new Ramal(ddd, telefone, ddi, tipo_tel, codigo);
				contato.setRamal(ramal);
				contato.setEmail(rs.getString(8));
				Departamento depto = new Departamento(rs.getString(9));
				contato.setDepto(depto);
				String login = rs.getString(10);
				String senha = rs.getString(11);
				Usuario usuario = new Usuario(login, senha);
				contato.setUsuario(usuario);
				
			}
			connection.close();
			return contato;
			
		}catch (Exception e) {
		
			System.out.println(e);
		}

		return null;
	}


}
