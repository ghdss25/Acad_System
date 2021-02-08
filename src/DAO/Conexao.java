package DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class Conexao {

	public static String status = "Não conectou...";

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null; // atributo do tipo Connection

		try {

			// Carregando o JDBC Driver padr�o

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			// Configurando a nossa conex�o com um banco de dados//

			String serverName = "localhost:3306"; // caminho do servidor do BD

			String mydatabase = "acadsystem"; // nome do seu banco de dados

			String url = "jdbc:mysql://localhost:3306/acadsystem?useSSL=false"; 

			String username = "gustavo"; // nome de um Usu�rio de seu BD

			String password = "123"; // sua senha de acesso

			connection = DriverManager.getConnection(url, username, password);

			// Testa sua conex�o//

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");

			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");

			}
			
			return connection;

		} catch (ClassNotFoundException e) { // Driver n�o encontrado

			System.out.println("O driver expecificado nao foi encontrado.");
			JOptionPane.showMessageDialog(null, "O driver expecificado nao foi encontrado.");

			return null;

		} catch (SQLException e) {

			// N�o conseguindo se conectar ao banco

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			JOptionPane.showMessageDialog(null, "Nao foi possivel conectar ao Banco de Dados.");

			return null;

		}
	}

	// Método que retorna o status da sua conexão//

	public static String statusConection() {

		return status;

	}
	// Método que fecha sua conexão//

	public static boolean FecharConexao() {

		try {

			Conexao.getConexaoMySQL().close();

			return true;

		} catch (SQLException e) {

			return false;

		}
	}

	// Método que reinicia sua conexão//

	public static java.sql.Connection ReiniciarConexao() {

		FecharConexao();
		return Conexao.getConexaoMySQL();

	}

	public boolean acessoADM;
	public boolean acessoUsuarioADM(String login, String senha) throws SQLException {
		
		Statement consulta = null;
		ResultSet tabela = null;
		Connection con = getConexaoMySQL();

		consulta = (Statement) con.createStatement();
		tabela = consulta.executeQuery("SELECT usu_nome, usu_senha FROM Usuario WHERE usu_nome = '" + login
				+ "' AND usu_senha = '" + senha + "' AND usu_tipo='ADMINISTRADOR';");

		if (tabela.next()) {
			acessoADM = true;
		} else {
			acessoADM = false;
		}

		return acessoADM;

	}

	public boolean acessoNRM;
	public boolean acessoUsuarioNormal(String login, String senha) throws SQLException {
	
		Statement consulta = null;
		ResultSet tabela = null;
		Connection con = Conexao.getConexaoMySQL();

		consulta = (Statement) con.createStatement();
		tabela = consulta.executeQuery("SELECT usu_nome, usu_senha, usu_tipo FROM Usuario WHERE usu_nome = '" + login
				+ "' AND usu_senha = '" + senha + "' AND USU_TIPO = 'NORMAL';");

		if (tabela.next()) {
			acessoNRM = true;
		} else {
			acessoNRM = false;
		}

		return acessoNRM;
	}

}