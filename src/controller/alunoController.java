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
import DAO.CursoDAO;
import DAO.OrientadorDAO;
import model.Aluno;
import model.Curso;
import model.Orientador;

public class alunoController {

	private AlunoDAO alunoDao = new AlunoDAO();
	private Aluno aluno = new Aluno();
	private OrientadorDAO orientadorDao = new OrientadorDAO();
	private CursoDAO cursoDao = new CursoDAO();
	private geradorID gerador = new geradorID();

	private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");


	public void gerarID(JTextField idField) {
		int idGerador = gerador.idRandomico();

		System.out.println("\nID RANDOMICO = " + idGerador);

		gerador.verificarIdAluno(idGerador);

		if (gerador.idValido == true) {
			idField.setText(String.valueOf(idGerador));
		} else {
			gerarID(idField);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public boolean verificarCampos(JComboBox cbCurso, JComboBox cbOrientador, JComboBox cbSistema,
			JComboBox cbProficiencia, JComboBox cbSexo, JTextField RAField, JTextField nomeField, JTextField cpfField, 
			JTextField nascimentoField, JTextField filiacaoField, JTextField enderecoField, JTextField telefoneField,
			JTextField matriculaField, JTextField disciplinaField, JTextField creditoField, JTextField pendenciaField){
		
		if ((!RAField.getText().equals("")) && (!nomeField.getText().equals("")) && 
				(!cpfField.getText().equals("")) && (!nascimentoField.getText().equals("")) && 
				(!filiacaoField.getText().equals("")) && (!enderecoField.getText().equals("")) &&
				(!telefoneField.getText().equals(""))  && (!matriculaField.getText().equals("")) && 
				(!disciplinaField.getText().equals("")) && (!creditoField.getText().equals("")) && 
				(!pendenciaField.getText().equals("")) && (!cbCurso.getSelectedItem().equals("Selecione")) && 
				(!cbOrientador.getSelectedItem().equals("Selecione")) && (!cbSistema.getSelectedItem().equals("Selecione")) &&
				(!cbProficiencia.getSelectedItem().equals("Selecione")) && 
				(!cbSexo.getSelectedItem().equals("Selecione")) ) {

			return true;
		} else {
			//JOptionPane.showMessageDialog(null, "Os campos n�o podem estar vazios");
			return false;
		}
	}
	
	public void ClearFields(JTextField RAField, JTextField nomeField, JTextField cpfField, JTextField nascimentoField,
			JTextField filiacaoField, JTextField enderecoField, JTextField telefoneField, JTextField matriculaField,
			JTextField disciplinaField, JTextField creditoField, JTextField pendenciaField) {

		RAField.setText("");
		nomeField.setText("");
		nascimentoField.setText("");
		cpfField.setText("");
		filiacaoField.setText("");
		enderecoField.setText("");
		telefoneField.setText("");
		matriculaField.setText("");
		disciplinaField.setText("");
		pendenciaField.setText("");
		creditoField.setText("");

	}

	@SuppressWarnings("rawtypes")
	public void BloquearFields(JComboBox cbCurso, JComboBox cbOrientador, JComboBox cbSistema, JComboBox cbProficiencia, JComboBox cbSexo, JTextField RAField,
			JTextField nomeField, JTextField cpfField, JTextField nascimentoField, JTextField filiacaoField,
			JTextField enderecoField, JTextField telefoneField, JTextField matriculaField, JTextField disciplinaField,
			JTextField creditoField, JTextField pendenciaField) {

		RAField.setEditable(false);
		nomeField.setEditable(false);
		nascimentoField.setEditable(false);
		cpfField.setEditable(false);
		filiacaoField.setEditable(false);
		enderecoField.setEditable(false);
		telefoneField.setEditable(false);
		matriculaField.setEditable(false);
		disciplinaField.setEditable(false);
		pendenciaField.setEditable(false);
		creditoField.setEditable(false);
		cbSexo.setEditable(false);
		cbProficiencia.setEditable(false);
		cbSistema.setEditable(false);
		cbOrientador.setEditable(false);
		cbCurso.setEditable(false);
	}

	@SuppressWarnings({ "rawtypes"})
	public void DesbloquearFields(JComboBox cbCurso, JComboBox cbOrientador, JComboBox cbSistema, JComboBox cbProficiencia, JComboBox cbSexo, JTextField RAField,
			JTextField nomeField, JTextField cpfField, JTextField nascimentoField, JTextField filiacaoField,
			JTextField enderecoField, JTextField telefoneField, JTextField matriculaField, JTextField disciplinaField,
			JTextField creditoField, JTextField pendenciaField) {

		RAField.setEditable(true);
		nomeField.setEditable(true);
		nascimentoField.setEditable(true);
		cpfField.setEditable(true);
		filiacaoField.setEditable(true);
		enderecoField.setEditable(true);
		telefoneField.setEditable(true);
		matriculaField.setEditable(true);
		disciplinaField.setEditable(true);
		pendenciaField.setEditable(true);
		creditoField.setEditable(true);
		cbSexo.setEditable(false);
		cbProficiencia.setEditable(false);
		cbSistema.setEditable(false);
		cbOrientador.setEditable(false);
		cbCurso.setEditable(false);
	}

	@SuppressWarnings("rawtypes")
	public void PosicionarCombobox(JComboBox cbCurso, JComboBox cbOrientador, JComboBox cbSistema, JComboBox cbProficiencia, JComboBox cbSexo) {

		cbSexo.setSelectedItem("Selecione");
		cbProficiencia.setSelectedItem("Selecione");
		cbSistema.setSelectedItem("Selecione");
		cbOrientador.setSelectedItem("Selecione");
		cbCurso.setSelectedItem("Selecione");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void carregarComboBoxOrientador(JComboBox cbOrientador){
	     
	     List<Orientador> orientadores;

	     orientadores =  orientadorDao.getOrientadores();
	     
	     cbOrientador.removeAllItems();
	     cbOrientador.addItem("Selecione");

	     for (int i = 0; i < orientadores.size(); i++){
	     	cbOrientador.addItem(orientadores.get(i).getORIENT_NOME());
	     }		
	}
	
	@SuppressWarnings("rawtypes")
	public int idOrientador(JComboBox cbOrientador) {

		int id = 0;

		List<Orientador> lista = orientadorDao.getOrientadores();
		for (Orientador orientadores : lista) {
			if (cbOrientador.getSelectedItem().toString().equals(orientadores.getORIENT_NOME())) {
				id = orientadores.getORIENT_ID();
			}

		}
		return id;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void carregarComboBoxCurso(JComboBox cbCurso){
	     
	     List<Curso> cursos;

	     cursos =  cursoDao.getCursos();
	     
	     cbCurso.removeAllItems();
	     cbCurso.addItem("Selecione");

	     for (int i = 0; i < cursos.size(); i++){
	    	 cbCurso.addItem(cursos.get(i).getCUR_DESCRICAO());
	     }		
	}

	@SuppressWarnings("rawtypes")
	public int idCurso(JComboBox cbCurso) {

		int id = 0;

		List<Curso> lista = cursoDao.getCursos();
		for (Curso cursos : lista) {
			if (cbCurso.getSelectedItem().toString().equals(cursos.getCUR_DESCRICAO())) {
				id = cursos.getCUR_ID();
			}

		}
		return id;
	}
	

	@SuppressWarnings({ "rawtypes"})
	public void btnSalvar(JComboBox cbCurso, JComboBox cbOrientador, JComboBox cbSistema, JComboBox cbProficiencia, JComboBox cbSexo, JTextField RAField,
			JTextField nomeField, JTextField cpfField, JTextField nascimentoField, JTextField filiacaoField,
			JTextField enderecoField, JTextField telefoneField, JTextField matriculaField, JTextField disciplinaField,
			JTextField creditoField, JTextField pendenciaField) {
		
		Boolean validaCampos = false;
		
		// fazendo valida��o de campos atrav�s do metodo : verificarCampos();
		validaCampos = verificarCampos(cbCurso, cbOrientador, cbSistema, cbProficiencia, cbSexo, RAField, nomeField,
				cpfField, nascimentoField, filiacaoField, enderecoField, telefoneField, matriculaField,
				disciplinaField, creditoField, pendenciaField);
		
		if (validaCampos == true) {
			
			// capturando o registro academico
			String RA = RAField.getText();
			int ra = Integer.parseInt(RA);
			aluno.setALU_RA(ra);

			// capturando o nome do Aluno
			aluno.setALU_NOME(nomeField.getText());

			// capturando o combobox
			aluno.setALU_SEXO(cbSexo.getSelectedItem().toString());

			// capturando data de nascimento
			java.util.Date invoiceDate = null;
			try {
				invoiceDate = formatDate.parse(nascimentoField.getText().trim());
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
			aluno.setALU_DATANASC(sqlDate);

			aluno.setALU_CPF(cpfField.getText());

			aluno.setALU_FILIACAO(filiacaoField.getText());

			aluno.setALU_ENDERECO(enderecoField.getText());

			aluno.setALU_TELEFONE(telefoneField.getText());

			// capturando a data da matricula
			java.util.Date invoiceDate2 = null;
			try {
				invoiceDate2 = formatDate.parse(matriculaField.getText().trim());
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			java.sql.Date sqlDate2 = new java.sql.Date(invoiceDate2.getTime());
			aluno.setALU_DATAMATRI(sqlDate2);

			aluno.setALU_DISCCONC(disciplinaField.getText());

			aluno.setALU_DISCPEND(pendenciaField.getText());

			String crd = creditoField.getText();
			int cre = Integer.parseInt(crd);
			aluno.setALU_CRED(cre);

			aluno.setALU_PROFIC(cbProficiencia.getSelectedItem().toString());

			aluno.setALU_SISTEMA(cbSistema.getSelectedItem().toString());

			// capturando o ID do ORIENTADOR por COMBOBOX
			aluno.setORIENT_ID(idOrientador(cbOrientador));

			aluno.setCUR_ID(idCurso(cbCurso));

			
			
			/// SALVANDO ALUNO
			alunoDao.save(aluno);
			// Alerta
			JOptionPane.showMessageDialog(null, "Aluno " + nomeField.getText() + " inserido com sucesso!");

			// apaga os dados preenchidos nos campos de texto
			ClearFields(RAField, nomeField, cpfField, nascimentoField, filiacaoField, enderecoField, telefoneField,
					matriculaField, disciplinaField, creditoField, pendenciaField);

			PosicionarCombobox(cbCurso, cbOrientador, cbSistema, cbProficiencia, cbSexo);
			gerarID(RAField);
		}else{
			JOptionPane.showMessageDialog(null, "Os campos n�o podem estar vazios");
		} 
	}
	
	
	@SuppressWarnings("rawtypes")
	public void btnPesquisar(JButton btnSalvar, JButton btnEditar, JComboBox cbCurso, JComboBox cbOrientador, JComboBox cbSistema, JComboBox cbProficiencia, JComboBox cbSexo, JTextField RAField,
			JTextField nomeField, JTextField cpfField, JTextField nascimentoField, JTextField filiacaoField,
			JTextField enderecoField, JTextField telefoneField, JTextField matriculaField, JTextField disciplinaField,
			JTextField creditoField, JTextField pendenciaField){
		
		Aluno aluno;
		aluno = alunoDao.pesquisarAluno(JOptionPane.showInputDialog("Informe o Nome do Aluno que deseja Editar!"));

		RAField.setText(Integer.toString(aluno.getALU_RA()));
		
		
		nomeField.setText(aluno.getALU_NOME());
		
		cbSexo.setSelectedItem(aluno.getALU_SEXO());
		
		nascimentoField.setText(formatDate.format(aluno.getALU_DATANASC()));
		
		filiacaoField.setText(aluno.getALU_FILIACAO());
		
		cpfField.setText(aluno.getALU_CPF());
		
		enderecoField.setText(aluno.getALU_ENDERECO());
		
		telefoneField.setText(aluno.getALU_TELEFONE());
		
		matriculaField.setText(formatDate.format(aluno.getALU_DATAMATRI()));
		
		creditoField.setText(Integer.toString(aluno.getALU_CRED()));
		
		cbProficiencia.setSelectedItem(aluno.getALU_PROFIC());
		
		cbSistema.setSelectedItem(aluno.getALU_SISTEMA());
		
		pendenciaField.setText(aluno.getALU_DISCPEND());
		
		disciplinaField.setText(aluno.getALU_DISCCONC());
		
		// sele��o do valor do curso
		List<Curso> listaCursos = cursoDao.getCursos();
		for (Curso cursos : listaCursos) {
			if (aluno.getCUR_ID() == cursos.getCUR_ID()) {
				cbCurso.setSelectedItem(cursos.getCUR_DESCRICAO());
			}

		}
		// fim da sele��o do curso.

		// sele��o do valor do orientador
		List<Orientador> lista = orientadorDao.getOrientadores();
		for (Orientador orientadores : lista) {
			if (aluno.getORIENT_ID() == orientadores.getORIENT_ID()) {
				cbOrientador.setSelectedItem(orientadores.getORIENT_NOME());
			}
		}
		// fim da sele��o do orientador
		

		
		DesbloquearFields(cbCurso, cbOrientador, cbSistema, cbProficiencia, cbSexo, RAField, nomeField, cpfField, nascimentoField, filiacaoField, enderecoField, telefoneField, matriculaField, disciplinaField, creditoField, pendenciaField);

		RAField.setEditable(false);
		
		btnSalvar.setEnabled(false);
		btnEditar.setEnabled(true);
	}
	
	
	@SuppressWarnings("rawtypes")
	public void btnEditar(JComboBox cbCurso, JComboBox cbOrientador, JComboBox cbSistema, JComboBox cbProficiencia, JComboBox cbSexo, JTextField RAField,
			JTextField nomeField, JTextField cpfField, JTextField nascimentoField, JTextField filiacaoField,
			JTextField enderecoField, JTextField telefoneField, JTextField matriculaField, JTextField disciplinaField,
			JTextField creditoField, JTextField pendenciaField, JButton btnEditar) {
		
		// capturando o registro academico
		String RA = RAField.getText();
		int ra = Integer.parseInt(RA);
		aluno.setALU_RA(ra);

		// capturando o nome do Aluno
		aluno.setALU_NOME(nomeField.getText());
		// capturando o combobox
		aluno.setALU_SEXO(cbSexo.getSelectedItem().toString());

		java.util.Date invoiceDate = null;
		try {
			invoiceDate = formatDate.parse(nascimentoField.getText().trim());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
		
		aluno.setALU_DATANASC(sqlDate);
		
		aluno.setALU_CPF(cpfField.getText());
		
		aluno.setALU_FILIACAO(filiacaoField.getText());
		
		
		aluno.setALU_ENDERECO(enderecoField.getText());
		
		aluno.setALU_TELEFONE(telefoneField.getText());
		
		// capturando a data da matricula
		java.util.Date invoiceDate2 = null;
		try {
			invoiceDate2 = formatDate.parse(matriculaField.getText().trim());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		java.sql.Date sqlDate2 = new java.sql.Date(invoiceDate2.getTime());
		aluno.setALU_DATAMATRI(sqlDate2);

		aluno.setALU_DISCCONC(disciplinaField.getText());
		
		aluno.setALU_DISCPEND(pendenciaField.getText());
		
		String crd = creditoField.getText();
		int cre = Integer.parseInt(crd);
		aluno.setALU_CRED(cre);
		
		aluno.setALU_PROFIC(cbProficiencia.getSelectedItem().toString());
		
		aluno.setALU_SISTEMA(cbSistema.getSelectedItem().toString());
		
		
		aluno.setORIENT_ID(idOrientador(cbOrientador));
		
		
		aluno.setCUR_ID(idCurso(cbCurso));
		
		
		// realizando o update.
		alunoDao.update(aluno);
		
		// Alerta
		JOptionPane.showMessageDialog(null, "Aluno " + nomeField.getText() + " atualizado com sucesso!");
		
		// Bloquear
		BloquearFields(cbCurso, cbOrientador, cbSistema, cbProficiencia, cbSexo, RAField,
			 nomeField, cpfField, nascimentoField, filiacaoField, enderecoField, telefoneField,
			 matriculaField, disciplinaField, creditoField, pendenciaField);
		
		btnEditar.setEnabled(false);
	}
	
	
	public void btnExcluir(String tipoUsuario) {
		int id;
		
		id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Aluno que deseja Excluir!"));

		if ( (tipoUsuario.equals("ADMINISTRADOR")) && (id != 0)){
			
			alunoDao.removeById(id);
			JOptionPane.showMessageDialog(null, "O Aluno foi excluido com sucesso !!!");

		}else if(tipoUsuario.equals("NORMAL")){
			JOptionPane.showMessageDialog(null, "O USU�RIO n�o tem permiss�o para excluir");
		}
	}
	
	
	public void listarAlunos(DefaultTableModel model) {
		model.setNumRows(0);

		for (Aluno alunos : alunoDao.getAlunos()) {
			model.addRow(new Object[] { alunos.getALU_RA(), alunos.getALU_NOME(), alunos.getALU_CPF(),
					alunos.getALU_TELEFONE(), alunos.getALU_CURSO(), alunos.getALU_SISTEMA(), alunos.getALU_ORIENT() });
		}
	}
	
	public void pesquisarAluno(DefaultTableModel model, JTextField PesquisarField){
		model.setNumRows(0);

		if (PesquisarField.getText().isEmpty() || alunoDao.pesquisarAlunos(PesquisarField.getText()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "N�o existe alunos com esse nome! Informe um novo nome.");
			PesquisarField.setText("");
		} else {

			for (Aluno alunos : alunoDao.pesquisarAlunos(PesquisarField.getText())) {
				model.addRow(new Object[] { alunos.getALU_RA(), alunos.getALU_NOME(), alunos.getALU_CPF(),
						alunos.getALU_TELEFONE(), alunos.getALU_CURSO(), alunos.getALU_SISTEMA(), alunos.getALU_ORIENT() });
			}
			PesquisarField.setText("");
		}
	}
}
