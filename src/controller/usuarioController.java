package controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.UsuarioDAO;
import model.Usuario;


public class usuarioController {

	private UsuarioDAO usuarioDao = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	
	public void gerarID(JTextField idField) {
		
		geradorID gerador = new geradorID();

		int idGerador = gerador.idRandomico();

		System.out.println("\nID RANDOMICO = " + idGerador);

		gerador.verificarIdUsuario(idGerador);
		
		if (gerador.idValido == true){
			idField.setText(String.valueOf(idGerador));
		}else{
			gerarID(idField);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public boolean verificarCampos(JComboBox cbTipo, JTextField idField, JTextField nomeField, 
			JTextField telefoneField, JTextField senhaField) {

		if ((!idField.getText().equals("")) && (!nomeField.getText().equals(""))
				&& (!telefoneField.getText().equals("")) && (!senhaField.getText().equals(""))
				&& (!cbTipo.getSelectedItem().equals("Selecione"))) {

			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Os campos n�o podem estar vazios");
			return false;
		}
	}

	public void ClearFields(JTextField idField, JTextField nomeField, JTextField telefoneField, JTextField senhaField) {
		idField.setText("");
		nomeField.setText("");
		telefoneField.setText("");
		senhaField.setText("");
	}

	@SuppressWarnings("rawtypes")
	public void BloquearFields(JComboBox cbTipo, JTextField idField, JTextField nomeField, JTextField telefoneField, JTextField senhaField) {
		idField.setEditable(false);
		nomeField.setEditable(false);
		telefoneField.setEditable(false);
		senhaField.setEditable(false);
		cbTipo.setEditable(false);
	}

	@SuppressWarnings({"rawtypes" })
	public void DesbloquearFields(JComboBox cbTipo, JTextField idField, JTextField nomeField, JTextField telefoneField, JTextField senhaField) {
		idField.setEditable(true);
		nomeField.setEditable(true);
		telefoneField.setEditable(true);
		senhaField.setEditable(true);
		cbTipo.setEditable(false);
	}
	
	@SuppressWarnings("rawtypes")
	public void PosicionarCombobox(JComboBox cbTipo) {
		cbTipo.setSelectedItem("Selecione");
	}
	
	
	@SuppressWarnings("rawtypes")
	public void btnSalvar(JComboBox cbTipo, JTextField idField, JTextField nomeField, JTextField telefoneField, JTextField senhaField) {

		String id = idField.getText();
		int ID = Integer.parseInt(id);
		
		usuario.setUSU_ID(ID);

		usuario.setUSU_NOME(nomeField.getText());
		
		usuario.setUSU_TEL(telefoneField.getText());

		usuario.setUSU_SENHA(senhaField.getText());

		usuario.setUSU_TIPO(cbTipo.getSelectedItem().toString());
		
		
		if (verificarCampos(cbTipo, idField, nomeField, telefoneField, senhaField) == true) {
			usuarioDao.save(usuario);
			JOptionPane.showMessageDialog(null, "Usuario " + nomeField.getText() + " inserido com sucesso!");

			ClearFields(idField, nomeField, telefoneField, senhaField);
			PosicionarCombobox(cbTipo);
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	public void btnPesquisar(JButton btnSalvar, JButton btnEditar, JComboBox cbTipo, JTextField idField, JTextField nomeField, JTextField telefoneField, JTextField senhaField) {

		usuario = usuarioDao.pesquisarUsuario(JOptionPane.showInputDialog("Informe o Nome do USUARIO que deseja Editar!"));

		idField.setText(Integer.toString(usuario.getUSU_ID()));
		idField.setEditable(false);

		nomeField.setText(usuario.getUSU_NOME());
		telefoneField.setText(usuario.getUSU_TEL());
		senhaField.setText(usuario.getUSU_SENHA());
		cbTipo.setSelectedItem(usuario.getUSU_TIPO());

		
		btnSalvar.setEnabled(false);
		btnEditar.setEnabled(true);
	}

	@SuppressWarnings("rawtypes")
	public void btnEditar(JComboBox cbTipo, JTextField idField, JTextField nomeField, JTextField telefoneField, JTextField senhaField) {

		String id = idField.getText();
		int ID = Integer.parseInt(id);
		
		usuario.setUSU_ID(ID);

		usuario.setUSU_NOME(nomeField.getText());
		
		usuario.setUSU_TEL(telefoneField.getText());

		usuario.setUSU_SENHA(senhaField.getText());

		usuario.setUSU_TIPO(cbTipo.getSelectedItem().toString());

		usuarioDao.update(usuario);

		JOptionPane.showMessageDialog(null, "Usuario " + nomeField.getText() + " atualizado com sucesso!");
		// Bloquear
		BloquearFields(cbTipo, idField, nomeField, telefoneField, senhaField);
	}

	public void btnExcluir() {
		int id;
		id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Usuario que deseja Excluir!"));

		if (id == 0) {
			JOptionPane.showMessageDialog(null, "Não existe Usuario com esse ID! Informe um ID valido.");
			JOptionPane.showInputDialog("Informe o ID do Usuario que deseja Excluir!");
		} else {

			JOptionPane.showMessageDialog(null, "O Usuario foi excluido com sucesso!!!");
			usuarioDao.removeById(id);
		}
	}

	
	public void listarUsuarios(DefaultTableModel model) {

		model.setNumRows(0);

		for (Usuario usuarios : usuarioDao.getUsuarios()) {
			model.addRow(new Object[] { usuarios.getUSU_ID(), usuarios.getUSU_NOME(), usuarios.getUSU_TIPO(), usuarios.getUSU_TEL() });
		}
	}

	public void pesquisarUsuario(DefaultTableModel model, JTextField PesquisarField) {

		model.setNumRows(0);

		if (PesquisarField.getText().isEmpty() || usuarioDao.pesquisarUsuarios(PesquisarField.getText()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não existe Usuario com esse nome! Informe um novo nome.");
			PesquisarField.setText("");
		} else {

			for (Usuario usuarios : usuarioDao.pesquisarUsuarios(PesquisarField.getText())) {
				model.addRow(new Object[] { usuarios.getUSU_ID(), usuarios.getUSU_NOME(), usuarios.getUSU_TIPO(), usuarios.getUSU_TEL() });
			}
			PesquisarField.setText("");
		}
	}

	
	
}
