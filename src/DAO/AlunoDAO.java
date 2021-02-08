package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class AlunoDAO {

	public void save(Aluno aluno) {
		/*
		 * Isso � uma sql comum, os ? s�o os par�metros que n�s vamos
		 * adicionar na base de dados
		 */

		String sql = "INSERT INTO Aluno (ALU_RA, ALU_NOME, ALU_SEXO, ALU_DATANASC, ALU_CPF, ALU_FILIACAO, ALU_ENDERECO,"
				+ "ALU_TELEFONE, ALU_DATAMATRI, ALU_DISCCON, ALU_DISCPEND, ALU_CRED, ALU_PROFIC, ALU_SISTEMA, ORIENT_ID, CUR_ID)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = Conexao.getConexaoMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro par�metro da sql
			pstm.setInt(1, aluno.getALU_RA());
			// Adicionar o valor do segundo par�metro da sql
			pstm.setString(2, aluno.getALU_NOME());
			// Adiciona o valor do terceiro par�metro da sql
			pstm.setString(3, aluno.getALU_SEXO());
			// Adiciona o valor do quarto par�metro da sql
			pstm.setDate(4, aluno.getALU_DATANASC());
			// Adiciona o valor do quinto par�metro da sql
			pstm.setString(5, aluno.getALU_CPF());
			// Adiciona o valor do sexto par�metro da sql
			pstm.setString(6, aluno.getALU_FILIACAO());
			// Adiciona o valor do setimo par�metro da sql
			pstm.setString(7, aluno.getALU_ENDERECO());
			// Adiciona o valor do oitavo par�metro da sql
			pstm.setString(8, aluno.getALU_TELEFONE());
			// Adiciona o valor do nona par�metro da sql
			pstm.setDate(9, aluno.getALU_DATAMATRI());
			// Adiciona o valor do decimo par�metro da sql
			pstm.setString(10, aluno.getALU_DISCCONC());
			// Adiciona o valor do decimo primeiro par�metro da sql
			pstm.setString(11, aluno.getALU_DISCPEND());
			// Adiciona o valor do decimo segundo par�metro da sql
			pstm.setInt(12, aluno.getALU_CRED());
			// Adiciona o valor do decimo terceiro par�metro da sql
			pstm.setString(13, aluno.getALU_PROFIC());
			// Adiciona o valor do decimo quarto par�metro da sql
			pstm.setString(14, aluno.getALU_SISTEMA());
			// Adiciona o valor do decimo quinto par�metro da sql
			pstm.setInt(15, aluno.getORIENT_ID());
			// Adiciona o valor do decimo quinto par�metro da sql
			pstm.setInt(16, aluno.getCUR_ID());
			// Adiciona o valor do decimo sexto par�metro da sql

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

		String sql = "DELETE FROM Aluno WHERE ALU_RA = ?";

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

	public void update(Aluno aluno) {

		String sql = "UPDATE Aluno SET ALU_NOME = ?, ALU_SEXO = ?, ALU_DATANASC = ?, ALU_CPF = ?, ALU_FILIACAO = ?"
				+ ", ALU_ENDERECO = ?, ALU_TELEFONE = ?, ALU_DATAMATRI = ?, ALU_DISCCON = ?, ALU_DISCPEND = ?, ALU_CRED = ?, ALU_PROFIC = ?"
				+ ", ALU_SISTEMA = ?, ORIENT_ID = ?, CUR_ID = ? WHERE ALU_RA = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = Conexao.getConexaoMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro par�metro da sql
			pstm.setString(1, aluno.getALU_NOME());
			// Adiciona o valor do segundo par�metro da sql
			pstm.setString(2, aluno.getALU_SEXO());
			// Adiciona o valor do terceiro par�metro da sql
			pstm.setDate(3, aluno.getALU_DATANASC());
			// Adiciona o valor do quarto par�metro da sql
			pstm.setString(4, aluno.getALU_CPF());
			// Adiciona o valor do quinto par�metro da sql
			pstm.setString(5, aluno.getALU_FILIACAO());
			// Adiciona o valor do sexto par�metro da sql
			pstm.setString(6, aluno.getALU_ENDERECO());
			// Adiciona o valor do setimo par�metro da sql
			pstm.setString(7, aluno.getALU_TELEFONE());
			// Adiciona o valor do oitavo par�metro da sql
			pstm.setDate(8, aluno.getALU_DATAMATRI());
			// Adiciona o valor do nono par�metro da sql
			pstm.setString(9, aluno.getALU_DISCCONC());
			// Adiciona o valor do decimo par�metro da sql
			pstm.setString(10, aluno.getALU_DISCPEND());
			// Adiciona o valor do decimo primeiro par�metro da sql
			pstm.setInt(11, aluno.getALU_CRED());
			// Adiciona o valor do decimo segundo par�metro da sql
			pstm.setString(12, aluno.getALU_PROFIC());
			// Adiciona o valor do decimo terceiro par�metro da sql
			pstm.setString(13, aluno.getALU_SISTEMA());
			// Adiciona o valor do decimo quarto par�metro da sql
			pstm.setInt(14, aluno.getORIENT_ID());
			// Adiciona o valor do decimo quinto par�metro da sql
			pstm.setInt(15, aluno.getCUR_ID());
			// Adiciona a matricula no valor do decimo sexto parametro da sql
			pstm.setInt(16, aluno.getALU_RA());

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

	public List<Aluno> getAlunos() {

		String sql = " SELECT ALU_RA, ALU_NOME, ALU_SEXO, ALU_CPF, ALU_TELEFONE, (SELECT Curso.CUR_DESCRICAO FROM Curso WHERE Curso.CUR_ID = Aluno.CUR_ID) AS ALU_CURSO, ALU_SISTEMA, (SELECT Orientador.ORIENT_NOME FROM Orientador WHERE Orientador.ORIENT_ID = Aluno.ORIENT_ID) AS ALU_ORIENT  FROM Aluno";

		
		List<Aluno> alunos = new ArrayList<Aluno>();

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

				Aluno aluno = new Aluno();

				aluno.setALU_RA(rset.getInt("ALU_RA"));
				aluno.setALU_NOME(rset.getString("ALU_NOME"));
				//aluno.setALU_SEXO(rset.getString("ALU_SEXO"));
				//aluno.setALU_DATANASC(rset.getDate("ALU_DATANASC"));
				aluno.setALU_CPF(rset.getString("ALU_CPF"));
				//aluno.setALU_FILIACAO(rset.getString("ALU_FILIACAO"));
				//aluno.setALU_ENDERECO(rset.getString("ALU_ENDERECO"));
				aluno.setALU_TELEFONE(rset.getString("ALU_TELEFONE"));
				//aluno.setALU_DATAMATRI(rset.getDate("ALU_DATAMATRI"));
				//aluno.setALU_DISCCONC(rset.getString("ALU_DISCCON"));
				//aluno.setALU_DISCPEND(rset.getString("ALU_DISCPEND"));
				//aluno.setALU_CRED(rset.getInt("ALU_CRED"));
				//aluno.setALU_PROFIC(rset.getString("ALU_PROFIC"));
				aluno.setALU_SISTEMA(rset.getString("ALU_SISTEMA"));
				//aluno.setORIENT_ID(rset.getInt("ORIENT_ID"));
				//aluno.setCUR_ID(rset.getInt("CUR_ID"));
				
				
				aluno.setALU_CURSO(rset.getString("ALU_CURSO"));
				aluno.setALU_ORIENT(rset.getString("ALU_ORIENT"));

				// Adiciono o contato recuperado, a lista de contatos
				alunos.add(aluno);
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

		return alunos;
	}

	// inicio do novo m�todo

	public List<Aluno> pesquisarAlunos(String nome) {

		String sql = " SELECT ALU_RA, ALU_NOME, ALU_SEXO, ALU_CPF, ALU_TELEFONE, (SELECT Curso.CUR_DESCRICAO FROM Curso WHERE Curso.CUR_ID = Aluno.CUR_ID) AS ALU_CURSO, ALU_SISTEMA, (SELECT Orientador.ORIENT_NOME FROM Orientador WHERE Orientador.ORIENT_ID = Aluno.ORIENT_ID) AS ALU_ORIENT  FROM Aluno WHERE ALU_NOME LIKE'%" + nome + "%'";

		List<Aluno> alunos = new ArrayList<Aluno>();

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

				Aluno aluno = new Aluno();

				aluno.setALU_RA(rset.getInt("ALU_RA"));
				aluno.setALU_NOME(rset.getString("ALU_NOME"));
				//aluno.setALU_SEXO(rset.getString("ALU_SEXO"));
				//aluno.setALU_DATANASC(rset.getDate("ALU_DATANASC"));
				aluno.setALU_CPF(rset.getString("ALU_CPF"));
				//aluno.setALU_FILIACAO(rset.getString("ALU_FILIACAO"));
				//aluno.setALU_ENDERECO(rset.getString("ALU_ENDERECO"));
				aluno.setALU_TELEFONE(rset.getString("ALU_TELEFONE"));
				//aluno.setALU_DATAMATRI(rset.getDate("ALU_DATAMATRI"));
				//aluno.setALU_DISCCONC(rset.getString("ALU_DISCCON"));
				//aluno.setALU_DISCPEND(rset.getString("ALU_DISCPEND"));
				//aluno.setALU_CRED(rset.getInt("ALU_CRED"));
				//aluno.setALU_PROFIC(rset.getString("ALU_PROFIC"));
				aluno.setALU_SISTEMA(rset.getString("ALU_SISTEMA"));
				//aluno.setORIENT_ID(rset.getInt("ORIENT_ID"));
				//aluno.setCUR_ID(rset.getInt("CUR_ID"));
				
				
				aluno.setALU_CURSO(rset.getString("ALU_CURSO"));
				aluno.setALU_ORIENT(rset.getString("ALU_ORIENT"));
				
				// Adiciono o contato recuperado, a lista de contatos
				alunos.add(aluno);
				
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

		return alunos;
	}
	// fim do novo m�todo

	// inicio do novo m�todo

	public Aluno pesquisarAluno(String nome) {

		String sql = "SELECT * FROM Aluno WHERE ALU_NOME LIKE '%" + nome + "%'";

		Aluno aluno = new Aluno();

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
				aluno.setALU_RA(rset.getInt("ALU_RA"));
				// Recupera o nome do banco e atribui ele ao objeto
				aluno.setALU_NOME(rset.getString("ALU_NOME"));
				// Adiciona o valor do terceiro par�metro da sql
				aluno.setALU_SEXO(rset.getString("ALU_SEXO"));
				// Adiciona o valor do quarto par�metro da sql
				aluno.setALU_DATANASC(rset.getDate("ALU_DATANASC"));
				// Adiciona o valor do quinto par�metro da sql
				aluno.setALU_CPF(rset.getString("ALU_CPF"));
				// Adiciona o valor do sexto par�metro da sql
				aluno.setALU_FILIACAO(rset.getString("ALU_FILIACAO"));
				// Adiciona o valor do setimo par�metro da sql
				aluno.setALU_ENDERECO(rset.getString("ALU_ENDERECO"));
				// Adiciona o valor do oitavo par�metro da sql
				aluno.setALU_TELEFONE(rset.getString("ALU_TELEFONE"));
				// Adiciona o valor do nona par�metro da sql
				aluno.setALU_DATAMATRI(rset.getDate("ALU_DATAMATRI"));
				// Adiciona o valor do decimo par�metro da sql
				aluno.setALU_DISCCONC(rset.getString("ALU_DISCCON"));
				// Adiciona o valor do decimo primeiro par�metro da sql
				aluno.setALU_DISCPEND(rset.getString("ALU_DISCPEND"));
				// Adiciona o valor do decimo segundo par�metro da sql
				aluno.setALU_CRED(rset.getInt("ALU_CRED"));
				// Adiciona o valor do decimo terceiro par�metro da sql
				aluno.setALU_PROFIC(rset.getString("ALU_PROFIC"));
				// Adiciona o valor do decimo quarto par�metro da sql
				aluno.setALU_SISTEMA(rset.getString("ALU_SISTEMA"));
				// Adiciona o valor do decimo quinto par�metro da sql
				aluno.setORIENT_ID(rset.getInt("ORIENT_ID"));
				// Adiciona o valor do decimo sexto par�metro da sql
				aluno.setCUR_ID(rset.getInt("CUR_ID"));

				// Adiciono o contato recuperado, a lista de contatos
				// alunos.add(aluno);
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

		return aluno;
	}
	// fim do novo m�todo

}