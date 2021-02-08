package view;

import java.awt.Color;
//import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controller.orientadorController;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameOrientador extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField nomeField;
	private JLabel lbl_Nome;
	private JTextField nascimentoField;
	private JLabel lbl_DataNasc;
	private JLabel lbl_Titulacao;
	private JTextField cpfField;
	private JLabel lbl_Cpf;
	private JTextField instituicaoField;
	private JLabel lbl_Instituicao;

	
	private orientadorController controleOrientador = new orientadorController();
	private JButton btnNovo;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameOrientador frame = new FrameOrientador();
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
	@SuppressWarnings("unchecked")
	public FrameOrientador(String nomeUsuario, String tipoUsuario) {
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
		setBounds(100, 100, 686, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GERENCIAR ORIENTADOR", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
		contentPane.setBackground(Color.DARK_GRAY);

		@SuppressWarnings("rawtypes")
		JComboBox cbTitulacao = new JComboBox();
		cbTitulacao.setFont(new Font("Dialog", Font.BOLD, 13));
		cbTitulacao.setBackground(new Color(47, 79, 79));
		cbTitulacao.setForeground(Color.WHITE);
		cbTitulacao.addItem("Selecione");
		cbTitulacao.addItem("DOUTOR(A)");
		cbTitulacao.addItem("MESTRE");
		cbTitulacao.addItem("ESPECIALISTA");
		cbTitulacao.setBounds(113, 163, 547, 23);
		contentPane.add(cbTitulacao);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(SystemColor.textInactiveText);
		btnVoltar.setForeground(new Color(0, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameMenu frameMenu = new FrameMenu(nomeUsuario, tipoUsuario);
				frameMenu.show();
				dispose();
			}
		});
		btnVoltar.setBounds(565, 280, 95, 23);
		contentPane.add(btnVoltar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleOrientador.btnSalvar(cbTitulacao, idField, nomeField, nascimentoField, cpfField, instituicaoField);
			}
		});
		btnSalvar.setBackground(SystemColor.textInactiveText);
		btnSalvar.setForeground(new Color(0, 255, 255));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setBounds(144, 280, 95, 23);
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(SystemColor.textInactiveText);
		btnEditar.setForeground(new Color(0, 255, 255));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleOrientador.btnEditar(cbTitulacao, idField, nomeField, nascimentoField, cpfField, instituicaoField, btnEditar);
			}
		});
		btnEditar.setBounds(283, 280, 95, 23);
		contentPane.add(btnEditar);

		lbl_Instituicao = new JLabel("Institui\u00E7\u00E3o:");
		lbl_Instituicao.setForeground(new Color(0, 255, 255));
		lbl_Instituicao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Instituicao.setBounds(25, 231, 76, 14);
		contentPane.add(lbl_Instituicao);

		instituicaoField = new JTextField();
		instituicaoField.setFont(new Font("Dialog", Font.BOLD, 13));
		instituicaoField.setBackground(new Color(47, 79, 79));
		instituicaoField.setForeground(Color.WHITE);
		instituicaoField.setBounds(113, 227, 547, 20);
		contentPane.add(instituicaoField);
		instituicaoField.setColumns(10);

		lbl_Cpf = new JLabel("* CPF:");
		lbl_Cpf.setForeground(new Color(0, 255, 255));
		lbl_Cpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Cpf.setBounds(293, 108, 46, 14);
		contentPane.add(lbl_Cpf);

		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// cpfField = new JTextField();
		cpfField = new JFormattedTextField(mascaraCpf);
		cpfField.setFont(new Font("Dialog", Font.BOLD, 13));
		cpfField.setBackground(new Color(47, 79, 79));
		cpfField.setForeground(Color.WHITE);
		cpfField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				String caracteres = "0987654321";
				if (!caracteres.contains(evt.getKeyChar() + "")) {
					evt.consume();
				}
			}
		});
		cpfField.setBounds(357, 104, 303, 20);
		contentPane.add(cpfField);
		cpfField.setColumns(10);

		lbl_Titulacao = new JLabel("* Titula\u00E7\u00E3o:");
		lbl_Titulacao.setForeground(new Color(0, 255, 255));
		lbl_Titulacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Titulacao.setBounds(25, 168, 76, 14);
		contentPane.add(lbl_Titulacao);

		lbl_DataNasc = new JLabel("Data de Nascimento:");
		lbl_DataNasc.setForeground(new Color(0, 255, 255));
		lbl_DataNasc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_DataNasc.setBounds(10, 108, 146, 14);
		contentPane.add(lbl_DataNasc);

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// DataNascField = new JTextField();
		nascimentoField = new JFormattedTextField(mascaraData);
		nascimentoField.setFont(new Font("Dialog", Font.BOLD, 13));
		nascimentoField.setBackground(new Color(47, 79, 79));
		nascimentoField.setForeground(Color.WHITE);
		nascimentoField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				String caracteres = "0987654321";
				if (!caracteres.contains(evt.getKeyChar() + "")) {
					evt.consume();
				}
			}
		});
		nascimentoField.setBounds(156, 104, 112, 20);
		contentPane.add(nascimentoField);
		nascimentoField.setColumns(10);

		lbl_Nome = new JLabel("* Nome:");
		lbl_Nome.setForeground(new Color(0, 255, 255));
		lbl_Nome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Nome.setBounds(293, 58, 54, 14);
		contentPane.add(lbl_Nome);

		nomeField = new JTextField();
		nomeField.setFont(new Font("Dialog", Font.BOLD, 13));
		nomeField.setBackground(new Color(47, 79, 79));
		nomeField.setForeground(Color.WHITE);
		nomeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				String caracteres = "0987654321";
				if (caracteres.contains(evt.getKeyChar() + "")) {
					evt.consume();
				}
			}
		});
		nomeField.setBounds(357, 54, 303, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);

		JLabel lbl_ID = new JLabel("* ID:");
		lbl_ID.setForeground(new Color(0, 255, 255));
		lbl_ID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_ID.setBounds(97, 58, 29, 14);
		contentPane.add(lbl_ID);

		idField = new JTextField();
		controleOrientador.gerarID(idField);
		idField.setEnabled(false);
		idField.setForeground(Color.WHITE);
		idField.setBackground(new Color(47, 79, 79));
		idField.setFont(new Font("Dialog", Font.BOLD, 13));
		idField.setBounds(144, 54, 112, 20);
		contentPane.add(idField);
		idField.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(SystemColor.textInactiveText);
		btnPesquisar.setForeground(new Color(0, 255, 255));
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controleOrientador.btnPesquisar(btnSalvar, btnEditar, cbTitulacao, idField, nomeField, nascimentoField, cpfField, instituicaoField);
			}
		});
		btnPesquisar.setBounds(422, 280, 112, 23);
		contentPane.add(btnPesquisar);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleOrientador.ClearFields(idField, nomeField, nascimentoField, cpfField, instituicaoField);
				controleOrientador.DesbloquearFields(cbTitulacao, idField, nomeField, nascimentoField, cpfField, instituicaoField);
				
				controleOrientador.gerarID(idField);
			}
		});
		btnNovo.setForeground(Color.CYAN);
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovo.setBackground(SystemColor.textInactiveText);
		btnNovo.setBounds(20, 280, 81, 23);
		contentPane.add(btnNovo);

	}
}
