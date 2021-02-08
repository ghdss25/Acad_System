package view;

import java.awt.Color;
//import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.border.TitledBorder;

import controller.alunoController;
import controller.mascaraController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;


@SuppressWarnings("serial")
public class FrameAluno extends JFrame {

	private JPanel contentPane;
	private JTextField RAField;
	private JTextField nascimentoField;
	private JTextField enderecoField;
	private JTextField nomeField;
	private JTextField filiacaoField;
	private JTextField cpfField;
	private JTextField telefoneField;
	private JTextField matriculaField;
	private JTextField creditoField;
	private JTextField disciplinaField;
	private JTextField pendenciaField;

	
	private mascaraController mascara = new mascaraController();

	private alunoController controleAluno = new alunoController();
	
	// Combobox para o sexo
	JComboBox<String> cbSexo = new JComboBox<String>();
	// Formato da Data
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	// Combobox para a profici�ncia
	JComboBox<String> cbProficiencia = new JComboBox<String>();
	// Combobox para a n�vel do curso
	JComboBox<String> cbSistema = new JComboBox<String>();
	// Combobox para buscar os orientadores
	JComboBox<String> cbOrientador = new JComboBox<String>();
	// Combobox para buscar os cursos
	JComboBox<String> cbCurso = new JComboBox<String>();

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameAluno frame = new FrameAluno();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrameAluno(String nomeUsuario, String tipoUsuario) {
		addWindowListener(new WindowAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void windowClosing(WindowEvent e) {
				FrameMenu frameMenu = new FrameMenu(nomeUsuario, tipoUsuario);
				frameMenu.show();
				dispose();
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				setResizable(false);
				setLocationRelativeTo(null);
			}
		});
		setTitle("AcadSystem");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/Graduation Cap.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 885, 505);


		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(15, 12, 839, 409);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GERENCIAR ALUNO", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));

		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(15, 432, 88, 23);
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovo.setForeground(new Color(0, 255, 255));
		btnNovo.setBackground(SystemColor.textInactiveText);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controleAluno.ClearFields(RAField, nomeField, cpfField, nascimentoField, filiacaoField, enderecoField, telefoneField, matriculaField, disciplinaField, creditoField, pendenciaField);
				controleAluno.DesbloquearFields(cbCurso, cbOrientador, cbSistema, cbProficiencia, cbSexo, RAField, nomeField, cpfField, nascimentoField, filiacaoField, enderecoField, telefoneField, matriculaField, disciplinaField, creditoField, pendenciaField);
				controleAluno.PosicionarCombobox(cbCurso, cbOrientador, cbSistema, cbProficiencia, cbSexo);
				controleAluno.gerarID(RAField);

			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(211, 432, 88, 23);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setForeground(new Color(0, 255, 255));
		btnEditar.setBackground(SystemColor.textInactiveText);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controleAluno.btnEditar(cbCurso, cbOrientador, cbSistema, cbProficiencia, cbSexo, RAField, nomeField,
						cpfField, nascimentoField, filiacaoField, enderecoField, telefoneField, matriculaField,
						disciplinaField, creditoField, pendenciaField, btnEditar);
				
			}
		});
		btnEditar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {

				Boolean validaCampos = false;
				
				validaCampos = controleAluno.verificarCampos(cbCurso, cbOrientador, cbSistema, cbProficiencia, cbSexo, RAField, nomeField,
						cpfField, nascimentoField, filiacaoField, enderecoField, telefoneField, matriculaField,
						disciplinaField, creditoField, pendenciaField);
				
				if (validaCampos == true) {
					btnEditar.setEnabled(true);
				}else{
					btnEditar.setEnabled(false);
				}
			}
		});
		btnEditar.setEnabled(false);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(113, 432, 88, 23);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setForeground(new Color(0, 255, 255));
		btnSalvar.setBackground(SystemColor.textInactiveText);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controleAluno.btnSalvar(cbCurso, cbOrientador, cbSistema, cbProficiencia, cbSexo, RAField, nomeField,
						cpfField, nascimentoField, filiacaoField, enderecoField, telefoneField, matriculaField,
						disciplinaField, creditoField, pendenciaField);
			}
		});

		// inicio do bot�o voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(751, 432, 103, 23);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setForeground(new Color(0, 255, 255));
		btnVoltar.setBackground(SystemColor.textInactiveText);
		btnVoltar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				FrameMenu telaMenu = new FrameMenu(nomeUsuario, tipoUsuario);
				telaMenu.show();
				dispose();

			}
		});

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(309, 432, 97, 23);
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisar.setForeground(new Color(0, 255, 255));
		btnPesquisar.setBackground(SystemColor.textInactiveText);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controleAluno.btnPesquisar(btnSalvar, btnEditar, cbCurso, cbOrientador, cbSistema, cbProficiencia,
						cbSexo, RAField, nomeField, cpfField, nascimentoField, filiacaoField, enderecoField,
						telefoneField, matriculaField, disciplinaField, creditoField, pendenciaField);

			}
		});

		JLabel lblRa = new JLabel("* RA:");
		lblRa.setForeground(new Color(0, 255, 255));
		lblRa.setFont(new Font("Tahoma", Font.BOLD, 11));

		RAField = new JTextField();
		RAField.setEnabled(false);
		controleAluno.gerarID(RAField);
		RAField.setForeground(Color.WHITE);
		RAField.setBackground(new Color(47, 79, 79));
		RAField.setFont(new Font("Tahoma", Font.BOLD, 13));
		RAField.setColumns(10);

		JLabel lblDataNasci = new JLabel("* Data de Nasc.:");
		lblDataNasci.setForeground(new Color(0, 255, 255));
		lblDataNasci.setFont(new Font("Tahoma", Font.BOLD, 11));


		nascimentoField = new JFormattedTextField(mascara.mascaraData());
		nascimentoField.setBackground(new Color(47, 79, 79));
		nascimentoField.setForeground(Color.WHITE);
		nascimentoField.setFont(new Font("Tahoma", Font.BOLD, 13));
		nascimentoField.setColumns(10);

		JLabel lblEndereo = new JLabel("* Endere\u00E7o:");
		lblEndereo.setForeground(new Color(0, 255, 255));
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 11));

		enderecoField = new JTextField();
		enderecoField.setBackground(new Color(47, 79, 79));
		enderecoField.setForeground(Color.WHITE);
		enderecoField.setFont(new Font("Tahoma", Font.BOLD, 13));
		enderecoField.setColumns(10);

		JLabel lblNome = new JLabel("* Nome:");
		lblNome.setForeground(new Color(0, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));

		nomeField = new JTextField();
		nomeField.setBackground(new Color(47, 79, 79));
		nomeField.setForeground(Color.WHITE);
		nomeField.setFont(new Font("Tahoma", Font.BOLD, 13));
		nomeField.setColumns(10);

		JLabel lblFiliao = new JLabel("* Filia\u00E7\u00E3o:");
		lblFiliao.setForeground(new Color(0, 255, 255));
		lblFiliao.setFont(new Font("Tahoma", Font.BOLD, 11));

		filiacaoField = new JTextField();
		filiacaoField.setBackground(new Color(47, 79, 79));
		filiacaoField.setForeground(Color.WHITE);
		filiacaoField.setFont(new Font("Tahoma", Font.BOLD, 13));
		filiacaoField.setColumns(10);

		JLabel lblSexo = new JLabel("* Sexo:");
		lblSexo.setForeground(new Color(0, 255, 255));
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblCpf = new JLabel("* CPF:");
		lblCpf.setForeground(new Color(0, 255, 255));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));


		cpfField = new JFormattedTextField(mascara.mascaraCPF());
		cpfField.setBackground(new Color(47, 79, 79));
		cpfField.setForeground(Color.WHITE);
		cpfField.setFont(new Font("Tahoma", Font.BOLD, 13));
		cpfField.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(new Color(0, 255, 255));
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		telefoneField = new JFormattedTextField(mascara.mascaraTelefone());
		telefoneField.setBackground(new Color(47, 79, 79));
		telefoneField.setForeground(Color.WHITE);
		telefoneField.setFont(new Font("Tahoma", Font.BOLD, 13));
		telefoneField.setColumns(10);

		JPanel panel_Academico = new JPanel();
		panel_Academico.setBackground(Color.DARK_GRAY);
		panel_Academico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados Academicos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 255, 255)));

		cbSexo.setBackground(new Color(47, 79, 79));
		cbSexo.setForeground(Color.WHITE);
		cbSexo.setFont(new Font("Tahoma", Font.BOLD, 13));

		// inicio do combox do sexo

		cbSexo.addItem("Selecione");
		cbSexo.addItem("M");
		cbSexo.addItem("F");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEndereo)
						.addComponent(lblDataNasci)
						.addComponent(lblRa))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(nascimentoField)
								.addComponent(RAField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblFiliao)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(filiacaoField, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNome)
									.addGap(18)
									.addComponent(nomeField, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
						.addComponent(enderecoField, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSexo)
							.addGap(18)
							.addComponent(cbSexo, 0, 130, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCpf)
							.addGap(18)
							.addComponent(cpfField, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTelefone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(telefoneField, 133, 133, 133)))
					.addContainerGap())
				.addComponent(panel_Academico, GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(RAField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRa)
						.addComponent(lblNome)
						.addComponent(lblSexo)
						.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDataNasci)
								.addComponent(nascimentoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFiliao)
								.addComponent(filiacaoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEndereo)
								.addComponent(enderecoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTelefone)
								.addComponent(telefoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCpf)
							.addComponent(cpfField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_Academico, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);

		JLabel lblDataMatri = new JLabel("* Data da Matricula:");
		lblDataMatri.setForeground(new Color(0, 255, 255));
		lblDataMatri.setFont(new Font("Tahoma", Font.BOLD, 11));


		matriculaField = new JFormattedTextField(mascara.mascaraData());
		matriculaField.setBackground(new Color(47, 79, 79));
		matriculaField.setFont(new Font("Tahoma", Font.BOLD, 13));
		matriculaField.setForeground(Color.WHITE);
		matriculaField.setColumns(10);

		JLabel lblsistema = new JLabel("* Sistema:");
		lblsistema.setForeground(new Color(0, 255, 255));
		lblsistema.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblsistema.setToolTipText("Graduca��oo, Mestrado ou Doutorado");

		JLabel lblDisciplinasConcludas = new JLabel("Disciplinas Concluidas:");
		lblDisciplinasConcludas.setForeground(new Color(0, 255, 255));
		lblDisciplinasConcludas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDisciplinasConcludas.setLabelFor(cbSexo);

		JLabel lblTotalCredito = new JLabel("* Total Cr\u00E9dito:");
		lblTotalCredito.setForeground(new Color(0, 255, 255));
		lblTotalCredito.setFont(new Font("Tahoma", Font.BOLD, 11));

		creditoField = new JFormattedTextField(mascara.mascaraCredito());
		creditoField.setBackground(new Color(47, 79, 79));
		creditoField.setFont(new Font("Tahoma", Font.BOLD, 13));
		creditoField.setForeground(Color.WHITE);
		creditoField.setColumns(10);

		JLabel lblCurso = new JLabel("* Curso:");
		lblCurso.setForeground(new Color(0, 255, 255));
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblProficiencia = new JLabel("Proficiencia");
		lblProficiencia.setForeground(new Color(0, 255, 255));
		lblProficiencia.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblOrientador = new JLabel("* Orientador:");
		lblOrientador.setForeground(new Color(0, 255, 255));
		lblOrientador.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblDisciplinasPendentes = new JLabel("Disciplinas Pendentes:");
		lblDisciplinasPendentes.setForeground(new Color(0, 255, 255));
		lblDisciplinasPendentes.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbProficiencia.setBackground(new Color(47, 79, 79));
		cbProficiencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbProficiencia.setForeground(Color.WHITE);

		// Combobox do Proficiencia
		cbProficiencia.addItem("Selecione");
		cbProficiencia.addItem("S");
		cbProficiencia.addItem("N");

		disciplinaField = new JTextField();
		disciplinaField.setBackground(new Color(47, 79, 79));
		disciplinaField.setFont(new Font("Tahoma", Font.BOLD, 13));
		disciplinaField.setForeground(Color.WHITE);
		disciplinaField.setColumns(10);

		pendenciaField = new JTextField();
		pendenciaField.setBackground(new Color(47, 79, 79));
		pendenciaField.setFont(new Font("Tahoma", Font.BOLD, 13));
		pendenciaField.setForeground(Color.WHITE);
		pendenciaField.setColumns(10);
		cbSistema.setBackground(new Color(47, 79, 79));
		cbSistema.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbSistema.setForeground(Color.WHITE);

		// Combobox para o n�vel do curso
		cbSistema.addItem("Selecione");
		cbSistema.addItem("Graduacao");
		cbSistema.addItem("Mestrado");
		cbSistema.addItem("Doutorado");

		// Combobox Orientador
		controleAluno.carregarComboBoxOrientador(cbOrientador);

		// Combobox Cursos
		controleAluno.carregarComboBoxCurso(cbCurso);

		GroupLayout gl_panel_1 = new GroupLayout(panel_Academico);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
						.createSequentialGroup().addContainerGap().addGroup(gl_panel_1.createParallelGroup(
								Alignment.LEADING).addComponent(lblDisciplinasConcludas)
								.addComponent(disciplinaField,
										GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblDataMatri)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(cbSistema, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(matriculaField, GroupLayout.PREFERRED_SIZE, 133,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(lblTotalCredito))
												.addComponent(lblsistema))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1
										.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(
												Alignment.LEADING)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(creditoField, GroupLayout.PREFERRED_SIZE,
																		142, GroupLayout.PREFERRED_SIZE)
																.addGap(39))
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(cbCurso, 0, 177, Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.RELATED)))
												.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblCurso)
														.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(
												gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel_1
																.createSequentialGroup().addComponent(lblProficiencia)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(cbProficiencia, 0, 120, Short.MAX_VALUE))
														.addGroup(gl_panel_1.createSequentialGroup().addGap(10)
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblOrientador).addComponent(
																				cbOrientador, 0, 211,
																				Short.MAX_VALUE)))))
								.addComponent(lblDisciplinasPendentes)
								.addComponent(pendenciaField, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
						.addContainerGap()));
		cbOrientador.setBackground(new Color(47, 79, 79));
		cbOrientador.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbOrientador.setForeground(Color.WHITE);
		cbCurso.setBackground(new Color(47, 79, 79));
		cbCurso.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbCurso.setForeground(Color.WHITE);
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(23)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblDataMatri)
								.addComponent(matriculaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotalCredito)
								.addComponent(creditoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProficiencia).addComponent(cbProficiencia, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblCurso)
								.addComponent(lblsistema).addComponent(lblOrientador))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbOrientador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbSistema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDisciplinasPendentes)
								.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblDisciplinasConcludas)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
												.addComponent(pendenciaField, GroupLayout.DEFAULT_SIZE, 84,
														Short.MAX_VALUE)
												.addComponent(disciplinaField, GroupLayout.DEFAULT_SIZE, 85,
														Short.MAX_VALUE))))
						.addContainerGap()));
		panel_Academico.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(btnNovo);
		contentPane.add(btnSalvar);
		contentPane.add(btnEditar);
		contentPane.add(btnPesquisar);
		contentPane.add(btnVoltar);
		contentPane.add(panel);
	}

	
}
