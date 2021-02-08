package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {
	
	public void save(Usuario usuario) {

		String sql = "INSERT INTO Usuario (USU_ID, USU_NOME, USU_TEL, USU_SENHA, USU_TIPO)" + " VALUES(?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.getConexaoMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, usuario.getUSU_ID());
			pstm.setString(2, usuario.getUSU_NOME());
			pstm.setString(3, usuario.getUSU_TEL());
			pstm.setString(4, usuario.getUSU_SENHA());
			pstm.setString(5, usuario.getUSU_TIPO());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conex�es

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM Usuario WHERE USU_ID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.getConexaoMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Usuario usuario) {

		String sql = "UPDATE Usuario SET USU_NOME = ?, USU_TEL = ?, USU_SENHA = ?, USU_TIPO = ?"
		+ "WHERE USU_ID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.getConexaoMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getUSU_NOME());
			pstm.setString(2, usuario.getUSU_TEL());
			pstm.setString(3, usuario.getUSU_SENHA());
			pstm.setString(4, usuario.getUSU_TIPO());
			pstm.setInt(5, usuario.getUSU_ID());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conex�es

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Usuario> getUsuarios() {

		String sql = "SELECT * FROM Usuario";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.getConexaoMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Usuario usuario = new Usuario();

				usuario.setUSU_ID(rset.getInt("USU_ID"));
				usuario.setUSU_NOME(rset.getString("USU_NOME"));
				usuario.setUSU_TEL(rset.getString("USU_TEL"));
				usuario.setUSU_SENHA(rset.getString("USU_SENHA"));
				usuario.setUSU_TIPO(rset.getString("USU_TIPO"));

				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return usuarios;
	}

	
	public Usuario pesquisarUsuario(String nome) {

		String sql = "SELECT * FROM Usuario WHERE USU_NOME LIKE '%" + nome + "%'";

		Usuario usuario = new Usuario();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.getConexaoMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				usuario.setUSU_ID(rset.getInt("USU_ID"));
				usuario.setUSU_NOME(rset.getString("USU_NOME"));
				usuario.setUSU_TEL(rset.getString("USU_TEL"));
				usuario.setUSU_SENHA(rset.getString("USU_SENHA"));
				usuario.setUSU_TIPO(rset.getString("USU_TIPO"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return usuario;
	}
	
	
	public List<Usuario> pesquisarUsuarios(String nome) {

		String sql = "SELECT * FROM Usuario WHERE USU_NOME LIKE'%" + nome + "%'";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		Connection conn = null;
		PreparedStatement pstm = null;
		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.getConexaoMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, fa�a
			while (rset.next()) {

				Usuario usuario = new Usuario();

				// Recupera o id do banco e atribui ele ao objeto
				usuario.setUSU_ID(rset.getInt("USU_ID"));
				
				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setUSU_NOME(rset.getString("USU_NOME"));
				
				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setUSU_TIPO(rset.getString("USU_TIPO"));
				
				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setUSU_TEL(rset.getString("USU_TEL"));


				// Adiciono o contato recuperado, a lista de contatos
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return usuarios;
	}


}
