package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Publicacao;

public class PublicacaoDAO {

	public void save(Publicacao publicacao) {
		String sql = "INSERT INTO Publicacao (PUBL_ID, PUBL_TITULO, PUBL_DATAPUBLICADA, PUBL_TIPO, ALU_RA)"
				+ " VALUES(?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.getConexaoMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, publicacao.getPUBL_ID());

			pstm.setString(2, publicacao.getPUBL_TITULO());

			pstm.setDate(3, publicacao.getPUBL_DATAPUBLICADA());

			pstm.setString(4, publicacao.getPUBL_TIPO());

			pstm.setInt(5, publicacao.getALU_RA());

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

	public void update(Publicacao publicacao) {

		String sql = "UPDATE Publicacao SET PUBL_TITULO = ?, PUBL_DATAPUBLICADA = ?, PUBL_TIPO = ?, ALU_RA = ? WHERE PUBL_ID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = Conexao.getConexaoMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, publicacao.getPUBL_TITULO());

			pstm.setDate(2, publicacao.getPUBL_DATAPUBLICADA());

			pstm.setString(3, publicacao.getPUBL_TIPO());

			pstm.setInt(4, publicacao.getALU_RA());

			pstm.setInt(5, publicacao.getPUBL_ID());

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

		String sql = "DELETE FROM Publicacao WHERE PUBL_ID = ?";

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

	public Publicacao pesquisarPublicacao(String nome) {

		String sql = "SELECT * FROM Publicacao WHERE PUBL_TITULO LIKE '%" + nome + "%'";

		Publicacao publicacao = new Publicacao();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.getConexaoMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				publicacao.setPUBL_ID(rset.getInt("PUBL_ID"));
				publicacao.setPUBL_TITULO(rset.getString("PUBL_TITULO"));
				publicacao.setPUBL_DATAPUBLICADA(rset.getDate("PUBL_DATAPUBLICADA"));
				publicacao.setALU_RA(rset.getInt("ALU_RA"));
				publicacao.setPUBL_TIPO(rset.getString("PUBL_TIPO"));
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

		return publicacao;
	}

	
	
	
	public List<Publicacao> getPublicacoes() {

		String sql = "SELECT * FROM Publicacao";

		List<Publicacao> publicacoes = new ArrayList<Publicacao>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.getConexaoMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Publicacao publicacao = new Publicacao();

				publicacao.setPUBL_ID(rset.getInt("PUBL_ID"));
				publicacao.setPUBL_DATAPUBLICADA(rset.getDate("PUBL_DATAPUBLICADA"));
				publicacao.setPUBL_TITULO(rset.getString("PUBL_TITULO"));
				publicacao.setPUBL_TIPO(rset.getString("PUBL_TIPO"));

				publicacoes.add(publicacao);
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

		return publicacoes;
	}

	
	
}