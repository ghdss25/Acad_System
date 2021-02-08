package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Orientador;

public class OrientadorDAO {

	public void save(Orientador orientador) {
		/*
		 * Isso � uma sql comum, os ? s�o os par�metros que n�s vamos adicionar
		 * na base de dados
		 */

		String sql = "INSERT INTO Orientador (ORIENT_ID, ORIENT_NOME, ORIENT_DATANASC, "
				+ "ORIENT_CPF, ORIENT_INSTITUICAO, ORIENT_TITULACAO)" + " VALUES(?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = Conexao.getConexaoMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro par�metro da sql
			pstm.setInt(1, orientador.getORIENT_ID());
			// Adicionar o valor do segundo par�metro da sql
			pstm.setString(2, orientador.getORIENT_NOME());
			// Adiciona o valor do terceiro par�metro da sql
			pstm.setDate(3, orientador.getORIENT_DATANASC());
			// Adiciona o valor do quarto par�metro da sql
			pstm.setString(4, orientador.getORIENT_CPF());
			// Adiciona o valor do quinto par�metro da sql
			pstm.setString(5, orientador.getORIENT_INSTITUICAO());
			// Adiciona o valor do quinto par�metro da sql
			pstm.setString(6, orientador.getORIENT_TITULACAO());
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

		String sql = "DELETE FROM Orientador WHERE ORIENT_ID = ?";

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

	public void update(Orientador orientador) {

		String sql = "UPDATE Orientador SET ORIENT_NOME = ?, ORIENT_DATANASC = ?, ORIENT_CPF = ?, ORIENT_INSTITUICAO = ?"
				+ ", ORIENT_TITULACAO = ? " + "WHERE ORIENT_ID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = Conexao.getConexaoMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro par�metro da sql
			pstm.setString(1, orientador.getORIENT_NOME());
			// Adiciona o valor do terceiro par�metro da sql
			pstm.setDate(2, orientador.getORIENT_DATANASC());
			// Adiciona o valor do quarto par�metro da sql
			pstm.setString(3, orientador.getORIENT_CPF());
			// Adiciona o valor do quinto par�metro da sql
			pstm.setString(4, orientador.getORIENT_INSTITUICAO());
			// Adiciona o valor do quinto par�metro da sql
			pstm.setString(5, orientador.getORIENT_TITULACAO());
			
			pstm.setInt(6, orientador.getORIENT_ID());

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

	public List<Orientador> getOrientadores() {

		String sql = "SELECT * FROM Orientador";

		List<Orientador> orientadores = new ArrayList<Orientador>();

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

				Orientador orientador = new Orientador();

				// Recupera o id do banco e atribui ele ao objeto
				orientador.setORIENT_ID(rset.getInt("ORIENT_ID"));
				// Recupera o nome do banco e atribui ele ao objeto
				orientador.setORIENT_NOME(rset.getString("ORIENT_NOME"));
				// Adiciona o valor do terceiro par�metro da sql
				orientador.setORIENT_DATANASC(rset.getDate("ORIENT_DATANASC"));
				// Adiciona o valor do quarto par�metro da sql
				orientador.setORIENT_CPF(rset.getString("ORIENT_CPF"));
				// Adiciona o valor do quinto par�metro da sql
				orientador.setORIENT_INSTITUICAO(rset.getString("ORIENT_INSTITUICAO"));
				// Adiciona o valor do sexto par�metro da sql
				orientador.setORIENT_TITULACAO(rset.getString("ORIENT_TITULACAO"));

				// Adiciono o contato recuperado, a lista de contatos
				orientadores.add(orientador);
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

		return orientadores;
	}

	// inicio do metodo pesquisar

	public List<Orientador> pesquisarOrientadores(String nome) {

		String sql = "SELECT * FROM Orientador WHERE ORIENT_NOME LIKE'%" + nome + "%'";

		List<Orientador> orientadores = new ArrayList<Orientador>();

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

				Orientador orientador = new Orientador();

				// Recupera o id do banco e atribui ele ao objeto
				orientador.setORIENT_ID(rset.getInt("ORIENT_ID"));
				// Recupera o nome do banco e atribui ele ao objeto
				orientador.setORIENT_NOME(rset.getString("ORIENT_NOME"));
				// Adiciona o valor do terceiro par�metro da sql
				orientador.setORIENT_DATANASC(rset.getDate("ORIENT_DATANASC"));
				// Adiciona o valor do quarto par�metro da sql
				orientador.setORIENT_CPF(rset.getString("ORIENT_CPF"));
				// Adiciona o valor do quinto par�metro da sql
				orientador.setORIENT_INSTITUICAO(rset.getString("ORIENT_INSTITUICAO"));
				// Adiciona o valor do sexto par�metro da sql
				orientador.setORIENT_TITULACAO(rset.getString("ORIENT_TITULACAO"));

				// Adiciono o contato recuperado, a lista de contatos
				orientadores.add(orientador);
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

		return orientadores;
	}
	
	public Orientador pesquisarOrientador(String nome) {

		String sql = "SELECT * FROM Orientador WHERE ORIENT_NOME LIKE '%" + nome + "%'";

		Orientador orientador = new Orientador();

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

				// Recupera o id do banco e atribui ele ao objeto
				//orientador.setORIENT_ID(rset.getInt("ORIENT_ID"));
				
				// Recupera o nome do banco e atribui ele ao objeto
				orientador.setORIENT_NOME(rset.getString("ORIENT_NOME"));
				// Adiciona o valor do terceiro par�metro da sql
				orientador.setORIENT_DATANASC(rset.getDate("ORIENT_DATANASC"));
				// Adiciona o valor do quarto par�metro da sql
				orientador.setORIENT_CPF(rset.getString("ORIENT_CPF"));
				// Adiciona o valor do quinto par�metro da sql
				orientador.setORIENT_INSTITUICAO(rset.getString("ORIENT_INSTITUICAO"));
				// Adiciona o valor do sexto par�metro da sql
				orientador.setORIENT_TITULACAO(rset.getString("ORIENT_TITULACAO"));
				
				// Adiciono o contato recuperado, a lista de contatos
				((List<Orientador>) orientador).add(orientador);
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

		return orientador;
	}

}