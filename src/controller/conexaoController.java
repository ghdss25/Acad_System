package controller;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.Conexao;
import view.FrameMenu;

public class conexaoController {

	private Conexao conex = new Conexao();

	@SuppressWarnings("deprecation")
	public boolean btnAcessar(JTextField loginField, JTextField passwordField) {

		String tipo;
		
		Boolean conectado = false;

		Conexao.getConexaoMySQL();

		try {
			conex.acessoUsuarioADM(loginField.getText(), passwordField.getText());
			conex.acessoUsuarioNormal(loginField.getText(), passwordField.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ((conex.acessoADM == true) && (conex.acessoNRM == false)) {
			JOptionPane.showMessageDialog(null, "Usuario e senha Corretos");
			
			tipo = "ADMINISTRADOR";
			
			FrameMenu telaMenu = new FrameMenu(loginField.getText(), tipo);
			telaMenu.show();
			
			System.out.println("ADMINISTRADOR LOGADO - conexaoController");

			conectado = true;
		} else if ((conex.acessoADM == false) && (conex.acessoNRM == false)) {

			JOptionPane.showMessageDialog(null, "Usuario e senha Incorretos");

			loginField.setText("");
			passwordField.setText("");
			loginField.requestFocus();

			conectado = false;
		} else if (conex.acessoNRM == true) {
			
			tipo = "NORMAL";
			
			FrameMenu telaMenu = new FrameMenu(loginField.getText(), tipo);
			telaMenu.show();
			System.out.println("USUARIO NORMAL LOGADO - conexaoController");

			conectado = true;
		}

		return conectado;
	}
	
	
	public void bloqueiaButtonsMenu(String tipoUsuario, JButton btnUsuario, JButton btnCurso, JButton btnOrientador, JButton btnAluno, JButton btnPublicacao){
		
		if(tipoUsuario.equals("NORMAL")){
			
			btnUsuario.setEnabled(false);
			btnCurso.setEnabled(false);
			btnOrientador.setEnabled(false);
			btnAluno.setEnabled(false);
			btnPublicacao.setEnabled(false);
			//System.out.println("USU�RIO NORMAL LOGADO");
			
		}else if(tipoUsuario.equals("ADMINISTRADOR")){
			//System.out.println("ADMINISTRADOR LOGADO");
			btnUsuario.setEnabled(true);
			btnCurso.setEnabled(true);
			btnOrientador.setEnabled(true);
			btnAluno.setEnabled(true);
			btnPublicacao.setEnabled(true);
		}		
	}

	

	public void bloqueiaButtonExcluir(String tipoUsuario, JButton btnExcluir){
		
		if(tipoUsuario.equals("NORMAL")){
			
			btnExcluir.setEnabled(false);
			System.out.println("USUARIO NORMAL LOGADO - conexaoController");
			
		}else if(tipoUsuario.equals("ADMINISTRADOR")){
			System.out.println("ADMINISTRADOR LOGADO - conexaoController");
		}		
	}

}
