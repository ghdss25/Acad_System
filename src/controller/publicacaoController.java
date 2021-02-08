package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.AlunoDAO;
import DAO.PublicacaoDAO;
import model.Aluno;
import model.Publicacao;

public class publicacaoController {
	
	private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

	private AlunoDAO alunoDao = new AlunoDAO();
	private PublicacaoDAO publicacaoDao = new PublicacaoDAO();
	private Publicacao publicacao = new Publicacao();
	private geradorID gerador = new geradorID();

	public void gerarID(JTextField idField) {
		int idGerador = gerador.idRandomico();

		System.out.println("\nID RANDOMICO = " + idGerador);

		gerador.verificarIdPublicacao(idGerador);
		
		if (gerador.idValido == true){
			idField.setText(String.valueOf(idGerador));
		}else{
			gerarID(idField);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public boolean verificarCampos(JComboBox cbTipo, JComboBox cbAluno, JTextField idField, JTextField dataField, 
			JTextField tituloField) {
		if ((!idField.getText().equals("")) && (!dataField.getText().equals(""))
				&& (!tituloField.getText().equals("")) && (!cbTipo.getSelectedItem().equals("Selecione"))
				&& (!cbAluno.getSelectedItem().equals("Selecione"))) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
			return false;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void ClearFields(JComboBox cbTipo, JComboBox cbAluno, JTextField idField, JTextField dataField, 
			JTextField tituloField) {
		idField.setText("");
		dataField.setText("");
		tituloField.setText("");
		cbTipo.setSelectedItem("Selecione");
		cbAluno.setSelectedItem("Selecione");
	}

	@SuppressWarnings("rawtypes")
	public void BloquearFields(JComboBox cbTipo, JComboBox cbAluno, JTextField idField, JTextField dataField, 
			JTextField tituloField) {
		idField.setEditable(false);
		dataField.setEditable(false);
		tituloField.setEditable(false);
		cbTipo.setEnabled(false);
		cbAluno.setEnabled(false);
	}

	@SuppressWarnings("rawtypes")
	public void DesbloquearFields(JComboBox cbTipo, JComboBox cbAluno, JTextField idField, JTextField dataField, 
			JTextField tituloField) {
		idField.setEditable(true);
		dataField.setEditable(true);
		tituloField.setEditable(true);
		cbTipo.setEnabled(true);
		cbAluno.setEnabled(true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void carregarComboBoxAluno(JComboBox cbAluno){
	     
	     List<Aluno> alunos;

	     alunos =  alunoDao.getAlunos();
	     
	     cbAluno.removeAllItems();
	     cbAluno.addItem("Selecione");

	     for (int i = 0; i < alunos.size(); i++){
	    	 cbAluno.addItem(alunos.get(i).getALU_NOME());
	     }		
	}
	
	@SuppressWarnings("rawtypes")
	public int idAluno(JComboBox cbAluno) {
		int id = 0;

		List<Aluno> listaAluno =alunoDao.getAlunos();
		for (Aluno alunos : listaAluno) {
			if (cbAluno.getSelectedItem().toString().equals(alunos.getALU_NOME())) {
				id = alunos.getALU_RA();
			}

		}
		return id;
	}
	
	@SuppressWarnings("rawtypes")
	public void btnSalvar(JComboBox cbTipo, JComboBox cbAluno, JTextField idField, JTextField dataField, 
			JTextField tituloField){
		
		publicacao.setPUBL_ID(Integer.parseInt(idField.getText()));

		publicacao.setPUBL_TIPO(cbTipo.getSelectedItem().toString());

		publicacao.setPUBL_TITULO(tituloField.getText());

		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date invoiceDate = null;
		try {
			invoiceDate = formatDate.parse(dataField.getText().trim());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());

		publicacao.setPUBL_DATAPUBLICADA(sqlDate);

		publicacao.setALU_RA(idAluno(cbAluno));

		if (verificarCampos(cbTipo, cbAluno, idField, dataField, tituloField) == true) {
			publicacaoDao.save(publicacao);
			JOptionPane.showMessageDialog(null, "Publicação " + tituloField.getText() + " inserido com sucesso!");

			ClearFields(cbTipo, cbAluno, idField, dataField, tituloField);
			DesbloquearFields(cbTipo, cbAluno, idField, dataField, tituloField);

		}
	}
	
	
	@SuppressWarnings("rawtypes")
	public void btnPesquisar(JButton btnSalvar, JButton btnEditar, JComboBox cbTipo, JComboBox cbAluno, JTextField idField,
			JTextField dataField, JTextField tituloField) {

		Publicacao publicacao;
		publicacao = publicacaoDao.pesquisarPublicacao(JOptionPane.showInputDialog("Informe o Titulo da PUBLICAÇÃO que deseja Editar!"));

		idField.setText(Integer.toString(publicacao.getPUBL_ID()));
		idField.setEditable(false);

		tituloField.setText(publicacao.getPUBL_TITULO());
		
		dataField.setText(formatDate.format(publicacao.getPUBL_DATAPUBLICADA()));

		// sele��o do aluno
		List<Aluno> listaAlunos = alunoDao.getAlunos();
		for (Aluno alunos : listaAlunos) {
			if (publicacao.getALU_RA() == alunos.getALU_RA()) {
				cbAluno.setSelectedItem(alunos.getALU_NOME());
			}
		}
		// fim da sele��o do aluno.
		
		cbTipo.setSelectedItem(publicacao.getPUBL_TIPO());

		
		DesbloquearFields(cbTipo, cbAluno, idField, dataField, tituloField);

		idField.setEditable(false);

		btnSalvar.setEnabled(false);
		
		btnEditar.setEnabled(true);
	}
	
	
	@SuppressWarnings("rawtypes")
	public void btnEditar(JComboBox cbTipo, JComboBox cbAluno, JTextField idField,
			JTextField dataField, JTextField tituloField, JButton btnEditar) {

		// capturando o ID publicacao
		String id = idField.getText();
		int ID = Integer.parseInt(id);
		publicacao.setPUBL_ID(ID);

		// capturando o nome do publicacao
		publicacao.setPUBL_TITULO(tituloField.getText());

		
		java.util.Date invoiceDate = null;
		try {
			invoiceDate = formatDate.parse(dataField.getText().trim());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
		publicacao.setPUBL_DATAPUBLICADA(sqlDate);

		
		publicacao.setPUBL_TIPO(cbTipo.getSelectedItem().toString());

		publicacao.setALU_RA(idAluno(cbAluno));

		
		// realizando o update.
		publicacaoDao.update(publicacao);
		
		// Alerta
		JOptionPane.showMessageDialog(null, "Publicação " + tituloField.getText() + " atualizado com sucesso!");
		
		// Bloquear Campos
		BloquearFields(cbTipo, cbAluno, idField, dataField, tituloField);

		// Bloquear o Bot�o EDITAR	
		btnEditar.setEnabled(false);
	}
	
	
	
	public void btnExcluir() {
		
		int id;
		id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da Publicação que deseja Excluir!"));

		if (id == 0) {
			
			JOptionPane.showMessageDialog(null, "Não existe Publicação com esse ID! Informe um ID valido.");
			JOptionPane.showInputDialog("Informe o ID do Publicão que deseja Excluir!");
			
		} else {

			JOptionPane.showMessageDialog(null, "A Publicação foi excluida com sucesso!!!");
			publicacaoDao.removeById(id);
		}
	}
	
	
	public void listarPublicacoes(DefaultTableModel model) {

		model.setNumRows(0);

		for (Publicacao publicacoes : publicacaoDao.getPublicacoes()) {
			
			model.addRow(new Object[] { publicacoes.getPUBL_ID(), publicacoes.getPUBL_TITULO(), publicacoes.getPUBL_DATAPUBLICADA(), publicacoes.getPUBL_TIPO() });
		}
	}

}
