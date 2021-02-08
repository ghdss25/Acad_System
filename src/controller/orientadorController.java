package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.OrientadorDAO;
import model.Orientador;

public class orientadorController {

	private Orientador orientador = new Orientador();
	private OrientadorDAO orientadorDao = new OrientadorDAO();

	private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

	private geradorID gerador = new geradorID();

	
	public void gerarID(JTextField idField) {
		int idGerador = gerador.idRandomico();

		System.out.println("\nID RANDOMICO = " + idGerador);

		gerador.verificarIdOrientador(idGerador);

		if (gerador.idValido == true) {
			idField.setText(String.valueOf(idGerador));
		} else {
			gerarID(idField);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public boolean verificarCampos(JTextField idField, JTextField nomeField, JTextField nascimentoField,
			JTextField cpfField, JTextField instituicaoField, JComboBox cbTitulacao) {

		if ((!idField.getText().equals("")) && (!nomeField.getText().equals("")) && 
				(!cpfField.getText().equals("")) && (!nascimentoField.getText().equals("")) && 
				(!instituicaoField.getText().equals("")) && (!cbTitulacao.getSelectedItem().equals("Selecione")) ) {

			return true;
		} else {
			return false;
		}
	}

	public void ClearFields(JTextField idField, JTextField nomeField, JTextField nascimentoField, JTextField cpfField,
			JTextField instituicaoField) {

		idField.setText("");
		nomeField.setText("");
		nascimentoField.setText("");
		cpfField.setText("");
		instituicaoField.setText("");
	}

	@SuppressWarnings("rawtypes")
	public void BloquearFields(JComboBox cbTitulacao, JTextField idField, JTextField nomeField,
			JTextField nascimentoField, JTextField cpfField, JTextField instituicaoField) {

		idField.setEditable(false);
		nomeField.setEditable(false);
		nascimentoField.setEditable(false);
		cpfField.setEditable(false);
		instituicaoField.setEditable(false);
		cbTitulacao.setEditable(false);
	}

	@SuppressWarnings({"rawtypes" })
	public void DesbloquearFields(JComboBox cbTitulacao, JTextField idField, JTextField nomeField,
			JTextField nascimentoField, JTextField cpfField, JTextField instituicaoField) {

		idField.setEditable(true);
		nomeField.setEditable(true);
		nascimentoField.setEditable(true);
		cpfField.setEditable(true);
		instituicaoField.setEditable(true);
		cbTitulacao.setEditable(false);
	}

	@SuppressWarnings("rawtypes")
	public void PosicionarCombobox(JComboBox cbTitulacao) {
		cbTitulacao.setSelectedItem("Selecione");
	}

	@SuppressWarnings("rawtypes")
	public void btnSalvar(JComboBox cbTitulacao, JTextField idField, JTextField nomeField, JTextField nascimentoField,
			JTextField cpfField, JTextField instituicaoField) {

		Boolean validaCampos = false;
		
		// fazendo valida��o de campos atrav�s do metodo : verificarCampos();
		validaCampos = verificarCampos(idField, nomeField, nascimentoField, cpfField, instituicaoField, cbTitulacao);
		
		if (validaCampos == true) {
			
			// capturando o ID orientador
			String id = idField.getText();
			int ID = Integer.parseInt(id);
			orientador.setORIENT_ID(ID);
	
			// capturando o nome do orientador
			orientador.setORIENT_NOME(nomeField.getText());
	
			java.util.Date invoiceDate = null;
			try {
				invoiceDate = formatDate.parse(nascimentoField.getText().trim());
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
			orientador.setORIENT_DATANASC(sqlDate);
	
			orientador.setORIENT_CPF(cpfField.getText());
	
			orientador.setORIENT_INSTITUICAO(instituicaoField.getText());
	
			orientador.setORIENT_TITULACAO(cbTitulacao.getSelectedItem().toString());
	
			orientadorDao.save(orientador);
			JOptionPane.showMessageDialog(null, "Orientador " + nomeField.getText() + " inserido com sucesso!");
	
			// apaga os dados preenchidos nos campos de texto
			ClearFields(idField, nomeField, nascimentoField, cpfField, instituicaoField);
	
			PosicionarCombobox(cbTitulacao);
			gerarID(idField);
		}else{
			JOptionPane.showMessageDialog(null, "Os campos n�o podem estar vazios");
		}
	}

	@SuppressWarnings("rawtypes")
	public void btnPesquisar(JButton btnSalvar, JButton btnEditar, JComboBox cbTitulacao, JTextField idField,
			JTextField nomeField, JTextField nascimentoField, JTextField cpfField, JTextField instituicaoField) {

		Orientador orientador;
		orientador = orientadorDao.pesquisarOrientador(JOptionPane.showInputDialog("Informe o Nome do Orientador que deseja Editar!"));

		idField.setText(Integer.toString(orientador.getORIENT_ID()));
		idField.setEditable(false);

		nomeField.setText(orientador.getORIENT_NOME());

		nascimentoField.setText(formatDate.format(orientador.getORIENT_DATANASC()));

		instituicaoField.setText(orientador.getORIENT_INSTITUICAO());

		cpfField.setText(orientador.getORIENT_CPF());

		cbTitulacao.setSelectedItem(orientador.getORIENT_TITULACAO());

		DesbloquearFields(cbTitulacao, idField, nomeField, nascimentoField, cpfField, instituicaoField);

		idField.setEditable(false);
		
		btnSalvar.setEnabled(false);
		btnEditar.setEnabled(true);
	}

	@SuppressWarnings("rawtypes")
	public void btnEditar(JComboBox cbTitulacao, JTextField idField, JTextField nomeField, JTextField nascimentoField,
			JTextField cpfField, JTextField instituicaoField, JButton btnEditar) {

		// capturando o ID orientador
		String id = idField.getText();
		int ID = Integer.parseInt(id);
		orientador.setORIENT_ID(ID);

		// capturando o nome do orientador
		orientador.setORIENT_NOME(nomeField.getText());

		java.util.Date invoiceDate = null;
		try {
			invoiceDate = formatDate.parse(nascimentoField.getText().trim());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
		orientador.setORIENT_DATANASC(sqlDate);

		orientador.setORIENT_CPF(cpfField.getText());

		orientador.setORIENT_INSTITUICAO(instituicaoField.getText());

		orientador.setORIENT_TITULACAO(cbTitulacao.getSelectedItem().toString());

		// realizando o update.
		orientadorDao.update(orientador);
		// Alerta
		JOptionPane.showMessageDialog(null, "Orientador " + nomeField.getText() + " atualizado com sucesso!");

		// Bloquear
		BloquearFields(cbTitulacao, idField, nomeField, nascimentoField, cpfField, instituicaoField);
		btnEditar.setEnabled(false);
	}
	
	public void btnExcluir() {
		int id;
		id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Orientador que deseja Excluir!"));

		if (id == 0) {
			JOptionPane.showMessageDialog(null, "Não existe Orientadores com esse ID! Informe um ID valido.");
			JOptionPane.showInputDialog("Informe o ID do Orientador que deseja Excluir!");
		} else {

			JOptionPane.showMessageDialog(null, "O Orientador foi excluido com sucesso!!!");
			orientadorDao.removeById(id);
		}
	}
	
	public void listarOrientadores(DefaultTableModel model){

		model.setNumRows(0);
    	
    	for(Orientador orientadores : orientadorDao.getOrientadores())
    	{
    		model.addRow(new Object[]{orientadores.getORIENT_ID(), orientadores.getORIENT_NOME(), orientadores.getORIENT_INSTITUICAO(), orientadores.getORIENT_TITULACAO()});
    	}
	}
	
	
	public void pesquisarOrientador(DefaultTableModel model, JTextField PesquisarField){
    	
		model.setNumRows(0);

    	if(PesquisarField.getText().isEmpty() || orientadorDao.pesquisarOrientadores(PesquisarField.getText()).isEmpty())
    	{
    		JOptionPane.showMessageDialog(null, "Não existe orientadores com esse nome! Informe um novo nome.");
    		PesquisarField.setText("");
    	}
    	else{
		    	
    			for(Orientador orientadores : orientadorDao.pesquisarOrientadores(PesquisarField.getText()))
		    	{
		    		model.addRow(new Object[]{orientadores.getORIENT_NOME(), orientadores.getORIENT_INSTITUICAO(), orientadores.getORIENT_TITULACAO()});
		    	}
		    PesquisarField.setText("");	
    	}
	}
	

}
