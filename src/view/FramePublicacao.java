package view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.TitledBorder;

import controller.mascaraController;
import controller.publicacaoController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;

@SuppressWarnings("serial")
public class FramePublicacao extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField dataField;
	private JLabel lbl_Data;
	private JTextField tituloField;
	private JLabel lbl_Titulo;
	private JLabel lbl_Aluno;
	private JComboBox<String> cbAluno = new JComboBox<String>();;
		
	private publicacaoController controlePublicacao = new publicacaoController();
	
	
	private mascaraController mascara = new mascaraController();
	private JButton btnNovo;


	
//	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FramePublicacao frame = new FramePublicacao();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FramePublicacao(String nomeUsuario, String tipoUsuario) {
		setTitle("AcadSystem");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/Graduation Cap.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				setResizable(false);	
				setLocationRelativeTo(null); 
			}
			@SuppressWarnings("deprecation")
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				FrameMenu frameMenu = new FrameMenu(nomeUsuario, tipoUsuario);
				frameMenu.show();
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 599, 330);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GERENCIAR PUBLICA\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(47, 79, 79));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setForeground(new Color(0, 255, 255));
		btnVoltar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameMenu frameMenu = new FrameMenu(nomeUsuario, tipoUsuario);
				frameMenu.show();
				dispose();
			}
		});
		
		JLabel lblTipo = new JLabel("* Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setForeground(new Color(0, 255, 255));
		lblTipo.setBounds(51, 164, 46, 14);
		contentPane.add(lblTipo);
		
		
		JComboBox cbTipo = new JComboBox();
		cbTipo.setFont(new Font("Dialog", Font.BOLD, 13));
		cbTipo.setBackground(new Color(47, 79, 79));
		cbTipo.setForeground(Color.WHITE);
		cbTipo.addItem("Selecione");
		cbTipo.addItem("PROJETO");
		cbTipo.addItem("PESQUISA");
		cbTipo.addItem("RESENHA");
		cbTipo.addItem("PRE-PROJETO");
		cbTipo.addItem("ARTIGO");
		cbTipo.addItem("TCC");
		cbTipo.setBounds(107, 160, 455, 23);
		contentPane.add(cbTipo);

		btnVoltar.setBounds(488, 257, 85, 23);
		contentPane.add(btnVoltar);

		
		cbAluno = new JComboBox();
		cbAluno.setFont(new Font("Dialog", Font.BOLD, 13));
		cbAluno.setBackground(new Color(47, 79, 79));
		cbAluno.setForeground(Color.WHITE);
		controlePublicacao.carregarComboBoxAluno(cbAluno);
		cbAluno.setBounds(107, 217, 455, 20);
		contentPane.add(cbAluno);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(47, 79, 79));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setForeground(new Color(0, 255, 255));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlePublicacao.btnSalvar(cbTipo, cbAluno, idField, dataField, tituloField);
			}
		});
		btnSalvar.setBounds(143, 257, 85, 23);
		contentPane.add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlePublicacao.btnEditar(cbTipo, cbAluno, idField, dataField, tituloField, btnEditar);
				
			}
		});
		btnEditar.setBackground(new Color(47, 79, 79));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setForeground(new Color(0, 255, 255));
		btnEditar.setEnabled(false);
		btnEditar.setBounds(249, 257, 85, 23);
		contentPane.add(btnEditar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlePublicacao.btnPesquisar(btnSalvar, btnEditar, cbTipo, cbAluno, idField, dataField, tituloField);

			}
		});
		btnPesquisar.setBackground(new Color(47, 79, 79));
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisar.setForeground(new Color(0, 255, 255));
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				idField.setText("");
				dataField.setText("");
				tituloField.setText("");
		
        		
				cbTipo.setSelectedItem("Selecione");
				
				
			}
		});
		btnPesquisar.setBounds(358, 257, 118, 23);
		contentPane.add(btnPesquisar);
		
		lbl_Aluno = new JLabel("* Aluno:");
		lbl_Aluno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Aluno.setForeground(new Color(0, 255, 255));
		lbl_Aluno.setBounds(44, 221, 92, 14);
		contentPane.add(lbl_Aluno);
		
		lbl_Titulo = new JLabel("* Titulo:");
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Titulo.setForeground(new Color(0, 255, 255));
		lbl_Titulo.setBounds(51, 111, 53, 14);
		contentPane.add(lbl_Titulo);
		
		tituloField = new JTextField();
		tituloField.setFont(new Font("Dialog", Font.BOLD, 13));
		tituloField.setBackground(new Color(47, 79, 79));
		tituloField.setForeground(Color.WHITE);
		tituloField.setFont(new Font("Tahoma", Font.BOLD, 11));
		tituloField.setForeground(new Color(0, 255, 255));
		tituloField.setBounds(107, 108, 455, 20);
		contentPane.add(tituloField);
		tituloField.setColumns(10);
		
		lbl_Data = new JLabel("* Data Publicada:");
		lbl_Data.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Data.setForeground(new Color(0, 255, 255));
		lbl_Data.setBounds(237, 57, 112, 14);
		contentPane.add(lbl_Data);
		
		
		dataField = new JFormattedTextField(mascara.mascaraData());
		dataField.setFont(new Font("Dialog", Font.BOLD, 13));
		dataField.setBackground(new Color(47, 79, 79));
		dataField.setForeground(Color.WHITE);
		dataField.setBounds(360, 53, 202, 20);
		contentPane.add(dataField);
		dataField.setColumns(10);
		
		
		
		
		
		JLabel lbl_ID = new JLabel("* ID:");
		lbl_ID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_ID.setForeground(new Color(0, 255, 255));
		lbl_ID.setBounds(68, 56, 29, 14);
		contentPane.add(lbl_ID);
		
		idField = new JTextField();
		controlePublicacao.gerarID(idField);
		idField.setForeground(Color.WHITE);
		idField.setBackground(new Color(47, 79, 79));
		idField.setFont(new Font("Tahoma", Font.BOLD, 13));
		idField.setEnabled(false);
		idField.setBounds(107, 53, 88, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlePublicacao.ClearFields(cbTipo, cbAluno, idField, dataField, tituloField);
				controlePublicacao.DesbloquearFields(cbTipo, cbAluno, idField, dataField, tituloField);
				
				controlePublicacao.gerarID(idField);
				
			}
		});
		btnNovo.setBackground(new Color(47, 79, 79));
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovo.setForeground(new Color(0, 255, 255));
		btnNovo.setBounds(26, 257, 89, 23);
		contentPane.add(btnNovo);
	}
}
