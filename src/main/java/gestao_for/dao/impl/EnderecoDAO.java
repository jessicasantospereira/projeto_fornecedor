package gestao_for.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import gestao_for.dao.IDAO;
import gestao_for.dominio.Cidade;
import gestao_for.dominio.Endereco;
import gestao_for.dominio.EntidadeDominio;
import gestao_for.dominio.Estado;
import gestao_for.dominio.Fornecedor;
import gestao_for.dominio.Pais;
import gestao_for.dominio.TipoEndereco;
import gestao_for.dominio.TipoLogradouro;

public class EnderecoDAO implements IDAO {
	private Connection connection;
	private boolean ctrlTransaction = true;
	
	public EnderecoDAO(){}
	
	public EnderecoDAO(Connection connection){
		this.connection = connection;
	}


	public void salvar(EntidadeDominio entidade, int id) {
		PreparedStatement pst=null;
		Endereco end = (Endereco)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tb_enderecos(tipo_end, tipo_log, log, numero, complemento, bairro, cep, cidade,");
		sql.append("estado, pais, for_id) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");	
		
		try {
			if(connection == null){
				connection = Conexao.conectar();
				 
			}else{
				ctrlTransaction = false;
			}
		
			connection.setAutoCommit(false);
			
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, end.getTipo().getNome());
			pst.setString(2, end.getTipo_log().getDescricao());	
			pst.setString(3, end.getLogradouro());		
			pst.setString(4, end.getNumero());		
			pst.setString(5, end.getComplemento());		
			pst.setString(6, end.getBairro());		
			pst.setString(7, end.getCep());
			pst.setString(8, end.getCidade().getNome());
			pst.setString(9, end.getCidade().getEstado().getNome());
			pst.setString(10, end.getCidade().getEstado().getPais().getNome());
			pst.setInt(11, id);
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			end.setId(idEnd);
			
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
		Endereco end = (Endereco)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE tb_enderecos SET tipo_end=?, tipo_log=?, log=?, numero=?, complemento=?, bairro=?, cep=?, cidade=?,");
		sql.append("estado=?, pais=? WHERE id_end=?;");
		
		try {
			if(connection == null){
				connection = Conexao.conectar();
				 
			}else{
				ctrlTransaction = false;
			}
			connection.setAutoCommit(false);
			pst = connection.prepareStatement(sql.toString());
			
			pst.setString(1, end.getTipo().getNome());
			pst.setString(2, end.getTipo_log().getDescricao());	
			pst.setString(3, end.getLogradouro());		
			pst.setString(4, end.getNumero());		
			pst.setString(5, end.getComplemento());		
			pst.setString(6, end.getBairro());		
			pst.setString(7, end.getCep());
			pst.setString(8, end.getCidade().getNome());
			pst.setString(9, end.getCidade().getEstado().getNome());
			pst.setString(10, end.getCidade().getEstado().getPais().getNome());
			pst.setInt(11, end.getId());
			
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
	public void excluir(EntidadeDominio entidade) {
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE from tb_enderecos where for_id=?;");

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
//		System.out.println("Aqui EndDAO");
		PreparedStatement pst=null;
		Endereco end = new Endereco();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from tb_enderecos WHERE for_id=?;");
		try {
			connection = Conexao.conectar();
			
			pst = connection.prepareStatement(sql.toString()); 
			pst.setInt(1, entidade.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				end.setId(Integer.parseInt(rs.getString(1)));
				TipoEndereco tipoEnd = new TipoEndereco(rs.getString(2));
				end.setTipo(tipoEnd);
				TipoLogradouro tipoLog = new TipoLogradouro(rs.getString(3));
				end.setTipo_log(tipoLog);
				end.setLogradouro(rs.getString(4));
				end.setNumero(rs.getString(5));
				end.setComplemento(rs.getString(6));
				end.setBairro(rs.getString(7));
				end.setCep(rs.getString(8));
				Pais pais = new Pais(rs.getString(11));
				Estado estado = new Estado(rs.getString(10), pais);
				Cidade cidade = new Cidade(rs.getString(9), estado);
				end.setCidade(cidade);
			}
			connection.close();
			return end;
			
		}catch (Exception e) {
		
			System.out.println(e);
		}

		return null;
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}


}
