package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DAO.Conexao;

public class geradorID {
	
	public boolean idValido;

	public int idRandomico() {
		int x = 1 + (int) (Math.random() * 999);
		return x;
	}

	public void verificarIdUsuario(int idGerador) {
		int idUSU = 0;

		try {

			String sql = ("SELECT * FROM Usuario WHERE USU_ID =" + idGerador);

			Connection conn = null;
			conn = Conexao.getConexaoMySQL();

			try (PreparedStatement pstm = conn.prepareStatement(sql)) {

				ResultSet rset = pstm.executeQuery();

				while (rset.next()) {
					idUSU = rset.getInt("USU_ID");

					if (idUSU == idGerador) {
						idValido = false;
						System.out.println("ID EXISTENTE NO BANCO DE DADOS: " + idGerador);

					} else if (idUSU == 0) {
						idValido = true;
						System.out.println("ID LIVRE, NÃO EXISTE NO BANCO DE DADOS: " + idGerador);
					}

				}

				pstm.executeQuery();
				pstm.close();

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		if (idUSU == 0) {
			idValido = true;
			System.out.println("ID LIVRE, NÃO EXISTE NO BANCO DE DADOS");
		}
	}
	
	public void verificarIdCurso(int idGerador) {
		int idUSU = 0;

		try {

			String sql = ("SELECT * FROM Curso WHERE CUR_ID =" + idGerador);

			Connection conn = null;
			conn = Conexao.getConexaoMySQL();

			try (PreparedStatement pstm = conn.prepareStatement(sql)) {

				ResultSet rset = pstm.executeQuery();

				while (rset.next()) {
					idUSU = rset.getInt("CUR_ID");

					if (idUSU == idGerador) {
						idValido = false;
						System.out.println("ID EXISTENTE NO BANCO DE DADOS: " + idGerador);

					} else if (idUSU == 0) {
						idValido = true;
						System.out.println("ID LIVRE, NÃO EXISTE NO BANCO DE DADOS: " + idGerador);
					}

				}

				pstm.executeQuery();
				pstm.close();

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		if (idUSU == 0) {
			idValido = true;
			System.out.println("ID LIVRE, NÃO EXISTE NO BANCO DE DADOS");
		}

	}
	
	
	public void verificarIdAluno(int idGerador) {
		int idUSU = 0;

		try {

			String sql = ("SELECT * FROM Aluno WHERE ALU_RA =" + idGerador);

			Connection conn = null;
			conn = Conexao.getConexaoMySQL();

			try (PreparedStatement pstm = conn.prepareStatement(sql)) {

				ResultSet rset = pstm.executeQuery();

				while (rset.next()) {
					idUSU = rset.getInt("ALU_RA");

					if (idUSU == idGerador) {
						idValido = false;
						System.out.println("ID EXISTENTE NO BANCO DE DADOS: " + idGerador);

					} else if (idUSU == 0) {
						idValido = true;
						System.out.println("ID LIVRE, NÃO EXISTE NO BANCO DE DADOS: " + idGerador);
					}

				}

				pstm.executeQuery();
				pstm.close();

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		if (idUSU == 0) {
			idValido = true;
			System.out.println("ID LIVRE, NÃO EXISTE NO BANCO DE DADOS");
		}
	}
	
	
	
	
	public void verificarIdOrientador(int idGerador) {
		int idUSU = 0;

		try {

			String sql = ("SELECT * FROM Orientador WHERE ORIENT_ID =" + idGerador);

			Connection conn = null;
			conn = Conexao.getConexaoMySQL();

			try (PreparedStatement pstm = conn.prepareStatement(sql)) {

				ResultSet rset = pstm.executeQuery();

				while (rset.next()) {
					idUSU = rset.getInt("ORIENT_ID");

					if (idUSU == idGerador) {
						idValido = false;
						System.out.println("ID EXISTENTE NO BANCO DE DADOS: " + idGerador);

					} else if (idUSU == 0) {
						idValido = true;
						System.out.println("ID LIVRE, NÃO EXISTE NO BANCO DE DADOS: " + idGerador);
					}

				}

				pstm.executeQuery();
				pstm.close();

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		if (idUSU == 0) {
			idValido = true;
			System.out.println("ID LIVRE, NÃO EXISTE NO BANCO DE DADOS");
		}
	}
	
	
	public void verificarIdPublicacao(int idGerador) {
		int idUSU = 0;

		try {

			String sql = ("SELECT * FROM Publicacao WHERE PUBL_ID =" + idGerador);

			Connection conn = null;
			conn = Conexao.getConexaoMySQL();

			try (PreparedStatement pstm = conn.prepareStatement(sql)) {

				ResultSet rset = pstm.executeQuery();

				while (rset.next()) {
					idUSU = rset.getInt("PUBL_ID");

					if (idUSU == idGerador) {
						idValido = false;
						System.out.println("ID EXISTENTE NO BANCO DE DADOS: " + idGerador);

					} else if (idUSU == 0) {
						idValido = true;
						System.out.println("ID LIVRE, NÃO EXISTE NO BANCO DE DADOS: " + idGerador);
					}

				}

				pstm.executeQuery();
				pstm.close();

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

		if (idUSU == 0) {
			idValido = true;
			System.out.println("ID LIVRE, NÃO EXISTE NO BANCO DE DADOS");
		}

	}
	
	
}
