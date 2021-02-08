package controller;


import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.CursoDAO;
import model.Curso;

public class cursoController {
	
	private Curso curso = new Curso();
	private CursoDAO cursoDao = new CursoDAO();
	private geradorID gerador = new geradorID();
	
	
	public void gerarID(JTextField idField) {
		int idGerador = gerador.idRandomico();

		System.out.println("\nID RANDOMICO = " + idGerador);

		gerador.verificarIdCurso(idGerador);
		
		if (gerador.idValido == true){
			idField.setText(String.valueOf(idGerador));
		}else{
			gerarID(idField);
		}
	}

	public boolean verificarCampos(JTextField idField, JTextField descricaoField) {
		if ((!idField.getText().equals("")) && (!descricaoField.getText().equals(""))) {
			return true;
		} else {
			return false;
		}
	}

	public void ClearFields(JTextField idField, JTextField descricaoField) {
		idField.setText("");
		descricaoField.setText("");
	}

	public void BloquearFields(JTextField idField, JTextField descricaoField) {
		idField.setEditable(false);
		descricaoField.setEditable(false);
	}

	public void DesbloquearFields(JTextField idField, JTextField descricaoField) {
		idField.setEditable(true);
		descricaoField.setEditable(true);
	}

	public void btnSalvar(JTextField idField, JTextField descricaoField) {
		
		
		Boolean validaCampos = false;
		
		// fazendo valida��o de campos atrav�s do metodo : verificarCampos();
		validaCampos = verificarCampos(idField, descricaoField);
		
		if (validaCampos == true) {
		
			// capturando o ID do CURSO
			curso.setCUR_ID(Integer.parseInt(idField.getText()));

			// capturando o nome do CURSO
			curso.setCUR_DESCRICAO(descricaoField.getText());

			cursoDao.save(curso);
			JOptionPane.showMessageDialog(null, "Curso " + descricaoField.getText() + " inserido com sucesso!");

			// apaga os dados preenchidos nos campos de texto
			ClearFields(idField, descricaoField);
			gerarID(idField);
		}else{
			JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
		}	
	}

	public void btnPesquisar(JButton btnSalvar, JButton btnEditar, JTextField idField, JTextField descricaoField) {

		Curso curso;
		curso = cursoDao.pesquisarCurso(JOptionPane.showInputDialog("Informe o Nome do CURSO que deseja Editar!"));

		idField.setText(Integer.toString(curso.getCUR_ID()));
		idField.setEditable(false);

		descricaoField.setText(curso.getCUR_DESCRICAO());
		
		DesbloquearFields(idField, descricaoField);

		idField.setEditable(false);

		btnSalvar.setEnabled(false);
		btnEditar.setEnabled(true);
	}

	public void btnEditar(JTextField idField, JTextField descricaoField, JButton btnEditar) {

		// capturando o ID orientador
		String id = idField.getText();
		int ID = Integer.parseInt(id);
		curso.setCUR_ID(ID);

		// capturando o nome do orientador
		curso.setCUR_DESCRICAO(descricaoField.getText());

		// realizando o update.
		cursoDao.update(curso);
		
		// Alerta
		JOptionPane.showMessageDialog(null, "Curso " + descricaoField.getText() + " atualizado com sucesso!");
		
		// Bloquear Campos
		BloquearFields(idField, descricaoField);

		// Bloquear o Bot�o EDITAR	
		btnEditar.setEnabled(false);
	}

	public void btnExcluir() {
		int id;
		id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do CURSO que deseja Excluir!"));

		if (id == 0) {
			JOptionPane.showMessageDialog(null, "Não existe CURSO com esse ID! Informe um ID valido.");
			JOptionPane.showInputDialog("Informe o ID do CURSO que deseja Excluir!");
		} else {

			JOptionPane.showMessageDialog(null, "O CURSO foi excluido com sucesso!!!");
			cursoDao.removeById(id);
		}
	}

	public void listarCursos(DefaultTableModel model) {

		model.setNumRows(0);

		for (Curso cursos : cursoDao.getCursos()) {
			model.addRow(new Object[] { cursos.getCUR_ID(), cursos.getCUR_DESCRICAO() });
		}
	}

	public void pesquisarCurso(DefaultTableModel model, JTextField PesquisarField) {

		model.setNumRows(0);

		if (PesquisarField.getText().isEmpty() || cursoDao.pesquisarCursos(PesquisarField.getText()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não existe Curso com esse nome! Informe um novo nome.");
			PesquisarField.setText("");
		} else {

			for (Curso cursos : cursoDao.pesquisarCursos(PesquisarField.getText())) {
				model.addRow(new Object[] { cursos.getCUR_ID(), cursos.getCUR_DESCRICAO() });
			}
			PesquisarField.setText("");
		}
	}

}
