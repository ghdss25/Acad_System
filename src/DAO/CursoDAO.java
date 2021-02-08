package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

public class CursoDAO {

	public void save(Curso curso) {
		/*
		 * Isso � uma sql comum, os ? s�o os par�metros que n�s vamos adicionar
		 * na base de dados
		 */

		String sql = "INSERT INTO Curso (CUR_ID, CUR_DESCRICAO)" + " VALUES(?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = Conexao.getConexaoMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro par�metro da sql
			pstm.setInt(1, curso.getCUR_ID());
			// Adicionar o valor do segundo par�metro da sql
			pstm.setString(2, curso.getCUR_DESCRICAO());

			// Executa a sql para inser��o dos dados
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

		String sql = "DELETE FROM Curso WHERE CUR_ID = ?";

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

	public void update(Curso curso) {

		String sql = "UPDATE Curso SET CUR_DESCRICAO = ?" + "WHERE CUR_ID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = Conexao.getConexaoMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do segundo par�metro da sql
			pstm.setString(1, curso.getCUR_DESCRICAO());
			pstm.setInt(2, curso.getCUR_ID());

			// Executa a sql para inser��o dos dados
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

	public List<Curso> getCursos() {

		String sql = "SELECT * FROM Curso";

		List<Curso> cursos = new ArrayList<Curso>();

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

				Curso curso = new Curso();

				// Recupera o id do banco e atribui ele ao objeto
				curso.setCUR_ID(rset.getInt("CUR_ID"));
				// Recupera o nome do banco e atribui ele ao objeto
				curso.setCUR_DESCRICAO(rset.getString("CUR_DESCRICAO"));

				// Adiciono o contato recuperado, a lista de contatos
				cursos.add(curso);
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

		return cursos;
	}
	
	
	public Curso pesquisarCurso(String nome) {

		String sql = "SELECT * FROM Curso WHERE CUR_DESCRICAO LIKE '%" + nome + "%'";

		Curso curso = new Curso();

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

				curso.setCUR_ID(rset.getInt("CUR_ID"));
				curso.setCUR_DESCRICAO(rset.getString("CUR_DESCRICAO"));
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

		return curso;
	}

	public List<Curso> pesquisarCursos(String nome) {

		String sql = "SELECT * FROM Curso WHERE CUR_DESCRICAO LIKE'%" + nome + "%'";

		List<Curso> cursos = new ArrayList<Curso>();

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

				Curso curso = new Curso();

				// Recupera o id do banco e atribui ele ao objeto
				curso.setCUR_ID(rset.getInt("CUR_ID"));
				// Recupera o nome do banco e atribui ele ao objeto
				curso.setCUR_DESCRICAO(rset.getString("CUR_DESCRICAO"));


				// Adiciono o contato recuperado, a lista de contatos
				cursos.add(curso);
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

		return cursos;
	}	
}